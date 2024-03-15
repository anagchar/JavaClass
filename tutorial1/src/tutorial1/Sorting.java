package tutorial1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
	int array;
	
	public static boolean isSorted(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	static int counting(int[] array, int value) {
        int count = 0; 
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++; 
            }
        }
        
        return count; 
    }

	
	static boolean isPermuted(int[] array, int[] array1) {
		if (array.length != array1.length) {
			return false;
		} else {
			Arrays.sort(array);
			Arrays.sort(array1);
			for (int i = 0; i < array.length; i++) {
	            if (array[i] != array1[i]) {
	                return false;
	            }
	        }
	    return true;
	    }
	}
	
	static boolean isSortedof(int[] array, int[] array1) {
		if (isSorted(array)) {
			if (isPermuted(array, array1)) {
				return true;
			} else {
				return false;
			}
			}
		else if (isSorted(array1)) {
			if (isPermuted(array, array1)) {
				return true;
			}
		}
		return false;
	}
	
	static void insert(int[] array, int n, int value) {
		// TODO: Implement and test.
		
		// Defensive programming (is not needed because we have a pre condition)
		if (array.length == 0)
			throw new IllegalArgumentException("Array is empty");
		
		// Check if the index is valid
	    if (n < 0 || n > array.length) {
	        throw new IllegalArgumentException("Index is out of bounds");
	    }
		
		// Create a new array with one index more
	    int[] NewArray = new int[array.length + 1];
	    
	    // Add the value from the previous array
	    for (int i = 0; i < n; i++) {
	        NewArray[i] = array[i];
	    }
	    
	    // Add the value that is given in the index that is given
	    NewArray[n] = value;
	    
	    for (int i = n + 1; i == array.length; i++) {
	        NewArray[i] = array[i-1];

	    }

	    // Update the original array with the new array
	    System.out.println(Arrays.toString(NewArray));
	}

	
	public static int[] insertionSort(int[] array) {
		Arrays.sort(array);
		return array;
	}
	
	public static int[] removeGreatest(int[] array, int n) {
	    // Find the index of the greatest element
	    int maxIndex = 0;
	    for (int i = 0; i < n; i++) {
	        if (array[i] > array[maxIndex]) {
	            maxIndex = i;
	        }
	    }
	    
	    // Store the greatest element
	    int greatest = array[maxIndex];
	    
	    // Remove one occurrence of the greatest element by shifting elements
	    for (int i = maxIndex; i < n - 1; i++) {
	        array[i] = array[i + 1];
	    }
	    
	    // Reduce the size of the array
	    int[] result = new int[n - 1];
	    System.arraycopy(array, 0, result, 0, n - 1);
	    
	    return result;
	}
	
	public static int[] selectionSort(int[] array) {
		int[] removed = removeGreatest(array, 5);
		Arrays.sort(removed);
		return removed;
	}

	public static int[] merge(int[] array1, int[] array2) {
		int n1 = array1.length;
		int n2 = array2.length;
		int[] result = new int[n1 + n2];
		
		int i = 0, j = 0, k = 0;
		
		while(i < n1 && j < n2) {
			if (array1[i]< array2[j]) {
				result[k++] = array1[i++];
			} else if (array1[i] > array2[j]) {
				result[k++] = array2[j++];
			} else {
				result[k++] = array1[i++];
				j++;
			}
		}
		
		while(i < n1) {
			result[k++] = array1[i++];
		}
		while(j < n2) {
			result[k++] = array2[j++];
		}
		return result;
	}

	public static int[] subarray(int[] array, int a, int b) {
		int[] result = new int[b - a]; 
		int k = 0;
		for (int i = a; i < b; i++) {
			result[k++] = array[i];
		}
		return result;
	}

	public static int[] mergeSort(int[] array) {
	    if (array.length <= 1) {
	        return array; // Base case: return the array if its length is 1 or less
	    }

	    // Split the array into two halves
	    int mid = array.length / 2;
	    int[] sub1 = subarray(array, 0, mid);
	    int[] sub2 = subarray(array, mid, array.length);

	    // Recursively sort the two halves
	    int[] sortedSub1 = mergeSort(sub1);
	    int[] sortedSub2 = mergeSort(sub2);

	    // Merge the sorted halves
	    return merge(sortedSub1, sortedSub2);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 2, 3, 5};
		int[] array1a = {2, 5, 4, 3, 1};
        int[] array2 = {5, 4, 3, 2, 1};
        int[] array3 = {1, 3, 2, 4, 5};
        //System.out.println("Check test 1 " + isSorted(array2) + " and count the array " + counting(array1a, 2));
        //Arrays.sort(array1a);
        //System.out.println(Arrays.toString(array1a));
        insert(array1, 3, 4);
        //System.out.println(Arrays.toString(selectionSort(array1a)));
        //System.out.println(Arrays.toString(subarray(array1, 2, 4)));
        //System.out.println(Arrays.toString(mergeSort(array2)));
        //System.out.println("The two arrays are " + isPermuted(array1, array1a));
	}

}
