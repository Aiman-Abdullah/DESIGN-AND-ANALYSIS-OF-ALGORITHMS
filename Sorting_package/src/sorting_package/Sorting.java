
package sorting_package;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PROGRAMMER
 */
public class Sorting {
    

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sorting obj = new Sorting();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter The size of the Array to Hold All Values."+"\n"+" All Values will Enter Randomly By System To make your Testing Easier !: ");

        int size = in.nextInt();
        Random random = new Random();
       
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(size);
            }

        
        
       
        
        System.out.println("Enter The Choice Which Sorting Algorithm You Want To use to Do Sorting! " + "\n" + "Bubble Sort Press 1"
                + "\n" + "Insertion Sort Press 2" + "\n"
                + "Selection Sort Press 3" + "\n"
                + "Merge Sort Press 4" + "\n"
                + "Heap Sort Press 5" + "\n"
                + "Quick Sort Press 6" + "\n"+
                "3 -Way Quick Sort Press 7");

        
        
        
     
        // User Will select which Algorithm Want To Use!
        int numbers = in.nextInt();

        switch (numbers) {
            case 1:
                obj.Bubble(array);
                break;

            case 2:
                obj.Insertion(array);
                break;

            case 3:
                obj.Selection(array);
                break;

            case 4:
                // Merge Sort
                      // array , first Index , Last Index
                long result =obj.sort(array, 0, array.length - 1);
                System.out.println("sorting Resutls Using Merge Sort:");
                for (int e = 0; e < array.length; e++) {
                    System.out.println(""+array[e]+"");
                }
                
                 System.out.print("result Total Time = "+result+"\n");
               
                break;

            case 5:
                // Heap sort
              
               long result2 = obj.heapSort(array);
                System.out.println("sorting Resutls Using Heap Sort:");
                for (int e = 0; e < array.length; e++) {
                    System.out.println(""+array[e]+"");
                }
                 System.out.print("result Total Time = "+result2+"\n");
                
                
                break;

            case 6:
                // Quick Sort
                           // array , first Index , Last Index
            long result3 =  obj.quickSort(array,0, array.length-1);
                 System.out.println("sorting Resutls Using Quick Sort:");
       for (int i = 0; i <array.length; i++) {
                     System.out.println(""+array[i]+"");
                }
        System.out.print("result Total Time = "+result3+"\n");
               
                break;

                
                
            case 7 :    // 3-Way Quick Sort
                
                int result5 = obj.quick_3way_sort(array,0, array.length-1);
                for (int i = 0; i <array.length; i++) {
                     System.out.println(""+array[i]+"");
                }
                System.out.println("result Total Time : "+ result5);
                break;
                
            default:
         
                System.out.println("You did not Choice any number From List !");
                break;
        }

    }
      
        

    
    /*
    Bubble Sort Worse Case O(N^2)
    By giving an array, the Algorithm will sort the array in ASC order
    This algorithm not Efficient because use Nested loop which will take more time
    Its good for sorting small data
     */
    public void Bubble(int array[]) {
        long timebegin = System.currentTimeMillis();
        // First Pointer 
        for (int i = 0; i < array.length; i++) {
           // 2nd Pointer to Check all elements and do swap
            for (int j = 0; j < array.length - 1; j++) {
                    // Swap Operation
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;

                }
            }

        }
        System.out.println("Bubble Sorting Result: ");
        for (int k = 0; k < array.length; k++) {
               System.out.println(""+array[k]+"");
        }
         long timeend = System.currentTimeMillis();
         long result = timeend - timebegin;
           System.out.print("result Total Time = "+result+"\n");
    }

    
    
  /*
    Insert Algorithm Worse Case O(N^2)
     By giving an array, the Algorithm will sort the array in ASC order
    Idea of this Algorithm is pick first element of array  and compare it with the all elements in left side if any of that element and swap if large element found on left side
    .
     sorting will search from left and all items from 
    left sub array smaller than right sub array and
    repeating iteration until all elements has been sorted.
    This is also not fast enough because use Neted loop to move items to left
    This is also good for small Data
    
  */
    
    public void Insertion(int array[]) {
        long timebegin = System.currentTimeMillis();
        int key;
        int j;
        for (int i = 0; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            // if True then whill do Swap to the elements
            while ((j >= 0) && (array[j] > key)) {
                array[j + 1] = array[j];
                j = j - 1;

            }
            array[j + 1] = key;

        }
       
        System.out.println("Insertion sorting Results are: ");
        for (int k = 0; k < array.length; k++) {
               System.out.println(""+array[k]+"");
        }
         long timeend = System.currentTimeMillis();
          long result = timeend - timebegin;
            System.out.print("result Total Time = "+result+"\n");

    }

    
    
    
    /*
    
    This will search from left -> Right start by pick item hold it in temp value and start to search for elment less than temp value if find will update temp value
    until get smallest one then will do swap after that move pointer one step up.
    start repeat same process.
       This is also not fast enough because use Neted loop to move items to left
    This is also good for small Data
    This Algorithm will take O(N^2) because the two Nested loop.
    */
    
    public void Selection(int array[]) {
          long timebegin = System.currentTimeMillis();
        int temp = 0;
        int min;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            temp = i;
            for (int j = i; j < array.length; j++) {

                if (array[j] < min) {
                    min = array[j];
                    temp = j;
                }
            }

            if (min < array[i]) {
                int temp2 = array[i];
                array[i] = array[temp];
                array[temp] = temp2;
            }
        }

        System.out.println("Selection sorting Resutls: ");
        for (int k = 0; k < array.length; k++) {
               System.out.println(""+array[k]+"");
        }
           long timeend = System.currentTimeMillis();
          long result = timeend - timebegin;
            System.out.print("result Total Time = "+result+"\n");

    }

    
    
    
    
    
    /*
  This Method Will sort the Array and return the Result
    This method is fast it Take O(n Log n )
It divide array to subarray and the subarrays also to sub of subarray until get single element then do loop back to sort element to
get at the end Sorted List.    
    
    This Algorithm Very Efficient fo Big Data set
    

     */
    public long sort(int array[], int begin, int end) {
 long timebegin = System.currentTimeMillis();
        // Mean there are Elements in the Array   
        if (begin < end) {

            int middle = (begin + end) / 2;
            sort(array, begin, middle); // Sort left Half by keep calling function until reach one digit
            sort(array, middle + 1, end); // Sort Right Half
            merge_array(array, begin, end, middle); // To merge the SubArrays

        }
        
         long timeend = System.currentTimeMillis();
          long result = timeend - timebegin;
           return result;

    }

    // This function will merge Numbers of left and right side!
    public int[] merge_array(int array[], int start, int end, int middle) {
        
          // Rigth side 
        int[] right = new int[end - middle + 1]; // middle+1 because we do not want to include middle Value
        int T = middle + 1;
        while (T <= end) {
            int k = T - middle - 1;
            right[k] = array[T];
            T++;
        }
       right[end - middle] = 10000000;  //10000000 it just big number to make sure not less than number we look for 

        
        // Left side we will create new array to move position around place by breaking our list to small lists
        int[] left = new int[middle - start+2];  // mid and start include locatin the last index so to make sure we include both of them we make it +2
        int k = start;
        while (k <= middle) {
            left[k - start] = array[k];
            k++;
        }
        int number = middle - start + 1;
        left[number] = 10000000;  //10000000 it just big number to make sure not less than number we look for 

      
        
        
        
        //Merge The Right, Left Lists
        int i = 0, j = 0, y = 0;
        for (int r = start; r <= end; r++) {
            if (left[i] < right[j]) {
                array[r] = left[i++];
            } else {
                array[r] = right[j++];
            }
        }

        return array;  // Sorted List
    }


    
    // To do Find Max element and place it to end of Array
    public  void heapify(int[] arr, int i,int size) { 
      int left_child = 2*i;   // left child
      int right_child = 2*i+1;   // Right child
      int parent=i/2;               // parent
      if(left_child <= size && arr[left_child] > arr[i]){
         parent=left_child;
      } else {
         parent=i;
      }
 
      if(right_child <= size && arr[right_child] > arr[parent]) {
         parent=right_child;
      }
      // If max is not current node, exchange it with max of left and right child
      if(parent!=i) {
       //  exchange(arr,i, parent);  parrent = j ,  i = i 
         
         int swap = arr[i];
         arr[i]=arr[parent];
         arr[parent]=swap;
         heapify(arr, parent,size);
      }
   }
    

    
    /*
    Worse Case O(n Log n )
    */
    
  public  long  heapSort(int[] arr) {
       long timebegin = System.currentTimeMillis();
      int size=arr.length-1;
     for(int i=(size)/2; i>=0; i--){
           heapify(arr,i,size);
      }

      for(int i=size; i>0; i--) {
         int swap = arr[0];
         arr[0]=arr[i];
         arr[i]=swap;

         
         size=size-1;
         heapify(arr, 0,size);
      }
     long timeend = System.currentTimeMillis();
          long result = timeend - timebegin;
           return result;
   }
    
    
  
  
  
  
  
