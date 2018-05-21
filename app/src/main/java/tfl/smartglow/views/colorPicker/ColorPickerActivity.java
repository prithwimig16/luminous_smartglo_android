package tfl.smartglow.views.colorPicker;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tfl.smartglow.Constants;
import tfl.smartglow.R;

public class ColorPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.beginFakeDrag();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        ColorFragment colorFragment = new ColorFragment();
        String mac = getIntent().getStringExtra(Constants.MAC_ADDRESS);
        colorFragment.setMacAddress(mac);
        adapter.addFragment(colorFragment, "Color");
        adapter.addFragment(new WhiteFragment(), "White");
        adapter.addFragment(new ModeFragment(), "Mode");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
