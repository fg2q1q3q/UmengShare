
本例主要是在umeng官方sdk的基础上进行二次封装，以方便接入AndroidStudio和调用
#  描述
功能参考umeng官方sdk，由于自己项目需要，只集成了新浪、QQ/Qzone、微信/朋友圈 三个平台的登陆和分享，demo中分享采用一键分享，当然你也可以按照官方提供的文档进行自定义分享

# 一步集成、一步调用即可轻松实现

* 集成
在project 中build.gradle下增加(已有跳过)
`allprojects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }`
在app module中增加
`dependencies {
            compile 'com.github.fg2q1q3q:DropDownMenu:1.1.1'
    }`
* 使用
只需在要使用的地方初始化ShareUtils，然后调用login/share方法即可，参考demo
* 注意
各平台参数在Application中初始化，wxapi等文件夹需要按照各平台文档放在固定位置
