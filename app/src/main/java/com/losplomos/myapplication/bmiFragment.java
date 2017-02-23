package com.losplomos.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_bmi,
                container, false);

        Button calBmi = (Button) rootView.findViewById(R.id.buttonCal);
        calBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Edit button here to do tasks
                EditText Weight = (EditText) rootView.findViewById(R.id.editTextWeightBmi);
                EditText feet = (EditText) rootView.findViewById(R.id.editTextFeetBmi);
                EditText inches = (EditText) rootView.findViewById(R.id.editTextInchesBmi);
                EditText bmi = (EditText) rootView.findViewById(R.id.editTextBmi);
                Double Pounds = Double.parseDouble(Weight.getText().toString());
                Double feetCal = Double.parseDouble(feet.getText().toString());
                Double inchesCal = Double.parseDouble((inches.getText().toString()));
                Double kg = Pounds / 2.2046;
                Double meters = ((feetCal * 12) + inchesCal) * .0254;
                Double metersSqr = meters * meters;
                double BMI = Math.round(kg / metersSqr);

                bmi.setText(String.valueOf(BMI) , TextView.BufferType.EDITABLE);


            }
        });




        return rootView;
    }
}