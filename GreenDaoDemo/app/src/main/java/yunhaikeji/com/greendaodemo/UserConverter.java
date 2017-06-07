package yunhaikeji.com.greendaodemo;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Use:
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

public class UserConverter implements PropertyConverter<User,String> {

    @Override
    public User convertToEntityProperty(String databaseValue) {

      return null;
    }

    @Override
    public String convertToDatabaseValue(User entityProperty) {
        return null;
    }
}
