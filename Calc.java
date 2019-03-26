import java.util.*;
import javax.swing.JOptionPane; //this was somethign suggested by the book to evaluate in a popup rather than the terminal

public class Calc  {

   private static String postfixExpression;
   
   public static void main(String[]args)  {
   
      //data fields
      // initializing and setting the various variables being used
      InfixToPostfix inToPost = new InfixToPostfix();
      String infix = null;
      String postfix = null;
      Scanner scan=new Scanner(System.in);
     
      //driver methods
      System.out.println("Please Enter an infix expression: ");
      infix = scan.next();

      //This is SUPPOSED to convert and display infix, postfix, and it evaluated as well.  It doesn't work as it should.
      try {
         System.out.println("your infix expression is " + infix);
         System.out.println("your postfix expression is " + postfix);
         System.out.println("Your expression evaluated is : ");
         System.out.println(PostfixCalc.evaluate(postfixExpression));
         postfix = inToPost.convert(infix);
      } catch (Exception e) {e.getMessage();}

   /*
   **********************************************************************************
   THIS CODE WAS SOMETHING WE WERE TESTING BUT WASNT WORKING BUT IT SEEMS WE'RE CLOSE
   **********************************************************************************
   //InfixToPostfix inToPost = new InfixToPostfix();
   PostfixCalc postEval = new PostfixCalc();
   InfixToPostfix inToPost = new InfixToPostfix();
   String infix = JOptionPane.showInputDialog ("Please Enter an infix expression");

   try {
      String postfix = inToPost.convert(infix); 
      JOptionPane.showMessageDialog(null, "infix " + infix + "becomes " + postfixExpression);

      */
      /*
       //Calculates the postfix
      if (postfixExpression != null) {
         System.out.println("Your expression evaluated is : ");
         System.out.println(postEval.evaluate(postfixExpression));
         } 
           
      }  
      catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
      }
      */

   }//end main

}//end TestPostfixCalc