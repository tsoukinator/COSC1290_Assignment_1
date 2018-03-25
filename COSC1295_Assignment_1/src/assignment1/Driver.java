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
	
	public static void CreateAccount() {

		
		char createLoop = 'y';
		String keyInput;
		
		while (createLoop != 'n') {
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
		      

			accountList[count++] = new Account(count, FName, LName, Age, Status, Image);
			
			
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
	
	
	public static void SearchAccount() {

		String accString;
		accString = accountList.toString();
		System.out.println(accString);
		
		/*
	System.out.println("Search Command Awaiting. Type a search term:");
		String keyInput = keyboard.next( );

		boolean check = false;
		for (int i = 0 ; i < accountList.length; i++)
		{
			if (accountList[i] == keyInput) {
				check = true;
			}

		}
	
		
		
	int ID = 1;
			int index = -1;
			
	for (int i=0;i<accountList.length;i++) {
    if (accountList[i].equals(ID)) {
        index = i;
        break;
    }
    }
}
	
	/*
		int x = accountList.length;
		accountList.toString()
		
	for (int i = 0; i < accountList.length; i++) {
        for (int j = 0; j < 6; j++) {
            if (accountList[i][j] == "Anthony") {
                System.out.println("Next available seat at position: [" + i + "][" + j + "]");
            }
        }
 }
System.out.println("No seat available");

/*
		// Searches for an existing profile
		int idSearch = keyboard.nextInt( );
		
		int ID = 0;
		
		Account User = getFName(ID);	
		
		System.out.println(newUser.getFName(idSearch));
		
		Account.getFName(idSearch);
		System.out.println(Account.getFName(idSearch));
			*/
	}	

	
	public static Account DisplayProfile() {
		
			System.out.println("Type in the name of the person you want to find.");
			String input = keyboard.next( ); 
			boolean findflag = false;
			
		    for (int i = 0; i < count; i++) {
		        String str = accountList[i].getFName();
		        if (str.equals(input))
		        	
		        {
		        	findflag = true;
		            // Return account ID with matching search value
		        	int searchID = (accountList[i].getID() -1);
		        	System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
		//            return accountList[i];        	
		        }
		        else
		        {
		        		///
		        }
		        
		    }
		    
	        if (findflag == false) {
		        System.out.println("No User with that name found.");
	        }

		    // Not found, return null
	        
	        return null;
		
				/*

		// Displays a profile
		String searchName = keyboard.next( ); 
		int searchID = Arrays.asList(accountList).indexOf(searchName) +1;
		
		System.out.println(Arrays.asList(accountList[2].toString()));
		System.out.println(searchID);
		
		System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
		
		*/
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
	
	public static void DisplayAllHumans() {

		int vLength = accountList.length;	
		for (int i = 0 ; i < count; i++)
		{
		System.out.printf("ID: " + accountList[i].getID() + " Name: " + accountList[i].getFName() + " " + accountList[i].getSName() + " Age: " + accountList[i].getAge() + " Status: " + accountList[i].getStatus() + " Image: " + accountList[i].getImage() + "%n");
		}
		
	}
}

