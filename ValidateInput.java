import java.util.Scanner;

public class ValidateInput {
   Scanner sc = new Scanner(System.in);

   /*
      Validate input (integer)
      Input parameters:
         s1    displayed string
         s2    error msg
         min minimumm value of input integer
         max maximumm value of input integer
      Output:  return integer
   */     
   public int getInput(String s1, String s2, int min, int max) {
      int input;
      boolean flag;
   
      do {
         System.out.print(s1);
         while (!sc.hasNextInt()) {                // trap input item error               
            sc.nextLine();                         //clear the invalid input
            System.out.println(s2);
            System.out.print(s1);
         }
         input = sc.nextInt();
         flag = input < min || input > max;
         if (flag)
            System.out.println("* Valid number range is from " + min + " to " + max);
      } while (flag);
      return input;
   } // end of getInput()
}   // end of class
