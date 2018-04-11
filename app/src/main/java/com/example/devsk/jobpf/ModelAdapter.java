package com.example.devsk.jobpf;

import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private List<Model> models;

    public ModelAdapter(List<Model> models) {
        this.models = models;
    }

    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
     return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ModelAdapter.ViewHolder holder, int position) {
       Model model = models.get(position);
       holder.nameProf.setText(model.getNameProf());
       holder.zp.setText(model.getZp());
       holder.company.setText(model.getCompany());

    }

    @Override
    public int getItemCount() {
        if (models == null)
            return  0;
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameProf;
        TextView zp;
        TextView company;

        public ViewHolder(View itemView) {
            super(itemView);
            nameProf = (TextView) itemView.findViewById(R.id.text_prof);
            zp = (TextView) itemView.findViewById(R.id.text_zp);
            company = (TextView) itemView.findViewById(R.id.text_company);

        }
    }
}
