package ExceptionsTest;

/*
* This class prints the given message on console.
*/

public class MessageUtil {

   private String message;

   //Constructor
   //@param message to be printed
   public MessageUtil(String message){
      this.message = message; 
   }

   // prints the message
   public void printMessage(){
      System.out.println(message);
     
      int a = 0;
      int b = 1/a;
      //this makes it run false so you do not get exception
      //int b = 1/1;
   }   

   // add "Hi!" to the message
   public String salutationMessage(){
      message = "Hi!" + message;
      System.out.println(message);
      return message;
   }   
}  	