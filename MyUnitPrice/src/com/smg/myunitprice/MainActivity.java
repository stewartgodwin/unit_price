package com.smg.myunitprice;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

	private double TotalWeight = 1;
	private double TotalPrice = 1;
	private EditText PriceEditText;
	private EditText WeightEditText;
	private EditText CostKiloEditText;
	private EditText Cost100EditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PriceEditText = (EditText) findViewById(R.id.editTextEnterPrice);
		WeightEditText = (EditText) findViewById(R.id.editTextEnterWeight);
		CostKiloEditText = (EditText) findViewById(R.id.editTextCostPerKilo);
		Cost100EditText = (EditText) findViewById(R.id.editTextCostPer100);

		PriceEditText.addTextChangedListener(PriceEditTextWatcher);
		WeightEditText.addTextChangedListener(WeightEditTextWatcher);
	} // onCreate

	private TextWatcher PriceEditTextWatcher = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			try {
				TotalPrice = Double.parseDouble(s.toString());
			} catch (NumberFormatException e) {
				TotalPrice = 1.0;
			}
			updateResult();		
		}
		
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}
	};	
	
	private TextWatcher WeightEditTextWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			try {
				TotalWeight = Double.parseDouble(s.toString());
			} catch (NumberFormatException e) {
				TotalWeight = 1.0;
			}
			updateResult();
		}

		@Override
		public void afterTextChanged(Editable arg0) {
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
		}
	};

	private void updateResult() {
		double result = TotalPrice/TotalWeight;
		CostKiloEditText.setText(String.format("%.02f", result));
		Cost100EditText.setText(String.format("%.02f", result/10));

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
