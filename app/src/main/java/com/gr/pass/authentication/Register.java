package com.gr.pass.authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gr.pass.HomeScreen;
import com.gr.pass.R;

public class Register extends AppCompatActivity {

    EditText register_name, register_mobile_no, register_password, register_confirm_password;
    Button register_button;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialization();
    }

    public void initialization(){

        register_name = (EditText)findViewById(R.id.register_name);
        register_mobile_no = (EditText)findViewById(R.id.register_mobile_no);
        register_password = (EditText)findViewById(R.id.register_password);
        register_confirm_password = (EditText)findViewById(R.id.register_confirm_password);
        register_button = (Button)findViewById(R.id.reister_button);
    }

    public void register_button_onClick(View view){

        if(register_name.getText().toString().equals("") || register_mobile_no.getText().toString().equals("") ||
                register_password.getText().toString().equals("") || register_confirm_password.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Please Provide Complete Details!!",Toast.LENGTH_SHORT).show();
        }
        else
            if(!register_password.getText().toString().equals(register_confirm_password.getText().toString())){

                Toast.makeText(getApplicationContext(), "Passwords Don't Match", Toast.LENGTH_SHORT).show();
            }

        else {

                sharedPreferences = getSharedPreferences(Login.PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Login.MOBILE_NO,register_mobile_no.getText().toString());
                editor.putString(Login.PASSWORD,register_password.getText().toString());
                editor.commit();

                Intent intent = new Intent(this,HomeScreen.class);
                intent.putExtra("mobile_no",register_mobile_no.getText());
                startActivity(intent);
                finish();
            }
    }
}
