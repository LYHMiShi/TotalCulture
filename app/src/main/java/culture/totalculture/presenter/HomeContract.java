package culture.totalculture.presenter;


import culture.totalculture.base.BasePresenter;
import culture.totalculture.base.BaseView;
import culture.totalculture.model.entity.Bean;

public interface HomeContract {
    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView<Presenter>{
        void showDate(Bean bean);
    }
}
