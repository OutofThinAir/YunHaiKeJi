package yunhaikeji.com.yuzhiweilai.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.utils.MD5;
import yunhaikeji.com.yuzhiweilai.view.fragment.ClassPagerFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.FreeClassFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.MyPagerFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.QualityClassFragment;
import yunhaikeji.com.yuzhiweilai.view.fragment.SpecialClassFragment;
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
    private FreeClassFragment freeclass;
    private QualityClassFragment qualityClass;
    private SpecialClassFragment specialClass;


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
        //免费课程的fragment
        freeclass = new FreeClassFragment();
        //精品课程
        qualityClass = new QualityClassFragment();
        //精品专辑
        specialClass = new SpecialClassFragment();
        addFragment(manager, sf, cf, mf, freeclass, qualityClass, specialClass);

        //RadioGroup r = (RadioGroup) findViewById(R.id.main_pager_rg);

        //RidioGroup点击事件
        mainPagerRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_frame_rb_stu:
                        cutFragment(manager, sf, cf, mf,freeclass,qualityClass,specialClass);

                        break;
                    case R.id.main_frame_rb_cla:
                        cutFragment(manager, cf, sf, mf,freeclass,qualityClass,specialClass);
                        break;
                    case R.id.main_frame_rb_my:
                        cutFragment(manager, mf, cf, sf,freeclass,qualityClass,specialClass);
                        break;
                }
            }
        });


      // Log.d("MainActivity--md5",ModelUtils.md5("qwer890"));




    }

    //开启事物添加fragment
    private void addFragment(FragmentManager manager, StudentPagerFragment sf, ClassPagerFragment cf, MyPagerFragment mf,
    FreeClassFragment freec,QualityClassFragment qc,SpecialClassFragment sc) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_frame, sf, "sf");
        transaction.add(R.id.main_frame, cf, "cf");
        transaction.add(R.id.main_frame, mf, "mf");
        transaction.add(R.id.main_frame, freec, "fc");
        transaction.add(R.id.main_frame, qc, "qc");
        transaction.add(R.id.main_frame, sc, "sc");

        transaction.hide(cf);
        transaction.hide(mf);
        transaction.hide(freec);
        transaction.hide(qc);
        transaction.hide(sc);
        transaction.commit();
    }

    //切换隐藏Fragment
    public void cutFragment(FragmentManager manager, Fragment newFrag, Fragment oldFrag01, Fragment oldFrag02
    ,Fragment oldFrag03,Fragment oldFrag04,Fragment oldFrag05) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(newFrag);
        transaction.hide(oldFrag01);
        transaction.hide(oldFrag02);
        transaction.hide(oldFrag03);
        transaction.hide(oldFrag04);
        transaction.hide(oldFrag05);
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
