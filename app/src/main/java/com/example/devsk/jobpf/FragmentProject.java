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
        projectList.add(new Project("http://adminu.ru/wp-content/uploads/2011/11/adminu-website-500x375.jpg",
                "Разработка веб-сайта","Нужно разработать  вебсайт для подготовки к экзаменам","devalsk",
                "https://github.com/devalsk/site-project1","devalsk@yandex.ru","https://github.com/devalsk"));

    }

    public FragmentProject() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_project_activity1,container,false);
        recyclerView = v.findViewById(R.id.list_project);
        FragmentAdapterProject fragmentAdapterProject = new FragmentAdapterProject(getActivity(),projectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SpaceItemDecoration(20));
        recyclerView.setAdapter(fragmentAdapterProject);
        return v;
    }
}
