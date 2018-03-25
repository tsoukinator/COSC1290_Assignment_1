package assignment1;

import java.util.Scanner;

import assignment1.Objects.*;

public class Driver {
	static int count = 0;
	static Scanner keyboard = new Scanner(System.in);
	
	static Account[] accountList = new Account[50]; 
	
	public static void main(String[] args) {
		System.out.println("Why did you call me? I don't do anything...");
	}
	
	public static void AutoAdd() {
		accountList[count++] = new Adult(count, "Anthony", "Tsoukas", 27, "VerySingle", "Tsoukinator.jpg");
		accountList[count++] = new Adult(count, "Chris", "Stefani", 25, "CoolDude", "FIFA-Runescape-Pro.jpg");
		accountList[count++] = new Adult(count, "Kevin", "Johnson", 45, "SuaveDude", "BigKev.jpg");
		accountList[count++] = new Adult(count, "David", "Lee", 26, "LikesWinnieBlue", "FPS4LYF.jpg");
		accountList[count++] = new Adult(count, "David", "Gibb", 40, "LikesProgramming", "TheGibbster.jpg");
	}
	
	public static void AddHenry( ) {
		// Test import method
		String FName = "Petrie";
		String LName = "Bird";
		int Age = 5;
		String Status = "Alive";
		String Image = "Bird.jpg";
		
		accountList[count++] = new Child(count, FName, LName, Age, Status, Image);
	//	accountList[count++] = new Account(count, "Henry", "Tran", 20, "Something", "Maybe.jpg");
	}
	
	public static void InputAccount(int ID, char action) {
		// Method used purely for receiving user details
		// Passes the details to either the "Create" account method (to create account)
		// or the "Update" Account method (to update existing details, or to remove an account)
		
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
	
			if (Age >= 18) {
				accountList[count++] = new Adult(count, FName, SName, Age, Status, Image);
			}
			else if (Age > 2) {
				accountList[count++] = new Child(count, FName, SName, Age, Status, Image);
			}
			else {
				accountList[count++] = new Infant(count, FName, SName, Age, Status, Image);
			}
			
			
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
	
	public static int DisplayAccount(int ID) {
		// Method purely used for displaying an account as a result of a search from "FindAccount"
		// The idea was to separate it out in case another method may have also required this functionality.
		int searchID = ID;
    	System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
    	return ID;
	}
	
	public static Account FindAccount() {
			int foundUser = -1;
			String selectInput;
			
			System.out.println("Type in the name of the person you want to find.");
			String input = keyboard.next( ); 
			boolean findflag = false;
 

			for (int i = 0; i < count; i++) {
		        String str = accountList[i].getFName();
		        if (str.contains(input))
		        	
		        {
		        	findflag = true;
		            // Return account ID with matching search value
		        	foundUser = i;
		        	Driver.DisplayAccount(i);
		        	
		        	// Ask user if this is the person they are looking for
					System.out.printf(" %n %n Is this the person you are looking for? (Y/N): ");
					
					selectInput = keyboard.next( );
					selectInput = selectInput.toLowerCase();
					
					switch (selectInput) {
					case "y":
						// Kill the loop since break isn't cooperating...
						i = i + count;
						break;
						
					case "n":
						findflag = false;
								
					default:
						System.out.println("Invalid Response. Continuing search.");
						findflag = false;
					}
		        	
		        //	       	
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
	        	
		        System.out.println("What would you like to do with this user?"						
		        		+ "\n1. Update Details"
						+ "\n2. Remove User"
						+ "\n3. See Friendships"
						+ "\n4. See Family Relationships"
						+ "\n \n9. Return to Menu"
						+ "\n \n" + "\n" + "Type an option: ");

		        int keyInput = keyboard.nextInt( );
				
		        switch (keyInput) {
				case 1:
					// Update Details
					action = 'u';
					Driver.InputAccount(foundUser, action);
					System.out.printf("Profile Updated. %n");
					userMenuLoop = 'n';
					break;
					
				case 2:
					// Remove User
					action = 'd';
					Driver.UpdateAccount(foundUser, action, "", "", 0, "", "");
					System.out.printf("User Removed. %n");
					userMenuLoop = 'n';
					break;
				
				case 3:
					// See Friendships
					
				case 4:
					// See family relationships
					
				case 9:
					// Go back
					userMenuLoop = 'n';
					break;
					
				default:
					System.out.printf("Invalid Response. Exiting User Search. %n");
					userMenuLoop = 'n';
					break;
				}
	        	} 
	        }
	        
	        return null;
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
			if (accountList[i].getID() != 0) {
		System.out.printf("ID: " + accountList[i].getID() + " Name: " + accountList[i].getFName() + " " + accountList[i].getSName() + " Age: " + accountList[i].getAge() + " Status: " + accountList[i].getStatus() + " Image: " + accountList[i].getImage() + "%n");
		}
		// If ID equals zero, do not display user in list of users
		}
		
	}
}

