import java.util.Scanner;

public class TestPostfixCalc  {

   public static void main(String[]args)  {
   
   Scanner scan=new Scanner (System.in);
   System.out.println("Please Enter a postfix expression");
   String postfix=scan.nextLine();
   
   System.out.println(PostfixCalc.evaluate(postfix));
   
   }//end main


}//end TestPostfixCalc