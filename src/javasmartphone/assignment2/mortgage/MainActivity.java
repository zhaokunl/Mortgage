package javasmartphone.assignment2.mortgage;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Button   mButton;
	EditText mEdit1;
	EditText mEdit2;
	EditText mEdit3;
	EditText mEdit4;
	EditText mEdit5;
	EditText mEdit6;
	Spinner mSpinner1;
	Spinner mSpinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mButton = (Button)findViewById(R.id.button);
	    mEdit1   = (EditText)findViewById(R.id.editText1);
	    mEdit2   = (EditText)findViewById(R.id.editText2);
	    mEdit3   = (EditText)findViewById(R.id.editText3);
	    mEdit4   = (EditText)findViewById(R.id.editText4);
	    mEdit5   = (EditText)findViewById(R.id.editText5);
	    mEdit6   = (EditText)findViewById(R.id.editText6);
	    mSpinner1 = (Spinner)findViewById(R.id.spinner1);
	    mSpinner2 = (Spinner)findViewById(R.id.spinner2);
        
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    
	    mButton.setOnClickListener(
	        new View.OnClickListener()
	        {
	            public void onClick(View view)
	            {
	            	double purchasePrice = Double.parseDouble(mEdit1.getText().toString());
	            	double downPayment = Double.parseDouble(mEdit2.getText().toString());
	                int mortgageTerm = Integer.parseInt(mEdit3.getText().toString());
	            	double interestRate = Double.parseDouble(mEdit4.getText().toString());
	            	double propertyTax = Double.parseDouble(mEdit5.getText().toString());
	            	double propertyInsurance = Double.parseDouble(mEdit6.getText().toString());
                    int month = Integer.parseInt(mSpinner1.getSelectedItem().toString());
	                int year = Integer.parseInt(mSpinner2.getSelectedItem().toString());
	            	
	                int monthResult = 0;
	                int yearResult=0;
	                if (month==1) {
	            		monthResult=12;
	            		yearResult=year+mortgageTerm-1;
	            	} else {
	            		monthResult=month-1;
	            		yearResult=year+mortgageTerm;
	            	}
	                
	            	
	            	double price=purchasePrice*(1-downPayment/100);
	            	double monthlyInterest=interestRate/12/100;
	            	double Months = mortgageTerm*12;
	            	double payInterest = (price*monthlyInterest*(Math.pow(1+monthlyInterest, Months))/(Math.pow(1+monthlyInterest, Months)-1));		
	            	
	            	double originalMonthlyPay=propertyTax/12+propertyInsurance/12+payInterest;
	            	double monthlyPay = Math.round(100*(originalMonthlyPay))/100.00;
	            	double totalPay = Math.round(100*originalMonthlyPay*Months)/100.00;
	            	
	            	
	            	String m = Double.toString(monthlyPay);
	            	String t = Double.toString(totalPay);            	
	            	
	                Log.v("EditText1", mEdit1.getText().toString());
	                Log.v("EditText2", mEdit2.getText().toString());
	                Log.v("EditText3", mEdit3.getText().toString());
	                Log.v("EditText4", mEdit4.getText().toString());
	                Log.v("EditText5", mEdit5.getText().toString());
	                Log.v("EditText6", mEdit6.getText().toString());  
	                
	                Log.v("monthlyPay", m);
	                Log.v("totalPay", t);
	                Log.v("payInterest", Double.toString(payInterest));      
	                
	        	    alertDialog.setTitle("Result");
	        	    alertDialog.setMessage("Monthly Payment:  $"+m+"\nTotal Payment:  $"+t + "\nPay-Off Date:  "+ monthResult + "/" + yearResult );
	                alertDialog.show();
	                
	            }
	        });
	}

	
}
