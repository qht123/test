package service;

import java.util.List;

import model.Type;

public interface TypeService {

	List<Type> selAll(int page,int limit);
	
	List<Type> selectAll();
	
	int insert(Type type);
	
	int delById(Type type);
	
	int update(Type type);

	int selAllNum();

	List<Type> selByName(String txt,int page,int limit);
	
	int selFindNum(String txt);

}
