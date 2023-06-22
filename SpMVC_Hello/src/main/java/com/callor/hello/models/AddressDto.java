package com.callor.hello.models;



/*
 * string framework project 에서 DTO데이터 클래스는
 * 모든 변수를 private로 선언한다.
 * 또한 생성자와 getter , setter method를 필수로 선언해야 한다.
 * jsp와 연동을 할 따 el tag(${변수})를 사용할 때 
 * 내부적으로 getter method를 사용하기 때문이다.
 */

public class AddressDto {

//	attribute : 속성 : data class의 변수 들
	private String name;
	private String tel;
	private String address;
	private int age;

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDto(String name, String tel, String address, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AddressDto [name=" + name + ", tel=" + tel + ", address=" + address + ", age=" + age + "]";
	}

	
	
	
}
