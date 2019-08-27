package model;

public class User {
	private String uname;
	private String pwd;
	private int uid;
	private int sex;
	private int age;
	private String birth = "1900-01-01";
	private int power=0;
	private double sales=0; 
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public User(String uname, String pwd, int uid, int sex, int age, String birth) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.uid = uid;
		this.sex = sex;
		this.age = age;
		this.birth = birth;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String uname, String pwd, int uid, int sex, int age) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.uid = uid;
		this.sex = sex;
		this.age = age;
	}

	

}
