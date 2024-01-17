package com.example.renewear.ui.home;

import android.annotation.SuppressLint;
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
import androidx.fragment.app.FragmentTransaction;

import com.example.renewear.databinding.FragmentThriftBinding;

public class CustomAdapter extends BaseAdapter {

    private final String[] data;
    private final String[] desc;
    private final LayoutInflater inflater;
    private final FragmentManager fragmentManager;

    public CustomAdapter(Context context, FragmentManager fragmentManager, String[] data, String[] desc) {
        this.data = data;
        this.desc = desc;
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
            holder.desc = convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Replace with your actual icons
        int[] icons = {R.drawable.media, R.drawable.media, R.drawable.media, R.drawable.media};
        holder.icon.setImageResource(icons[position]);

        holder.text.setText(data[position]);
        holder.desc.setText(desc[position]);

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

    @SuppressLint("ResourceType")
    private void openNewFragment(String data) {
        // Buat instance FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Gantilah "ThriftFragment" dengan nama Fragment Anda
        Fragment thriftFragment = new ThriftFragment();

        // Kustomisasi Bundle (jika perlu) dan tambahkan data yang diperlukan ke fragment
        Bundle bundle = new Bundle();
        bundle.putString("dataKey", data);
        thriftFragment.setArguments(bundle);

        // Gantilah R.id.fragment_container dengan ID container fragment di layout Anda
        transaction.replace(R.id.fragment_thrift, thriftFragment);

        // Tambahkan transaksi ke back stack agar dapat kembali dengan tombol back
        transaction.addToBackStack(null);

        // Lakukan transaksi
        transaction.commit();
    }

    private static class ViewHolder {
        ImageView icon;
        TextView text;
        TextView desc;
    }
}