/*
    Steps: 
    1- select Pivot and get R, L arrays
    2- repeat step 1 for R , L subarrays until get Sorted array.
    So,
    We need to Find Pivot. 
    Then divide Array to two part L, R
    then we will check Left array side and check 
    if has greater than pivot stop.
    Also check the right side and check if right array has element less than Pivot stop 
    Then do swap from element in left array with element in Right array
    and contunie until array sorted. 
    Next, will repeat same process for left array and for Right array. 
    In case We select Pivot as Larger value our Big-O will be N^2
    
    Low , Hight use to select the Pivot.
  This method is Very Efficient for Large Set of Data
  
  We selected Last element as the Pivot 
    */
    public long quickSort(int array[] , int start , int end) {
 long timebegin = System.currentTimeMillis();
   
 if(start<end){
   int pi = partition(array, start, end);
     quickSort(array, start, pi-1);
     quickSort(array, pi+1, end);
 }
 
 
 

           long timeend = System.currentTimeMillis();
         long result = timeend - timebegin;
        return result;
    }
    
    
    public int partition (int[] array , int start , int end ){
       
       int pivot = array[end];
       int i = start-1;
        for (int j = start; j <=end-1; j++) {
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i]= array[j];
                array[j]=temp;
            }
        }
        int temp = array[i+1];
        array[i+1]=array[end];
        array[end]= temp;
        return i+1;

}
    
  
    
       public  void Sortquick_3_median(int[] array, int begin, int end) {
        int total = end - begin + 1;
        if (total == 2) {
            if (array[begin] > array[end])
            {
        int p = array[begin];
        array[begin] = array[end];
        array[end] = p ;
            }
                
            
        }
        else {
            if (array[begin] > array[end - 1])
            {
                int p = array[begin];
        array[begin] = array[end-1];
        array[end-1] = p;
            }
            
            if (array[begin] > array[end]){
                        int p = array[begin];
        array[begin] = array[end];
        array[end] = p; 
            }
               
            if (array[end - 1] > array[end]){
          int p = array[end-1];
        array[end-1] = array[end];
        array[end] = p;
            }
               
        }
    }
    
    
    @SuppressWarnings("empty-statement")
    public  int quicksort_divition(int[] array, int begin, int pivot, int end) {
      
        int t_p = end - 1;

        while (true) {
            while (array[++begin] < pivot){}
                
            while (array[--t_p] > pivot){}
                
            if (begin >= t_p){
                break;
            }
            else{
                      int p = array[begin];
        array[begin] = array[t_p];
        array[t_p] = p;
                
            }
               
        }
        
           int p = array[begin];
        array[begin] = array[end - 1];
        array[end - 1] = p;
        
       
        return begin;
    } 
    
    
 public  int quick_3_medians(int[] array, int begin, int end) {
        int median = (begin + end) / 2;

        if (array[begin] > array[median]){
             int p = array[begin];
        array[begin] = array[median];
        array[median] = p;
            
        }
          

        if (array[begin] > array[end]){
            
                  int p = array[begin];
        array[begin] = array[end];
        array[end] = p;
            
        }
        

        if (array[median] > array[end]){
              int p = array[median];
        array[median] = array[end];
        array[end] = p;
        }
          
    int p = array[median];
        array[median] = array[end - 1];
        array[end - 1] = p;
        
      
        return array[end - 1];
    }

   public int quick_3way_sort(int[] array, int begin, int end) {
       long timebegin = System.currentTimeMillis();
        int size = end - begin + 1;
        if (size <= 3){
           Sortquick_3_median(array, begin, end);  
        }
           
        else {
            int median = quick_3_medians(array, begin, end);
            int part = quicksort_divition(array, begin, median, end);
            quick_3way_sort(array, begin, part - 1);
            quick_3way_sort(array, part + 1, end);
        }
        
        long timeend = System.currentTimeMillis();
          long result = timeend - timebegin;
           return (int) result;
    }


}
