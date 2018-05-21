package tfl.smartglow.di;

import android.app.Application;

public class App extends Application {


    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        setUpInjector();


    }

    private void setUpInjector(){
        applicationComponent= DaggerApplicationComponent
                .builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}