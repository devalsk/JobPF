package com.example.devsk.jobpf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.example.devsk.jobpf.modelsvacancy.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.ViewHolder> {

    //private List<Model> models;
    private List<Vacancy> vacancies;
    private List<Vacancy> mvacancies;
    private Context context;


    public VacancyAdapter(Context context, List<Vacancy> vacancies) {
        this.context = context;
        this.vacancies = vacancies;
        this.mvacancies = vacancies;

    }

    @Override
    public VacancyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final VacancyAdapter.ViewHolder holder, int position) {
        Vacancy vacancy = vacancies.get(position);

        holder.nameProf.setText(vacancy.getHeader());
        holder.zp.setText(vacancy.getZpMin() + " руб.");
        holder.company.setText(vacancy.getCompany().getTitle());

    }

    @Override
    public int getItemCount() {
        if (vacancies == null)
            return 0;
        return vacancies.size();
    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String str = constraint.toString();
                if (str.isEmpty()) {
                    vacancies = mvacancies;
                }else{

                     ArrayList<Vacancy> filteredList= new ArrayList<>();
                     for(Vacancy vacancy:mvacancies){

                         if(vacancy.getHeader().toLowerCase().contains(str)){
                            filteredList.add(vacancy);
                         }

                     }
                     vacancies = filteredList;
                }


                FilterResults filterResults = new FilterResults();
                filterResults.values = vacancies;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                vacancies = (List<Vacancy>) results.values;
                notifyDataSetChanged();

            }
        };
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
                        // Log.d("click", clickVacancyData.getHeader());
                        Intent intent = new Intent(context, DetailsActivityJob.class);
                        intent.putExtra("data", clickVacancyData);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }
                }
            });

        }


    }
    public void updateList(List<Vacancy> vac){

        vacancies = new ArrayList<>();
        vacancies.addAll(vac);
        notifyDataSetChanged();

    }


}
