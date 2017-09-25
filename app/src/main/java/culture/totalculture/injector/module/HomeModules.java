package culture.totalculture.injector.module;


import culture.totalculture.ui.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModules {

    MainActivity mainActivity;


    public HomeModules(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainActivity getMainActivity(){
        return mainActivity;
    }
}
