package tfl.smartglow.views.SliderPage;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import it.xabaras.android.viewpagerindicator.widget.ViewPagerIndicator;
import tfl.smartglow.R;
import tfl.smartglow.model.DataObject;
import tfl.smartglow.views.Login.LoginActivity;
import tfl.smartglow.views.LoginSignUp.LoginSignUpActivity;
import tfl.smartglow.views.welcomeHome.WelcomeHomeActivity;

public class SliderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_slider);
        List<DataObject> getData = dataSource();
        ViewPager mViewPager = (ViewPager) findViewById(R.id.signup_viewPageAndroid);


        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(this, getData);
        mViewPager.setAdapter(mCustomPagerAdapter);

        ViewPagerIndicator viewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        final Button button = (Button) findViewById(R.id.btn_skip_or_continue);
        viewPagerIndicator.initWithViewPager(mViewPager);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    button.setBackground(ContextCompat.getDrawable(SliderActivity.this, R.drawable.skip_button));
                } else if (position == 1) {
                    button.setBackground(ContextCompat.getDrawable(SliderActivity.this, R.drawable.skip_button));
                } else if (position == 2) {
                    button.setBackground(ContextCompat.getDrawable(SliderActivity.this, R.drawable.skip_button));
                } else if (position == 3) {
                    button.setBackground(ContextCompat.getDrawable(SliderActivity.this, R.drawable.bt_continue));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(SliderActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private List<DataObject> dataSource() {
        List<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(R.drawable.slide1, "Pop colours", getString(R.string.intro_desc)));
        data.add(new DataObject(R.drawable.slide2, "Automate your lights", getString(R.string.intro_desc)));
        data.add(new DataObject(R.drawable.slide3, "Change your scenario", getString(R.string.intro_desc)));
        data.add(new DataObject(R.drawable.slide4, "Dance with lights", getString(R.string.intro_desc)));
        return data;
    }
}
