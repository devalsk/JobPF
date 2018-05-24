package com.example.devsk.jobpf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devsk.jobpf.modelcompanies.Company;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<Company> companyList;
    private Context context;


    public CompanyAdapter(List<Company> companyList, Context context) {
        this.companyList = companyList;
        this.context = context;
    }

    @Override
    public CompanyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_companies, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CompanyAdapter.ViewHolder holder, int position) {
        Company company = companyList.get(position);
        holder.officialCompany.setText(company.getOfficialTitle());
        holder.employess.setText(company.getEmployees() + " вакансий");
        holder.rubrics.setText(company.getRubrics());
        Picasso.get().load(company.getLogo().getUrl()).into(holder.imageLogo);


    }

    @Override
    public int getItemCount() {
        if (companyList == null)
            return 0;
        return companyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView officialCompany, employess, rubrics;
        ImageView imageLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            officialCompany = itemView.findViewById(R.id.official_company);
            imageLogo = itemView.findViewById(R.id.imageViewLogo);
            employess = itemView.findViewById(R.id.employess);
            rubrics = itemView.findViewById(R.id.rubrics);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Company company = companyList.get(pos);
                        Intent intent = new Intent(context,DetailsCompanyActivity.class);
                        intent.putExtra("dataCompany",company);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }

                }
            });
        }
    }
}
