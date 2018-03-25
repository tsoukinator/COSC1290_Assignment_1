package assignment1;

import java.util.ArrayList;
import java.util.List;
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
		      String Image = keyboard.next( ); 
		      
			Account newUser = new Account(count++, FName, LName, Age, Status, Image);
			System.out.printf("ID: " + newUser.getID() + "%n" + "Age: " + newUser.getAge() + "%n" + "Name: " + newUser.getFName() + " " + newUser.getSName() + "%n" + "Status: " + newUser.getStatus() + "%n" + "Image: " + newUser.getImage() + "%n" + "%n");
				
	}
	
	public void SearchAccount() {
		// Searches for an existing profile
		int idSearch = keyboard.nextInt( );
		System.out.println(Account.getFName(idSearch));
	}
	
	public static void DisplayProfile() {
		// Displays a profile
		
	}
	
	public static void UpdateProfile() {
		// Updates a profile - allows for changing details
		
	}
	
	public static void DeleteProfile() {
		// Removes a profile - ideally by id or name
		
	}
	
	public static void ConnectProfile() {
		// Assigns friendship or family connections between users
		
	}
	
	public static void ConnectStatus() {
		// Checks friendship or family connections between users
		
	}
	
	public static void FamilyConnection() {
		// Checks if person has children/parents in system
		
	}
	

}

