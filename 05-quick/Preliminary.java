public class Preliminary{
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int partition ( int [] data, int start, int end){
    System.out.println(toString(data));

    int index = (int)(Math.random()*(end -start) + start);
    int pivot = data[index];
    int temp = data[start];
    int x = start;
    data[start] = data[index];
    data[index] = temp;
    System.out.println(toString(data));

    for(int i = start; i <= end; i++){
      if(data[i] <= pivot){
        temp = data[i];
        data[x] = temp;
        data[i] = pivot;
        System.out.println(toString(data));
        System.out.println();
      }
    }
    System.out.println(pivot);
    System.out.println(toString(data));
    return x + start;
  }

  public static void main(String[] args) {
    int[] t1 = {1,7,5,2,3,4};
    int[] t2 = {999,999,999,4,3,2,1,0,999,999,999};
    //System.out.println(toString(t1));
    System.out.println(partition(t1, 0, 5));
    //System.out.println(toString(t2));
    //System.out.println(partition(t2, 0, 9));
  }
  public static String toString(int[] ary){
    String ans = "[";
    for(int c:ary){
      ans += c + ", ";
    }
    return ans + ']';
  }
}
