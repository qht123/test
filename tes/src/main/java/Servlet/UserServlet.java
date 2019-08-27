package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Service.UserService;
import pojo.User;

@WebServlet("/user")
public class UserServlet  extends BasicServlet{
	UserService us = new UserService();
	User model;
	String cmd;
	private void selAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
	
		resp.setContentType("text/html;charset=utf-8");
		List<User> users = us.selUsersToPage(page,limit);
		int num = us.usersNum();
		ObjectMapper om = new ObjectMapper();
		StringBuilder sb = new StringBuilder("{\"data\":");
		sb.append(om.writeValueAsString(users));
		sb.append(",\"count\":"+num+"}");
		
		System.out.println(page+"---"+limit+"---"+num);
		resp.getWriter().write(sb.toString());
	}
	
	private void del(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(model.getName());
		int index = us.del(model);
		if(index>0) {
			System.out.println("删除成功");
		}
	}
	

}
