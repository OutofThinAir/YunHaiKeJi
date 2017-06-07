package yunhaikeji.com.yuzhiweilai.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import yunhaikeji.com.yuzhiweilai.model.function_interface.FirstHandInterface;
import yunhaikeji.com.yuzhiweilai.model.impl_class.ImplFirstHand;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.view.function_interface.ViewFistHandInterface;

/**
 * Use:首次握手的p
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

public class FirstHandPresenter {
    Context context;
    SharedPreferences preferences;
    FirstHandInterface firstHand;
    ViewFistHandInterface viewFist;

    public FirstHandPresenter(Context context, SharedPreferences preferences,  ViewFistHandInterface viewFist) {
        this.context = context;
        this.preferences = preferences;
        this.firstHand = new ImplFirstHand(this,context);
        this.viewFist = viewFist;
    }

    public void getFirstHand(boolean b) {
        viewFist.getFristHand(b);
    }


    public void showFirst() {
        firstHand.first_hand(context,preferences, ModelUtils.APPTYPE,ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick());
    }
}
