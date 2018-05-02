package com.example.devsk.jobpf;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devsk.jobpf.models.Model;
import com.example.devsk.jobpf.models.Vacancy;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    //private List<Model> models;
    private List<Vacancy> vacancies;


    public ModelAdapter(List<Vacancy> vacancies) {
        this.vacancies = vacancies;

    }

    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ModelAdapter.ViewHolder holder, int position) {
        Vacancy vacancy = vacancies.get(position);

        holder.nameProf.setText(vacancy.getHeader());
        holder.zp.setText(vacancy.getZpMin());
        holder.company.setText(vacancy.getCompany().getTitle());


    }

    @Override
    public int getItemCount() {
        if (vacancies == null)
            return 0;
        return vacancies.size();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Vacancy clickVacancyData = vacancies.get(pos);
                        Log.d("click", clickVacancyData.getHeader());

                    }
                }
            });

        }


    }

}
