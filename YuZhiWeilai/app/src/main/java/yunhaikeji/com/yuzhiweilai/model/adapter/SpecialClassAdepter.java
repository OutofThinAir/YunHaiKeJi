package yunhaikeji.com.yuzhiweilai.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;

/**
 * Use:专辑列表适配器
 * Author:陈懿鹏
 * Data:2017/5/26.
 */

public class SpecialClassAdepter extends BaseAdapter {
    Context context;
    ArrayList<SpecialClassBean.DataBean.TopicBean> list;

    public SpecialClassAdepter(Context context, ArrayList<SpecialClassBean.DataBean.TopicBean> list) {
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
        TryViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.stu_pager_lv_item03_layout,null);
            viewHolder=new TryViewHolder();
            viewHolder.imageView01= (ImageView) convertView.findViewById(R.id.stu_pil03_hiamge);
            viewHolder.imageView02 = (ImageView) convertView.findViewById(R.id.stu_pil03_iamge);
            viewHolder.title= (TextView) convertView.findViewById(R.id.stu_pil03_title);
            viewHolder.info= (TextView) convertView.findViewById(R.id.stu_pil03_info);


            convertView.setTag(viewHolder);
        }else{
            viewHolder= (TryViewHolder) convertView.getTag();
        }
       viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.info.setText(list.get(position).getTitle2());
        Glide.with(context).load(list.get(position).getImage()).into(viewHolder.imageView01);

        return convertView;
    }

    private class TryViewHolder{
        ImageView imageView01;
        ImageView imageView02;

        TextView title;
        TextView info;



    }

}
