package com.example.renewear.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.renewear.R;
import com.example.renewear.databinding.FragmentThriftBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThriftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThriftFragment extends Fragment {
    private FragmentThriftBinding binding;
    public ThriftFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThriftBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        FrameLayout frameLayout = rootView.findViewById(R.id.fragment_container);
        TextView textView = new TextView(requireContext());
        textView.setText("Isi FrameLayout ini");
        frameLayout.addView(textView);

        return rootView;
    }
}