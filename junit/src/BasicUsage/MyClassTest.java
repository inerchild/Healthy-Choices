package BasicUsage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyClassTest {
	
   String message = "Hello World";	
   MessageUtil messageUtil = new MessageUtil(message);


   
	   MyClass tester = new MyClass();
	   
	   
	   public void testPrintMessage()
	   {
	      //message = "New World"; //when run this added line as run( as java)and select test runner,should get false result
      assertEquals(message,messageUtil.printMessage());
	   
	  
      
   }
}