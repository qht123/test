package Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.User;

public class UserService{
	private List<User> users = null;
	private static InputStream is = null;
	private static SqlSessionFactory factory = null;
	private  SqlSession sqlSession  = null;
	
	static {
		try {
			is = Resources.getResourceAsStream("mybaits.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void creatMyBaites() {
		sqlSession = factory.openSession();
	}
	
	public List<User> selUsers() {
		creatMyBaites();
		List<User> users = sqlSession.selectList("a.b.selAll");
		sqlSession.close();
		return users;
	}
	
	public List<User> selUsersToPage(int page,int limit) {
		creatMyBaites();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<User> users = sqlSession.selectList("a.b.selAllToPage",map);
		sqlSession.close();
		return users;
	}
	
	public int usersNum() {
		creatMyBaites();
		int num = sqlSession.selectOne("a.b.selAllNum");
		sqlSession.close();
		return num;
	}
	
	public int del(User user) {
		creatMyBaites();
		int index = sqlSession.delete("a.b.del",user);
		System.out.println(index);
		sqlSession.commit();
		sqlSession.close();
		return index;
	}
	
	
	public static void main(String[] args) {
		UserService userService = new UserService();
			userService.selUsers();
	}
	

}
