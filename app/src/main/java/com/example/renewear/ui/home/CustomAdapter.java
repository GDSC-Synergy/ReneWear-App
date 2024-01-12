package com.example.renewear.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.renewear.R;
import androidx.fragment.app.FragmentManager;

public class CustomAdapter extends BaseAdapter {

    private final String[] data;
    private final LayoutInflater inflater;
    private final FragmentManager fragmentManager;

    public CustomAdapter(Context context, FragmentManager fragmentManager, String[] data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.fragmentManager = fragmentManager;
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

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                Log.d("Item Clicked", "Position: " + position + ", Data: " + data[position]);
                openNewFragment(data[position]);
            }
        });

        return convertView;
    }

    private void openNewFragment(String selectedItem) {
        // Check if the selected item is "Thrift"
        if ("Thrift".equals(selectedItem)) {
            Log.d("nav","thrift");
            Fragment newFragment = new ThriftFragment();
            Bundle args = new Bundle();
            args.putString("selectedItem", selectedItem);
            newFragment.setArguments(args);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, newFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private static class ViewHolder {
        ImageView icon;
        TextView text;
    }
}
