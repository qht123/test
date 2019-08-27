package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Goods;
import model.User;

@Repository
public interface GoodsDao {

	@Select("select * from goods limit #{0},#{1}")
	List<Goods> selAll(int page ,int limit);
	
	@Select("select * from goods where gname like #{0} limit #{1},#{2}")
	List<Goods> selByName(String txt,int page,int limit);
	
	@Select("select count(*) from goods where gname like #{0}")
	int selFindNum(String txt);
	
	@Insert("insert into goods(gname,gsprice,gnum,gbprice,gclassid,gsumprice) values(#{gname},#{gsprice},#{gnum},#{gbprice},#{gclassid},#{gsumprice})")
	int insert(Goods goods);
	
	@Delete("delete from goods where gid = #{gid}")
	int delById(Goods goods);
	
	@Update("update goods set gname = #{gname},gsprice=#{gsprice},gnum=#{gnum},gbprice=#{gbprice},gclassid=#{gclassid},gsumprice=#{gsumprice} where gid = #{gid}")
	int update(Goods goods);
	
	@Select("select count(*) from goods ")
	int selAllNum();
	
}
