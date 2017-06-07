package yunhaikeji.com.yuzhiweilai.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;

/**
 * Use:注册界面
 * Author:陈懿鹏
 * Data:2017/6/2.
 */

public class ReginActivity extends BaseActivity {
    @BindView(R.id.regin_return)
    ImageView reginReturn;
    @BindView(R.id.regin_img)
    ImageView reginImg;
    @BindView(R.id.regin_tel)
    EditText reginTel;
    @BindView(R.id.regin_Editcheck)
    EditText reginEditcheck;
    @BindView(R.id.regin_getCheckNum)
    TextView reginGetCheckNum;
    @BindView(R.id.regin_pwd)
    EditText reginPwd;
    @BindView(R.id.regin_noShowPwd)
    ImageView reginNoShowPwd;
    @BindView(R.id.regin_regin)
    Button reginRegin;
    @BindView(R.id.regin_agree)
    CheckBox reginAgree;
    private ImplPresenter presrnrter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regin_pager_layout);
        ButterKnife.bind(this);

        //实例p层
        presrnrter = new ImplPresenter(this,this);

    }

    @OnClick({R.id.regin_return, R.id.regin_img, R.id.regin_tel, R.id.regin_Editcheck, R.id.regin_getCheckNum, R.id.regin_pwd, R.id.regin_noShowPwd, R.id.regin_regin, R.id.regin_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regin_return:
                break;
            case R.id.regin_img:
                break;
            case R.id.regin_tel:
                break;
            case R.id.regin_Editcheck:
                break;
            case R.id.regin_getCheckNum:
                break;
            case R.id.regin_pwd:
                break;
            case R.id.regin_noShowPwd:
                break;
            case R.id.regin_regin:
                //注册
                //获得注册信息
                String phone=reginTel.getText().toString();
                String rand = reginEditcheck.getText().toString();
                String pwd = reginPwd.getText().toString();
                if(TextUtils.isEmpty(reginTel.getText().toString())){
                    Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(reginEditcheck.getText().toString())){
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(reginPwd.getText().toString())){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else if(!TextUtils.isEmpty(reginTel.getText().toString())&&!TextUtils.isEmpty(reginEditcheck.getText().toString())
                        &&!TextUtils.isEmpty(reginPwd.getText().toString())){
                    if (pwd.length()>=6){
                        presrnrter.userReginBean(phone,rand,pwd);
                    }else{
                        Toast.makeText(this, "密码长度小于六位", Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            case R.id.regin_agree:
                break;
        }
    }

    /**
     * 展示注册信息
     * @param info
     */
    @Override
    public void showReginInfo(String info) {
        super.showReginInfo(info);
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        if (info.equals("注册成功")){
            finish();
        }
    }
}
