package com.hsiung.androidlearn.ui.statusbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.hsiung.androidlearn.R;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);

        // SystemUI
        // 在Android2.3以前，对StatusBar的操作有两个：StatusBar的显示与隐藏、Activiy内容延伸到StatusBar下方（全局布局）
        // 全屏布局且隐藏状态栏：
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 全屏布局，不隐藏状态栏：
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        /*
         * 在Android3.0中，View添加了一个重要的方法：setSystemUiVisibility(int)，用于控制一些窗口装饰元素的显示，
         * 并添加了View.STATUS_BAR_VISIBLE和View.STATUS_BAR_HIDDEN两个Flag用于控制Status Bar的显示与隐藏。

         * 在Android4.0中，View.STATUS_BAR_VISIBLE改为View.SYSTEM_UI_FLAG_VISIBLE，
         * View.STATUS_BAR_HIDDEN更名为View.SYSTEM_UI_FLAG_LOW_PROFILE。
         * 由于引进了NavigationBar，因此也添加了一个flag:SYSTEM_UI_FLAG_HIDE_NAVIGATION

         * View.SYSTEM_UI_FLAG_LOW_PROFILE: 同时影响StatusBar和NavigationBar,但并不会使得SystemUI消失，而只会使得背景很浅，并且去掉SystemUI的一些图标或文字。
         * View.SYSTEM_UI_FLAG_HIDE_NAVIGATION: 会隐藏NavigationBar,但是由于NavigationBar是非常重要的，因此只要有用户交互，系统就会清除这个flag使NavigationBar就会再次出现。

         * 在Android4.1中，又引入了以下几个flag:
         * View.SYSTEM_UI_FLAG_FULLSCREEN: 这个标志与WindowManager.LayoutParams.FLAG_FULLSCREEN作用相同，但是如果你从屏幕下滑或者一些其它操作，会使得StatusBar重新显示。
         * View.SYSTEM_UI_FLAG_LAYOUT_STABLE: 与其它flag配合使用，防止系统栏隐藏时内容区域发生变化。
         * View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN: Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住
         * View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION: 使内容布局到NavigationBar之下，可以配合SYSTEM_UI_FLAG_HIDE_NAVIGATION使用防止跳动

         * 在Android4.4(API 19)又增加了两个flag：
         * View.SYSTEM_UI_FLAG_IMMERSIVE
         * View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
         * 这两个flag主要是对SYSTEM_UI_FLAG_FULLSCREEN和SYSTEM_UI_FLAG_HIDE_NAVIGATION的修补。前文已经说过，在使用这两个flag后，用户的某些行为会使得系统强制清除这些flag。
         * 这并不是用户想要的，因此配合View.SYSTEM_UI_FLAG_IMMERSIVE和View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY就可以阻止系统的强制清除行为。

         * View.SYSTEM_UI_FLAG_IMMERSIVE只作用与SYSTEM_UI_FLAG_FULLSCREEN，而View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY同时作用于两个
         * */

        // 综上，我们可以给出全屏布局和隐藏状态栏的新方案
        //仅仅只是全屏布局：
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

