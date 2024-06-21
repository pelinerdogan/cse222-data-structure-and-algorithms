package hw4;
import java.util.Stack;
 class password1 {
	 String pass;
	 
  protected password1(String s) {
			pass = s;
		}
		
 /**
  * in a for loop we push the brackets we find and pop the bracket if we find the closing bracket. If brackets are not balanced stack will be not empty
  * @return true if passwords brackets are balanced
  */
  
  protected boolean isBalancedPassword() {
		 
		   Stack<Character> st = new Stack<Character>();
		   
		   for(int i = 0; i< pass.length();i++) {
			   if(pass.charAt(i)== '{' ||pass.charAt(i)== '('||pass.charAt(i)== '[') {
				   st.add(pass.charAt(i));
		
			   }
			   else if(pass.charAt(i)== ']') {
				  
				  if(st.peek() == '[')
					  st.pop();
				  else {
					  System.out.println("Password not balanced");
					  return false;
				  }
			   }
			   else if(pass.charAt(i)== '}') {
				   
				   if(st.peek() == '{')
						  st.pop();
				   else {
						  System.out.println("Password not balanced");
						  return false;
					  }
				   
			   }else if(pass.charAt(i)== ')') {
				   
				   if(st.peek() == '(')
						  st.pop();
				   else {
						  System.out.println("Password not balanced");
						  return false;
					  }
			   }
			   
		   }
		 
		   if(st.size()== 0)
		   return true;
		   else {
			   System.out.println("Password not balanced");
			   return false;
			   
		   }
	 }
  /**
   * a palindrome can only have 1 letter in odd number. other letters should be in an even number. This function counts letters and if we have 
   * 2 different letter with odd amount returns false
   * 
   * @param oddexists this boolean is to keep if we have odd number of a letter
   * @param lettercount counts amount of the letter we are currently searching. When we search different letter it turns back to 1 because we take the letter we 
   * will search from sentence this means we have at least 1 letter
   * @param letter  is index of letter we search and count. when it hits end of the sentence recursion stops
   * @param search is the iterator we move around stringg
   * @param pass1 is the modified string
   * @return true if sentence can be a palindrome
   * 
   */
 protected boolean isPalindromePossible(boolean oddexists,int lettercount,int letter,int search,String pass1) {
	  

	  if(letter<pass1.length()) {
			 
	
		
		  
		  if(search<pass1.length()) {
			
			  if(pass1.charAt(letter)== pass1.charAt(search)) {
				 
			

				pass1= pass1.substring(0,letter+1) + pass1.charAt(search)+ pass1.substring(letter+1,search)+ pass1.substring(search+1);
				lettercount++;
				search++;
				  return isPalindromePossible(oddexists,lettercount,letter,search,pass1);
			  }
			  else {
				  
				  search++;
				  return isPalindromePossible(oddexists,lettercount,letter,search,pass1);
				  
			  }
		  }
		  else {
			  
			  if(lettercount % 2 == 1) {
				  if(oddexists == true) {
					  System.out.println("It is not possible to make a palindrome out of this password");
					  return false;
				  }
				  else {
			
					  oddexists = true;
					  letter= letter+lettercount;
					  return isPalindromePossible(oddexists,1,letter,letter+1,pass1);
				  }
				  
			  }
			  else {
			      
				  letter= letter+lettercount;
				  return isPalindromePossible(oddexists,1,letter,letter+1,pass1);
				  
				  
				  
			  }
		  }
	  }else {
		  return true;
	  }
	
	  
	  
	  
	  
  }
  /**
   * 
   * @return password without brackets
   */
 protected String withoutparantheses() {
	  String pass1 = pass;
	   pass1= pass1.replace("(", "");
	   pass1= pass1.replace("[", "");
	   pass1= pass1.replace("{", "");
	   pass1= pass1.replace(")", "");
	   pass1= pass1.replace("]", "");
	   pass1= pass1.replace("}", "");
	
	   return pass1;
  }
 /**
  * function checks what characters are with ascii values 
	* @param calltime is counter of amount of time we called the function. Should be 0 in begining 
	* @return true if password only contains letters and at least has length 8 and 2 brackets
  * @param calltime
  * @return
  */
	boolean checkIfValidPassword(int calltime,int brecketcount) {
		
		if (calltime < pass.length() && pass.length() > 8 ) {
			char letter = pass.charAt(calltime);
			if((letter<=125 && letter!=124 && letter >=97 )|| (letter<=93 && letter!=92 && letter >=65 )||letter ==40||letter ==41) {//checking characters 
		        if(letter == '(' || letter == ')' ||letter == '{' ||letter == '}' ||letter == '[' ||letter == ']' )
		        	++brecketcount; // counting brackets
				return checkIfValidPassword(calltime+1,brecketcount	);
			}
			else {

				System.out.println("Not a valid password1. Password1 can have only letters and parentheses");
				return false;
			}
			
		}
		else if(pass.length() < 8 ) { //checking length
			System.out.println("Not a valid password1. Password1 needs at least length 8");
			return false;
		}
		else if(pass.length() == calltime) {
			if(brecketcount>1) //checking counter
			return true;
			else {
				System.out.println("Not a valid password1. Password1 needs at least 2 bracket");
				return false;
			}
		}

				
		
				
		
		
		return false;
		
	}
}
