package service;

import java.util.List;

import model.Goods;

public interface GoodsService {

	List<Goods> selAll(int page,int limit);
	
	int insert(Goods goods);
	
	int delById(Goods goods);
	
	int update(Goods goods);

	int selAllNum();

	List<Goods> selByName(String txt,int page,int limit);
	
	int selFindNum(String txt);

}
