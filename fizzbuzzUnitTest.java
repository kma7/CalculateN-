//Fizzbuzz class
public class FizzBuzz {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Input an integer: ");
		int n = input.nextInt();
		/*
		I tried to check whether n < 1 here like:
		if(n < 1){
		    System.out.print("Illegal input. Please input a new one: ");
		    n = input.nextInt();
		}
		but I failed how to set input as 0 from Junit test case.Could you please help me out?
		*/
		FizzBuzz myFB = new FizzBuzz();
		myFB.fizzbuzz(n);
	}
	public void fizzbuzz(int n){
		if(n < 1){
		      System.out.print("Illegal input.");
		}
		for(int i = 1; i <= n; i++){
			if(i % 15 == 0){
		      System.out.print("fizzbuzz ");
		    }else if(i % 5 == 0){
		      System.out.print("buzz ");
		    }else if(i % 3 == 0){
		      System.out.print("fizz ");
		    }else{
		    	System.out.print(i + " ");
		    }
		}
	}
}
//Test illegal input
public class TestIllegalInput {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//private final ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
	@Before
	public void setUpStream(){
		System.setOut(new PrintStream(outContent));
		//System.setIn(in);
	}
	@After
	public void cleanUpStream(){
		System.setOut(null);
		//System.setIn(null);
	}
	
	@Test
	public void test() {
		FizzBuzz myFB = new FizzBuzz();
		myFB.fizzbuzz(0);
		assertEquals("Illegal input.", outContent.toString());
	}
}
//Test normal input
public class TestNormal {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStream(){
		System.setOut(new PrintStream(outContent));
	}
	@After
	public void cleanUpStream(){
		System.setOut(null);
	}
	@Test
	public void test3() {
		FizzBuzz myFB = new FizzBuzz();
		myFB.fizzbuzz(3);
		assertEquals("1 2 fizz ", outContent.toString());
	}
	@Test
	public void test5() {
		FizzBuzz myFB = new FizzBuzz();
		myFB.fizzbuzz(5);
		assertEquals("1 2 fizz 4 buzz ", outContent.toString());
	}
	@Test
	public void test15() {
		FizzBuzz myFB = new FizzBuzz();
		myFB.fizzbuzz(15);
		assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz ", outContent.toString());
	}
}
