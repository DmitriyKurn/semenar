public class HeapSort {

   public static void main(String[] args) {
    int[] arr = {123, 4, 9, 2, 1, -3, 0, 547, 45, 93, 34,2, 334};

    heapSort(arr);

    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }

  public static void heapSort(int[] arr) {
    
    int n = arr.length;
    
    for(int i  = n / 2 - 1; i >= 0; i--)
      heapify(arr, i , n);

    for (int i = n - 1; i >= 0; i--){

      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;

      heapify(arr, 0, i);
    }

  }
  
  private static void heapify(int[] arr, int i, int n) {
   
    int l = i * 2 + 1;

    int r = i * 2 + 2;

    int largest = i;

    if(l < n && arr[l] > arr[largest])
      largest = l;

    if(r < n && arr[r] > arr[largest])
      largest = r;

    if (i != largest){
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      heapify(arr, largest, n);
    }
  }
}