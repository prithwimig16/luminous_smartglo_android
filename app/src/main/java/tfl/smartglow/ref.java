package tfl.smartglow;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import org.jetbrains.annotations.NotNull;

import io.ghyeok.stickyswitch.widget.StickySwitch;
import io.techery.properratingbar.ProperRatingBar;
import tfl.smartglow.utils.ProgressDrawable;
import tfl.smartglow.views.colorPicker.ColorPickerActivity;
import tfl.smartglow.views.welcomeHome.WelcomeHomeActivity;

public class ref {


    ProperRatingBar ratingBar;
    ImageView imgBulb;
    int newProgress=0;
    int i=0;

//
//        this.imgBulb=(ImageView)findViewById(R.id.img_bulb_logo);
//    powerOnOff();
//        this.imgBulb.setColorFilter(Color.rgb( 255, 100, 200));
//        this.imgBulb.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent i=new Intent(WelcomeHomeActivity.this, ColorPickerActivity.class);
//            startActivity(i);
//            overridePendingTransition(R.anim.right_to_left, R.anim.stable);
//        }
//    });
//    // ratingBar=new ProperRatingBar(this,null);
//
//    //LinearLayout ll = new LinearLayout(this);
//    LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
//    //ll.setOrientation(LinearLayout.VERTICAL);
//
//    final ProgressBar pb = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
//    Drawable d = new ProgressDrawable();
//        pb.setProgressDrawable(d);
//        pb.setPadding(20, 20, 20, 0);
//        ll.addView(pb);
//
//    SeekBar.OnSeekBarChangeListener l = new SeekBar.OnSeekBarChangeListener() {
//        @Override
//        public void onStopTrackingTouch(SeekBar seekBar) {
//        }
//
//        @Override
//        public void onStartTrackingTouch(SeekBar seekBar) {
//        }
//
//        @Override
//        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//            newProgress = pb.getMax() * progress / seekBar.getMax();
//            Log.d("TAG", "onProgressChanged " + newProgress);
//            pb.setProgress(newProgress);
//            imgBulb.setColorFilter(Color.rgb( 255, 100, newProgress));
//        }
//    };
//
//    int[] maxs = {100};
//        for (int i = 0; i < maxs.length; i++) {
//        SeekBar sb = new SeekBar(this);
//        sb.setMax(maxs[i]);
//        sb.setAlpha(0.8f);
//        sb.setOnSeekBarChangeListener(l);
//        sb.setPadding(20, 0, 20, 0);
//
//        ll.addView(sb);
//    }
//
//}
//
//    private void powerOnOff(){
//        StickySwitch stickySwitch = (StickySwitch) findViewById(R.id.sticky_switch);
//        stickySwitch.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
//            @Override
//            public void onSelectedChange(@NotNull StickySwitch.Direction direction, @NotNull String text) {
//                Log.d("TAG", "Now Selected : " + direction.name() + ", Current Text : " + text);
//            }
//        });
//}
}
//    <?xml version="1.0" encoding="utf-8"?>
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:background="#f5f5f5"
//        tools:context=".views.welcomeHome.WelcomeHomeActivity">
//
//<android.support.v7.widget.Toolbar
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:id="@+id/toolbar"
//        android:padding="10dp"
//        android:background="#ffffff">
//
//<RelativeLayout
//            android:layout_width="match_parent"
//                    android:layout_height="match_parent">
//<TextView
//                android:layout_width="wrap_content"
//                        android:layout_height="wrap_content"
//                        android:id="@+id/tv_title"
//                        android:textSize="20sp"
//                        android:textColor="#6b90ff"
//                        android:text="Welcome Home" />
//
//<ImageView
//                android:layout_width="wrap_content"
//                        android:layout_height="wrap_content"
//                        android:id="@+id/img_add"
//                        android:layout_below="@+id/tv_title"
//                        android:layout_marginTop="15dp"
//                        android:src="@drawable/ic_icon_addbutton"/>
//
//<TextView
//                android:layout_width="wrap_content"
//                        android:layout_height="wrap_content"
//                        android:layout_below="@+id/tv_title"
//                        android:layout_toRightOf="@+id/img_add"
//                        android:layout_marginTop="10dp"
//                        android:textSize="14sp"
//                        android:layout_marginLeft="20dp"
//                        android:textColor="#4c84ff"
//                        android:lineSpacingExtra="6sp"
//                        android:text="Edit" />
//
//<!--<RelativeLayout-->
//<!--android:layout_width="108dp"-->
//<!--android:layout_height="54dp"-->
//<!--android:layout_alignParentRight="true"-->
//<!--android:layout_marginTop="10dp"-->
//<!--android:background="@drawable/ic_rectangle_11">-->
//
//<!--<ImageView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:layout_alignParentEnd="true"-->
//<!--android:layout_marginTop="20dp"-->
//<!--android:layout_centerVertical="true"-->
//<!--android:layout_marginEnd="30dp"-->
//<!--android:src="@drawable/power_on_bg"-->
//<!--android:layout_alignParentRight="true"-->
//<!--android:layout_marginRight="30dp" />-->
//
//<!--<ImageView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:layout_alignParentEnd="true"-->
//<!--android:layout_marginTop="20dp"-->
//<!--android:layout_centerVertical="true"-->
//<!--android:layout_marginEnd="60dp"-->
//<!--android:src="@drawable/icon_power_on"-->
//<!--android:layout_alignParentRight="true"-->
//<!--android:layout_marginRight="30dp" />-->
//<io.ghyeok.stickyswitch.widget.StickySwitch
//        android:id="@+id/sticky_switch"
//        android:layout_width="150dp"
//        android:layout_height="wrap_content"
//        android:layout_alignParentRight="true"
//        app:ss_animationDuration="200"
//        app:ss_iconPadding="18dp"
//        app:ss_iconSize="22dp"
//        app:ss_sliderBackgroundColor="#ebf1fe"
//        android:layout_centerInParent="true"
//        app:ss_leftIcon="@drawable/icon_power_on"
//        app:ss_leftText="ON"
//        app:ss_rightIcon="@drawable/icon_power_on"
//        app:ss_rightText="OFF"
//        app:ss_selectedTextSize="14sp"
//        app:ss_textSize="12sp"
//        app:ss_animationType="line"/>
//
//<!--</RelativeLayout>-->
//
//
//</RelativeLayout>
//
//</android.support.v7.widget.Toolbar>
//
//
//<!--<RelativeLayout-->
//<!--android:layout_width="match_parent"-->
//<!--android:layout_height="match_parent"-->
//<!--android:padding="20dp"-->
//<!--android:layout_below="@+id/toolbar">-->
//
//<!--<RelativeLayout-->
//<!--android:layout_width="match_parent"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:layout_marginTop="10dp"-->
//<!--android:padding="10dp"-->
//<!--android:id="@+id/relative1">-->
//
//<!--<ImageView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:id="@+id/img_progressbar_bg"-->
//<!--android:visibility="gone"-->
//<!--android:layout_centerHorizontal="true"-->
//<!--android:src="@drawable/ic_oval_5"/>-->
//
//<!--<ImageView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:id="@+id/img_progressbar"-->
//<!--android:visibility="gone"-->
//<!--android:layout_marginTop="7dp"-->
//<!--android:layout_centerHorizontal="true"-->
//<!--android:src="@drawable/ic_icon_progressbar"/>-->
//
//<!--<TextView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:id="@+id/tv_connected_bulb_number"-->
//<!--android:textSize="14sp"-->
//<!--android:layout_below="@+id/img_progressbar_bg"-->
//<!--android:layout_centerHorizontal="true"-->
//<!--android:layout_marginTop="20dp"-->
//<!--android:textColor="#a5a5a5"-->
//<!--android:lineSpacingExtra="6sp"-->
//<!--android:text="Connected to 1/1 Luminous SmartGlo’s"-->
//<!--/>-->
//<!--</RelativeLayout>-->
//
//<!--<RelativeLayout-->
//<!--android:layout_width="match_parent"-->
//<!--android:layout_height="112dp"-->
//<!--android:id="@+id/rel_"-->
//<!--android:layout_below="@+id/relative1"-->
//<!--android:layout_centerHorizontal="true"-->
//<!--android:background="#ffffff"-->
//<!--android:layout_marginTop="20dp"-->
//<!--android:padding="10dp">-->
//
//
//
//<!--<LinearLayout-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="100dp"-->
//<!--android:id="@+id/linear1"-->
//<!--android:baselineAligned="false"-->
//<!--android:gravity="center"-->
//<!--android:orientation="vertical">-->
//
//<!--<LinearLayout-->
//<!--android:layout_width="85dp"-->
//<!--android:layout_height="85dp"-->
//<!--android:gravity="center"-->
//<!--android:background="@drawable/oval"-->
//<!--android:orientation="vertical">-->
//
//<!--<ImageView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:id="@+id/img_bulb_logo"-->
//<!--android:layout_height="50dp"-->
//<!--android:layout_gravity="center"-->
//<!--android:src="@drawable/ic_icon_bulbwhite" />-->
//<!--</LinearLayout>-->
//<!--</LinearLayout>-->
//
//<!--<TextView-->
//<!--android:layout_width="wrap_content"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:id="@+id/tv_bulb_name"-->
//<!--android:textSize="18sp"-->
//<!--android:textColor="#696969"-->
//<!--android:layout_toRightOf="@+id/linear1"-->
//<!--android:layout_marginStart="10dp"-->
//<!--android:layout_centerHorizontal="true"-->
//<!--android:layout_marginTop="40dp"-->
//<!--android:lineSpacingExtra="9sp"-->
//<!--android:text="Bulb 1"-->
//<!--android:layout_marginLeft="10dp" />-->
//
//
//
//<!--&lt;!&ndash;<io.techery.properratingbar.ProperRatingBar&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_width="wrap_content"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_height="wrap_content"&ndash;&gt;-->
//<!--&lt;!&ndash;android:id="@+id/rating_bar"&ndash;&gt;-->
//<!--&lt;!&ndash;android:textSize="22sp"&ndash;&gt;-->
//<!--&lt;!&ndash;android:textStyle="bold"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_defaultRating="10"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_symbolicTick="|"&ndash;&gt;-->
//<!--&lt;!&ndash;android:gravity="center_horizontal"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_toEndOf="@+id/tv_bulb_name"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_marginTop="35dp"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_clickable="true"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_symbolicTickNormalColor="@android:color/darker_gray"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_symbolicTickSelectedColor="@android:color/holo_green_dark"&ndash;&gt;-->
//<!--&lt;!&ndash;app:prb_totalTicks="30"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_toRightOf="@+id/tv_bulb_name" />&ndash;&gt;-->
//
//<!--<LinearLayout-->
//<!--android:layout_width="match_parent"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:orientation="vertical"-->
//<!--android:layout_toEndOf="@+id/tv_bulb_name"-->
//<!--android:layout_toRightOf="@+id/tv_bulb_name"-->
//<!--android:layout_marginTop="35dp"-->
//<!--android:id="@+id/ll">-->
//
//
//<!--</LinearLayout>-->
//
//
//
//
//<!--</RelativeLayout>-->
//
//
//
//
//<!--</RelativeLayout>-->
//
//</RelativeLayout>