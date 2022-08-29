/*
*Developed By Yam Dangar (s4653215)


*/

import java.io.PrintStream;





public class CoffeeNRoll {

   
     
    public static void main(String[] args) {
      int opt;
      int quantity;
      int sale;
      int paid;
      int total = 0;
      int notes[][];
      int coins [][];
      String s1;
      String s2;
      ValidateInput in;
      Product order[];
      Change change;
      
      //create and initialise objects
      order = new Product[6];    //each element corresponding
      order[1] = new Product("Schnitzel Roll");
      order[1].setPrice(1880);
      order[2] = new Product("Fish Roll");
      order[2].setPrice(1725);
      order[3] = new Product("Lamb Roll");
      order[3].setPrice(1460);
      order[4] = new Product("Ice Cream Roll");
      order[4].setPrice(675);
      order[5] = new Product("Coffee Latte");
      order[5].setPrice(340);
      
      change = new Change();   //create change object
      in = new ValidateInput();    //validate input
      
      do {
       // Print Coffe N Roll menu, prices in dollars and cents
      System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
      System.out.println("------------------------------------------------");
      for (int i = 1; i < 6; i++)
      System.out.printf("%4d. %-15s%10s%n", i, order[i].getName(), change.currency(order[i].getPrice()));
          PrintStream printf = System.out.printf("%4d. Done%n" + "--------------------------------------" + "%n%n", 6);
      
      do {
          // get the order number
          s1 ="Enter the item number you want to order : ";
          s2= "***only options 1 to 6 allowed";
          opt = in.getInput(s1, s2, 1, 6);   //description string,
          if(opt==6)
            break;                 // exit while loop
          
          //Get ordered quantity, getInput () handles input errors
          s1="Enter quantity ordered:";
          s2="***Quantity is a positive integer";
          sale = order[opt].salePrice(in.getInput(s1, s2, 1, 200));
          order[opt].addToTotal(sale);    // track total sales
          System.out.println("Sale price:" + change.currency(sale));
          
          //amount of tendered money, this money will come out of the cash register
          do{
              s1="Enter the amount paid in cents[0-1000000] : ";
              s2="***Amount paid is a positive integer";
              paid = in.getInput(s1, s2, 1, 1000000);   // maximum spend $10,000
              if(paid % 5 !=0)              // Australian doller smallest legal coin is 5 cents piece
                  System.out.println("***Money paid must be in multiples of 5 cents");
              if(paid<sale)     
                  System.out.println("***Not enough money paid for the purchase");
          }while (paid % 5 !=0 || paid < sale);
          paid = paid - sale;           // change in cents
          if(paid > 0)
              System.out.println("The change is: " + change.currency(paid));
          else
               System.out.println("Exact money tendered, no change required");
             System.out.println(""); 
             
             //Print to screen formatted change currency denominations
             change.denChange(paid);    //calculate currency denominations
             notes = change.getNotes();
             coins = change.getCoins();
             System.out.println("The change returned to the customer is : ");
             System.out.printf("------------------------------------------" + "%n");  //horizontal line
              for (int i =0; i<5; i++)
                  if(notes[i][0]>0)
                       System.out.printf("|Number of %3d dollar notes: %2d | %n", notes[i][1]/100, notes[i][0]);
              
              for(int i=0; i<6; i++)
                  if (coins[i][0]>0)
                      if(coins[i][1]<100)
                           System.out.printf("|Number of %3d cents coins: %2d | %n", coins[i][1],coins[i][0]);
                      else
                           System.out.printf("|Number of %3d dollar coins: %2d | %n", coins[i][1]/100,coins[i][0]);
              System.out.printf("-------------------------------------------" + "%n");      //horizontal line
              } while (opt<1 || opt>6);
      } while (opt!=6);
      for (int i = 1; i <6; i++)
          total+=order[i].getTotal();
      System.out.printf("----------------------------------------------------" +"%n");
      System.out.printf("Total %14s Sales %9s%n", "Daily", change.currency(total));
      System.out.printf("-----------------------------------------------------" + "%n");
      for(int i=1; i<6; i++)
          System.out.printf("Total %14s Sales: %9s%n", order[i].getName(),change.currency(order[i].getTotal()));
      
      
}      //end of main method
    
}     //end of class CoffeeNRoll
      
      
      




        
        
      
        
    
    
    
    

