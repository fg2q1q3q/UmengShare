package com.umeng.soexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

import simbest.com.sharelib.ILoginCallback;
import simbest.com.sharelib.IShareCallback;
import simbest.com.sharelib.ShareModel;
import simbest.com.sharelib.ShareUtils;

public class MainActivity extends AppCompatActivity {
    private ShareUtils su;
    SHARE_MEDIA platform = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        su = new ShareUtils(this);
    }

    public void login(View view) {
        switch (view.getId()) {
            case R.id.qqlogin:
                platform = SHARE_MEDIA.QQ;
                break;
            case R.id.wxlogin:
                platform = SHARE_MEDIA.WEIXIN;
                break;
            case R.id.wblogin:
                platform = SHARE_MEDIA.SINA;
                break;
        }
        Log.d("zxl","555555555");
        su.login(platform, new ILoginCallback() {
            @Override
            public void onSuccess(Map<String, String> data) {
                Toast.makeText(MainActivity.this, "用户信息：" + data.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFaild(String msg) {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void share(View view) {
        ShareModel model = new ShareModel();
        model.setTitle("测试分享标题");
        model.setContent("测试分享内容");
        model.setImageMedia(new UMImage(this, R.mipmap.ic_launcher));
        su.share(model, new IShareCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFaild() {
                Toast.makeText(MainActivity.this, "分享失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "取消分享", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        su.onActivityResult(requestCode, resultCode, data);
    }

}
