/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Say hello at the start
        System.out.println("Hello! Welcome to the Login System");
        System.out.println("==================================");
        
        // Scanner to allow the user to respond to the compiler
        Scanner input = new Scanner(System.in);
        
        // Create Login object to access methods and variables
        Login method = new Login();
        
        boolean exit = false;
        boolean isRegistered = false;
        
        while (!exit) {
            System.out.println("\nChoose option:");
            System.out.println("---Login system---");
            System.out.println("Choose option");
            System.out.println("1. register");
            System.out.println("2. login");
            System.out.println("3. exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    // Registration
                    System.out.println("\n--- Registration ---");
                    System.out.println("Must contain an underscore");
                    System.out.println("Must be no more than 5 characters");
                    
                    // Prompt the user to enter their first name
                    System.out.print("Enter FirstName: ");
                    method.First = input.next();
                    
                    // Prompt the user to enter their last name
                    System.out.print("Enter LastName: ");
                    method.Last = input.next();
                    
                    // Prompt the user to create a username
                    System.out.print("Enter username: ");
                    method.Username = input.next();
                    
                    // Prompt the user to create the password
                    System.out.print("Enter password: ");
                    method.Password = input.next();
                    
                    // Prompt the user to enter their cell phone number
                    System.out.print("Enter Cell Phone Number (with international code, e.g., +27123456): ");
                    method.CellPhoneNumber = input.next();
                    
                    // Tell the user if they are registered or not
                    System.out.println("\n" + method.registerUser());
                    
                    // Check if all conditions are met
                    if (method.checkUsername() && method.checkPasswordComplexity() && method.checkCellPhoneNumber()) {
                        isRegistered = true;
                    }
                    break;
                    
                case 2:
                    // Login
                    if (!isRegistered) {
                        System.out.println("\nYou must register first before logging in!");
                        break;
                    }
                    
                    System.out.println("\n--- Login ---");
                    
                    // Prompt the user to login with information they registered with
                    System.out.print("Enter Username: ");
                    method.username = input.next();
                    
                    // Prompt the user to login with the password they registered with
                    System.out.print("Enter Password: ");
                    method.password = input.next();
                    
                    // Prompt the user to login with the cell phone number they registered with
                    System.out.print("Enter Cell Phone Number: ");
                    method.cellphoneNumber = input.next();
                    
                    // Tell the user if login was successful
                    System.out.println("\n" + method.returnLoginStatus());
                    break;
                    
                case 3:
                    // Exit
                    exit = true;
                    System.out.println("\nGoodbye! Thank you for using the Login System");
                    break;
                    
                default:
                    System.out.println("\nInvalid option! Please choose 1, 2, or 3.");
                    break;
            }
        }
        
        input.close();
    }
}
