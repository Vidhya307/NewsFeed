package com.example.newsfeed;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
 private NewsViewModel newsViewModel;
 private NewsAdapter adapter;
 private final List<NewsModel> articleList = new ArrayList<>();
 private SwipeRefreshLayout swipeRefreshLayout;
 private ProgressBar progressBar;
 
 private static final String API_KEY = BuildConfig.NEWS_API_KEY;
 private String currentCategory = "general";
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 swipeRefreshLayout = findViewById(R.id.swipeRefresh);
 progressBar = findViewById(R.id.progressBar);
 RecyclerView recyclerView = findViewById(R.id.recyclerView);
 recyclerView.setLayoutManager(new LinearLayoutManager(this));
 adapter = new NewsAdapter(this, articleList);
 recyclerView.setAdapter(adapter);
 newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
 findViewById(R.id.btnGeneral).setOnClickListener(v -> 
updateCategory("general"));
 findViewById(R.id.btnTech).setOnClickListener(v -> 
updateCategory("technology"));
 findViewById(R.id.btnSports).setOnClickListener(v -> 
updateCategory("sports"));
 findViewById(R.id.btnBusiness).setOnClickListener(v -> 
updateCategory("business"));
 findViewById(R.id.btnEntertainment).setOnClickListener(v -> 
updateCategory("entertainment"));
 fetchNews(currentCategory);
 swipeRefreshLayout.setOnRefreshListener(() -> 
fetchNews(currentCategory));
 }
 private void updateCategory(String category) {
 currentCategory = category;
 fetchNews(category);
 }
 private void fetchNews(String category) {
 swipeRefreshLayout.setRefreshing(true);
 
 Log.d("NewsApp", "Fetching news with API Key: " + API_KEY);
 if (API_KEY == null || API_KEY.isEmpty() || 
API_KEY.equals("YOUR_API_KEY_HERE") || API_KEY.startsWith("012345")) {
 swipeRefreshLayout.setRefreshing(false);
 Toast.makeText(this, "Please provide a valid News API Key in 
build.gradle.kts", Toast.LENGTH_LONG).show();
 return;
 }
 newsViewModel.getNews("us", category, API_KEY).observe(this, articles 
-> {
 swipeRefreshLayout.setRefreshing(false);
 if (articles != null) {
 articleList.clear();
 articleList.addAll(articles);
 adapter.notifyDataSetChanged();
 if (articles.isEmpty()) {
 Toast.makeText(MainActivity.this, "No articles found for 
this category.", Toast.LENGTH_SHORT).show();
 }
 } else {
 Toast.makeText(MainActivity.this, "Failed to fetch news. 
Check connection or API key.", Toast.LENGTH_SHORT).show();
 }
 });
 }
}
