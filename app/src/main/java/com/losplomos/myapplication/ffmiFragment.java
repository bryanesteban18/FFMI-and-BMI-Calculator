package com.losplomos.myapplication;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class ffmiFragment extends Fragment{
DataBase dbHelper;
SQLiteDatabase db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_ffmi,
                container, false);
        Button cal = (Button) rootView.findViewById(R.id.buttonCalculate);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Edit button here to do tasks
                EditText Weight = (EditText) rootView.findViewById(R.id.editTextWeightBmi);
                EditText feet = (EditText) rootView.findViewById(R.id.editTextFeetBmi);
                EditText inches = (EditText) rootView.findViewById(R.id.editTextInchesBmi);
                EditText bodyFat = (EditText) rootView.findViewById(R.id.editTextBodyFat);
                EditText LeanMass = (EditText) rootView.findViewById(R.id.editTextLeanMass);
                EditText FFMI = (EditText) rootView.findViewById(R.id.editTextFfmi);
                Double Pounds = Double.parseDouble(Weight.getText().toString());
                Double kg = Pounds / 2.2046;
                Double fat = Double.parseDouble(bodyFat.getText().toString());
                Double feetCal = Double.parseDouble(feet.getText().toString());
                Double inchesCal = Double.parseDouble(inches.getText().toString());
                Double HeightCal = (feetCal * 12.0 + inchesCal) * 0.0254;
                Double LeanMassToatal = kg * (1.0 - (fat/100.0)) * 2.2046;
                Double BeginingEquation = (((feetCal * 12.0 + inchesCal) * 0.0254) * HeightCal) * 2.20462;
                Double ffmiCal = (LeanMassToatal / 2.2)  / BeginingEquation * 2.20462;
                double ffmiCalRound = Math.round(ffmiCal);
                LeanMass.setText(LeanMassToatal.toString(), TextView.BufferType.EDITABLE);
                FFMI.setText(String.valueOf(ffmiCalRound), TextView.BufferType.EDITABLE);




            }
        });

        Button save = (Button) rootView.findViewById(R.id.buttonSaveFFMI);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Weight = (EditText) rootView.findViewById(R.id.editTextWeightBmi);
                EditText feet = (EditText) rootView.findViewById(R.id.editTextFeetBmi);
                EditText inches = (EditText) rootView.findViewById(R.id.editTextInchesBmi);
                EditText bodyFat = (EditText) rootView.findViewById(R.id.editTextBodyFat);
                EditText LeanMass = (EditText) rootView.findViewById(R.id.editTextLeanMass);
                EditText FFMI = (EditText) rootView.findViewById(R.id.editTextFfmi);
                dbHelper = new DataBase(ffmiFragment.this);
                ContentValues insertValues = new ContentValues();
                insertValues.put("Weight", Weight.getText().toString());





            }
        });




        return rootView;


    }





  }




