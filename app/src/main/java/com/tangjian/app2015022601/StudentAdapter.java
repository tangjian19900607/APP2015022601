package com.tangjian.app2015022601;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tangjian on 26/2/15.
 */
public class StudentAdapter extends BaseAdapter {
    private List<Student> list;
    private LayoutInflater layoutInflater;
    public StudentAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<Student> students) {
        this.list = students;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.student,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)convertView.findViewById(R.id.name);
            viewHolder.age = (TextView)convertView.findViewById(R.id.age);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.age.setText(list.get(position).getAge()+"");
        return convertView;
    }

    public static class ViewHolder {
        private TextView name;
        private TextView age;
    }
}
