package yunhaikeji.com.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wyk.greendaodemo.greendao.gen.DaoMaster;
import com.wyk.greendaodemo.greendao.gen.DaoSession;
import com.wyk.greendaodemo.greendao.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper devOpenHelper =  new DaoMaster.DevOpenHelper(this, "notes-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
     DaoSession   daoSession = daoMaster.newSession();
        //获得UserDao
        UserDao userDao = daoSession.getUserDao();
        //User user = new User(3,"陈xx");

        //添加数据
       // userDao.insert(user);
        //查找数据
        List<User> userList = userDao.loadAll();
        for (int i = 0; i <userList.size() ; i++) {
            Toast.makeText(this, userList.get(i).getName(), Toast.LENGTH_SHORT).show();

        }
    }
}
