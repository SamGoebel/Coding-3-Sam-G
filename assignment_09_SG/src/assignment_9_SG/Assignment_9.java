package assignment_9_SG;

public class Assignment_9 
{
	/* Splits arr[] into different seperate arrays in order to more effecively sort them. 
	This way is done to save on phyical memory being used to save a temperary array */
    
	static void merge(int arr[], int start, int mid,
                      int end)
    {
        int start2 = mid + 1;
 
        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2]) {
            return;
        }
 
        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {
 
            // If element 1 is in right place
            if (arr[start] <= arr[start2]) {
                start++;
            }
            else {
                int value = arr[start2];
                int index = start2;
 
                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
 
                // Updates pointers
                start++;
                mid++;
                start2++;
            }
        }
    }
 
    //sorts the seperated chunks of the array and sends them back to be reunited back into the orignal array. 
    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Same as (l + r) / 2, but avoids overflow
            // for large l and r
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
 
    //Prints s array
    static void printArray(int A[], int size)
    {
    	System.out.print("The sorted array is: \n");
    	int i;
        for (i = 0; i < size; i++)
        
        System.out.print(A[i] + " ");
        System.out.println();
    }
 
    //Driver to test made methods
    public static void main(String[] args)
    {
        int arr[] = { 12, 18, 19, 3, 2, 7 };
        int arr_size = arr.length;
 
        mergeSort(arr, 0, arr_size - 1);
        printArray(arr, arr_size);
    }	 
	
}


