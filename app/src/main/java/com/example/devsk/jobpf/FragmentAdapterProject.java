package com.example.devsk.jobpf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FragmentAdapterProject extends  RecyclerView.Adapter<FragmentAdapterProject.ViewHolder>{


    private List<Project> projects;

    public FragmentAdapterProject(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public FragmentAdapterProject.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_pc,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FragmentAdapterProject.ViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.textView.setText(project.getStr());

    }

    @Override
    public int getItemCount() {
        if (projects == null)
            return 0;
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_test);

        }
    }
}
