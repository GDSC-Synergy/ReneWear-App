package com.example.renewear.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.renewear.R;
import com.example.renewear.databinding.FragmentThriftBinding;

public class ThriftFragment extends Fragment {

    private FragmentThriftBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        binding = FragmentThriftBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View root = inflater.inflate(R.layout.fragment_thrift, container, false);
        // Handle UI setup or data binding here if needed

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
