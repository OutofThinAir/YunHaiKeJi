package yunhaikeji.com.yuzhiweilai.model.function_interface;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Use:首次握手的接口
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

public interface FirstHandInterface {


    /**
     * 首次握手
     * @param type
     * @param dev_id
     * @param ver_code
     * @param tick
     */
    void first_hand(Context context, SharedPreferences preferences, String type, final String dev_id, final int ver_code, final String tick);
}
