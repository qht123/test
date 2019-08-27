package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserServlet {

	@Autowired
	UserService userService;
	
	String[] sex = {"女","男","不限"}; 
	@ResponseBody
	@RequestMapping(value="selAll",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String selAll(Integer page ,Integer limit,ModelMap m) throws JsonProcessingException{
		System.out.println("selAll");
		List<User> users = userService.selAllPage((page-1)*limit, limit);
		int num = userService.selAllNum();
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(users)+"}");
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping("del")
	public String del(int uid) {
		System.out.println("del");
		int index = userService.delById(uid);
		System.out.println(index);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String add(@RequestBody User user) throws JsonProcessingException {
		System.out.println("add");
		System.out.println(user.getUname());
		int index = userService.insert(user);
		return "";
	}
	
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String update(@RequestBody User user) throws JsonProcessingException {
		System.out.println("update");
		System.out.println(user.getUname());
		System.out.println(userService.update(user));
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="userFind",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String userFind(Integer page ,Integer limit,String uname) throws JsonProcessingException {
		String txt = "%"+uname+"%";
		List<User> users = userService.selByName(txt,(page-1)*limit, limit);
		int num = userService.selFindNum(txt);
		StringBuilder sb = new StringBuilder("{\"count\":"+num+",\"data\":");
		ObjectMapper objectMapper = new ObjectMapper();
		sb.append(objectMapper.writeValueAsString(users)+"}");
		return sb.toString() ;
	}
	
	@ResponseBody
	@RequestMapping(value="getSex",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String getSex() throws JsonProcessingException {
		System.out.println("getSex");
		ObjectMapper objectMapper = new ObjectMapper();
		StringBuilder sb = new StringBuilder("{\"sex\":");
		sb.append(objectMapper.writeValueAsString(sex)).append("}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="uptoFile",method=RequestMethod.POST )
	public String uptoFile(@RequestParam("filett") CommonsMultipartFile file,HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("uptoFile");
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		File ff = new File(path);
		ff.mkdir();
		System.out.println(path);
		file.transferTo(new File(path,nname));
		path = "/imgg"+"/"+nname;
		System.out.println(path);
		return "/upload/"+nname;
	}

}
