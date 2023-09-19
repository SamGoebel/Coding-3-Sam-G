
public class assignment3{

	  public static void main (String[]args)
	  {
	   String str = "Sam";
	   char[] arr = new char[str.length()];
	   int sNumber = 0;

	    // Copy character by character into the array
	    for (int i = 0; i < str.length(); i++) 
	    {
	      arr[i] = str.charAt(i);
	      sNumber = 1;
	    }
	  
	    //shows what happens if string is unique. 
	    IsAllUnique(str, arr, sNumber);
	    
	    
	    String str2 = "Matt";
		   char[] arr2 = new char[str2.length()];

		    // Copy character by character into the array
		    for (int i = 0; i < str2.length(); i++) 
		    {
		      arr2[i] = str2.charAt(i);
		      sNumber = 2;
		    }
	  
		   
		    //shows what happens if it fails the test
		    IsAllUnique(str2, arr2, sNumber);
		 
	  }
	  
	  public static boolean IsAllUnique(String str, char[] arr, int sNumber)
	  {
		//loop checks for the value at the array and compares it to y to see if they are the same. Fails if true.
		  for(int x = 1; x < str.length(); x++)
		{
			for(int y = 0; y < str.length(); y++)
			{
				if(arr[x] == str.charAt(y) && x != y) 
				{
					
					System.out.println("String " + sNumber + " was not unique at " + str.charAt(y));
					
					return false; 
				}
				
			}
			
		}
		System.out.println("String " + sNumber + " was unique");
		return true; 
	  }
	  
	  
	 }
