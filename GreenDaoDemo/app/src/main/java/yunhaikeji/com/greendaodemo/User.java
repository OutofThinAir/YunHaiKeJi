package yunhaikeji.com.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Use:
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

@Entity
public class User {

    @Id
    private long id;
    private String name;
    @Transient
    private long tempUsageCount; // not persisted
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Keep
    @Generated(hash = 873297011)
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Keep
    @Generated(hash = 586692638)
    public User() {
    }
}
