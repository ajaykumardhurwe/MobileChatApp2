package com.example.mobilechatapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilechatapp.ChatActivity;
import com.example.mobilechatapp.R;
import com.example.mobilechatapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
    return root;

    }

public View login(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
{
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    TextView login = (TextView) view.findViewById(R.id.ajay);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ChatActivity.class);
            intent.putExtra("some", "some data");
            startActivity(intent);
        }
    });

    return view;
}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}