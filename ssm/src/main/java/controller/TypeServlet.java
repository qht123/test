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

import model.Type;
import service.TypeService;

@Controller
@RequestMapping("type")
public class TypeServlet {
	
	@Autowired
	TypeService typeService;

	public TypeServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@ResponseBody
	@RequestMapping(value="selAll",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String selAll(Integer page,Integer limit,ModelMap m) throws JsonProcessingException {
		List<Type> users = typeService.selAll((page-1)*limit, limit);
		int num = typeService.selAllNum();
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(users)+"}");
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String update(@RequestBody Type type) {
		typeService.update(type);
		return "";
	}
	
	@ResponseBody
	@RequestMapping("del")
	public String del(int tid) {
		Type type = new Type();
		type.setTid(tid);
		System.out.println(type.getTid());
		typeService.delById(type);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="insert",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String insert(@RequestBody Type type) {
		typeService.insert(type);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="typeFind",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String userFind(Integer page ,Integer limit,String tname) throws JsonProcessingException {
		String txt = "%"+tname+"%";
		System.out.println(txt);
		List<Type> types = typeService.selByName(txt, (page-1)*limit, limit);
		int num = typeService.selFindNum(txt);
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(types)+"}");
		return sb.toString() ;
	}

}
