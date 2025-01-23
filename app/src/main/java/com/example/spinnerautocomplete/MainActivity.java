package com.example.spinnerautocomplete;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> cityList;
    Button btnSubmit;
    AutoCompleteTextView autoCompleteTextView;

    RadioButton radioButtonMale,radioButtonFemale;
    RadioGroup radioGroupGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        btnSubmit=findViewById(R.id.btnSubmit);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);

        radioButtonFemale=findViewById(R.id.radioButtonFemale);
        radioButtonMale=findViewById(R.id.radioButtonMale);
        radioGroupGender=findViewById(R.id.radioGroupGender);
        cityList=new ArrayList<>();
        cityList.add("--Select City --");
        cityList.add("Nashik");
        cityList.add("Pune");
        cityList.add("Mumbai");
        cityList.add("Nagpur");
        cityList.add("Delhi");

        String[] names=new String[]{"AAAAA","AAAAA","AAAAA","AAAAA","AAAAA","AAAAA","AAAAA"};

        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.cities));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cityList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               if(parent.getSelectedItemPosition()>0)
               {
                   Toast.makeText(MainActivity.this, "Selected : "+cityList.get(position).toString(), Toast.LENGTH_SHORT).show();
                   //Toast.makeText(MainActivity.this, ""+names[position], Toast.LENGTH_SHORT).show();

                   //Toast.makeText(MainActivity.this, ""+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
               }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(2);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoCompleteTextView.showDropDown();
            }
        });

        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, ""+adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d("mytag",""+radioGroupGender.getCheckedRadioButtonId());

                if(radioGroupGender.getCheckedRadioButtonId()>0)
                {

                }else{
                    Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
                }

               if(autoCompleteTextView.enoughToFilter())
               {
                   Toast.makeText(MainActivity.this, ""+autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
               }else{

                   Toast.makeText(MainActivity.this, "Select From AutoComplete", Toast.LENGTH_SHORT).show();
               }

                if(spinner.getSelectedItemPosition()>0)
                {

                }else{
                    Toast.makeText(MainActivity.this, "Please Select City", Toast.LENGTH_SHORT).show();
                }
            }
        });


        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroup.getCheckedRadioButtonId();
                if(id==R.id.radioButtonMale)
                {
                    Toast.makeText(MainActivity.this, ""+radioButtonMale.getText().toString(), Toast.LENGTH_SHORT).show();
                }else if(id==R.id.radioButtonFemale){

                    Toast.makeText(MainActivity.this, ""+radioButtonFemale.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}