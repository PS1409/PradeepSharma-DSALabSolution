package com.greatlearning.balancebracketdriver;
import java.util.Scanner;

import com.greatlearning.balancebracketservice.BalanceBracketService;

public class Main {
	static BalanceBracketService balanceBracketService =  new BalanceBracketService();
	static Scanner scanner = new Scanner(System.in); 

	public static void main(String[] args) {
		
		// Getting the bracket sequence from the user
           System.out.println("Please enter the string with bracket sequence: ");
         String strBalanceBracket =  scanner.nextLine();
         
         //Declare a variable for holding the sequence status
         boolean balanceSequenceStatus = false;
         if(strBalanceBracket.length() > 1) {
        	 // Checking the entered string and show the result
        	 balanceSequenceStatus = balanceBracketService.checkIfBracketSequenceIsBalanced(strBalanceBracket);
        	 if(balanceSequenceStatus) {
        		 System.out.println("The entered string has balanced brackets.");
        	 }
        	 else {
        		 System.out.println("The entered string do not conatain balance brackets.");
        	 }
         }
         else {
        	 System.out.println("no input or invalid input provided.");
         }
	}

}