//        全屏布局并且隐藏状态栏与导航栏
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        /*
         * 在Android4.4还为WindowManager.LayoutParams添加了两个flag:
         * FLAG_TRANSLUCENT_STATUS： 当使用这个flag时SYSTEM_UI_FLAG_LAYOUT_STABLE和SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN会被自动添加
         * FLAG_TRANSLUCENT_NAVIGATION：当使用这这个个flag时SYSTEM_UI_FLAG_LAYOUT_STABLE和SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION会被自动添加。
         * */


        /*
        * StatusBar颜色更改
        * StatusBar的颜色更改分为两部分,一个是背景颜色的修改，一个是字体颜色的修改。
        * 首先先说说背景颜色的修改，在Android 5.0之前，状态栏颜色并不可定制，5.0之后才可定制。首先，我们可以在主题里通过colorPrimaryDark来指定背景色，
        * 其次，我们可以调用 window.setStatusBarColor(@ColorInt int color) 来修改状态栏颜色，但是让这个方法生效有一个前提条件：
        * 你必须给window添加FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS并且取消FLAG_TRANSLUCENT_STATUS
        * 此外，设置FLAG_TRANSLUCENT_STATUS也会影响到StatusBar的背景色，但并没有固定的表现：
        * 对于6.0以上的机型，设置此flag会使得StatusBar完全透明
        * 对于5.x的机型，大部分是使背景色半透明，小米和魅族以及其它少数机型会全透明
        * 对于4.4的机型，小米和魅族是透明色，而其它系统上就只是黑色到透明色的渐变。
        * 我们知道了改背景色后，我们再来看看字体和图标颜色的更改。默认字体和图标是白色，如果在浅色背景上就会看不到状态栏信息了，因此体验会很糟糕。但可惜的是android6.0才官方支持更改字体和图标的颜色。
        * 在Android6以后，我们只要给SystemUI加上SYSTEM_UI_FLAG_LIGHT_STATUS_BAR这个flag，就可以让字体和图标变为黑色。虽然官方已经支持了，但国内有些机型的版本号确实是6.0，但并不能更改字体和图标颜色，例如联想的ZUK Z1机型
        * 当然，国内的魅族和小米走在前沿，从Android4.4开始就已经更改字体和图标颜色了，但并没有直接的接口用，必须通过反射的方式去更改字体颜色
        */



        /*
        * fitSystemWindows
        * 我们首先探讨了内容布局是否全屏以及状态栏的显示与隐藏，其次我们探讨了状态栏颜色的修改问题。那如果我们全屏布局并且显示透明状态栏的时候会怎样？
        * 状态栏与内容会重叠。这既是我们想要的效果，也是我们不想要的内容。如果APP顶部时高斯模糊的图片，与状态栏重叠是设计师希望看到的效果；
        * 但是，如果ActionBar和状态栏重叠了，那可就不好看了。 所以重叠与不重叠完全看业务，而库的封装者则需要告诉业务方，如何才能不重叠。
        *
        * 这个时候就是fitSystemWindows出场的时候了。
        *
        * 我们可以给view设置fitSystemWindows属性，其是一个bool值。其既可以在xml里直接设置android:fitsSystemWindows="true",
        * 也可以通过View#setFitsSystemWindows(boolean fitSystemWindows)在java代码中设置。不过这一步也仅仅只是设置了一个flag。
        *
        * Android系统组件例如状态栏、NavBar、键盘所占据的空间称为界面的WindowInsets,Android系统会在特定的时机从根View派发WindowInsets，
        * 如果View的fitSystemWindows标志位被设为true的话，WindowInsets会传递给下列几个方法：
        *
        * 1、fitSystemWindows(Rect insets): 这个是老版本提供的接口，现在已经被弃用，仅用于API 19
        * 2、onApplyWindowInsets(WindowInsets insets): 这应该是标准的方式了，然而在魅蓝M1上竟然会出现找不到WindowInsets这个类的crash
        * 3、使用ViewCompat.setOnApplyWindowInsetsListener添加的Listener: 这种setListener的方式比较灵活，并且传值是WindowInsetsCompat类型，在魅蓝M1等机型都可以跑通，是上乘之选。
        *
        * 此外有几个关键点需要重点关注：
        *
        * 1、一旦有一个View消耗了WindowInsets，那么WindowInsets的dispatch就结束了。所以一般只在Activity的最外层View调用setFitsSystemWindows(true)
        * 2、系统处理WindowInsets的手段本质是设置padding，因此这会让你View原本的padding失效
        * 3、一般而言，只有一个View消耗WindowInsets，但这是系统行为，我们可以在onApplyWindowInsets里主动调用dispatchApplyWindowInsets使得其可以继续传递。
        * 第三点的意义在于，如果我们需要多个View受WindowInsets影响时，我们可以自己去传递WindowInsets，一般封装者也会提供一个WindowInsetsLayout, 让直接子元素的fitSystemWindows都生效。
        * @XiNGRZ在Mantou Earth有一个很好的实现（点我查看）。使用这个Layout可以满足大部分需求，但也存在一个小漏洞：使用onApplyWindowInsets在魅蓝M1上会crash（前文已经指出原因)
        * 业务上可能会对fitSystemWindows有更复杂的应用，很多时候是由于历史业务的原因导致大大小小的坑，这个时候就需要我们很好的把握fitSystemWindows，随机应变，自由适配WindowInsets了。
        * */

    }
}