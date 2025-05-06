package project;
import java.util.Scanner;

public class DriverSystem{
	
	public DriverSystem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---Driver's Choice---");
		System.out.println("1. Login");
		System.out.println("2. Signup");
		System.out.println("3. Menu");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: new DriverLogin("driver");
		break;
		case 2: new Registration("driver");
		break;
		default: new Main();
		}
	}
}
