package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Type;
import model.User;

@Repository
public interface TypeDao {

	@Select("select * from type limit #{0},#{1}")
	List<Type> selAll(int page ,int limit);
	
	@Select("select * from type ")
	List<Type> selecteAll();
	
	@Select("select * from type where tname like #{0} limit #{1},#{2}")
	List<Type> selByName(String txt,int page,int limit);
	
	@Select("select count(*) from type where tname like #{0}")
	int selFindNum(String txt);
	
	@Insert("insert into type(tname) values(#{tname})")
	int insert(Type type);
	
	@Delete("delete from type where tid = #{tid}")
	int delById(Type type);
	
	@Update("update type set tname = #{tname} where tid = #{tid}")
	int update(Type type);
	
	@Select("select count(*) from type ")
	int selAllNum();
	
}
