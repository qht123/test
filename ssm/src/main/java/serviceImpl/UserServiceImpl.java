package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import dao.UserDao;
import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public List<User> selAll() {
		// TODO Auto-generated method stub
		return userDao.selAll();
	}

	public int delById(int uid) {
		// TODO Auto-generated method stub
		return userDao.delById(uid);
	}

	public int insert(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public User selOne(int uid) {
		// TODO Auto-generated method stub
		return userDao.selOne(uid);
	}

	public List<User> selByName(String txt,int page ,int limit) {
		// TODO Auto-generated method stub
		return userDao.selByName(txt,page,limit);
	}

	public int selAllNum() {
		// TODO Auto-generated method stub
		return userDao.selAllNum();
	}

	public List<User> selAllPage(int page, int limit) {
		// TODO Auto-generated method stub
		return userDao.selAllPage(page, limit);
	}

	public int selFindNum(String txt) {
		// TODO Auto-generated method stub
		return userDao.selFindNum(txt);
	}

}
