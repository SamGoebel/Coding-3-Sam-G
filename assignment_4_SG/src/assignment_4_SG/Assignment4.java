package assignment_4_SG;

public class Assignment4 {

	 static void findRow(int[][] a, int n, int m, int k)
	    {
	        int l = 0, r = n - 1, mid;
	 
	        while (l <= r) {
	            mid = (l + r) / 2;
	 
	          
	            if (k == a[mid][0]) // looks at furtherest right element 
	            {
	                System.out.println("Found at (" + mid + ","
	                                   + "0)");
	                return;
	            }
	 
	            if (k == a[mid][m - 1]) // looks at furtherest right element 
	            {
	                int t = m - 1;
	                System.out.println("Found at (" + mid + ","
	                                   + t + ")");
	                return;
	            }
	 
	            if (k > a[mid][0]
	                && k < a[mid]
	                        [m - 1]) // this means the element
	                                 // must be within this row
	            {
	                binarySearch(a, n, m, k,
	                             mid); // we'll apply binary
	                                   // search on this row
	                return;
	            }
	 
	            if (k < a[mid][0])
	                r = mid - 1;
	            if (k > a[mid][m - 1])
	                l = mid + 1;
	        }
	        System.out.println("Number is either too big or too small");
	    }
	 
	    static void binarySearch(int[][] a, int n, int m, int k,
	                             int x) // x is the row number
	    {
	        //the row is narrowed down and now it is conducting a search to find the value
	    	
	        int l = 0, r = m - 1, mid;
	        while (l <= r) {
	            mid = (l + r) / 2;
	 
	            if (a[x][mid] == k) {
	                System.out.println("Found at (" + x + ","
	                                   + mid + ")");
	                return;
	            }
	 
	            if (a[x][mid] > k)
	                r = mid - 1;
	            if (a[x][mid] < k)
	                l = mid + 1;
	        }
	        System.out.println("Number is not there at all");
	    }
	   
	    
	    public static void main(String args[])
	    {
	        int n = 3; // number of rows
	        int m = 4; // number of columns
	 
	        int a[][] = { { 0, 5, 10, 15},
	                      { 20, 25, 30, 35},
	                      { 40, 45, 50, 55}};
	 
	        int k = 12; // numbers we're looking for
	        int v = -1; 
	        int i = 50;	        
	        
	        findRow(a, n, m, k);
	        findRow(a, n, m, v);
	        findRow(a, n, m, i); 
	    }
	}

	



