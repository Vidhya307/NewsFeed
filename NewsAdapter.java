package com.example.newsfeed;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> 
{
 private final Context context;
 private final List<NewsModel> articles;
 public NewsAdapter(Context context, List<NewsModel> articles) {
 this.context = context;
 this.articles = articles;
}
 @NonNull
 @Override
 public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int 
viewType) {
 View view = LayoutInflater.from(context).inflate(R.layout.news_item, 
parent, false);
 return new ViewHolder(view);
 }
 @Override
 public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
 NewsModel article = articles.get(position);
 holder.title.setText(article.getTitle());
 holder.desc.setText(article.getDescription());
 holder.source.setText(article.getSource() != null ? 
article.getSource().getName() : "Unknown Source");
 holder.date.setText(article.getPublishedAt());
 Glide.with(context)
 .load(article.getUrlToImage())
 .placeholder(android.R.drawable.progress_horizontal)
 .error(android.R.drawable.stat_notify_error)
 .into(holder.image);
 holder.itemView.setOnClickListener(v -> {
 Intent intent = new Intent(context, WebViewActivity.class);
 intent.putExtra("url", article.getUrl());
 context.startActivity(intent);
 });
 }
 @Override
 public int getItemCount() {
 return articles.size();
 }
 public static class ViewHolder extends RecyclerView.ViewHolder {
 ImageView image;
 TextView title, desc, source, date;
 public ViewHolder(@NonNull View itemView) {
 super(itemView);
 image = itemView.findViewById(R.id.newsImage);
 title = itemView.findViewById(R.id.newsTitle);
 desc = itemView.findViewById(R.id.newsDesc);
 source = itemView.findViewById(R.id.newsSource);
 date = itemView.findViewById(R.id.newsDate);
 }
 }
}
