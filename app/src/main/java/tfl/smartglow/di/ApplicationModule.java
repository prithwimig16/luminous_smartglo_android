package tfl.smartglow.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private App app;

    public ApplicationModule(App app){
        this.app = app;

    }



    @Provides
    public Application provideApplication(){
        return app;
    }

    @Provides
    public  App provideapp(){
        return app;
    }



}