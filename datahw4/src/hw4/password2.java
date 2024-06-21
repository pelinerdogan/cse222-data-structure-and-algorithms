package hw4;

 class password2 {
	 int pass;

  protected password2 (int s) {
			pass = s;
		   
		}
  /**
   * 
   * function is checking if denominations in given index is bigger than number. If it is, it moves to next index. If index is already last index of array it 
   * checks if number is zero if it is not it returns false. If index is not the last index of array it calls itself again with increasing index. If number is 
   * bigger than denomination it substracts the denomination from number and calls itself with same index.
   * @param password2 password2's value is changing as we keep deleting a denmomination from it
   * @param denominations should be sorted to highest to lowest
   * @param index
   * @return
   */
		
  boolean isExactDivision(int password2, int [] denominations , int index) {
	    if(pass<10 || pass> 10000)
	    {
	        	System.out.println("Password 2 must be between 10 and  10000");
	        	return false;
	    }
	  if(denominations[index]>password2 && index<denominations.length-1) {
		  
		  return isExactDivision(password2, denominations , index+1);
	  }
	  else if( denominations[index]<=password2){
		  
	 
		  return isExactDivision(password2-denominations[index], denominations , index);
		  
	  }else {
		  if (password2 == 0) {
			
			  return true;
		  }
		  else {
			  System.out.println("password2 is unvalid because denominations can't be summed to a way to make " + pass);
			  return false;
		  }
		  
	  }
	  
	  
  }
  
 
}
