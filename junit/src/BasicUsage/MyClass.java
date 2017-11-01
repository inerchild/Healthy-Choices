package BasicUsage;

public class MyClass {
	//not static because we are calling an instance of a class like in MyClassTest
	//these are instances of a class
	
	// MyClass tester = new MyClass()
	 //assertEquals("10 x 0 must be 0", 1, tester.multiply(10, 0));  since 1 is there for all 3, then it will be true instead
	   //assertEquals("10 x 0 must be 0", 1, tester.multiply(10, 0));
	   //assertEquals("10 x 0 must be 0", 1, tester.multiply(10, 0));
	
	 public int multiply (int x, int y){
		 return x * y;
	 }
}
