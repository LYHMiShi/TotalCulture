package culture.totalculture.app;


import android.app.Application;

import culture.totalculture.base.BaseActivity;

public class App extends Application{

    public static BaseActivity context;
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
