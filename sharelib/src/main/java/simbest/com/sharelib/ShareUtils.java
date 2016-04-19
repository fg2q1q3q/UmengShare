package simbest.com.sharelib;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by zhangxiaolong on 2016/4/14.
 */
public class ShareUtils {
    private UMShareAPI mShareAPI = null;
    private Activity c;
    private ILoginCallback loginCallback;
    private IShareCallback shareCallback;

    public ShareUtils(Activity context) {
        this.c = context;
        if (mShareAPI == null) {
            mShareAPI = UMShareAPI.get(context);
        }
    }

    public void login(SHARE_MEDIA platform, ILoginCallback callback) {
        this.loginCallback = callback;
        Log.d("zxl","444444444");
        mShareAPI.doOauthVerify(c, platform, umAuthListener);
    }

    public void share(ShareModel model, IShareCallback shareCallback) {
        this.shareCallback = shareCallback;
        new ShareAction(c).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)
                .withTitle(model.getTitle())
                .withText(model.getContent())
                .withMedia(model.getImageMedia())
                .setCallback(umShareListener)
                .open();
    }

    /**********
     * 内部方法
     ***********/
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Log.d("zxl","登陆授权获取成功"+data);
            if (data != null) {
                mShareAPI.getPlatformInfo(c, platform, getInfoListener);
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Log.d("zxl","000000000");
            loginCallback.onFaild("授权失败");
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Log.d("zxl","111111111");
            loginCallback.onCancel();
        }
    };
    private UMAuthListener getInfoListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Log.d("zxl","获取用户信息成功"+data);
            if (data != null) {
                loginCallback.onSuccess(data);
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Log.d("zxl","22222222");
            loginCallback.onFaild("获取用户信息失败");
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Log.d("zxl","33333333");
            loginCallback.onCancel();
        }
    };
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            shareCallback.onSuccess();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            shareCallback.onFaild();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            shareCallback.onCancel();
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
