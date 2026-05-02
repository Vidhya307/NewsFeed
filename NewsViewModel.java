package com.example.newsfeed;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
public class NewsViewModel extends ViewModel {
 private final NewsRepository repository;
 public NewsViewModel() {
 repository = new NewsRepository();
 }
 public LiveData<List<NewsModel>> getNews(String country, String category, 
String apiKey) {
 return repository.getNews(country, category, apiKey);
 }
}
