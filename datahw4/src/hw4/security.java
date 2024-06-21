package hw4;

public class security {

	username userName  ;
	password1 password_1  ;
	password2 password_2 ;
	
	protected security(String username,String password1,int password2) {
		
		 userName = new username(username);
		 password_1 = new password1(password1);
		 password_2 = new password2(password2);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		security sec= new security("pelin1","aa{bb}iii",75); // tests validusername
		security sec1= new security("","aa{bb}iii",75);//tests validusername
		security sec2= new security("pelin","aa{bb}iii1",75);//test checkIfValidPassword
		security sec3= new security("pelin","aabbiiiiii",75);//test checkIfValidPassword
		security sec4= new security("pelin","aabbiiiiii",10000000);// test password2 boundries
		security sec5= new security("pelin","aa{bbiii",75);// isBalancedPassword
		security sec6= new security("pelin","aabbiii()i",22);//isExactDivision
		security sec7= new security("pelin","aa{bb}kkkk",75);//containsUserNameSpirit
		security sec8= new security("pelin","aa{bb}iiik",75);//isPalindromePossible
		security sec9= new security("pelin","aa{bb}iiii",75);//isPalindromePossible
		
		int [] denominations = {4,17,29};
		sec.test(denominations);	
		sec1.test(denominations);	
		sec2.test(denominations);	
		sec3.test(denominations);
		sec4.test(denominations);		
		sec5.test(denominations);	
		sec6.test(denominations);	
		sec7.test(denominations);	
		sec8.test(denominations);	
		sec9.test(denominations);	
		
		
		
	}
	/**
	 *  sorts array highest to lowest
	 * @param arr denominations
	 * @return sorted array
	 * 
	 */
	
	 int [] sortingdenom(int [] arr) {
		int minindex;
		for(int i= 0; i<arr.length;i++) {
			minindex=i;
			for(int k= i+1; k<arr.length;k++) {
				if(arr[minindex]<arr [k])
					minindex=k;
			}
			if(minindex!=i) {
				int m = arr[i];
				arr[i]=arr[minindex];
				arr[minindex]=m;
				
			}
		}
		
		return arr;
		
	}
	 /**
	  * tests whole code 
	  * @param arr 
	  */
	 void test(int arr[]) {
		 System.out.println("\nUsername : "+ userName.user_name +"\nPassword1 : "+password_1.pass+"\nPassword2 : "+password_2.pass);
		
		 if( password_1.isBalancedPassword()&&userName.checkIfValidUsername(0) && password_2.isExactDivision(password_2.pass, sortingdenom(arr), 0)  && 
				 userName.containsUserNameSpirit(password_1)&& password_1.checkIfValidPassword(0,0)&&
				 password_1.isPalindromePossible(false,1 , 0, 1, password_1.withoutparantheses()))
			
			 System.out.println("The username and passwords are valid. The door is opening, please wait..");
	 else 
		      System.out.println("You can't get in");
	 /*
	  *)
	  */
}
}
