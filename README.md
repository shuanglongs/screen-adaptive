# screen-adaptive 
（根据“今日头条技术团队”分享的Android屏幕适配方案进行封装。）

用法很简单，记得要在Activity的setContentView方法之间调用喔。
示例如下：
1.按照设计图纸宽度 360dp ，density：3 进行适配
ScreenAdaptiveUtils.screenAdaptiveWidth(this,App.getsContext(),360);





按照设计图纸高度 640dp ，density：3 进行适配
ScreenAdaptiveUtils.screenAdaptiveHeight(this,App.getsContext(),640);
取消或者关闭屏幕适配
ScreenAdaptiveUtils.cancelAdaptive(this,App.getsContext());

使用方式有三种：
1. 直接下载项目，然后依赖项目中的 “ScreenAdaptiveUtils” Module。
2. 直接复制 “ScreenAdaptiveUtils” 类，因为这个适配方案的代码并不多，所以一个类就搞定了。
3. 在项目的 “build.gradle”文件中添加 Gradle 依赖。

