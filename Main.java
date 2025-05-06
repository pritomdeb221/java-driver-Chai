package project;

import java.util.Scanner;

public class
		Main extends greetings implements runable{
	public static void main(String[] args) {
		Main m = new Main();
		m.message();
		m.run();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Who are you?");
			System.out.println("1. Admin");
			System.out.println("2. Driver");
			System.out.println("3. User");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: new AdminLogin("admin");
				break;
			case 2: new DriverSystem();
				break;
			case 3: new UserSystem();
				break;
//			default: System.exit(0);
			}
		}
	}

	@Override
	public void message() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to DriverChai!\n\n");
		System.out.println("Enter any key to continue...");
		sc.nextLine();
	}
}