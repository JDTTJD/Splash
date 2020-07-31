package com.tuoren.jetpack.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuoren.jetpack.R;
import com.tuoren.jetpack.User;
import com.tuoren.jetpack.databinding.FragmentBlankBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * Create by JDT on 2020-07-27.
 */
public class BlankFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBlankBinding inflate = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        User user = new User("jack", 20);
        inflate.setUser(user);
//        viewRoot.findViewById(R.id.tv_nav).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavHostFragment.findNavController(BlankFragment.this).navigate(R.id.action_blankFragment_to_blankFragment2);
//            }
//        });
        return inflate.getRoot();
    }
}
