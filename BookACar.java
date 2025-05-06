package project;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookACar {
	Scanner sc = new Scanner(System.in);
	Scanner str_sc = new Scanner(System.in);
	private String name, details;
	private int place_no;
	static private String[] place = {"Jatrabari","Kamalapur","Motijheel","Agargaon","Badda","Hatijheel",
							  "Natunbajar","Gulshan","Banani","Bashundara","Dhanmondi","Uttara"}; 
	
	public BookACar() {
		//
	}
	
	public BookACar(String name) {
		this.name = name;
		System.out.println("Welcome! "+name+", Book A Car");
		System.out.print("Enter place no. you wanna go: ");
		for(int i=0; i<place.length; i++) {
			System.out.println((i+1)+". "+place[i]);
		}
		place_no = sc.nextInt();
		System.out.print("Enter your journey details: ");
		details = str_sc.nextLine();
		
		BookACarDetails bcd = new BookACarDetails(name,place_no,details);
		
		try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("BookAcar.dat",true))) {
			outputStream.writeUTF(bcd.getName());
			outputStream.writeInt(bcd.getPlace_no());
			outputStream.writeUTF(bcd.getDetails());
//			System.out.println("book a car data stored");
            
//            System.out.println("Driver object saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String[] getPlace() {
		return place;
	}
	public static void setPlace(String[] place) {
		BookACar.place = place;
	}
	
	public List<BookACarDetails> getBookings() {
		List<BookACarDetails> bcds = new ArrayList<>();
		try (DataInputStream inputStream = new DataInputStream(new FileInputStream("BookAcar.dat"))) {
			String name,details;
			int place_no;
			while (true) {
            	name = inputStream.readUTF();
            	place_no = inputStream.readInt();
            	details = inputStream.readUTF();
//            	System.out.println(name+place_no+details);
            	
            	BookACarDetails bcd = new BookACarDetails(name,place_no,details);
            	bcds.add(bcd);
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (Exception e) {
//            e.printStackTrace();
        	System.out.println("No record found :(");
        }
		return bcds;
	}
	
}
