
本例主要是在umeng官方sdk的基础上进行二次封装，以方便接入AndroidStudio和调用
#  描述
功能参考umeng官方sdk，由于自己项目需要，只集成了新浪、QQ/Qzone、微信/朋友圈 三个平台的登陆和分享，demo中分享采用一键分享，当然你也可以按照官方提供的文档进行自定义分享

# 一步集成、一步调用即可轻松实现
1.2.0修复新浪微博登陆和分享crash问题
# 集成
在project 中build.gradle下增加(已有跳过)

    allprojects {
            repositories {
                maven { url "https://jitpack.io" }
            }
        }

在app module中build.gradle下增加

    dependencies {
            compile 'com.github.fg2q1q3q:UmengShare:1.2.0'
    }

# 使用
只需在要使用的地方初始化ShareUtils，然后调用login/share方法即可，参考demo

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
分享前请设置分享对象

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

# 注意
各平台参数在Application中初始化，wxapi等文件夹需要按照各平台文档放在固定位置
# 已知问题
 * 由于umeng demo未申请微信登录权限，所以微信登陆会提示参数错误，无视即可

# demo下载
详情可参考demo，[点此下载][1]或扫描二维码

![此处输入图片的描述][2]



  [1]: https://www.pgyer.com/fXOm
  [2]: https://o1wjx1evz.qnssl.com/app/qrcode/fXOm

# 混淆
    -dontshrink
    -dontoptimize
    -dontwarn com.google.android.maps.**
    -dontwarn android.webkit.WebView
    -dontwarn com.umeng.**
    -dontwarn com.tencent.weibo.sdk.**
    -dontwarn com.facebook.**
    -keep enum com.facebook.**
    -keepattributes Exceptions,InnerClasses,Signature
    -keepattributes *Annotation*
    -keepattributes SourceFile,LineNumberTable
    -keep public interface com.facebook.**
    -keep public interface com.tencent.**
    -keep public interface com.umeng.socialize.**
    -keep public interface com.umeng.socialize.sensor.**
    -keep public interface com.umeng.scrshot.**
    -keep public class com.umeng.socialize.* {*;}
    -keep public class javax.**
    -keep public class android.webkit.**
    -keep class com.facebook.**
    -keep class com.facebook.** { *; }
    -keep class com.umeng.scrshot.**
    -keep public class com.tencent.** {*;}
    -keep class com.umeng.socialize.sensor.**
    -keep class com.umeng.socialize.handler.**
    -keep class com.umeng.socialize.handler.*
    -keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
    -keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
    -keep class im.yixin.sdk.api.YXMessage {*;}
    -keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
    -dontwarn twitter4j.**
    -keep class twitter4j.** { *; }
    -keep class com.tencent.** {*;}
    -dontwarn com.tencent.**
    -keep public class com.umeng.soexample.R$*{
        public static final int *;
    }
    -keep public class com.umeng.soexample.R$*{
        public static final int *;
    }
    -keep class com.tencent.open.TDialog$*
    -keep class com.tencent.open.TDialog$* {*;}
    -keep class com.tencent.open.PKDialog
    -keep class com.tencent.open.PKDialog {*;}
    -keep class com.tencent.open.PKDialog$*
    -keep class com.tencent.open.PKDialog$* {*;}
    -keep class com.sina.** {*;}
    -dontwarn com.sina.**
    -keep class  com.alipay.share.sdk.** {
       *;
    }
    -keepnames class * implements android.os.Parcelable {
        public static final ** CREATOR;
    }
    -keep class com.linkedin.** { *; }
    -keepattributes Signature
