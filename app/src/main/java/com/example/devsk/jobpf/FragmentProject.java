package com.example.devsk.jobpf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentProject extends Fragment {


    View v;

    private RecyclerView recyclerView;
    private List<Project> projectList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectList = new ArrayList<>();
        projectList.add(new Project("Tex1"));
        projectList.add(new Project("Tex2"));
        projectList.add(new Project("Tex2"));
    }

    public FragmentProject() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_project_activity1,container,false);
        recyclerView = v.findViewById(R.id.list_project);
        FragmentAdapterProject fragmentAdapterProject = new FragmentAdapterProject(projectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SpaceItemDecoration(50));
        recyclerView.setAdapter(fragmentAdapterProject);
        return v;
    }
}
