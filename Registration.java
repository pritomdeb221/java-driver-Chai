package project;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration {
	Scanner sc = new Scanner(System.in);
	Scanner str_sc = new Scanner(System.in);
	public Registration(String s) {
		if(s.equals("user")) {
			System.out.println("User Registration");
			System.out.print("Enter username: ");
			String username = sc.next();
			System.out.print("Enter Email: ");
			String email = sc.next();
			System.out.print("Enter Password: ");
			String pass = sc.next();
			
			User user = new User(username,email,pass);
			
			try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("Users.dat", true))) {
				outputStream.writeUTF(user.getName());
				outputStream.writeUTF(user.getEmail());
				outputStream.writeUTF(user.getPassword());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		else {
			System.out.println("Driver Registration");
			System.out.print("Enter username: ");
			String username = sc.next();
			System.out.print("Enter Email: ");
			String email = sc.next();
			System.out.print("Enter Password: ");
			String pass = sc.next();
			System.out.print("Enter car name: ");
			String car = str_sc.nextLine();
			System.out.print("Enter location id you can go(enter 0 to end): ");
			BookACar bac = new BookACar();
			String[] place = bac.getPlace();
			for(int i=0; i<place.length; i++) {
				System.out.println((i+1)+". "+place[i]);
			}
			List<Integer> p_id = new ArrayList<>();;
			for(int i=0; i<place.length; i++) {
				p_id.add(sc.nextInt());
				if(p_id.get(i)==0){
					break;
				}
			}
			
			Driver driver = new Driver(username, email, pass, car, p_id);
			
			try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("Drivers.dat", true))) {
				outputStream.writeUTF(driver.getName());
				outputStream.writeUTF(driver.getEmail());
				outputStream.writeUTF(driver.getPass());
				outputStream.writeUTF(driver.getCarName());
				outputStream.writeUTF(driver.getLoc_id_str());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			new DriverSystem();
		}
	}
}
