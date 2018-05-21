package tfl.smartglow.views.LoginSignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tfl.smartglow.Constants;
import tfl.smartglow.R;
import tfl.smartglow.utils.Utils;
import tfl.smartglow.views.Login.LoginActivity;
import tfl.smartglow.views.welcomeHome.WelcomeHomeActivity;

public class LoginSignUpActivity extends AppCompatActivity {
  TextView tvAlreadyHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        String email= Utils.getValueFromPref(Constants.EMAIL);
        if (TextUtils.isEmpty(email)){
            intView();
        } else {
            Intent i=new Intent(LoginSignUpActivity.this, WelcomeHomeActivity.class);
            startActivity(i);
            finish();
        }


    }

    private void intView(){
        this.tvAlreadyHaveAccount=(TextView)findViewById(R.id.tv_already_account_tag);
        this.tvAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginSignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
