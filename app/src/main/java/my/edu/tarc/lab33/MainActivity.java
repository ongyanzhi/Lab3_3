package my.edu.tarc.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBox);
        textViewPremium = findViewById(R.id.textViewPremiun);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void reset(View view)
    {

        textViewPremium.setText("Premium : 0");
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Position: "+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void calculatePremium(View view)
    {
        int position;
        double premium = 0.0;
        position = spinner.getSelectedItemPosition();
        if(position == 0)
        {
            premium = 50;
        }else if(position == 1)
        {
            //TODO calculate the basic premium
            premium = 55;
        }
        else if(position==2)
        {
            premium = 60;
        }
        else if(position==3)
        {
            premium = 70;
        }
        else if(position==4)
        {
            premium = 120;
        }
        else if(position==5)
        {
            premium = 160;
        }
        else if(position==6)
        {
            premium = 200;
        }
        else if(position==7)
        {
            premium = 250;
        }

        int gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale)
        {
            //TODO calculate extra premium for male
            switch (position)
            {
                case 2:
                    premium+=50;
                    break;
                case 3:
                    premium+=100;
                    break;
                case 4 :
                    premium+=100;
                    break;
                case 5 :
                    premium+=50;
                    break;
            }
        }
        if(checkBoxSmoker.isChecked())
        {
            //TODO calculate extra premium smoker
            switch (position)
            {
                case 3:
                    premium+=100;
                    break;
                case 4:
                    premium+=150;
                    break;
                case 5:
                    premium+=150;
                    break;
                case 6:
                    premium+=250;
                    break;
                case 7 :
                    premium+=250;
                    break;
            }
        }
        Currency currency = Currency.getInstance(Locale.getDefault());
        String symbol = currency.getCurrencyCode();
        textViewPremium.setText("Premium :"+premium);
    }

}
