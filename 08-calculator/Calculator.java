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
    Scanner scan = new Scanner(s);
    ArrayDeque<double> bob = new ArrayDeque<double>();
    while(scan.hasNext()){
      String mary = scan.next();
      if(mary.equals("+"))bob.push(bob.pop() + bob.pop();
      if(mary.equals("*"))bob.push(bob.pop() * bob.pop();
      if(mary.equals("-")){
        double a = bob.pop
      }
      if(mary.equals("/")){

      }
      if(mary.equals("*")){

      }

    }
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *"));
  }
}
