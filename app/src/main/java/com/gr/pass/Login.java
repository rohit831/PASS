package com.gr.pass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_mobile_no, login_password;
    Button login_button;
    TextView register_here;

    public static String PREFS = "Customer Preferences";
    public static String MOBILE_NO = "Mobile No";
    public static String PASSWORD = "Password";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();

        if(!(sharedPreferences.getString(MOBILE_NO,"").equals("") && sharedPreferences.getString(PASSWORD,"").equals(""))){

            Intent intent = new Intent(this,HomeScreen.class);
            intent.putExtra("mobile_no",sharedPreferences.getString(MOBILE_NO,""));
            startActivity(intent);
            finish();
        }
    }

    public void initialization(){

        login_mobile_no = (EditText)findViewById(R.id.login_mobile_no);
        login_password = (EditText)findViewById(R.id.login_password);
        login_button = (Button)findViewById(R.id.login_button);
        register_here = (TextView)findViewById(R.id.register_here);

        sharedPreferences = getSharedPreferences(PREFS,MODE_PRIVATE);
    }

    public void login_button_onClick(View view){

        if(login_mobile_no.getText().toString().equals("") || login_password.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Invalid User Credentials!!",Toast.LENGTH_SHORT).show();
        else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(MOBILE_NO,login_mobile_no.getText().toString());
            editor.putString(PASSWORD,login_password.getText().toString());
            editor.commit();

            Intent intent = new Intent(this,HomeScreen.class);
            intent.putExtra("mobile_no",login_mobile_no.getText());
            startActivity(intent);
            finish();
        }
    }
}
