package project;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSelect {
	Scanner sc = new Scanner(System.in);
	public BookingSelect(Driver driver) {
		BookACar bac = new BookACar();
		List<BookACarDetails> bcds = new ArrayList<>();
		bcds = bac.getBookings();
		List<Integer> locs = driver.getLoc_id();
		System.out.println("You can accept one: [or 0 to go back home]");
		System.out.println("id\tName\tPlace_no\tDetails");
		BookACarDetails bcdSelected=null;
		
//		for(int i=0; i<locs.size(); i++) {
//			System.out.println(locs.get(i));
//		}
		
		for(BookACarDetails bcd: bcds) {
			for(int i=0; i<locs.size(); i++) {
				if(bcd.getPlace_no()==locs.get(i)) {
					System.out.println((i+1)+"\t"+bcd.getName()+"\t"+bcd.getPlace_no()+"\t\t"+bcd.getDetails());
					bcdSelected = bcd;
				}
			}
		}
		int choice = sc.nextInt();
		if(choice==0 || bcdSelected==null) {
			new Main();
		}
		
		//done
		else {
			System.out.println("You selected "+choice);
			for(BookACarDetails bcd: bcds) {
				for(int i=0; i<locs.size(); i++) {
					if(bcd.getPlace_no()==locs.get(i) && (i+1)==choice) {
//						System.out.println((i+1)+"\t"+bcd.getName()+"\t"+bcd.getPlace_no()+"\t\t"+bcd.getDetails());
						bcdSelected = bcd;
					}
				}
			}
			try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("BookAcar.dat"))) {
				for(BookACarDetails bcd: bcds) {
					if(bcd.getName()!=bcdSelected.getName())
						{
						outputStream.writeUTF(bcd.getName());
						outputStream.writeInt(bcd.getPlace_no());
						outputStream.writeUTF(bcd.getDetails());
						}
				}
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}

}
