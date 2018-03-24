package assignment1;

import java.util.Scanner;


public class Driver {
	static int count = 1;
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	}
	
	public static void CreateAccount() {


			System.out.println("Enter your new account. Type in Name, Age, Status, and Image");
			
			// Name(2), Age, Status, Image
		      // First Name
		      String FName = keyboard.next( );          
		      // Last Name
		      String LName = keyboard.next( );   
		      // Age
		      int Age = keyboard.nextInt( ); 
		      // Status
		      String Status = keyboard.next( ); 
		      // Image
		      String Image = keyboard.nextLine( ); 
		      
			Account e1 = new Account(count++, FName, LName, Age, Status, Image);
			System.out.printf("ID: " + e1.getID() + "%n" + "Age: " + e1.getAge() + "%n" + "Name: " + e1.getFName() + " " + e1.getSName() + "%n" + "Status: " + e1.getStatus() + "%n" + "Image: " + e1.getImage() + "%n" + "%n");
				
	}
	
	public static void SearchAccount() {
		
	}
	
	
}

