package tfl.smartglow.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import tfl.smartglow.base.Presenter;

@Singleton
@Component(modules = {ApplicationModule.class})

public interface  ApplicationComponent {

    Application application();

    App app();


    void inject(ApplicationModule applicationModule);

    void inject(Context context);

}
