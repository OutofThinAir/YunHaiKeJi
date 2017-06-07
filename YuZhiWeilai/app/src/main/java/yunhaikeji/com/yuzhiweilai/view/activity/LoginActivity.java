package yunhaikeji.com.yuzhiweilai.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
 * Use:登录界面
 * Author:陈懿鹏
 * Data:2017/6/1.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_pager_return)
    ImageView loginPagerReturn;
    @BindView(R.id.login_pager_img)
    ImageView loginPagerImg;
    @BindView(R.id.login_pager_phonen)
    EditText loginPagerPhonen;
    @BindView(R.id.login_pager_pwd)
    EditText loginPagerPwd;
    @BindView(R.id.login_pager_noShowPwd)
    ImageView loginPagerNoShowPwd;
    @BindView(R.id.login_pager_forgetPwd)
    TextView loginPagerForgetPwd;
    @BindView(R.id.login_pager_login)
    Button loginPagerLogin;
    @BindView(R.id.login_paget_pregin)
    Button loginPagetPregin;
    @BindView(R.id.login_pager_weChat)
    TextView loginPagerWeChat;
    @BindView(R.id.login_pager_QQ)
    TextView loginPagerQQ;
    private ImplPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_pager_layout);
        ButterKnife.bind(this);

        //实例化p层
        presenter = new ImplPresenter(this,this);

    }

    @OnClick({R.id.login_pager_return, R.id.login_pager_img, R.id.login_pager_noShowPwd, R.id.login_pager_forgetPwd, R.id.login_pager_login, R.id.login_paget_pregin, R.id.login_pager_weChat, R.id.login_pager_QQ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_pager_return:
                break;
            case R.id.login_pager_img:
                break;
            case R.id.login_pager_noShowPwd:
                break;
            case R.id.login_pager_forgetPwd:
                break;
            case R.id.login_pager_login:
                //登录
                String phone=loginPagerPhonen.getText().toString();
                String pwd =loginPagerPwd.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else if(!TextUtils.isEmpty(phone)&&!TextUtils.isEmpty(pwd)){
                    presenter.userLogin(phone,pwd);
                }

                break;
            case R.id.login_paget_pregin:
                //跳转手机注册界面
                Intent intent = new Intent(LoginActivity.this,ReginActivity.class);
                startActivity(intent);
                break;
            case R.id.login_pager_weChat:
                break;
            case R.id.login_pager_QQ:
                break;
        }
    }

    /**
     * 返回登录信息
     * @param info
     */
    @Override
    public void showLoginInfo(String info) {
        super.showLoginInfo(info);
        Toast.makeText(this,info, Toast.LENGTH_SHORT).show();
        if (info.equals("登录成功")){
               finish();
        }
    }
}
