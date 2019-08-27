package service;

import java.util.List;

import model.User;

public interface UserService {
	List<User> selAll();
	
	List<User> selAllPage(int page,int limit);
	
	int selAllNum();
	
	int selFindNum(String txt);

	User selOne(int uid);
	
	List<User> selByName(String txt,int page ,int limit);
	
	int delById(int uid);
	
	int insert(User user);
	
	int update(User user);
}
