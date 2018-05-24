package com.example.devsk.jobpf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.devsk.jobpf.modelnews.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    private Context context;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }


    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_row_news_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);
        News news = newsList.get(position);
        holder.dataTime.setText(news.getTime());
        holder.title.setText(news.getTitle());
        Picasso.get().load(news.getImageUrl()).into(holder.img);
        //     holder.descriptive.setText(news.getTitle());

    }

    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dataTime, descriptive, title;
        ImageView img;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            dataTime = itemView.findViewById(R.id.date_text);
            img = itemView.findViewById(R.id.thumb_img);
            //descriptive = itemView.findViewById(R.id.description_text);
            cardView = itemView.findViewById(R.id.cardview);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        News news = newsList.get(pos);
                        Intent intent = new Intent(context,BrowserActivity.class);
                        intent.putExtra("webURL",news.getSiteUrl());
                        context.startActivity(intent);

                    }


                }
            });
        }
    }
}
