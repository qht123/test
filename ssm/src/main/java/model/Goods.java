package model;

import java.sql.*;
import java.util.*;

public class Goods {

	private Double gbprice;
	private Integer gid;
	private Double gsprice;
	private Integer gclassid;
	private String gname;
	private Double gsumprice;
	private Double gnum;
	private String gclassname;

	public String getGclassname() {
		return gclassname;
	}

	public void setGclassname(String gclassname) {
		this.gclassname = gclassname;
	}

	public Double getGbprice(){
		return gbprice;
	}

	public Integer getGid(){
		return gid;
	}

	public Double getGsprice(){
		return gsprice;
	}

	public Integer getGclassid(){
		return gclassid;
	}

	public String getGname(){
		return gname;
	}

	public Double getGsumprice(){
		return gsumprice;
	}

	public Double getGnum(){
		return gnum;
	}

	public void setGbprice(Double gbprice){
		this.gbprice = gbprice ;
	}

	public void setGid(Integer gid){
		this.gid = gid ;
	}

	public void setGsprice(Double gsprice){
		this.gsprice = gsprice ;
	}

	public void setGclassid(Integer gclassid){
		this.gclassid = gclassid ;
	}

	public void setGname(String gname){
		this.gname = gname ;
	}

	public void setGsumprice(Double gsumprice){
		this.gsumprice = gsumprice ;
	}

	public void setGnum(Double gnum){
		this.gnum = gnum ;
	}

}
