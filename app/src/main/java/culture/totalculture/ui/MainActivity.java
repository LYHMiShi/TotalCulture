package culture.totalculture.ui;

import android.view.View;
import android.widget.RadioButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import culture.totalculture.R;
import culture.totalculture.app.App;
import culture.totalculture.base.BaseActivity;
import culture.totalculture.injector.commpent.DaggerHomeComponent;
import culture.totalculture.injector.module.HomeModules;
import culture.totalculture.manager.FragmentBuilder;
import culture.totalculture.model.entity.Bean;
import culture.totalculture.presenter.HomeContract;
import culture.totalculture.presenter.HomePresenter;
import culture.totalculture.ui.chat.ChatFragment;
import culture.totalculture.ui.mine.MineFragment;
import culture.totalculture.ui.read.ReadFragment;
import culture.totalculture.ui.record.RecordFragment;
import culture.totalculture.utils.ToastUtils;

public class MainActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomePresenter presenter;
    @BindView(R.id.home_page)
    RadioButton homePage;
    @BindView(R.id.record_page)
    RadioButton recordPage;
    @BindView(R.id.chat_page)
    RadioButton chatPage;
    @BindView(R.id.mine_page)
    RadioButton minePage;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        App.context = this;

        DaggerHomeComponent
                .builder()
                .homeModules(new HomeModules(this))
                .build()
                .inject(this);


        FragmentBuilder.changeFragment(ReadFragment.class,R.id.container_frame,true,true);
    }

    @Override
    public void showMsg(String msg) {
        ToastUtils.toa(msg);
    }

    @Override
    public void showDate(Bean bean) {

    }

    @OnClick({R.id.home_page, R.id.record_page, R.id.chat_page, R.id.mine_page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_page:
                FragmentBuilder.changeFragment(ReadFragment.class,R.id.container_frame,true,true);
                break;
            case R.id.record_page:
                FragmentBuilder.changeFragment(RecordFragment.class,R.id.container_frame,true,true);
                break;
            case R.id.chat_page:
                FragmentBuilder.changeFragment(ChatFragment.class,R.id.container_frame,true,true);
                break;
            case R.id.mine_page:
                FragmentBuilder.changeFragment(MineFragment.class,R.id.container_frame,true,true);
                break;
        }
    }
}
