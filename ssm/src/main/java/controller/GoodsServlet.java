package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Goods;
import service.GoodsService;
import service.TypeService;

@Controller
@RequestMapping("goods")
public class GoodsServlet {
	
	@Autowired
	GoodsService goodsService;

	@Autowired
	TypeService typeService;
	
	public GoodsServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@ResponseBody
	@RequestMapping(value="selAll",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String selAll(Integer page,Integer limit,ModelMap m) throws JsonProcessingException {
		List<Goods> goods = goodsService.selAll((page-1)*limit, limit);
		int num = goodsService.selAllNum();
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(goods)+"}");
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String update(@RequestBody Goods goods) {
		System.out.println("update");
		goodsService.update(goods);
		return "";
	}
	
	@ResponseBody
	@RequestMapping("del")
	public String del(int gid) {
		Goods goods = new Goods();
		goods.setGid(gid);
		System.out.println(goods.getGid());
		goodsService.delById(goods);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="insert",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String insert(@RequestBody Goods goods) {
		goodsService.insert(goods);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="goodsFind",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String goodsFind(Integer page ,Integer limit,String gname) throws JsonProcessingException {
		String txt = "%"+gname+"%";
		System.out.println(txt);
		List<Goods> goodss = goodsService.selByName(txt, (page-1)*limit, limit);
		int num = goodsService.selFindNum(txt);
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(goodss)+"}");
		return sb.toString() ;
	}
	
	@ResponseBody
	@RequestMapping(value="getType",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String getType() throws JsonProcessingException {
		System.out.println("getType");
		ObjectMapper objectMapper = new ObjectMapper();
		StringBuilder sb = new StringBuilder("{\"type\":");
		sb.append(objectMapper.writeValueAsString(typeService.selectAll())).append("}");
		System.out.println(sb.toString());
		return sb.toString();
	}

}
