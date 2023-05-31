package com.example.zue.utils.task;

import android.app.Application;

import com.example.zue.MyApp;
import com.example.zue.utils.SettingSPUtils;
import com.example.zue.utils.sdkinit.XBasicLibInit;
import com.example.zue.utils.sdkinit.XUpdateInit;
import com.example.zue.widget.iconfont.XUIIconFont;
import com.mikepenz.iconics.Iconics;
import com.xuexiang.xtask.api.step.SimpleTaskStep;
import androidx.annotation.NonNull;
import com.xuexiang.xtask.core.ThreadType;
import com.xuexiang.xui.XUI;

public class MainInitTask extends SimpleTaskStep {

    private Application mApplication;

    /**
     * 构造方法
     *
     * @param application 应用上下文
     */
    public MainInitTask(Application application) {
        mApplication = application;
    }

    @Override
    public void doTask() throws Exception {
        // 初始化基础库
        XBasicLibInit.init(mApplication);
        // 初始化UI框架
        initUi();
        // XUpdate版本更新
        XUpdateInit.init(mApplication);
    }

    /**
     * 初始化UI框架
     */
    private void initUi() {
        XUI.debug(MyApp.isDebug());
        if (SettingSPUtils.getInstance().isUseCustomFont()) {
            //设置默认字体为华文行楷
            XUI.initFontStyle("fonts/hwxk.ttf");
        }
        //字体图标库
        Iconics.init(mApplication);
        //这是自己定义的图标库
        Iconics.registerFont(new XUIIconFont());
    }

    @Override
    public String getName() {
        return "MainInitTask";
    }

    @NonNull
    @Override
    public ThreadType getThreadType() {
        return ThreadType.SYNC;
    }
}
