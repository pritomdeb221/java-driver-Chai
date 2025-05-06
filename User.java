package project;

public class User{
	private String name,email,password;
	
	public User(String n, String e, String p) {
		name =n;
		email = (e);
		password = p;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
