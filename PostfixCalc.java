import java.util.*;

public class  PostfixCalc {

   private static final String operators="+-/*"; //define operators
   
   //initialize a stack 
   private static Stack<Integer> s=new Stack<>();
   
   public static int evaluate(String postfix)  {
   
      s = new Stack<Integer>();
      
      // splits the strings into token that can be analyzed separately
      String[] tokens = postfix.split("\\s+");
      
      for (String nextToken: tokens) {
      
         char firstChar = nextToken.charAt(0);
         if (isOperator(firstChar))
            s.push(evalOperator(firstChar));
         else {
            s.push(Integer.parseInt(nextToken));
         }//end else
      }//end for
      
      return s.peek();
   }//end calculate
   
   private static boolean isOperator(char c)  {
    
      return operators.indexOf(c) != -1;
   }//end isOperator
   
   public static int evalOperator(char c)  {
   
   //Calculate the postfix expression by popping the operands into the appropriate side (left or right)
   int rightoperand=s.pop();
   int leftoperand=s.pop();
   int result = 0 ;
   switch (c){
   
      case '+': result = (leftoperand + rightoperand);
         break;
         
      case '-': result = (leftoperand - rightoperand);
         break;
         
      case '/': result = (leftoperand / rightoperand);
         break;
         
      case '*': result = (leftoperand * rightoperand);
         break;
   
             }//end switch
   
   return result;
   
   }//end evaluating


}// end postfix