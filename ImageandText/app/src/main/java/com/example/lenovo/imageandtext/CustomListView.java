package com.example.lenovo.imageandtext;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {
    private String[] bts;
    private Integer[] imgid;
    private Activity context;

    public CustomListView(Activity context, String[] bts,Integer[] imgid) {
        super(context,R.layout.llistview_layout,bts);
        this.context=context;
        this.bts=bts;
        this.imgid=imgid;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder=null;

        if (r==null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.llistview_layout,null,true);
            viewHolder =new ViewHolder(r);
            r.setTag(viewHolder);

        }

        else {

            viewHolder=(ViewHolder)r.getTag();
        }

        viewHolder.ivm.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(bts[position]);
        return r;

    }

    class ViewHolder {
        TextView tvw1;
        ImageView ivm;

        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.btsname);
            ivm=v.findViewById(R.id.imageView);
        }
    }
}
