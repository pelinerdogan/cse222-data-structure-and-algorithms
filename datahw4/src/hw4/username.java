package hw4;

import java.util.Stack;

class username {

	String user_name;
	
	protected username(String s) {
		user_name = s;
	}
	/**
	 * function checks what characters are with ascii values 
	 * @param calltime is counter of amount of time we called the function. Should be 0 in begining 
	 * @return true if username only contains letters and at least has length 1
	 */

	
	boolean checkIfValidUsername(int calltime) {
		
		if (calltime < user_name.length()) {
			char letter = user_name.charAt(calltime);
			if((letter<=122 && letter >=97 )|| (letter<=90 && letter >=65 )) {
		      
				return checkIfValidUsername(calltime+1);
			}
			else {

				System.out.println("Not a valid username. Username can have only letters");
				return false;
			}
			
		}
		else if(user_name.length() == 0 ) {
			System.out.println("Not a valid username. Username needs at least length 1");
			return false;
		}
		else if(user_name.length() == calltime) {
			return true;
		}

				
		
				
		
		
		return false;
		
	}
	/**
	 * 
	 * @param password_1 is the password we put in stack
	 * @return true if username contains a letter from password
	 */
	
	boolean containsUserNameSpirit (password1 password_1) {
		
		Stack<Character> password1s = new Stack<Character>();
	 
		
		for(int i= 0; password_1.pass.length()>i ;i++) {
			password1s.push(password_1.pass.charAt(i));
		}
		
		
		while(password1s.isEmpty() == false) {
			
				char a = password1s.pop();
				if (user_name.contains(String.valueOf(a))==true) {
					return true;
				}
			
				
		}
		System.out.println("This username doesn't contain username spirit ");
		
		return false;
		
	}
	
}

 