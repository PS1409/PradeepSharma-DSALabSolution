package com.greatlearning.balancebracketservice;
import java.util.Stack;

public class BalanceBracketService {
      public boolean checkIfBracketSequenceIsBalanced(String braketSequence) {
    	  
    	  //Create Stack to push the open brackets 
    	  Stack<Character> openBracketStack =  new Stack<Character>();
    	  char poppedChar;
    	  //loop through the entire string length
    	  for(int i= 0; i<braketSequence.length(); i++)
    	  {
    		  char currentCharInStr = braketSequence.charAt(i);
    		  //if current character is either '(', '{' or '[', push to the stack and continue
    		  
    		  if(currentCharInStr == '(' || currentCharInStr == '{' || currentCharInStr == '[') {
    			  openBracketStack.push(currentCharInStr);
    			  continue;
    		  }
    		  
    		  // if there is no opening brackets in stack, return false
    		  if(openBracketStack.isEmpty()){
    			  return false;
    		  }   		  
    		  
    		  // check the current bracket character with the popped bracket from stack 
    		  switch(currentCharInStr) {
    		      case ')':
    		    	  poppedChar = openBracketStack.pop();
    		    	  if(poppedChar == '{' || poppedChar == '[') {
    		    		  return false;
    		    	  }
    			  break;
    		      case '}':
    		    	  poppedChar = openBracketStack.pop();
    		    	  if(poppedChar == '(' || poppedChar == '[') {
    		    		  return false;
    		    	  }
    			  break;
    		      case ']':
    		    	  poppedChar = openBracketStack.pop();
    		    	  if(poppedChar == '{' || poppedChar == '(') {
    		    		  return false;
    		    	  }
    			  break;
    		  }
    	  }
    	  return (openBracketStack.isEmpty());
      }
}
