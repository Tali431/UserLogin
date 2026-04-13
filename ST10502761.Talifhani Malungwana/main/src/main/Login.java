/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 
 */
/**
 * Login class handles user registration and authentication
 * @author 
 */
public class Login {
    
    String Username;
    String Password;
    String CellPhoneNumber;
    String First;
    String Last;
    String username;
    String password;
    String cellphoneNumber;
    
    /**
     * Checks if the username meets complexity requirements
     * Username must contain an underscore and be no more than 5 characters
     * @return true if username is valid, false otherwise
     */
    public boolean checkUsername() {
        boolean check = false;
        for (int i = 0; i < Username.length(); i++) {
            if (Username.length() <= 5) {
                if ((int)Username.charAt(i) == 95)
                    check = true;
            }
        }
        return check;
    }

    /**
     * Checks if the password meets complexity requirements
     * Password must be at least 8 characters and contain:
     * - A capital letter
     * - A number
     * - A special character
     * @return true if password is valid, false otherwise
     */
    public boolean checkPasswordComplexity() {
        boolean CapitalLetter = false;  
        boolean Number = false;
        boolean Special = false;
        
        for (int i = 0; i < Password.length(); i++) {
            if (Password.length() >= 8) { 
                if ((int)Password.charAt(i) > 65 && (int)Password.charAt(i) <= 90) {
                    CapitalLetter = true;
                }  
                if ((int)Password.charAt(i) >= 48 && (int)Password.charAt(i) <= 57) {
                    Number = true;
                }          
                if ((int)Password.charAt(i) >= 33 && (int)Password.charAt(i) <= 47 || 
                    (int)Password.charAt(i) >= 58 && (int)Password.charAt(i) <= 64 || 
                    (int)Password.charAt(i) >= 91 && (int)Password.charAt(i) <= 96 || 
                    (int)Password.charAt(i) >= 123 && (int)Password.charAt(i) <= 126) {
                    Special = true;
                }
            }
        }
        return CapitalLetter && Number && Special;
    }

    /**
     * Checks if the cell phone number meets requirements
     * Cell phone number must contain the international country code 
     * and be no more than 10 characters long
     * @return true if cell phone number is valid, false otherwise
     */
    public boolean checkCellPhoneNumber() {
        boolean check = false;
        
        // Check if length is no more than 10 characters
        if (CellPhoneNumber.length() <= 14) {
            // Check if it starts with a '+' (international code)
            if (CellPhoneNumber.charAt(0) == '+') {
                check = true;
            }
        }
        
        return check;
    }
    
    /**
     * Registers a user by validating username and password
     * Prints appropriate messages based on validation results
     * @return empty string
     */
    public String registerUser() {
        if (checkUsername() == true) {
            System.out.println("Username succefully captured");
        } else {
            System.out.println("Username is not correctly formatted,please ensure that your Username contains an underscore and is no more than 5 characters in length ");
        }   
        
        if (checkPasswordComplexity() == true) {
            System.out.println("Password succefully captured");
        } else {
            System.out.println("Password is not correctly formatted please ensure that the password contains atleast 8characters, a capital letter , a number and a special character ");
        }
        
        if (checkCellPhoneNumber() == true) {
            System.out.println("Cell phone number successfully added");
        } else {
            System.out.println("Cell phone number is incorrectly formatted or does not contain international code");
        }
        
        if (checkUsername() == true && checkPasswordComplexity() == true && checkCellPhoneNumber() == true) {
            System.out.println("The three above conditions have been met and the user has been registered succefully");  
        }
        
        if (checkPasswordComplexity() == false) {
            System.out.println("The Password does not meet the complexity requirements");      
        }
        
        if (checkUsername() == false) {
            System.out.println("The username is incorrectly formatted");
        }
        
        if (checkCellPhoneNumber() == false) {
            System.out.println("The cell phone number does not meet the requirements");
        }
        
        return "";
    }
    
    /**
     * Validates login credentials
     * Compares entered username and password with registered credentials
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser() {
        boolean Compare = false;
        
        if (username.equals(Username) && password.equals(Password) && cellphoneNumber.equals(CellPhoneNumber)) {
            Compare = true;
        }
        return Compare;
    }
    
    /**
     * Returns the login status message
     * Displays welcome message on successful login or error message on failure
     * @return empty string
     */
    String returnLoginStatus() {
        if (loginUser() == true) {
            System.out.println("succeful login");
            System.out.println("welcome " + " " + First + " " + " " + " " + Last + " " + " it is great to see you again ");
        } else {
            System.out.println("A failed login"); 
            System.out.println("Username, Password or cellphone number incorrect please try again");
        }  
        
        return "";
    }
}