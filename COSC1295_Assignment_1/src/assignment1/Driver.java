package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import assignment1.Objects.*;

public class Driver {
	// Placeholder variable for parentID finding
	public static int foundParent = -2;
	// Shared array to pass to other methods - defining parents
	public static ArrayList foundParents = null;
	// Shared array to pass to other methods - defining friendship creation between two people
	public static int foundFriend = -1;
	public static ArrayList friendshipArray = null;
	
	static int count = 0;
	
	static char createLoop = 'y';
	
	static Scanner keyboard = new Scanner(System.in);
	
	static Account[] accountList = new Account[50]; 
	
	public static void main(String[] args) {
		System.out.println("Why did you call me? I don't do anything...");
	}
	
	public static void AutoAdd() {
		ArrayList<Integer> nullList = new ArrayList<Integer>();
//		nullList.add(999);
		
		accountList[count++] = new Adult(count, "Anthony", "Tsoukas", 27, "VerySingle", "Tsoukinator.jpg", nullList, nullList);
		accountList[count++] = new Adult(count, "Chris", "Stefani", 25, "CoolDude", "FIFA-Runescape-Pro.jpg", nullList, nullList);
		accountList[count++] = new Adult(count, "Kevin", "Johnson", 45, "SuaveDude", "BigKev.jpg", nullList, nullList);
		accountList[count++] = new Adult(count, "David", "Lee", 26, "LikesWinnieBlue", "FPS4LYF.jpg", nullList, nullList);
		accountList[count++] = new Adult(count, "David", "Gibb", 40, "LikesProgramming", "TheGibbster.jpg", nullList, nullList);
	}
	
	int[] Friends = {0};
	
