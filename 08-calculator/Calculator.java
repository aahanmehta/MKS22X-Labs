import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static double eval(String s){
    if(s.length() == 0)throw new IllegalArgumentException("too few operands");
    Scanner scan = new Scanner(s);
    ArrayDeque<Double> bob = new ArrayDeque<Double>();
    
    while(scan.hasNext()){
      String mary = scan.next();
      if(mary.equals("+")){
        if(bob.size() < 2)throw new IllegalArgumentException("too few operands for operation +");
        double a = bob.pop();
        double b = bob.pop();
        bob.push(a+b);

      }
      else if(mary.equals("*")){
        if(bob.size() < 2)throw new IllegalArgumentException("too few operands for operation *");
        double a = bob.pop();
        double b = bob.pop();
        bob.push(a*b);

      }
      else if(mary.equals("-")){
        if(bob.size() < 2)throw new IllegalArgumentException("too few operands for operation -");
        double a = bob.pop();
        double b = bob.pop();
        bob.push(b-a);

      }
      else if(mary.equals("/")){
        if(bob.size() < 2)throw new IllegalArgumentException("too few operands for operation /");
        double a = bob.pop();
        double b = bob.pop();
        bob.push(b/a);

      }
      else if(mary.equals("%")){
        if(bob.size() < 2)throw new IllegalArgumentException("too few operands for operation %");
        double a = bob.pop();
        double b = bob.pop();
        bob.push(b%a);

      }
      else{
        bob.push(Double.parseDouble(mary));

      }
    }


    return bob.pop();
  }

  public static void main(String[] args) {
    System.out.println(eval("5 + +"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
  }
}
