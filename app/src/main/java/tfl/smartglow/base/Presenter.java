package tfl.smartglow.base;

public interface Presenter <T extends Presenter.View>  {

    void OnCreate();
    void Onstart();
    void OnStop();
    void OnResume();
    void OnPause();
    void attachView(T View);
    interface View{ }
}
