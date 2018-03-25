package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Driver {
	static int count = 0;
	static Scanner keyboard = new Scanner(System.in);
	
	static Account[] accountList = new Account[50]; 
	
	public static void main(String[] args) {
	
	}
	
	public static void AutoAdd() {
		accountList[count++] = new Account(count, "Anthony", "Tsoukas", 27, "VerySingle", "Tsoukinator.jpg");
		accountList[count++] = new Account(count, "Chris", "Stefani", 25, "CoolDude", "FIFA-Runescape-Pro.jpg");
		accountList[count++] = new Account(count, "Kevin", "Johnson", 45, "SuaveDude", "BigKev.jpg");
		accountList[count++] = new Account(count, "David", "Lee", 26, "LikesWinnieBlue", "FPS4LYF.jpg");
		accountList[count++] = new Account(count, "David", "Gibb", 40, "LikesProgramming", "TheGibbster.jpg");
	}
	
	
	public static void AddHenry( ) {
		// Test import method
		String FName = "Petrie";
		String LName = "Bird";
		int Age = 5;
		String Status = "Alive";
		String Image = "Bird.jpg";
		
		accountList[count++] = new Account(count, FName, LName, Age, Status, Image);
	//	accountList[count++] = new Account(count, "Henry", "Tran", 20, "Something", "Maybe.jpg");
	}
	
	public static void InputAccount(int ID, char action) {
		// Method used purely for receiving user details
		// Name(2), Age, Status, Image
		
		if (action == 'c') {
			System.out.println("Enter your new account. Type in Name, Age, Status, and Image.");
		}
		if (action == 'u') {
			System.out.println("Edit details of an existing account. Type in Name, Age, Status, and Image.");
		}
		
	      // First Name
	      String FName = keyboard.next( );          
	      // Last Name
	      String SName = keyboard.next( );   
	      // Age
	      int Age = keyboard.nextInt( ); 
	      // Status
	      String Status = keyboard.next( ); 
	      // Image
	      String Image = keyboard.next( );
		
	      if (action == 'c') {
	    	  CreateAccount(FName, SName, Age, Status, Image);
	      }
	      if (action == 'u') {
	    	  UpdateAccount(ID, action, FName, SName, Age, Status, Image);
	      }
	      
	}
	
	public static void CreateAccount(String FName, String SName, int Age, String Status, String Image) {

		char createLoop = 'y';
		String keyInput;
		
		while (createLoop != 'n') {
	
			accountList[count++] = new Account(count, FName, SName, Age, Status, Image);

			int searchID = count - 1;
			System.out.printf("------------------------------------- %n");
			System.out.printf("Account Successfully Created: %n");
			System.out.printf("------------------------------------- %n %n");
			System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
			System.out.printf(" %n %n Would you like to create another account? (Y/N): ");
			
			keyInput = keyboard.next( );
			keyInput = keyInput.toLowerCase();
			
			switch (keyInput) {
			case "y":
				createLoop = 'y';
				Driver.InputAccount(0, 'c');
				break;
				
			case "n":
				createLoop = 'n';
				break;
			
			default:
				System.out.println("Invalid Response. Exiting Create Screen.");
				createLoop = 'n';
				break;
			}
		}
	}
	

	public static Account FindAccount() {
			int foundUser = -1;
			
			System.out.println("Type in the name of the person you want to find.");
			String input = keyboard.next( ); 
			boolean findflag = false;
 
			for (int i = 0; i < count; i++) {
		        String str = accountList[i].getFName();
		        if (str.equals(input))
		        	
		        {
		        	findflag = true;
		            // Return account ID with matching search value
		        	foundUser = i;
		        	Driver.DisplayAccount(i);
		        	
		        	break;
		//            return accountList[i];        	
		        }
		        else
		        {
		        		/// If not found, search next record in Array.
		        }     
		    }
		    
		    
	        if (findflag == false) {
		        System.out.println("No User with that name found.");
	        }
	        
		    // Not found, return null
	        
	        if (findflag == true) {
	        	char userMenuLoop = 'y';
	        	char action = ' ';
	        			
	        	while (userMenuLoop == 'y') {
	        	
		        System.out.println("What would you like to do with this user?");
		        int keyInput = keyboard.nextInt( );
				
		        switch (keyInput) {
				case 1:
					// Update Details
					action = 'u';
					Driver.InputAccount(foundUser, action);
					System.out.println("Profile Updated.");
					userMenuLoop = 'n';
					break;
					
				case 2:
					// Delete User
					action = 'd';
					Driver.UpdateAccount(foundUser, action, "", "", 0, "", "");
					System.out.println("User Removed.");
					userMenuLoop = 'n';
					break;
				
				case 3:
					// See Friendships
					
				case 4:
					// See family relationships
					
				case 5:
					// Go back
					break;
					
				default:
					System.out.println("Invalid Response. Exiting User Search.");
					userMenuLoop = 'n';
					break;
				}
	        	} 
	        }
	        
	        return null;
    
	}
	
	
	public static int DisplayAccount(int ID) {
		int searchID = ID;
    	System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
    	return ID;
	}
	
	public static void UpdateAccount(int ID, char action, String FName, String SName, int Age, String Status, String Image) {
		// Updates or removes a profile
		
		int searchID = ID;
		
		// If "Delete" Action is commissioned, set the ID to 0 (other variables will also come over as null or zero)
		if (action == 'd') {
	           	accountList[searchID].setID(0);
							}
		// Continue on overwriting current variable values with either new updates or nulls/zeroes
		        accountList[searchID].setFName(FName);
		        accountList[searchID].setSName(SName);
		        accountList[searchID].setAge(Age);
		        accountList[searchID].setStatus(Status);
		        accountList[searchID].setImage(Image);
		}
	

	public static void ConnectAccounts() {
		// Assigns friendship or family connections between users
		
	}
	
	public static void ConnectStatus() {
		// Checks friendship or family connections between users
		
	}
	
	public static void FamilyConnection() {
		// Checks if person has children/parents in system
		
	}
	
	public static void DisplayAllAccounts() {
		for (int i = 0 ; i < count; i++)
		{
		System.out.printf("ID: " + accountList[i].getID() + " Name: " + accountList[i].getFName() + " " + accountList[i].getSName() + " Age: " + accountList[i].getAge() + " Status: " + accountList[i].getStatus() + " Image: " + accountList[i].getImage() + "%n");
		}
		
	}
}

