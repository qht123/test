package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import model.Type;
import model.User;
import service.TypeService;

@Service
public class TypeServiceImpl  implements TypeService  {

	@Autowired
	TypeDao typeDao;

	
	public TypeServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	public int insert(Type type) {
		// TODO Auto-generated method stub
		return typeDao.insert(type);
	}

	public int delById(Type type) {
		// TODO Auto-generated method stub
		return typeDao.delById(type);
	}

	public int update(Type type) {
		// TODO Auto-generated method stub
		return typeDao.update(type);
	}


	public List<Type> selAll(int page, int limit) {
		// TODO Auto-generated method stub
		return typeDao.selAll(page, limit);
	}


	public int selAllNum() {
		// TODO Auto-generated method stub
		return typeDao.selAllNum();
	}


	public List<Type> selByName(String txt, int page, int limit) {
		// TODO Auto-generated method stub
		return typeDao.selByName(txt, page, limit);
	}


	public int selFindNum(String txt) {
		// TODO Auto-generated method stub
		return typeDao.selFindNum(txt);
	}


	public List<Type> selectAll() {
		// TODO Auto-generated method stub
		return typeDao.selecteAll();
	}

}
