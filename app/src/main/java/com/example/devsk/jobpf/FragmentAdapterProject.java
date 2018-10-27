package com.example.devsk.jobpf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FragmentAdapterProject extends RecyclerView.Adapter<FragmentAdapterProject.ViewHolder> {

    Intent intent;
    Context context;

    public FragmentAdapterProject(Context context, List<Project> projects) {
        this.projects = projects;
        this.context = context;
    }

    private List<Project> projects;

    public FragmentAdapterProject(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public FragmentAdapterProject.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_pc, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FragmentAdapterProject.ViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.textView.setText(project.getStr());
        holder.author.setText(project.getAuthor());
        Picasso.get().load(project.getImg()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        if (projects == null)
            return 0;
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, author;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name_project);
            imageView = itemView.findViewById(R.id.img_project);
            author = itemView.findViewById(R.id.by_aftor);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION) {
                        Project project = projects.get(pos);
                        intent = new Intent(context, DetailProjectActivity.class);

                        intent.putExtra("img",project.getImg());
                        intent.putExtra("name",project.getNameProject());
                        intent.putExtra("desc",project.getDesc());
                        intent.putExtra("author",project.getAuthor());
                        intent.putExtra("gitRepo",project.getGitRepository());
                        intent.putExtra("email",project.getContactEmail());
                        intent.putExtra("gitaccount",project.getContactGit());


                        context.startActivity(intent);

                    }

                }
            });
        }


    }
}
