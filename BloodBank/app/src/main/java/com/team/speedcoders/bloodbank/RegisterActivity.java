package com.team.speedcoders.bloodbank;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends MyActivityForConnection implements View.OnClickListener {

    EditText userName,  email, phone, password, confirmPassword;
    AutoCompleteTextView bloodGroup,division, destrict, upozila;
    String userNameString, divisionString, bloodGroupString, emailString, phoneString, destrictString, upozilaString, passwordString, confirmPasswordString;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initiateAll();

    }

    private void getStrings() {
        userNameString = userName.getText().toString();
        bloodGroupString = bloodGroup.getText().toString();
        emailString = email.getText().toString();
        phoneString = phone.getText().toString();
        destrictString = destrict.getText().toString();
        upozilaString = upozila.getText().toString();
        passwordString = password.getText().toString();
        divisionString = division.getText().toString();
        confirmPasswordString = confirmPassword.getText().toString();
        upozilaString=upozilaString.replace("Cox's","Coxs");
        destrictString=destrictString.replace("Cox's","Coxs");
    }

    private void initiateAll() {
        userName = (EditText) findViewById(R.id.userName);
        bloodGroup = (AutoCompleteTextView) findViewById(R.id.bloodGroup);
        phone = (EditText) findViewById(R.id.phoneNumber);
        email = (EditText) findViewById(R.id.emailAddress);
        division = (AutoCompleteTextView) findViewById(R.id.division);
        destrict = (AutoCompleteTextView) findViewById(R.id.destrict);
        upozila = (AutoCompleteTextView) findViewById(R.id.upozila);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        registerButton = (Button) findViewById(R.id.registerMe);
        bloodGroup.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.bgroups,
                R.layout.auto_complete_view));
        division.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.divisions,
                R.layout.auto_complete_view));
        division.setOnItemClickListener(new AutoCompleteTextViewListener(division, destrict, getApplicationContext()));
        destrict.setOnItemClickListener(new AutoCompleteTextViewListener(destrict, upozila, getApplicationContext()));
        upozila.setOnItemClickListener(new AutoCompleteTextViewListener(upozila, null, getApplicationContext()));
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getStrings();
        if(checkIfEmpty()){
            Toast.makeText(getApplicationContext(), "Each Field Must Be Filled", Toast.LENGTH_LONG).show();
        }
        else if (passwordString.length() < 6) {
            Toast.makeText(getApplicationContext(), "Passwords must contain at least 6 character", Toast.LENGTH_LONG).show();
        }
        else if (passwordString.equals(confirmPasswordString)) {
            String data = codedData("username", userNameString) + "&" + codedData("bloodgroup", bloodGroupString) +
                    "&" + codedData("email", emailString) + "&" + codedData("phone", phoneString) + "&" +
                    codedData("district", destrictString) + "&" + codedData("division", divisionString) +
                    "&" + codedData("upazila", upozilaString) + "&" + codedData("password", passwordString);
            String regLink = getString(R.string.regLink);
            ServerConnectionActivity insertData = new ServerConnectionActivity(getApplicationContext(), this, regLink);
            insertData.execute(data);
        } else {
            Toast.makeText(getApplicationContext(), "Passwords didn't matched", Toast.LENGTH_LONG).show();
            confirmPassword.setText("");
            confirmPasswordString = "";
        }
    }

    private boolean checkIfEmpty() {
        return (userNameString.isEmpty() || phoneString.isEmpty() || bloodGroupString.isEmpty() ||
                emailString.isEmpty() || divisionString.isEmpty() || destrictString.isEmpty() ||
                userNameString.isEmpty());
    }

    @Override
    public void doTheTask(String... s) {
        finish();
    }
}
