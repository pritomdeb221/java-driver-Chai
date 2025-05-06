package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminSystem {
	private List<User> users = new ArrayList<>();
	private List<Driver> drivers = new ArrayList<>();
	List<BookACarDetails> bcds = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public AdminSystem() {
		System.out.println("Admin's Dashboard");
		System.out.println("1. User Details");
		System.out.println("2. Driver Details");
		System.out.println("3. Booking Details");
		System.out.println("4. Home");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: {
			showUsers();
//			edited
			System.out.println("");
			new AdminSystem();
		}
		break;
		case 2: {
			showDrivers();
			// edited
			System.out.println("");
			new AdminSystem();
		}
		break;
		case 3: {
			showBcds();
//			edited
			System.out.println("");
			new AdminSystem();
		}
		break;
		default: new Main();
		}
	}
	public void showBcds() {
		System.out.println("Booking details");
		System.out.println("Name\tPlace_no\tDetails");
		BookACar bac = new BookACar();
		bcds = bac.getBookings();
		for (BookACarDetails bcd : bcds) {
            System.out.println(bcd.getName()+"\t"+bcd.getPlace_no()+"\t"+bcd.getDetails());
        }
	}
	public void showUsers() {
		System.out.println("User Details");
		System.out.println("Name\tEmail");
		Login L = new Login();
		users = L.getUsers();
		for (User user : users) { /*int i=0; for(User user=users.getindex(i); i<users.size(); i++)*/
            System.out.println(user.getName()+"\t"+user.getEmail());
        }
	}
	
	public void showDrivers() {
		System.out.println("Driver Details");
		System.out.println("Name\tEmail\tCar");
		Login L = new Login();
		drivers = L.getDrivers();
		for (Driver driver : drivers) {
            System.out.println(driver.getName()+"\t"+driver.getEmail()+"\t"+driver.getCarName());
        }
	}
}
