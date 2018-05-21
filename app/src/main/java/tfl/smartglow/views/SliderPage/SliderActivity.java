package tfl.smartglow.views.SliderPage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import it.xabaras.android.viewpagerindicator.widget.ViewPagerIndicator;
import tfl.smartglow.R;
import tfl.smartglow.views.LoginSignUp.LoginSignUpActivity;

public class SliderActivity extends AppCompatActivity {
TextView tvBoldText;
ImageView imgContinue;
//boolean isContinue=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_slider);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.signup_viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        ViewPagerIndicator viewPagerIndicator=(ViewPagerIndicator)findViewById(R.id.indicator);
        viewPagerIndicator.initWithViewPager(mViewPager);
        tvBoldText=(TextView)findViewById(R.id.tv_pop_color);
        imgContinue=(ImageView)findViewById(R.id.img_continue);
        imgContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(SliderActivity.this, LoginSignUpActivity.class));
                    finish();

            }
        });


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                     if(position==0){
                       tvBoldText.setText("Pop colours");
                         imgContinue.setImageResource(R.drawable.skip_button);

                     }
                     else if(position==1){
                         tvBoldText.setText("Automate your lights");
                         imgContinue.setImageResource(R.drawable.skip_button);

                     }
                     else if(position==2){
                         tvBoldText.setText("Change your scenario");
                         imgContinue.setImageResource(R.drawable.skip_button);

                     }
                     else if(position==3){
                         tvBoldText.setText("Dance with lights");
                         imgContinue.setImageResource(R.drawable.bt_continue);

                     }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
