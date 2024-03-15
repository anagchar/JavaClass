package tutorial1;

import java.util.Arrays;

public class Heap_sort {
    public static void heapAdd(int[] array, int n) {
        if (n >= array.length) {
            throw new IllegalArgumentException("Index out of range.");
        }

        // Place the new element at index n in the heap
        int current = n;

        // Sift up algorithm
        while (current > 0) {
        	// Calculate the index of the parent node
            int parent = (current - 1) / 2; 
         // If the current value is greater than its parent's value
            if (array[current] > array[parent]) { 
                // Swap the elements
                int temp = array[current];
                array[current] = array[parent];
                array[parent] = temp;
                // Move up to the parent node
                current = parent;
            } else {
                // If the current value is not greater than its parent's value, stop
                break;
            }
        }
    }
    
    public static int[] heapRemove(int[] array, int n) {
    	if (n >= array.length) {
    		throw new IllegalArgumentException("Index out of range.");
    	}
    	
    	//Replace the first element with the last
    	array[0] = array[array.length - 1];
    	  	    	
    	// Resize the array to remove the last element
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i]; // Copy elements from the original array to the new array
        }
        
        
        //Sift down algorithm
        int current = 0;
        while (current < newArray.length) {
        	 int leftChild = 2 * current + 1;
             int rightChild = 2 * current + 2;
             int largest = current;

             if (leftChild < newArray.length && newArray[leftChild] > newArray[largest]) {
                 largest = leftChild;
             }
             if (rightChild < newArray.length && newArray[rightChild] > newArray[largest]) {
                 largest = rightChild;
             }

             //If the first element is not the largest one
             if (largest != current) {
                 // Swap the current node with the largest child
                 int temp = newArray[current];
                 newArray[current] = newArray[largest];
                 newArray[largest] = temp;
                 current = largest; 
                 
        		} else {
        			break;
        		}
        	}
        
        return newArray;
        }
    
    public static int[] heapSort(int[] array) {
    	// Build a max-heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
		return array;
    }
    
    //Heapify function
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Initialize the largest as root
        int leftChild = 2 * rootIndex + 1; // Left child index
        int rightChild = 2 * rootIndex + 2; // Right child index
        
        // If the left child is larger than root
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        
        // If the right child is larger than largest so far
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        
        // If the largest is not the root
        if (largest != rootIndex) {
            // Swap the root with the largest element
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            
            // Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] array = {1, 8, 7, 5, 6, 5}; 
        int newIndex = 6;
        
        
        // Example of headRemove
        int[] heap = heapSort(array);
        for (int num1 : heap) {
            System.out.print(num1 + " ");
        }
    }
}
