package yunhaikeji.com.yuzhiweilai.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.view.fragment.ClassPagerFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.MyPagerFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.StudentPagerFragment;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_frame_rb_stu)
    RadioButton mainFrameRbStu;
    @BindView(R.id.main_frame_rb_cla)
    RadioButton mainFrameRbCla;
    @BindView(R.id.main_frame_rb_my)
    RadioButton mainFrameRbMy;
    @BindView(R.id.main_pager_rg)
    RadioGroup mainPagerRg;


    private FragmentManager manager;
    private StudentPagerFragment sf;
    private ClassPagerFragment cf;
    private MyPagerFragment mf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        //实例化Fragment
        sf = new StudentPagerFragment();
        cf = new ClassPagerFragment();
        mf = new MyPagerFragment();
        addFragment(manager, sf, cf, mf);

        RadioGroup r = (RadioGroup) findViewById(R.id.main_pager_rg);

        //RidioGroup点击事件
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_frame_rb_stu:
                        cutFragment(manager, sf, cf, mf);

                        break;
                    case R.id.main_frame_rb_cla:
                        cutFragment(manager, cf, sf, mf);
                        break;
                    case R.id.main_frame_rb_my:
                        cutFragment(manager, mf, cf, sf);
                        break;
                }
            }
        });

    }

    //开启事物添加fragment
    private void addFragment(FragmentManager manager, StudentPagerFragment sf, ClassPagerFragment cf, MyPagerFragment mf) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_frame, sf, "sf");
        transaction.add(R.id.main_frame, cf, "cf");
        transaction.add(R.id.main_frame, mf, "mf");
        transaction.hide(cf);
        transaction.hide(mf);
        transaction.commit();
    }

    //切换隐藏Fragment
    private void cutFragment(FragmentManager manager, Fragment newFrag, Fragment oldFrag01, Fragment oldFrag02) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(newFrag);
        transaction.hide(oldFrag01);
        transaction.hide(oldFrag02);
        transaction.commit();
    }

    //沉浸式实现
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
