import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0; start = 0; end = 0;
  }
  public MyDeque(int initialCapacity){
    if(initialCapacity<=0)initialCapacity = 10;
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0; start = 0; end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "[";
    if(size == 0) return ans+"]";

    if(start <= end){
      for(int i = start; i<=end; i++){
        if(i != end){
          ans += data[i] + ", ";
        }
        else{
          ans += data[i] + "]";
        }
      }
    }

    if(start > end){
      for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i =0; i <= end; i++){
        if(i != end){
          ans += data[i] += ", ";
        }
        else{
          ans += data[i] + "]";
        }
      }
    }
    return ans;
  }

  public String toStringDebug(){
    System.out.println("start: " + start);
    System.out.println("end: " + end);
    String ans = "[";
    for(E c : data){
      ans += c +", ";
    }
    return ans + "]";
  }

  public void addFirst(E element) throws NullPointerException{
    if(element == null)throw new NullPointerException("nh");
    if(size == data.length){
      expand();
    }
    if(size == 0)data[start] = element;
    else{
      start--;
      if(start < 0)start = data.length-1;
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element) throws NullPointerException{
    if(element == null)throw new NullPointerException("nah");
    if(size == data.length){
      expand();
    }
    if(size == 0)data[end] = element;
    else{
      end++;
      if(end >= data.length)end = 0;
      data[end] = element;
    }
    size++;
  }

  private void expand(){
    @SuppressWarnings("unchecked")
    E[] newThing = (E[])new Object[data.length*2];
    int copIn = start;
    for(int i = 0; i < size; i++){
      if(copIn == data.length)copIn = 0;
      newThing[i] = data[copIn];
      copIn++;
    }
    data = newThing;
    start = 0;
    end = size-1;

  }



  public E removeFirst() throws NoSuchElementException{
    if(size == 0)throw new NoSuchElementException("size 0");
    E removed = data[start];
    start++;
    if(start >= data.length)start = 0;
    size--;
    return removed;

  }

  public E removeLast() throws NoSuchElementException{
    if(size == 0)throw new NoSuchElementException("size 0");
    E removed = data[end];
    end--;
    if(end < 0)end = size-1;
    size--;
    return removed;

  }

  public E getFirst() throws NoSuchElementException{
    if(size == 0)throw new NoSuchElementException("size 0");
    return data[start];
  }

  public E getLast() throws NoSuchElementException{
    if(size == 0)throw new NoSuchElementException("size 0");
    return data[end];
  }

  public int getStart(){
    return start;
  }
  public int getEnd(){
    return end;
  }
  private void stuff(){
    System.out.println("start: " + getStart() + "  end: " + getEnd());
    System.out.println(toString());
    System.out.println(size());
    System.out.println();
  }

  public static void main(String[] args) {
    MyDeque a = new MyDeque<Integer>(2);
    // System.out.println(a.toString());
    // System.out.println(a.size());

    a.addLast(1);
    a.stuff();

    a.removeLast();
    a.stuff();

    a.addLast(1342);
    a.stuff();

    a.removeLast();
    a.stuff();
    a.addLast(null);
    // System.out.println(a.size());
  }
}
