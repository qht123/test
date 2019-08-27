package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserDao {

	@Select("select * from t_user ")
	List<User> selAll();
	
	@Select("select * from t_user limit #{0},#{1}")
	List<User> selAllPage(int page,int limit);
	
	@Select("select count(*) from t_user ")
	int selAllNum();
	
	@Select("select count(*) from t_user where uname like #{0}")
	int selFindNum(String txt);
	
	
	@Select("select * from t_user where uid = #{uid}")
	User selOne(int uid);
	
	@Select("select * from t_user where uname like #{0} limit #{1},#{2}")
	List<User> selByName(String txt,int page,int limit);
	
	@Delete("delete from t_user where uid = #{uid}")
	int delById(int uid);
	
	@Insert("insert into t_user(uname,pwd,sex,age,birth,power,sales) values(#{uname},#{pwd},#{sex},#{age},#{birth},#{power},#{sales})")
	int insert(User user);
	
	@Update("update t_user set uname=#{uname},pwd=#{pwd},sex=#{sex},age=#{age},birth=#{birth},power=#{power},sales=#{sales} where uid=#{uid}")
	int update(User user);
}
