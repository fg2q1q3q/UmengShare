
本例主要是在umeng官方sdk的基础上进行二次封装，以方便接入AndroidStudio和调用
#  描述
功能参考umeng官方sdk，由于自己项目需要，只集成了新浪、QQ/Qzone、微信/朋友圈 三个平台的登陆和分享，demo中分享采用一键分享，当然你也可以按照官方提供的文档进行自定义分享

# 一步集成、一步调用即可轻松实现
**集成**

在project 中build.gradle下增加(已有跳过)

    allprojects {
            repositories {
                maven { url "https://jitpack.io" }
            }
        }

在app module中build.gradle下增加

    dependencies {
            compile 'com.github.fg2q1q3q:DropDownMenu:1.1.1'
    }

**使用**

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

**注意**

各平台参数在Application中初始化，wxapi等文件夹需要按照各平台文档放在固定位置
**已知问题**

目前发现一键分享中点击新浪平台会直接crash，应该是umeng的问题，尚未排查，稍后补充
