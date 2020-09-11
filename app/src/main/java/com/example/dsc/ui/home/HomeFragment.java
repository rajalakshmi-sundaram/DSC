package com.example.dsc.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dsc.EventAdapter;
import com.example.dsc.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recy);
        String events_list[] = {"Adobe XD Scratchclass - Introduction","Latest Innovation and Trends in Flutter","Discuss with DSC - Blockchain and Pi cryptocurrency","Discuss with DSC - Data Engineering with Spark","Free Practical Cloud course","DeveLup Series - Machine Learning Novice to Jarvis","DeveLup Series - Problem Solving with Design Thinking","DeveLup Series - Touring google Cloud","DeveLup Series - Unboxing Mixed Reality","DeveLup Series - Flutter Zero to Hero","DeveLup Series - Kickstart with Firebase","DeveLup Series - Graphic Designing - Intermediate","DeveLup Series - Introduction to JavaScript","DeveLup Series - Getting started with LaTeX","DeveLup Series Launch"};

        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new EventAdapter(events_list,getActivity());
        mRecyclerView.setAdapter(adapter);

        return root;
    }
}
