package assignment1;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.printHeader();
		menu.printMenu();
	}
	
	public void printHeader() {
		System.out.println("|--------------------------------|");
		System.out.println("|           Main Menu            |");
		System.out.println("|--------------------------------|");
	}
	
	private void printMenu() {
			char quit = 'n';
			String input;
			int choice = 0;
			
			Scanner menuscan = new Scanner(System.in);
			
			while (quit != 'y') {
				System.out.println("Welcome to SkyNet. Please choose an option:"
						+ "\n1. Create User"
						+ "\n2. Search User"
						+ "\n3. Alt-F4"
						+ "\n4. All The Things"
						+ "\n9. Exit Skynet");
				
				choice = menuscan.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("Create Account");
					Driver.CreateAccount();
					break;
				case 2:
					System.out.println("Choice 2");
					
					break;
				case 3:
					System.out.println("Choice 3");
					Driver.CreateAccount();
					break;
				case 4:
					System.out.println("Choice 4");
					break;
				case 9:
					System.out.println("Exiting Skynet. You can run but you can't hide!");
					quit = 'y';
					break;
				default:
					System.out.println("Invalid Function. Please type a valid menu option.");
				}
			}
		}
	}

