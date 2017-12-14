package com.hisoft.ovi.phoneverification.phoneVerify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hisoft.ovi.phoneverification.R;
import com.hisoft.ovi.phoneverification.baseActivity.MosqueBaseActivity;
import com.hisoft.ovi.phoneverification.model.UserDetails;
import com.hisoft.ovi.phoneverification.service.DTOBase;
import com.hisoft.ovi.phoneverification.service.IServiceResultListener;
import com.hisoft.ovi.phoneverification.utility.AppManager;

public class UserDetailsActivity extends MosqueBaseActivity implements IServiceResultListener {
    Button submitBtn;
    EditText firstNameEditText,lastNameEditText,emailEditText;
    private String mobile;
    private String countryCode;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        firstNameEditText=  findViewById(R.id.firstNameEditText);
        lastNameEditText=  findViewById(R.id.lastNameEditText);
        emailEditText=  findViewById(R.id.emailEditText);
        submitBtn=findViewById(R.id.submit);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            mobile=bundle.getString("mobile");
            countryCode=bundle.getString("countryCode");
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

    private void saveData() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        Boolean done= true;

        if(TextUtils.isEmpty(firstName)){
            firstNameEditText.setError("First name is required");
            done=false;
        }else if(TextUtils.isEmpty(email)){
            emailEditText.setError("Email Address is Empty");
            done=false;
        }

        if(done){
            if(AppManager.hasInternetConnection(context)){
                UserDetails userDetails = new UserDetails();
                userDetails.setUser_unique_id(mobile);
                userDetails.setCountry_code(countryCode);
                userDetails.setFirst_name(firstName);
                userDetails.setLast_name(lastName);
                userDetails.setEmail(email);
                userDetails.setSelector(preferences.getValue("selector"));
                userDetails.setValidator(preferences.getValue("validator"));
                service.setUserDetails(userDetails);
            }else{
                Toast.makeText(context,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void OnServiceResult(String method, DTOBase dtoBase, boolean success) {
        if(success){
            if(method.equals("USER_DETAILS")){
                UserDetails userDetails = (UserDetails) dtoBase;
                if(userDetails.getStstus().equals("200")){
                    intent = new Intent(context,HomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else if(userDetails.getStstus().equals("404")){
                    customAlertDialog.showDialog(userDetails.getMsg());
                }
            }
        }
    }
}
