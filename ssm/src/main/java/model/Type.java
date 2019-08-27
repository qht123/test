package model;

import java.sql.*;
import java.util.*;

public class Type {

	private String tname;
	private Integer tid;

	public String getTname(){
		return tname;
	}

	public Integer getTid(){
		return tid;
	}

	public void setTname(String tname){
		this.tname = tname ;
	}

	public void setTid(Integer tid){
		this.tid = tid ;
	}

}
