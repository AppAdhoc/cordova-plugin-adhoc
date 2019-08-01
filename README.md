# cordova-plugin-adhoc

吆喝科技官方支持的 PhoneGap/Cordova 插件（Android &amp; iOS）。

[![tag](https://img.shields.io/badge/tag-0.0.1-blue.svg)](https://github.com/AppAdhoc/cordova-plugin-adhoc)

## 安装

```
cordova plugin add cordova-plugin-adhoc
```

## 配置

### iOS SDK 初始化

找到 AppDelegate.m 文件， 引用头文件：

```
#import <AdhocSDKLite/AdhocSDK.h>
```

在 @selector(application:didFinishLaunchingWithOptions:) 中：

```
AdhocSDKConfig *config = [AdhocSDKConfig defaultConfig];
config.appKey = @"ADHOC_XXX";
[AdhocSDK startWithConfigure:config options:launchOptions];
```

### Android SDK 初始化

通过在工程 build.gradle 配置脚本中添加 maven 线上依赖，导入最新版本 SDK。在 Gradle 依赖中添加：

```

dependencies {    
  implementation 'com.appadhoc:abtest-lite:5.1.2'
}
```
在 Application 的 onCreate 方法中初始化原生 SDK

```
AdhocConfig adhocConfig = new AdhocConfig.Builder()
        //设置App上下文(必要参数)
        .context(this)
        //设置Appkey(必要参数)
        .appKey("ADHOC_XXX")
        //全部配置参考官网
        .build();

AdhocTracker.init(adhocConfig);
```
## API

可直接参考 [AdhocSDK.js](https://github.com/AppAdhoc/cordova-plugin-adhoc/blob/master/www/AdhocSDK.js) 文件。

## 参考

[iOS AdhocSDK 集成文档](http://help.appadhoc.com/zh/sdk/iosSDK.html)  

[Android AdhocSDK 集成文档](http://help.appadhoc.com/zh/sdk/androidSDK.html)
