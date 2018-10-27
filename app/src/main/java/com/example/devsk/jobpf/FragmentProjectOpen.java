package com.example.devsk.jobpf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentProjectOpen extends Fragment {


    View v;

    private RecyclerView recyclerView;
    private List<Project> projectList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectList = new ArrayList<>();
        projectList.add(new Project("https://allerror.ru/wp-content/uploads/2016/11/android-1.jpg",
                "Разработка мобильного приложения","Нужно разработать  вебсайт для подготовки к экзаменам","dev",
                "https://github.com/devalsk/site-project1","devalsk@yandex.ru","https://github.com/devalsk"));
        projectList.add(new Project("https://developer-tech.com/media/img/news/reactive-nativingitup.png.800x600_q96.png",
                "Разработка приложение на React Native","Необходимо, опираясь на готовый скелет (React Native, Redux, NativeBase, React Navigation) и макеты, довести приложение до конечного вида. Приложение предназначено для наблюдения за портфелем инвестиций, в общей сложности не более 10 экранов. Прикладная бизнес-логика и необходимые запросы REST уже реализованы.","dev",
                "https://github.com/devalsk/site-project1","devalsk@yandex.ru","https://github.com/devalsk"));
        projectList.add(new Project("https://bitcoin.org/img/icons/opengraph.png",
                "Разработка биржи обмена криптовалют","Стандартная биржа для обмена валюты, в приоритете обмены с евро, долларов, гривен, рублей на bitcoin, ethereum, в дальнейшем подключим еще несколько криптовалют","dev",
                "https://github.com/devalsk/site-project1","devalsk@yandex.ru","https://github.com/devalsk"));


    }

    public FragmentProjectOpen() {

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
