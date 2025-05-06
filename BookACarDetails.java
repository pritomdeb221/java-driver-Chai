package project;

public class BookACarDetails{
	private String name,details;
	private int place_no;
	
	public BookACarDetails(String n,int p,String d) {
		name = n;
		place_no = p;
		details = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlace_no() {
		return place_no;
	}

	public void setPlace_no(int place_no) {
		this.place_no = place_no;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
