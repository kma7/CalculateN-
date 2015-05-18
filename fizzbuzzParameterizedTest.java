public class FizzBuzz {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Input an integer: ");
		int n = input.nextInt();
		FizzBuzz myFB = new FizzBuzz();
		System.out.println(myFB.fizzbuzz(n));
	}

	public String fizzbuzz(int n){
		if(n < 1){
			System.out.print("Illegal input.");
		}
		if(n % 15 == 0){
	      return "fizzbuzz";
	    }else if(n % 5 == 0){
	      return "buzz";
	    }else if(n % 3 == 0){
	      return "fizz";
	    }else{
	    	return String.valueOf(n);
	    }
	}
}
//Parameterized Test
@RunWith(Parameterized.class)
public class NewTest {
	private int inputNumber;
	private String expectedResult;
	private FizzBuzz myFizzBuzz;
	@Before
	public void initialize(){
		myFizzBuzz = new FizzBuzz();
	}
	public NewTest(int inputNumber, String expectedResult){
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> fb(){
		return Arrays.asList(new Object[][]{
				{1, "1"},
				{3, "fizz"},
				{5, "buzz"},
				{15, "fizzbuzz"}
		});
	}
	@Test
	public void testFizzbuzz() {
		System.out.println("Parameterized number is: " + inputNumber);
		assertEquals(expectedResult, myFizzBuzz.fizzbuzz(inputNumber));
	}

}
