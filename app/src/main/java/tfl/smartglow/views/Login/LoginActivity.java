package tfl.smartglow.views.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tfl.smartglow.Constants;
import tfl.smartglow.R;
import tfl.smartglow.utils.Config;
import tfl.smartglow.utils.Utils;
import tfl.smartglow.views.LoginSignUp.LoginSignUpActivity;
import tfl.smartglow.views.welcomeHome.WelcomeHomeActivity;

public class LoginActivity extends AppCompatActivity {
Button btLogin;
EditText etEmail,etPassword;
String MY_PREFS_NAME="Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Config.getSharedInstance().applicationContext = this.getApplicationContext();
        intView();

        //finish();
    }

    private void intView(){
        this.etEmail=(EditText) findViewById(R.id.et_email);
        this.etPassword=(EditText) findViewById(R.id.et_password);
        this.btLogin=(Button)findViewById(R.id.bt_login);
        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etEmail.getText().toString().length()>2&&(etPassword.getText().toString().length()>2)){
                    methodLogin();
                    Intent i=new Intent(LoginActivity.this, WelcomeHomeActivity.class);
                    startActivity(i);
                }

                else{
                    Utils.alert("Please Enter Valid Email or Password",LoginActivity.this);
                }

            }
        });
    }

    private void methodLogin(){
        String email=this.etEmail.getText().toString().trim();
        String password=this.etPassword.getText().toString().trim();
        if(email.length()>2&&password.length()>2){
            Utils.saveValueInPref(Constants.EMAIL, email);
            Utils.saveValueInPref(Constants.PASSWORD, password);

        }

//        else{
//            Utils.alert("Please Enter Valid Email or Password",LoginActivity.this);
//        }

    }
}
