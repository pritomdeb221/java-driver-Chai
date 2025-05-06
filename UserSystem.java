package project;
import java.util.Scanner;

public class UserSystem{
	public UserSystem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---User's Choice---");
		System.out.println("1. Login");
		System.out.println("2. Signup");
		System.out.println("3. Home");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: new UserLogin("user");
		break;
		case 2: new Registration("user");
		break;
		default: new Main();
		}
	}
	
}