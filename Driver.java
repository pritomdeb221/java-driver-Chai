package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver{
	static Scanner sc = new Scanner(System.in);
	private String name, email, pass, carName, s;
	List<Integer> loc_id = new ArrayList<>();
	
	public Driver(String name, String email, String pass, String carName, List<Integer> loc_id) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.carName = carName;
		this.loc_id = loc_id;
	}
	public Driver() {
		System.out.println("Driver's Choice");
		System.out.println("1. See Bookings");
		System.out.println("2. Edit Profile");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: /* new seeBookings(); */
		break;
		case 2: 
			break;
		}
	}
	
	public Driver(String s) {
		this.s = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public List<Integer> getLoc_id() {
		return loc_id;
	}
	
	public String getLoc_id_str() {
		String id="";
		for(int i=0; i<loc_id.size(); i++) {
			id += loc_id.get(i)+".";
		}
		return id;
	}
	
	public List<Integer> getLoc_id_str_arr() {
	    List<Integer> id = new ArrayList<>();
	    String t = "";
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) != '.') {
	            t += s.charAt(i);
	        } else {
	            id.add(Integer.parseInt(t));
	            t = "";
	        }
	    }
	    
	    if (!t.isEmpty()) {
	        id.add(Integer.parseInt(t));
	    }
	    
	    return id;
	}

	public void setLoc_id(List<Integer> loc_id) {
		this.loc_id = loc_id;
	}
	public String getPass() {
		return pass;
	}

}
