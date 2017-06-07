package yunhaikeji.com.yuzhiweilai.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.R;
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
        TryViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.stu_pager_lv_item02_layout,null);
            viewHolder=new TryViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.stu_pil02_iamge);
            viewHolder.title= (TextView) convertView.findViewById(R.id.stu_pil02_title);
            viewHolder.info= (TextView) convertView.findViewById(R.id.stu_pil02_info);
            viewHolder.tercher= (TextView) convertView.findViewById(R.id.stu_pil02_teacher);
            viewHolder.isFree= (TextView) convertView.findViewById(R.id.stu_pil02_isfree);
            viewHolder.duration= (TextView) convertView.findViewById(R.id.stu_pil02_duration);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (TryViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).image).placeholder(R.mipmap.android_template).into(viewHolder.imageView);
        viewHolder.title.setText(list.get(position).title);
        viewHolder.info.setText(list.get(position).title2);
        viewHolder.tercher.setText(list.get(position).speaker);
        //viewHolder.isFree.setText(l);
        viewHolder.duration.setText(list.get(position).length+"");
        return convertView;
    }

    private class TryViewHolder{
        ImageView imageView;
        TextView title;
        TextView info;
        TextView tercher;
        TextView isFree;
        TextView duration;


    }

}
