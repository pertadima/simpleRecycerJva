package com.example.irfan.layouting.section.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.section.home.adapter.TabAdapter;

public class FragmentMain extends Fragment {
    View layout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_main, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = layout.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(0);
        setupViewPager(viewPager);

        tabLayout = layout.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new FragmentHome(), "ONE");
        adapter.addFragment(new FragmentTab(), "TWO");
        adapter.addFragment(new FragmentTab(), "THREE");
        viewPager.setAdapter(adapter);
    }
}
