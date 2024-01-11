package com.example.renewear.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renewear.R;

public class CustomAdapter extends BaseAdapter {

    private final String[] data;
    private final LayoutInflater inflater;

    public CustomAdapter(Context context, String[] data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
            holder.text = convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Replace with your actual icons
        int[] icons = {R.drawable.media, R.drawable.media, R.drawable.media, R.drawable.media};
        holder.icon.setImageResource(icons[position]);

        holder.text.setText(data[position]);

        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView text;
    }
}
