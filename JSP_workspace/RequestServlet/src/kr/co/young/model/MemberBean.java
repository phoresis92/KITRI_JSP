package kr.co.young.model;

public class MemberBean {

	//1. 이름 String
	//2. 이메일 String
	
	private String name;
	public MemberBean() {
	}

	private String email;
	
	public MemberBean(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "name=" + name + ", email=" + email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
}
