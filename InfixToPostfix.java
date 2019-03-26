import java.util.*;

public class InfixToPostfix  {
    
   //Data Fields
   private Stack<Character>  operatorStack;
   private static final String OPERATORS = "+-*/()";
   private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
   private StringBuilder postfix;
   
   //here the infix string converts the expression to postfix
   public String convert(String infix)
         throws SyntaxErrorException {
      operatorStack = new Stack<Character>();
      postfix = new StringBuilder();
      try {
      
         String nextToken; //The split tokens from before will be analyzed separately here 
         Scanner scan = new Scanner(infix);
         
         //Checks to see if there's an operand or not.  If there isnt then it appends it to the postfix
         // isJavaidentifierstart is used to to decide whether a given character is what were looking for or not
         while ((nextToken = scan.findInLine("[-+/\\*()]")) != null) {
            char firstChar = nextToken.charAt(0);
               if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar))
               {
                  postfix.append(nextToken);
                  postfix.append(' ');
               }
               //if its not an operand then it checks for being operator
               else if(isOperator(firstChar))  {
                  processOperator(firstChar);
                  }
                  else {
                     throw new SyntaxErrorException
                        ("Unexpected Character Encountered: " + firstChar);
                       }
           }// end While
           
           //Now whatever is left over, its popped and appended to the postfix
           while (!operatorStack.empty()) {
               char op = operatorStack.pop();
               
               if  (op == '(')
                  throw new SyntaxErrorException ("Unmatched opening paranthesis");
                  postfix.append(op);
                  postfix.append(' ');
                  }
                  return postfix.toString();
              }
              
              catch (EmptyStackException ex)  {
                  throw new SyntaxErrorException("Syntax Error: The stack is empty");
                  } 
              }
   //this method is used to check precedene, process operators, figure whats done when           
   private void processOperator(char op)  {
      if (operatorStack.empty()  || op == '(')  {
         operatorStack.push(op);
         }
      else {
         char topOp = operatorStack.peek();
         //if the precedence is lower then it pushes it
         if (precedence(op) > precedence(topOp)) {
            operatorStack.push(op);
            }
         // this checks if the precedence is higher or equal and pops it
         else {
            while (!operatorStack.empty() && precedence(op) <= precedence(topOp))  {
               operatorStack.pop();
               if (topOp == ')') {
                  break;
               }
               postfix.append(topOp);
               postfix.append(' ');
               if (!operatorStack.empty())  {
                  topOp = operatorStack.peek();
                  }
               }
               
               if (op!= ')')
                  operatorStack.push(op);
             }
          }
       }
       
      //this checks to see if the char is an operator or not. 
      private boolean isOperator(char ch)  {
         return OPERATORS.indexOf(ch) != -1;
      }
      
      // this is used to check the precedence of operators to see which is supposed to be done first
      private int precedence(char op)  {
         return PRECEDENCE[OPERATORS.indexOf(op)] ;
      }
      
      //Syntax error exception required by the program when compiling
      public static class SyntaxErrorException extends Exception {
      SyntaxErrorException(String message)  {
         super (message);
      }
   }            

}//end InfixToPostfix
