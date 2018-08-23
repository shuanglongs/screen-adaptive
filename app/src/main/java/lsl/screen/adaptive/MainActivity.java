package lsl.screen.adaptive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //按照设计图纸宽度 360dp ，density：3 进行适配
        ScreenAdaptiveUtils.screenAdaptiveWidth(this,App.getsContext(),360);
        //按照设计图纸高度 640dp ，density：3 进行适配
//        ScreenAdaptiveUtils.screenAdaptiveHeight(this,App.getsContext(),640);
        //取消或者关闭屏幕适配
//        ScreenAdaptiveUtils.cancelAdaptive(this,App.getsContext());

        setContentView(R.layout.activity_main);
    }
}
