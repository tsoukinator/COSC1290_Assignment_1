package assignment1;

import java.util.Scanner;

public class MiniNet {
	public static void main(String[] args) {
		Driver.AutoAdd();
		MiniNet menu = new MiniNet();
		menu.printMenu(menu);
	}
	
	public void printHeader() {
		System.out.println("|--------------------------------|");
		System.out.println("|           Main Menu            |");
		System.out.println("|--------------------------------|");
	}
	
	private void printMenu(Object i) {
			char quit = 'n';
			int choice = 0;
			
			Scanner menuscan = new Scanner(System.in);
			
			while (quit != 'y') {
				this.printHeader();
				System.out.println("Welcome to SkyNet. Please choose an option:"
						+ "\n1. Create User"
						+ "\n2. Manage Users"
						+ "\n3. Manage Relationships"
						+ "\n4. Display All Humans"
						+ "\n \n9. Exit Skynet"
						+ "\n" + "\n" + "Type an option: ");
				
				choice = menuscan.nextInt();
				
				switch (choice) {
				
				case 1:
					System.out.println("Create Account");
					Driver.InputAccount(0,'c',null);
					break;
					
				case 2:
					System.out.println("Manage Users");
					// User search, update details, delete users
					Driver.FindAccount('s');
					break;
					
				case 3:
					System.out.println("Manage Relationships");
					System.out.println("Who would you like to manage relationships for?");
					Driver.FindAccount('r');
					// Add friends, manage parent relationships
					break;
					
				case 4:
					System.out.println("Display All Humans");
					Driver.DisplayAllAccounts();
					break;
					
				case 9:
					System.out.println("Exiting Skynet. You can run but you can't hide!");
					quit = 'y';
					menuscan.close();
					break;
					
				default:
					System.out.println("Invalid Function. Please type a valid menu option." + "\n");
					break;
					
				}
			}
		}
	}

