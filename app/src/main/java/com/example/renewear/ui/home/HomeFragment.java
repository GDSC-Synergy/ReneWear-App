package com.example.renewear.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.renewear.R;
import com.example.renewear.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridView gridViewHome = root.findViewById(R.id.grid_view);
        String[] data = {"Thrift", "Remake", "Donate", "Recycle"};
        String[] desc = {"Shop affordable, second-\n" +
                "hand fashion for stylish \n" +
                "savings.", "Transform old clothes into \n" +
                "trendy, new designs with \n" +
                "skilled tailors.", "Easily give back by \n" +
                "donating unused clothes \n" +
                "to those in need.", "Sustainably dispose of \n" +
                "worn-out items for eco-\n" +
                "friendly fashion."};

        // Create a custom adapter
        CustomAdapter adapter = new CustomAdapter(requireContext(), getChildFragmentManager(), data);

        // Set the adapter for the GridView
        gridViewHome.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}