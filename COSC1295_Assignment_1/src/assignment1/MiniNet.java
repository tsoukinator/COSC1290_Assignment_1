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
						+ "\n2. Search User"
						+ "\n3. Display All Humans"
						+ "\n4. Add Henry"
						+ "\n \n9. Exit Skynet"
						+ "\n" + "\n" + "Type an option: ");
				
				choice = menuscan.nextInt();
				
				switch (choice) {
				
				case 1:
					System.out.println("Create Account");
					Driver.InputAccount(0,'c',null);
					break;
					
				case 2:
					System.out.println("Search User");
					// Begin Single user search
					Driver.FindAccount('s');
					break;
					
				case 3:
					System.out.println("Display All Humans");
					Driver.DisplayAllAccounts();
					break;
					
				case 4:
					System.out.println("Add Henry");
					// Driver.AddHenry();
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

