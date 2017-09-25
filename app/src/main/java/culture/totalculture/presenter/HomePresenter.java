package culture.totalculture.presenter;


import javax.inject.Inject;

import culture.totalculture.model.entity.Bean;
import culture.totalculture.net.RetrofitService;
import culture.totalculture.ui.MainActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter{

    MainActivity activity;

    @Inject
    public HomePresenter(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    @Override
    public void start() {
        RetrofitService.create()
                .getBeanDate()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Bean bean) {
                        activity.showDate(bean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
