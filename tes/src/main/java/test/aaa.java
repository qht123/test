package test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import junit.framework.TestCase;

public class aaa {

	String name;
	public aaa() {
		// TODO Auto-generated constructor stub
	}
	public int sss1() {
		int a = 100;
		int b = 200;
		return a+b;
	}
	public static void main(String[] args) throws IOException {
		ObjectMapper om = new ObjectMapper();
		Person person = new Person();
		person.setAge(33);
		person.setName("dfas");
		String json = om.writeValueAsString(person);
		System.out.println(json);
		Person person2 = om.readValue(json, Person.class);
		System.out.println(person);
		System.out.println(person2+" "+person2.getName());
	}

}
