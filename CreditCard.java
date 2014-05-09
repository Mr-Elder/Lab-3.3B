

import static java.lang.System.out;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CreditCard
{
    public static void main (String[] args)
    {
        final double ZERO = 0.0;
        final double FIFTY = 50.0;
        final double THREE_HUNDRED = 300.0;
        final double INTEREST_RATE = 0.02;     //Credit Card Interest Rate
        final double TWENTY_PERCENT = 0.20;
        
        String builder = "";
        
        double prevBal = 0;
        double addCharge = 0;
        double monthly_Interest = 0;
        double new_Balance = 0;
        double min_Payment = 0;
        DecimalFormat format = new DecimalFormat("0.00");
        
        prevBal = GetInfo.getDouble("Enter the previous months balance: ");
        addCharge = GetInfo.getDouble("Enter the charges for this month: ");
        
        // Compute the charges ...
        
        new_Balance = prevBal + addCharge;
        
        if(prevBal > 0){
        	monthly_Interest = new_Balance * .02;
        	new_Balance += monthly_Interest;
        }
        
        if(new_Balance > 300)
        	min_Payment = new_Balance * .20;
        else if(new_Balance >=  50 && new_Balance <= 300)
        	min_Payment = 50.0;
        else if(new_Balance < 50)
        	min_Payment = new_Balance;
       
        // Output the Credit Card Statement
        
        builder  += ("CS CARD International Statement\n");
        builder  += ("===============================\n");
        builder  += ("Previous Balance: " +  "$" + format.format(prevBal));
        builder  += ("\nAdditional Charges : " + "$" + format.format(addCharge));
        builder  += ("\nInterest : " + "$" + format.format(monthly_Interest));
        builder  += ("\n\nNew Balance : " + "$" + format.format(new_Balance));
        builder  += ("\n\nMinimum Payment : " + "$" + format.format( min_Payment));
        
        GetInfo.showMessage(builder);
        
        
    }
}