	public static void InputAccount(int ID, char action, ArrayList ParentIDs) {
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
	    	  if (Age < 18) {
	    		  // If user is under 18 years of age, their parents must be identified in the system
	    		  System.out.println("Creation of minors requires their parents in the system. Please locate the children's parents.");
	    	//	  ArrayList Parents = null;
	    		  // Send ID of -2 to no effect (placeholder for return call to AssignParents, from FindAccount)
	    		  Driver.AssignParents();
	    	//	  Parents = foundParents;
					if (foundParent != -2) {
						// If no errors assigning parents, create account
			    		  CreateAccount(FName, SName, Age, Status, Image, foundParents);
					}

	    	  }
	    	  else {
	    		  // If person is not under 18 years, use the super class constructor (standard account creation)
		    	  CreateAccount(FName, SName, Age, Status, Image, null);
	    	  }
	      }
	      if (action == 'u') {
	    	  UpdateAccount(ID, action, FName, SName, Age, Status, Image);
	      }
	}
	
	public static void CreateAccount(String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Parents) {

		createLoop = 'y';
		String keyInput;
		
		while (createLoop != 'n') {
	
			if (Age >= 18) {
				accountList[count++] = new Adult(count, FName, SName, Age, Status, Image, null, null);
			}
			else if (Age > 2) {
				accountList[count++] = new Child(count, FName, SName, Age, Status, Image, Parents);
			}
			else {
				accountList[count++] = new Infant(count, FName, SName, Age, Status, Image, Parents);
			}
			
			// Nullify found parents for cleaner usage next runtime
			foundParents = null;
			
			// If instance of command should be here to show parents if Child/Infant
			
			int searchID = count - 1;
			System.out.printf("------------------------------------- %n");
			System.out.printf("Account Successfully Created: %n");
			System.out.printf("------------------------------------- %n %n");
			if (Age >= 18) {
				System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "%n");
			}
			if (Age > 2) {
				System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "Parents: " + ((Child)accountList[searchID]).getParents() + "%n" + "%n");
			}
			if (Age <= 2 ) {
				System.out.printf("ID: " + accountList[searchID].getID() + "%n" + "Name: " + accountList[searchID].getFName() + " " + accountList[searchID].getSName() + "%n" + "Age: " + accountList[searchID].getAge() + "%n" + "Status: " + accountList[searchID].getStatus() + "%n" + "Image: " + accountList[searchID].getImage() + "%n" + "Parents: " + ((Infant)accountList[searchID]).getParents() + "%n" + "%n");
			}
			
			System.out.printf(" %n %n Would you like to create another account? (Y/N): ");
			
			keyInput = keyboard.next( );
			keyInput = keyInput.toLowerCase();
			
			switch (keyInput) {
			case "y":
				createLoop = 'y';
				Driver.InputAccount(0, 'c',null);
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
	
	public static int FindAccount(char type) {
		// Method designed for searching and identifying people
		// Used by both standard search, as well as the "FindParents" method (triggered upon creating a child or infant)
			int foundUser = -1;
			String selectInput;
			char userMenuLoop = 'y';
			
			System.out.println("Type in the name of the person you want to find.");
			String input = keyboard.next( ); 
			boolean findflag = false;
 
			for (int i = 0; i < count; i++) {
		        String str = accountList[i].getFName();
		        if (str.contains(input))
		        	
		        {
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
			        	findflag = true;
						i = i + count;
				        if (type == 'd') {
				        	// Having issues here. foundParent is a public variable to allow the passing of integers due to return not working during a loop.
				        	foundParent = foundUser;
				        	userMenuLoop = 'n';
				   //     	return foundUser;
				        }
				        else if (type == 'r') {
							Driver.ManageRelationships(foundUser);
				        }
				        else if (type == 'f') {
				        	// Return id of located friend
						        	foundFriend = foundUser;
						        	userMenuLoop = 'n';
						        	break;
				        }
				        
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
		    // Not found, return null (at bottom of statement)
	        
	        if (findflag == true) {
	        	char action = ' ';
	        			
	        	while (userMenuLoop == 'y') {
	        	
		        System.out.println("What would you like to do with this user?"						
		        		+ "\n1. Update Details"
						+ "\n2. Remove User"
						+ "\n3. Manage Relationships"
						+ "\n \n9. Return to Menu"
						+ "\n \n" + "\n" + "Type an option: ");

		        int keyInput = keyboard.nextInt( );
				
		        switch (keyInput) {
				case 1:
					// Update Details
					action = 'u';
					Driver.InputAccount(foundUser, action, null);
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
					// Manage relationships
					Driver.ManageRelationships(foundUser);
					
				
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
	        
	        return 0;
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
	
	public static void AssignParents() {
		int parentID = -1;
		char quitflag = 'n';
		ArrayList<Integer> parentList = new ArrayList<Integer>();
		
		// Triggered on create account in case of a child or infant
		while (quitflag == 'n') {
		for (int i = 0; i < 2; i++) {
			// Begin double user search
			Driver.FindAccount('d');
			// Return?
			if (foundParent < 0) {
				System.out.println("Parent does not exist. Exiting account creation.");
				quitflag = 'y';
				break;
			}
			parentID = foundParent;
				parentList.add(parentID);
				// Set found parent variable back to standard value - in case of error finding next parent, we can bail out of method
				foundParent = -2;
			}
		foundParents = parentList;
		System.out.println(parentList);
		
		quitflag = 'y';
	//	return parentList;	
		}
	}
	
	public static void ManageRelationships(int ID) {
		// View relationships tab, allowing for viewing/creating family/friend records
		
		int foundUser = ID;
		char userMenuLoop = 'y';
		
		Driver.DisplayAccount(foundUser);
		
    	while (userMenuLoop == 'y') {
    	
        System.out.println("How would you like to manage this user's relationships?"						
        		+ "\n1. View Friends"
				+ "\n2. Add Friends"
				+ "\n3. View Family Relationships"
		//		+ "\n4. Change Family Relationships"
				+ "\n \n9. Return to Menu"
				+ "\n \n" + "\n" + "Type an option: ");

        int keyInput = keyboard.nextInt( );
		
        switch (keyInput) {
		case 1:
			// View Friends
			Driver.ViewFriends(foundUser);
			userMenuLoop = 'n';
			break;
			
		case 2:
			// Add Friends
			Driver.AddFriends(foundUser);
			// userMenuLoop = 'n';
			break;
			
		case 3:
			// Add Family Relationships
			Driver.ManageRelationships(foundUser);
			
		case 4:
			// View Family Relationships
			Driver.ManageRelationships(foundUser);
			userMenuLoop = 'n';
		
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
	
	public static void AddFriends(int ID) {
		List<Integer> friends = null;
		int friendLen = -1;
		
		// Assigns friendship connections between users
		System.out.println("Adding Users");
		int foundUser = ID;

		if (accountList[foundUser] instanceof Infant) {
			System.out.println("Friendships are not allowed between infants!");
		}
        		
		else {
			// Call FindAccount
			Driver.FindAccount('f');
			
        	if (accountList[foundUser] instanceof Child | accountList[foundFriend] instanceof Child) {
        		// Find appropriate object friend list to obtain
        		
        			friendLen = ((Child)accountList[foundUser]).getFriends().size();

    					friends = ((Child)accountList[foundUser]).getFriends().subList(0, friendLen); 
    					int[] array = friends.stream().mapToInt(i->i).toArray();
    					
            			for (int i = 0; i < friendLen; i++) {
            				if (array.equals(foundFriend)) {
            					System.out.println("Friend already exists!");
            				}
            			}
    					// Add friend
    					((Child)accountList[foundUser]).setFriend(foundFriend);
    		//			((Child)accountList[foundFriend]).setFriend(foundUser);
    					System.out.println("Children added as friends.");

        	}
        		
        	else if (accountList[foundUser] instanceof Adult | accountList[foundFriend] instanceof Adult) {
        	//		friendLen = ((Adult)accountList[foundUser]).getFriends().size();

    					friends = ((Adult)accountList[foundUser]).getFriends(); 
    					int[] array = friends.stream().mapToInt(i->i).toArray();
    					friendLen = array.length;
    					friends = friends.subList(0, friendLen);
    					
            			for (int i = 0; i < friendLen; i++) {
            				if (array.equals(foundFriend)) {
            					System.out.println("Friend already exists!");
            					break;
            				}
        		}
    					// Add friend
    					((Adult)accountList[foundUser]).setFriend(foundFriend);
    			//		((Adult)accountList[foundFriend]).setFriend(foundUser);
    					System.out.println("Adults added as friends.");    
            			}
            	
        	else {
    			System.out.println("Users are not of the same type! A friendship cannot be made - perhaps a mentoring program?");
        	}
        	}	

        	}
	

	public static void ViewFriends(int ID) {
		// Checks friendship connections between users
		int foundUser = ID;
		List<Integer> friends = null;
		int friendLen = -1;
		
		String friendName = "";
		String friendList = "";
		int friendID = -1;
		
			if (accountList[foundUser] instanceof Adult) {
				System.out.println(((Adult)accountList[foundFriend]).getFriends());
				friendLen = ((Adult)accountList[foundUser]).getFriends().size();
				if (friendLen != 0) {
					friendList = "Friends: ";
					friends = ((Adult)accountList[foundUser]).getFriends().subList(0, friendLen); 
					int[] array = friends.stream().mapToInt(i->i).toArray();
					
	    			for (int i = 0; i < friendLen; i++) {
	    				friendID = array[i];
	    				friendList = accountList[friendID].getFName();
	    				if (i+1 < friendLen) {
	    					friendList = (friendList + ", ");
	    				}
	    				}
				}
				else {
					friendList = "This user has no friends.";
				}

    			
			}
			else {
				System.out.println(((Child)accountList[foundFriend]).getFriends());
				friendLen = ((Child)accountList[foundUser]).getFriends().size();
				if (friendLen != 0) {
					friendList = "Friends: ";
					friends = ((Child)accountList[foundUser]).getFriends().subList(0, friendLen); 
					int[] array = friends.stream().mapToInt(i->i).toArray();
					
	    			for (int i = 0; i < friendLen; i++) {
	    					friendID = array[i];
	    					friendList = accountList[friendID].getFName() + ", ";
	    			//		friendList = (friendList + accountList[i].getFName() + ", ");
		    				if (i+1 < friendLen) {
		    					friendList = (friendList + ", ");
		    				}
	    				}
				}
				else {
					friendList = "This user has no friends.";
				}
				
    			}
			
			System.out.println("This user is friends with the following people:");
			System.out.println(friendList);
			}

	
	public static void FamilyStatus(int ID) {
		// Checks if person has children/parents in system
		
	}
	
	public static void ChangeParents(int ID) {
		// This should be the last one you attempt
		
	}
	
	
	public static void DisplayAllAccounts() {
		String listString = "";
		String parentsString = "";
		
		int firstNum = 0;
		int secondNum = 0;
		
		List<Integer> head = null;
		
		for (int j = 0 ; j < count; j++)
		{
			// Conditional code to run if person is a minor - display parents in user list
			if (accountList[j].getID() != 0) {
				if (accountList[j] instanceof Child) 
				{
					// Retrieve the IDs of the children's parents from an array
					head = ((Child)accountList[j]).getParents().subList(0, 2); 
					int[] array = head.stream().mapToInt(i->i).toArray();
					// Split out the IDs into primitives
					firstNum = array[0];
					secondNum = array[1];
					array = null;
					
					// Search up the IDs through an account get command
					String firstParent = accountList[firstNum].getFName();
					String secondParent = accountList[secondNum].getFName();
					// Add the names of the parents to the result of the string
					parentsString = (" Parents: " + firstParent + " and " + secondParent);
				}
				
				else if (accountList[j] instanceof Infant) {
					head = ((Infant)accountList[j]).getParents().subList(0, 2); 
					int[] array = head.stream().mapToInt(i->i).toArray();
					// Split out the IDs into primitives
					firstNum = array[0];
					secondNum = array[1];
					array = null;
					
					// Search up the IDs through an account get command
					String firstParent = accountList[firstNum].getFName();
					String secondParent = accountList[secondNum].getFName();
					// Add the names of the parents to the result of the string
					parentsString = (" Parents: " + firstParent + " and " + secondParent);
				}
				
				else {
					parentsString = ("");
				}

				}
			
		System.out.printf("ID: " + accountList[j].getID() + " Name: " + accountList[j].getFName() + " " + accountList[j].getSName() + " Age: " + accountList[j].getAge() + " Status: " + accountList[j].getStatus() + " Image: " + accountList[j].getImage() + parentsString + "%n");
		}
		// If ID equals zero, do not display user in list of users
		}

	}

