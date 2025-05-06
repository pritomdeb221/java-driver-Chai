package project;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	static private List<User> users = new ArrayList<>();
	static private List<Driver> drivers = new ArrayList<>();
	private Driver driver;
	Scanner sc = new Scanner(System.in);
	
	public Login() {
		
	}
	
	public Login(String s) {
		if(s.equals("user")) {
			System.out.print("Enter username: ");
			String name = sc.next();
			System.out.print("Enter password");
			String pass = sc.next();
			boolean login = checkUserLogin(name,pass);
			if(login) {
				new BookACar(name);
			}
			else {
				new UserSystem();
			}
		}
		else if(s.equals("driver")) {
			System.out.print("Enter username: ");
			String name = sc.next();
			System.out.print("Enter password");
			String pass = sc.next();
			boolean login = checkDriverLogin(name,pass);
			if(login) {
				new BookingSelect(driver);
			}
			else {
				new UserSystem();
			}
		}
		else {
			System.out.print("Enter username: ");
			String name = sc.next();
			System.out.print("Enter password: ");
			String pass = sc.next();
			
			if(name.equals("Admin") && pass.equals("admin")) {
				new AdminSystem();
			}
		}
	}
	private boolean checkDriverLogin(String n, String p) {
		getDrivers();
		for(Driver driver: drivers) {
			if (driver.getName().equals(n) && driver.getPass().equals(p)) {
				this.driver = driver;
                return true;
            }
		}
		return false;
	}
	public List<Driver> getDrivers() {
		try (DataInputStream inputStream = new DataInputStream(new FileInputStream("Drivers.dat"))) {
            while (true) {
            	String name, email, pass, carName, locs;
            	
                while (true) {
                	name = inputStream.readUTF();
                	email = inputStream.readUTF();
                	pass = inputStream.readUTF();
                	carName = inputStream.readUTF();
                	locs = inputStream.readUTF();
                	Driver d = new Driver(locs);
					Driver driver = new Driver(name, email, pass, carName, d.getLoc_id_str_arr());
                	drivers.add(driver);
                }
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (Exception e) {
//            e.printStackTrace();
        	System.out.println("No record found :(");
        }

        return drivers;
	}
	private boolean checkUserLogin(String n, String p) {
		getUsers();
		for(User user: users) {
			if (user.getName().equals(n) && user.getPassword().equals(p)) {
                return true;
            }
		}
		return false;
	}
	public List<User> getUsers() {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("Users.dat"))) {
        	String name, email, password;
            while (true) {
            	name = inputStream.readUTF();
            	email = inputStream.readUTF();
            	password = inputStream.readUTF();
            	User user = new User(name, email, password);
            	users.add(user);
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (Exception e) {
//            e.printStackTrace();
        	System.out.println("No record found :(");
        }

        return users;
    }
}