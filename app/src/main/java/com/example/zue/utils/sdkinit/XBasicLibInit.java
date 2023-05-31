package com.example.zue.utils.sdkinit;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.zue.MyApp;
import com.example.zue.R;
import com.example.zue.utils.SettingSPUtils;
import com.example.zue.utils.TokenUtils;
import com.fanjun.keeplive.KeepLive;
import com.fanjun.keeplive.config.ForegroundNotification;
import com.fanjun.keeplive.config.ForegroundNotificationClickListener;
import com.fanjun.keeplive.config.KeepLiveService;
import com.xuexiang.xhttp2.XHttpSDK;
//import com.xuexiang.xormlite.XUIDataBaseRepository;
import com.xuexiang.xpage.PageConfig;
import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xrouter.launcher.XRouter;
import com.xuexiang.xutil.XUtil;

public class XBasicLibInit {

    private XBasicLibInit() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化基础库
     */
    public static void init(Application application) {
        initKeeplive(application);
        initUtils(application);
        initPage(application);
        initRouter(application);
        initAOP(application);
        initDB(application);
        initHttp(application);
    }

    private static  void initKeeplive(Application application){
        //定义前台服务的默认样式。即标题、描述和图标
        ForegroundNotification foregroundNotification = new ForegroundNotification("测试","描述", R.mipmap.ic_launcher,
                //定义前台服务的通知点击事件
                new ForegroundNotificationClickListener() {
                    @Override
                    public void foregroundNotificationClick(Context context, Intent intent) {
                    }
                });
        //启动保活服务
        KeepLive.startWork(application, KeepLive.RunMode.ENERGY, foregroundNotification,
                //你需要保活的服务，如socket连接、定时任务等，建议不用匿名内部类的方式在这里写
                new KeepLiveService() {
                    /**
                     * 运行中
                     * 由于服务可能会多次自动启动，该方法可能重复调用
                     */
                    @Override
                    public void onWorking() {

                    }
                    /**
                     * 服务终止
                     * 由于服务可能会被多次终止，该方法可能重复调用，需同onWorking配套使用，如注册和注销broadcast
                     */
                    @Override
                    public void onStop() {

                    }
                }
        );
    }
    /**
     * 初始化工具类
     *
     * @param application 应用上下文
     */
    private static void initUtils(Application application) {
        XUtil.init(application);
        XUtil.debug(MyApp.isDebug());
        TokenUtils.init(application);
    }


    /**
     * 初始化XPage页面框架
     *
     * @param application
     */
    private static void initPage(Application application) {
        PageConfig.getInstance()
//                //页面注册,默认不设置的话使用的就是自动注册
//                .setPageConfiguration(new AutoPageConfiguration())
                //开启调试
                .debug(MyApp.isDebug())
                //设置默认的容器Activity
                .setContainActivityClazz(XPageActivity.class)
                //初始化页面配置
                .init(application);
    }

    /**
     * 初始化XAOP切片框架
     *
     * @param application
     */
    private static void initAOP(Application application) {
//        初始化插件
//        XAOP.init(application);
//        //日志打印切片开启
//        XAOP.debug(MyApp.isDebug());
//        //设置动态申请权限切片 申请权限被拒绝的事件响应监听
//        XAOP.setOnPermissionDeniedListener(permissionsDenied -> XToastUtils.error("权限申请被拒绝:" + StringUtils.listToString(permissionsDenied, ",")));
    }

    /**
     * 初始化XRouter路由
     *
     * @param application
     */
    private static void initRouter(Application application) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (MyApp.isDebug()) {
            XRouter.openLog();     // 打印日志
            XRouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        XRouter.init(application);
    }

    /**
     * 初始化数据库框架
     *
     * @param application
     */
    private static void initDB(Application application) {
//        XUIDataBaseRepository.getInstance()
//                //设置内部存储的数据库实现接口
//                .setIDatabase(new InternalDataBase())
//                .init(application);
//        DBLog.debug(MyApp.isDebug());
    }

    private static void initHttp(Application application) {
        XHttpSDK.init(application);   //初始化网络请求框架，必须首先执行
        XHttpSDK.debug("XHttp");  //需要调试的时候执行
        XHttpSDK.setBaseUrl(SettingSPUtils.getInstance().getApiURL());  //设置网络请求的基础地址
//
//        XHttp.get("/hap/ass")
//                .syncRequest(false) //异步请求
//                .onMainThread(true) //回到主线程
//                .execute(new SimpleCallBack<List<User>>() {
//                    @Override
//                    public void onSuccess(List<User> response) {
//                        for (User f : response) {
//                            System.out.println(f.bb);
//                        }
//                    }
//
//                    @Override
//                    public void onError(ApiException e) {
//                    }
//
//                });
//        Request request = new Request.Builder()
//                .url("ws://192.168.31.208:8877/hap/bans/A")
//                .build();
//        OkHttpClient client = new OkHttpClient();
//        WebSocket ws = client.newWebSocket(request, new WebSocketListener() {
//            @Override
//            public void onOpen(WebSocket webSocket, Response response) {
//                // WebSocket 连接已经打开
//                System.out.println("连接已经打开");
//                JSONObject j = new JSONObject();
//                try {
//                    j.put("act","kec");
//                    j.put("data","wfff");
//                    webSocket.send(j.toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onMessage(WebSocket webSocket, String text) {
//                // 接收到文本消息
//            }
//
//            @Override
//            public void onMessage(WebSocket webSocket, ByteString bytes) {
//                // 接收到二进制消息
//            }
//
//            @Override
//            public void onClosing(WebSocket webSocket, int code, String reason) {
//                // WebSocket 连接正在关闭
//            }
//
//            @Override
//            public void onClosed(WebSocket webSocket, int code, String reason) {
//                // WebSocket 连接已经关闭
//            }
//
//            @Override
//            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
//                // WebSocket 连接失败
//            }
//        });
    }

}
