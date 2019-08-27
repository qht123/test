package pojo;

import java.sql.*;
import java.util.*;

public class User {

	private Double sellprofit;
	private String password;
	private String name;
	private Double sellPrice;
	private Integer power;
	private Integer sellNum;

	public Double getSellprofit(){
		return sellprofit;
	}

	public String getPassword(){
		return password;
	}

	public String getName(){
		return name;
	}

	public Double getSellPrice(){
		return sellPrice;
	}

	public Integer getPower(){
		return power;
	}

	public Integer getSellNum(){
		return sellNum;
	}

	public void setSellprofit(Double sellprofit){
		this.sellprofit = sellprofit ;
	}

	public void setPassword(String password){
		this.password = password ;
	}

	public void setName(String name){
		this.name = name ;
	}

	public void setSellPrice(Double sellPrice){
		this.sellPrice = sellPrice ;
	}

	public void setPower(Integer power){
		this.power = power ;
	}

	public void setSellNum(Integer sellNum){
		this.sellNum = sellNum ;
	}

}
