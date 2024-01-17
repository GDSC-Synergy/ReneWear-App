package com.synergy.renewear.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.synergy.renewear.R;
import com.synergy.renewear.databinding.FragmentHomeBinding;
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
        CustomAdapter adapter = new CustomAdapter(requireContext(), getActivity().getSupportFragmentManager(), data, desc);

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