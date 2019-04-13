package com.example.taxcalculation_nabin;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText etSalary;
    private TextView tvTotalTax, tvTotalSalary;
    private Button btnCalculation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSalary = findViewById(R.id.etSalary);
        tvTotalSalary = findViewById(R.id.tvTotalSalary);
        tvTotalTax = findViewById(R.id.tvTotalTax);
        btnCalculation = findViewById(R.id.btnCalculate);
        btnCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation() == true) {
                    float salary;
                    salary = Float.parseFloat(etSalary.getText().toString());
                    TaxCalculate tax = new TaxCalculate(salary);
                    tvTotalSalary.setText(Float.toString(tax.getTotalSalary()));
                    tvTotalTax.setText(Float.toString(tax.calculateTax()));
                }
            }
        });
    }
    public Boolean Validation() {
        if (TextUtils.isEmpty(etSalary.getText())) {
            etSalary.requestFocus();
            etSalary.setError("Please Enter Salary");
            return false;
        }
        return true;
    }
}

