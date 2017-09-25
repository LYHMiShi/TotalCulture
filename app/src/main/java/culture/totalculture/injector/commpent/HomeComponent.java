package culture.totalculture.injector.commpent;


import culture.totalculture.injector.module.HomeModules;
import culture.totalculture.ui.MainActivity;
import dagger.Component;

@Component(modules = HomeModules.class)
public interface HomeComponent {
    void inject(MainActivity mainActivity);
}
