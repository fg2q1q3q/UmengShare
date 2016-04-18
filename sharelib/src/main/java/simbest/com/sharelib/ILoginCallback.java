package simbest.com.sharelib;

import java.util.Map;

/**
 * Created by zhangxiaolong on 2016/4/14.
 */
public interface ILoginCallback {
    void onSuccess(Map<String, String> data);
    void onFaild(String msg);
    void onCancel();
}
