package serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GoodsDao;
import dao.TypeDao;
import model.Goods;
import model.Type;
import model.User;
import service.GoodsService;

@Service
public class GoodsServiceImpl  implements GoodsService  {

	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	TypeDao typeDao;
	

	public GoodsServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insert(goods);
	}

	public int delById(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.delById(goods);
	}

	public int update(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.update(goods);
	}


	public List<Goods> selAll(int page, int limit) {
		// TODO Auto-generated method stub
		Map<Integer, String> types = getType();
		List<Goods> goods = new ArrayList<Goods>();
		goods = goodsDao.selAll(page, limit);
		for (Goods goods2 : goods) {
			goods2.setGclassname(types.get(goods2.getGclassid()));
		}
		return goods;
	}


	public int selAllNum() {
		// TODO Auto-generated method stub
		return goodsDao.selAllNum();
	}


	public List<Goods> selByName(String txt, int page, int limit) {
		// TODO Auto-generated method stub
		Map<Integer, String> types = getType();
		List<Goods> goods = new ArrayList<Goods>();
		goods = goodsDao.selByName(txt, page, limit);
		for (Goods goods2 : goods) {
			goods2.setGclassname(types.get(goods2.getGclassid()));
		}
		return goods;
	}


	public int selFindNum(String txt) {
		// TODO Auto-generated method stub
		return goodsDao.selFindNum(txt);
	}
	
	private Map<Integer, String> getType() {

		Map<Integer, String> types = new HashMap<Integer, String>();

		List<Type> typelist = typeDao.selecteAll();
		for (Type type : typelist) {
			types.put(type.getTid(), type.getTname());
		}
		return types;
	}

}
