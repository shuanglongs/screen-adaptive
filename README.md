# screen-adaptive 
## 根据“今日头条技术团队”分享的[Android屏幕适配方案](https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA)进行封装

用法很简单（记得要在Activity的setContentView方法之前调用）
示例如下：
```
//按照设计图纸宽度 360dp ，density：3 进行适配
ScreenAdaptiveUtils.screenAdaptiveWidth(this,App.getsContext(),360);

//按照设计图纸高度 640dp ，density：3 进行适配
ScreenAdaptiveUtils.screenAdaptiveHeight(this,App.getsContext(),640);

//取消或者关闭屏幕适配
ScreenAdaptiveUtils.cancelAdaptive(this,App.getsContext());
```

添加到项目方式有三种：
1. 直接下载项目，然后依赖项目中的 “ScreenAdaptiveUtils” Module。

2. 直接复制 “ScreenAdaptiveUtils” 类，因为这个适配方案的代码并不多，所以一个类就搞定了。

3. 以 Gradle 依赖的形式添加到项目中。的 “build.gradle”文件中添加 。
```
// project的 build.gradle
allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
  
//  app 的 build.gradle
dependencies {
	implementation 'com.github.shuanglongs:screen-adaptive:1.0'
}
```

备注 ：使用中如果发现有问题可以直接在 github 中提 issue，或者直接邮件我 lishuanglongl@aliyun.com ，欢迎 star ！






