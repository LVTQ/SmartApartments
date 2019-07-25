package cn.tklvyou.smartapartments.ui.main;

import cn.tklvyou.smartapartments.base.BaseContract;
import cn.tklvyou.smartapartments.widget.FrameLayout4Loading;

/**
 * 主页配置约定
 */

public interface MainContract {
    interface View extends BaseContract.BaseView{
        void loginSuccess(String msg);
        void loginError(String msg);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void login(FrameLayout4Loading frameLayout4Loading, String name, String password);
    }
}
