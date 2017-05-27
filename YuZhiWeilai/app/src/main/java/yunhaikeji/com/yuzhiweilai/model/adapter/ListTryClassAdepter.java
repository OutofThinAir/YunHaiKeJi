package yunhaikeji.com.yuzhiweilai.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;

/**
 * Use:试听列表适配器
 * Author:陈懿鹏
 * Data:2017/5/26.
 */

public class ListTryClassAdepter extends BaseAdapter {
    Context context;
    ArrayList<ListTryBean.DataBean.TryBean> list;

    public ListTryClassAdepter(Context context, ArrayList<ListTryBean.DataBean.TryBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
