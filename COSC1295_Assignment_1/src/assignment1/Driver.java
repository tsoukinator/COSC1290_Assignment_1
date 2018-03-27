package assignment1;

import java.lang.reflect.Array;
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
	
	public static char addFlag = 'n';
	
	public static boolean cheating = false;
	
	static int count = 0;
	
	static char createLoop = 'y';
	
	static Scanner keyboard = new Scanner(System.in);
	
	static Account[] accountList = new Account[200]; 
	
	public static void main(String[] args) {
		System.out.println("Why did you call me? I don't do anything...");
	}
	
	public static void AutoAdd() {
		ArrayList<Integer> nullList = new ArrayList<Integer>();
//		nullList.add(999);
	
		// Test parents code
		ArrayList<Integer> testParents = new ArrayList<Integer>();
		testParents.add(1);
		testParents.add(2);
		
		// Test friends code 1
		ArrayList<Integer> testFriendsOne = new ArrayList<Integer>();
		testFriendsOne.add(1);
		testFriendsOne.add(2);		
		
		// Test friends code 2
		ArrayList<Integer> testFriendsTwo = new ArrayList<Integer>();
		testFriendsTwo.add(0);
		
		
		accountList[count++] = new Adult(count, "Anthony", "Tsoukas", 27, "VerySingle", "Tsoukinator.jpg", testFriendsOne, nullList);
		accountList[count++] = new Adult(count, "Chris", "Stefani", 25, "CoolDude", "FIFA-Runescape-Pro.jpg", testFriendsTwo, nullList);
		accountList[count++] = new Adult(count, "Kevin", "Johnson", 45, "SuaveDude", "BigKev.jpg", testFriendsTwo, nullList);
		accountList[count++] = new Adult(count, "David", "Lee", 26, "LikesWinnieBlue", "FPS4LYF.jpg", nullList, nullList);
		accountList[count++] = new Adult(count, "David", "Gibb", 40, "LikesProgramming", "TheGibbster.jpg", nullList, nullList);
		accountList[count++] = new Child(count, "Young", "Person", 5, "LikesToys", "ForeverYoung.jpg", testParents, nullList);
		accountList[count++] = new Child(count, "LessYoung", "Person", 9, "LikesGames", "ForeverYoung.jpg", testParents, nullList);
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
	    	  if (Age < 16) {
	    		  // If user is under 16 years of age, their parents must be identified in the system
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
	
			if (Age >= 16) {
				accountList[count++] = new Adult(count, FName, SName, Age, Status, Image, null, null);
			}
			else if (Age > 2) {
				accountList[count++] = new Child(count, FName, SName, Age, Status, Image, Parents, null);
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
				        else if (type == 'm') {
				        	Driver.ManageAccount(foundUser);
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
		for (int j = 0; j < 2; j++) {
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
		
		// Check existing parents
		
		List<Integer> parents = parentList.subList(0, 2); 
		int[] array = parents.stream().mapToInt(i->i).toArray();
		int parent1 = array[0];
		int parent2 = array[1];
		
		CheckExistingParents(parent1, parent2);
		if (cheating == false) {
			System.out.println("Found parents: " + parentList);
			foundParents = parentList;
			
			foundParent = 0;
		}
		
		quitflag = 'y';
	//	return parentList;	
		}
	}
	
	public static void ManageAccount(int ID) {
		
		int foundUser = ID;
     	char action = ' ';
     	
     	char userMenuLoop = 'y';
     	
     	Driver.DisplayAccount(foundUser);
     	
     	while (userMenuLoop == 'y') {
     	
	        System.out.println("What would you like to do with this user?"						
	        		+ "\n1. Update Details"
					+ "\n2. Remove User"
					+ "\n3. Manage Relationships"
					+ "\n \n9. Return to Main Menu"
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
				System.out.printf("Invalid Response. Exiting Menu. %n");
				userMenuLoop = 'n';
				break;
			}
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
				+ "\n4. Manage User Details"
				+ "\n \n9. Return to User Menu"
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
			//View Family Relationships
			Driver.FamilyStatus(foundUser);
			
		case 4:
			// Manage User Details
			Driver.ManageAccount(foundUser);
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
		int loopID = -1;
		int testID = -2;
		
		// Assigns friendship connections between users
		System.out.println("Adding Users");
		int foundUser = ID;

		if (accountList[foundUser] instanceof Infant) {
			System.out.println("Friendships are not allowed between infants!");
		}
        		
		else {
			// Call FindAccount
			Driver.FindAccount('f');
			
			if (accountList[foundUser] instanceof Adult | accountList[foundFriend] instanceof Adult) {
				// Check to see if any friends exist
	        				friendLen = ((Adult)accountList[foundUser]).getFriends().size();
	        				
	        	// Extract friend details from array to search for whether friend has already been added
	    					friends = ((Adult)accountList[foundUser]).getFriends().subList(0, friendLen);
	    					int[] array = friends.stream().mapToInt(i->i).toArray();
	    					
					if (friendLen == 0) {
						// Skip ahead and add the user if no users exist in friends list
					}
					else {
						// Else, check that the user doesn't already exist
	        			for (int i = 0; i < friendLen; i++) {
	        				
	        				loopID = array[i]+1;
	        				testID = accountList[foundFriend].getID();
	        				
	        				System.out.println("Array Value: " + array[i] + " - Test ID: " + testID);
	        				if (loopID == testID) {
	        					System.out.println("Friend already exists! \n");
	        					break;
	        				}
					}

	        		}
	    					// Add friend
					if (loopID != testID) {
						((Adult)accountList[foundUser]).setFriend(foundFriend);
				//		((Adult)accountList[foundFriend]).setFriend(foundUser);
						System.out.println("Adults added as friends. \n");   
					}
			}
			
			else if (accountList[foundUser] instanceof Child | accountList[foundFriend] instanceof Child) {
        		// Find appropriate object friend list to obtain
        		
				Driver.CompareChildParents(foundUser, foundFriend);
				if (addFlag == 'n') {
					// User will get message that friends can't be added as they share parents.
				}
				else {
					friendLen = ((Child)accountList[foundUser]).getFriends().size();

					friends = ((Child)accountList[foundUser]).getFriends().subList(0, friendLen); 
					int[] array = friends.stream().mapToInt(i->i).toArray();
					
         			for (int i = 0; i < friendLen; i++) {
        				loopID = array[i];
        				testID = accountList[loopID].getID();
        				if (loopID == testID) {
        					System.out.println("Friend already exists! \n");
        				}
        			}
					// Add friend - if age gap more than 3 years
         			int childAgeOne = ((Child)accountList[foundUser]).getAge();
         			int childAgeTwo = ((Child)accountList[foundFriend]).getAge();
         			int ageDiff = 0;
         			
         			ageDiff = (childAgeOne - childAgeTwo);
         					
         			if(ageDiff < -3 | ageDiff > 3) {
         				System.out.println("Children ages are too far apart. Cannot add friends. \n");
         			}
         			else {
    					((Child)accountList[foundUser]).setFriend(foundFriend);
    		 //			((Child)accountList[foundFriend]).setFriend(foundUser);
    		    		System.out.println("Children added as friends. \n");
         			}
				}
				
        	}
        		
        	else {
    			System.out.println("Users are not of the same stage in life! A friendship cannot be made - perhaps a mentoring program? \n");
        	}
        	}	

        	}
	

	public static void ViewFriends(int ID) {
		// Checks friendship connections between users
		int foundUser = ID;
		List<Integer> friends = null;
		int friendLen = -1;
		
		String friendList = "";
		int friendID = -1;
		
		int friendCount = 0;
		
			if (accountList[foundUser] instanceof Adult) {
				
				// Array ref gives the order the related person appears in the account list array (starting from 0) - rather than their actual ID
				
				friendLen = ((Adult)accountList[foundUser]).getFriends().size();
				if (friendLen != 0) {
					friendList = "Friends: ";
					friends = ((Adult)accountList[foundUser]).getFriends().subList(0, friendLen); 
					int[] array = friends.stream().mapToInt(i->i).toArray();
					
	    			for (int i = 0; i < friendLen; i++) {
	    				friendID = array[i];
	    				friendList = friendList + " " + accountList[friendID].getFName();
    					friendCount = friendCount + 1;
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
				friendLen = ((Child)accountList[foundUser]).getFriends().size();
				if (friendLen != 0) {
					friendList = "Friends: ";
					friends = ((Child)accountList[foundUser]).getFriends().subList(0, friendLen); 
					int[] array = friends.stream().mapToInt(i->i).toArray();
					
	    			for (int i = 0; i < friendLen; i++) {
	    					friendID = array[i];
	    					friendList = friendList + " " +  accountList[friendID].getFName();
	    					friendCount = friendCount + 1;
		    				if (i+1 < friendLen) {
		    					friendList = (friendList + ", ");
		    				}
	    				}
				}
				else {
					friendList = "This user has no friends.";
				}
				
    			}
			
				if (friendCount > 0) {
					System.out.println("This user has " + friendCount + " friends:");
				}
				
				System.out.println(friendList + "\n");
				
			}

	
	public static void FamilyStatus(int ID) {
		String listString = "";
		String parentsString = "";
		String childrenString = "";
		
		int firstNum = 0;
		int secondNum = 0;
		
		int childrenCount = 0;
		
		List<Integer> head = null;
		
		int foundUser = ID;
		int[] array = null;
		
		// Checks if person has children/parents in system
		
		// If adult, find mentions of their ID in child/infant fields
		if (accountList[foundUser] instanceof Adult) {
			
			System.out.println("User holds Adult account. \n");
			for (int j = 0 ; j < count; j++)
			{
				if (accountList[j] instanceof Child) {
					System.out.println("User holds Child account. \n");
					// Retrieve the IDs of the children's parents from an array
					head = ((Child)accountList[j]).getParents().subList(0, 2); 
					array = head.stream().mapToInt(i->i).toArray();
					// Split out the IDs into primitives
					firstNum = array[0];
					secondNum = array[1];
					
					for (int k = 0; k < 2; k++) {
						if (foundUser == array[k]) {
							if (childrenCount > 0) {
								childrenString = (childrenString + ", ");
							}
							childrenString = childrenString + ((Child)accountList[j]).getFName();
							childrenCount = childrenCount + 1;
						}
				}
					array = null;
				}
				
				else if (accountList[j] instanceof Infant) {
					System.out.println("User holds Infant account. \n");
					// Retrieve the IDs of the infants's parents from an array
					head = ((Child)accountList[j]).getParents().subList(0, 2); 
					array = head.stream().mapToInt(i->i).toArray();
					// Split out the IDs into primitives
					firstNum = array[0];
					secondNum = array[1];
					
					for (int k = 0; k < 2; k++) {
						if (foundUser == array[k]) {
							if (childrenCount > 0) {
								childrenString = (childrenString + ", ");
							}
							childrenString = childrenString + ((Child)accountList[j]).getFName();
							childrenCount = childrenCount + 1;
						}
				}
					array = null;
				}

		}
			
			// If children > 0
			if (childrenCount == 0) {
				System.out.println("User has no children.");
			}
			else {
				System.out.println("User has: " + childrenCount + " children. Their names are:");
				System.out.println(childrenString);
			}

		}
		
		// If not adult, list parents
		else if (accountList[foundUser] instanceof Child) 
			{
				// Retrieve the IDs of the children's parents from an array
				head = ((Child)accountList[foundUser]).getParents().subList(0, 2); 
				array = head.stream().mapToInt(i->i).toArray();
				// Split out the IDs into primitives
				firstNum = array[0];
				secondNum = array[1];
				array = null;
				
				// Search up the IDs through an account get command
				String firstParent = accountList[firstNum].getFName();
				String secondParent = accountList[secondNum].getFName();
				// Add the names of the parents to the result of the string
				parentsString = (" Parents: " + firstParent + " and " + secondParent);
				
				System.out.println("User holds Child account.");
				System.out.println(parentsString);
			}
			
			else if (accountList[foundUser] instanceof Infant) {
				head = ((Infant)accountList[foundUser]).getParents().subList(0, 2); 
				array = head.stream().mapToInt(i->i).toArray();
				// Split out the IDs into primitives
				firstNum = array[0];
				secondNum = array[1];
				array = null;
				
				// Search up the IDs through an account get command
				String firstParent = accountList[firstNum].getFName();
				String secondParent = accountList[secondNum].getFName();
				// Add the names of the parents to the result of the string
				parentsString = (" Parents: " + firstParent + " and " + secondParent);
				
				System.out.println("User holds Infant account.");
				System.out.println(parentsString);
			}
		// Blank space under each group of returned lines
		System.out.println("");
	}
	
	public static void IsFriendOf (int ID) {
		// Method meant to be used to do a friend "Search"
		// i.e "is x a friend of y?"
		
	}
	
	public static void ChangeParents(int ID) {
		// This should be the last one you attempt
		
	}
	
	public static void CheckExistingParents(int currentParent1, int currentParent2) {
		// Called by create account (for children/infants)
		// if a potential parent-child relationship has one of the two ids, it must be declined
		// parents can only be assigned, if they don't already have a child with another parent
		
		int childrenCount = 0;
		
		List<Integer> head = null;
		
		int[] array = null;
		
		int parentOne = -1;
		int parentTwo = -1;
		
		int curParentOne = currentParent1;
		int curParentTwo = currentParent2;
		
		cheating = false;

			for (int j = 0; j < count; j++) {
				// Extract out each child/infant record, check their parent IDs
				
				if (accountList[j] instanceof Child) {
					head = ((Child)accountList[j]).getParents().subList(0, 2); 
					array = head.stream().mapToInt(i->i).toArray();
					
					if (parentOne == -1) {
						// If no existing parents found yet, take their IDs down now
						parentOne = array[0];
						parentTwo = array[1];
					}
					
					else {
	//					System.out.println("1: curP: " + curParentOne + " Found: " + array[0]);
						if (curParentOne == array[0]) {
	//						System.out.println("2: curP: " + curParentTwo + " Found: " + array[1]);
							if (curParentTwo != array[1]) {
								cheating = true;
							}
						}
							else {
	//							System.out.println("3: curP: " + curParentOne + " Found: " + array[1]);
								if (curParentOne == array[1]) {
	//								System.out.println("4: curP: " + curParentTwo + " Found: " + array[0]);
									if (curParentTwo != array[0]) {
										cheating = true;
									}
									else {
										// Monogamy
							}
						}
							}
						}
				}
				
				else if (accountList[j] instanceof Infant) {
					head = ((Infant)accountList[j]).getParents().subList(0, 2); 
					array = head.stream().mapToInt(i->i).toArray();
					
					if (parentOne == -1) {
						// If no existing parents found yet, take their IDs down now
						parentOne = array[0];
						parentTwo = array[1];
					}
					
					else {
	//					System.out.println("1: curP: " + curParentOne + " Found: " + array[0]);
						if (curParentOne == array[0]) {
	//						System.out.println("2: curP: " + curParentTwo + " Found: " + array[1]);
							if (curParentTwo != array[1]) {
								cheating = true;
							}
						}
							else {
	//							System.out.println("3: curP: " + curParentOne + " Found: " + array[1]);
								if (curParentOne == array[1]) {
	//								System.out.println("4: curP: " + curParentTwo + " Found: " + array[0]);
									if (curParentTwo != array[0]) {
										cheating = true;
									}
									else {
										// Monogamy
							}
						}
							}
						}
					
				}
				
				array = null;
		}
		
			if (cheating == true) {
				System.out.println("Cheater alert. What are you going to tell your partner about this? \n");
				System.out.println("Account not created.");
			}
			else {
				cheating = false;
			}

}
	
	public static void CompareChildParents(int ID, int ID2) {
		// Method checks to see if children have same parents before allowing them to add each other
		
		// Need to see the parent-child combinations currently set
		// Children can't add their siblings as friends (???)

		List<Integer> head = null;
		
		int foundUser = ID;
		int potentialFriend = ID2;
		
		addFlag ='n';
		
				head = ((Child)accountList[foundUser]).getParents().subList(0, 2); 
				int [] array1 = head.stream().mapToInt(i->i).toArray();
						
				head = ((Child)accountList[potentialFriend]).getParents().subList(0, 2); 
				int [] array2 = head.stream().mapToInt(i->i).toArray();
				
				// Checks to see if one of the parents matches either of the other child's parents
				// This if statement assumes that parents are already mutually exclusive from one another
				if(array1[0] == array2[0] || array1[0] == array2[1]) {
					System.out.println("Cant add children as friends - they share parents. \n");
					addFlag ='n';
				}
				else {
					addFlag = 'y';
					// If all is good, the add friendship process will continue
				}
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
		System.out.println("");
		// If ID equals zero, do not display user in list of users
		}

	}

