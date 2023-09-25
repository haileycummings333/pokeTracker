package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//variables
 Button reset, submit;
 RadioGroup gender;
 Spinner levelSpin;
 EditText nationalET, nameET, speciesET, heightET, weightET, hpET, attackET, defenseET;


    //listeners
    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //set everything to default status
            nationalET.setText(R.string.ntnlDefault);
            nameET.setText(R.string.nameDefault);
            speciesET.setText(R.string.speciesDefault);
            heightET.setText(R.string.heightDefault);
            weightET.setText(R.string.weightDefault);
            hpET.setText(R.string.baseStatsDefault);
            attackET.setText(R.string.baseStatsDefault);
            defenseET.setText(R.string.baseStatsDefault);
            levelSpin.setSelection(0);
            gender.clearCheck();

        }
    };

    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Validate the input fields
            boolean isValid = true;

            // Validate National Number
            String nationalNumStr = nationalET.getText().toString();
            try {
                int nationalNum = Integer.parseInt(nationalNumStr);
                if (nationalNum < 0 || nationalNum > 1010) {
                    nationalET.setTextColor(getResources().getColor(R.color.red));
                    isValid = false;
                } else {
                    nationalET.setTextColor(getResources().getColor(R.color.black));
                }
                //make sure the input is a number
            } catch (NumberFormatException e) {
                nationalET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            }

            // Validate Name
            String name = nameET.getText().toString();
            boolean isAlphabetical = true;

            if (name.isEmpty() || name.length() < 3 || name.length() > 12) {
                isAlphabetical = false;
            } else {
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (!Character.isLetter(c)) {
                        isAlphabetical = false;
                        break;
                    }
                }
            }

            if (!isAlphabetical) {
                nameET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                nameET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Species
            String speciesStr = speciesET.getText().toString();
            if (speciesStr.isEmpty()) {
                speciesET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                nationalET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Height
            String heightStr = heightET.getText().toString();
            if (heightStr.isEmpty() || Double.parseDouble(heightStr) < 0.3 || Double.parseDouble(heightStr) > 19.99) {
                heightET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                heightET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Weight
            String weightStr = weightET.getText().toString();
            if (weightStr.isEmpty() || Double.parseDouble(weightStr) < 0.3 || Double.parseDouble(weightStr) > 19.99) {
                weightET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                weightET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate HP
            String hpStr = hpET.getText().toString();
            boolean isHpValid = false;
            try {
                int hp = Integer.parseInt(hpStr);
                if (hp >= 1 && hp <= 362) {
                    isHpValid = true;
                }
            } catch (NumberFormatException e) {
                hpET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            }

            if (!isHpValid) {
                hpET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                hpET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Attack
            String attackStr = attackET.getText().toString();
            boolean isAttackValid = false;
            try {
                int attack = Integer.parseInt(attackStr);
                if (attack >= 5 && attack <= 526) {
                    isAttackValid = true;
                }
            } catch (NumberFormatException e) {
                attackET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            }

            if (!isAttackValid) {
                attackET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                attackET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Defense
            String defenseStr = defenseET.getText().toString();
            boolean isDefenseValid = false;
            try {
                int defense = Integer.parseInt(defenseStr);
                if (defense >= 5 && defense <= 614) {
                    isDefenseValid = true;
                }
            } catch (NumberFormatException e) {
                defenseET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            }

            if (!isDefenseValid) {
                defenseET.setTextColor(getResources().getColor(R.color.red));
                isValid = false;
            } else {
                defenseET.setTextColor(getResources().getColor(R.color.black));
            }

            // Validate Level (Spinner)
            String selectedLevel = levelSpin.getSelectedItem().toString();
            if (selectedLevel.isEmpty()) {
                // You may need to adjust this validation based on Spinner's values
                isValid = false;
            }

            // Validate Gender (Radio buttons)
            int selectedGenderId = gender.getCheckedRadioButtonId();
            if (selectedGenderId == -1) {
                isValid = false;
            }

            if (isValid) {
                // All checks passed, display a success Toast
                Toast.makeText(MainActivity.this, "Information stored in the database.", Toast.LENGTH_SHORT).show();
            } else {
                // Notify the user about errors via Toast
                Toast.makeText(MainActivity.this, "Please fix the errors in red.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    AdapterView.OnItemSelectedListener spinListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };



    //ONCREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = findViewById(R.id.resetButton);
        submit = findViewById(R.id.submitButton);
        nationalET = findViewById(R.id.ntnlNumEdit);
        nameET = findViewById(R.id.nameEdit);
        speciesET = findViewById(R.id.speciesEdit);
        heightET = findViewById(R.id.heightEdit);
        weightET = findViewById(R.id.weightEdit);
        hpET = findViewById(R.id.hpEdit);
        attackET = findViewById(R.id.attackEdit);
        defenseET = findViewById(R.id.defenseEdit);
        gender = findViewById(R.id.radioGroup);

        reset.setOnClickListener(resetListener);
        submit.setOnClickListener(submitListener);
        levelSpin.setOnItemSelectedListener(spinListener);





    }



}