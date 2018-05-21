package tfl.smartglow.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import tfl.smartglow.di.App;
import tfl.smartglow.di.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    protected ApplicationComponent applicationComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        applicationComponent = ((App) getApplication()).getApplicationComponent();
        intDagger();
        initPresenter();

    }

    protected abstract boolean canDisplayBackButton();
    protected abstract void initPresenter();
    protected abstract int getLayoutId();
    protected abstract void intDagger();
    protected abstract int initialize(Bundle bundle);
}
