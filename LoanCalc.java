/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
	/*
 		#Feedbaack:
   		It's really bad idea to use same static variable for different calculations of different methods.
     		However if you do like this way, you should protect yourself from unexpected behaviours.
		Observe the case when `bisectionSolver` get called before this method - the `iterationCounter` will
		contain the sum of itterations of both method.
		To avoid that, you should guard your this method like you did in `bisectionSolver`
     	*/
	    	iterationCounter = 0;
	    
		double x=loan/n; //min value of x is in case the rate is 0
		double temp_loan=loan;
		while(loan>epsilon && x<=temp_loan) 
		{
			x+=epsilon;
			iterationCounter++;
			loan=temp_loan;
			loan=endBalance(loan, rate, n, x);
		}
    	return x;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
    	iterationCounter=0;
		double L=loan/n; //L is the min value of x, which is in case the rate is 0
		double H=loan-(loan/n);
		double x=(L+H)/2.0;

		while((H-L)>epsilon)
		{
			iterationCounter++;
			if(((endBalance(loan, rate, n, x))*endBalance(loan, rate, n, L))>0)
			{
				L=x;
			}
			else
			{
				H=x;
			}
			x=(L+H)/2.0;
		}

		return x;
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
		for(int i=0;i<n;i++)
			{
					loan=(loan-payment)*((rate/100)+1);
			}
		
    	return loan;
	}
}
