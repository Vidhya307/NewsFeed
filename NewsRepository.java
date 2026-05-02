
package com.example.newsfeed;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class NewsRepository {
 private final ApiInterface apiInterface;
 public NewsRepository() {
 apiInterface = ApiClient.getInterface();
 }
 public LiveData<List<NewsModel>> getNews(String country, String category, String apiKey) {
 MutableLiveData<List<NewsModel>> data = new MutableLiveData<>();
 apiInterface.getNews(country, category, apiKey).enqueue(new 
Callback<NewsResponse>() {
 @Override
 public void onResponse(Call<NewsResponse> call, 
Response<NewsResponse> response) {
 if (response.isSuccessful() && response.body() != null) {
 data.setValue(response.body().getArticles());
 } else {
 data.setValue(null);
 }
 }
 @Override
 public void onFailure(Call<NewsResponse> call, Throwable t) {
 data.setValue(null);
 }
 });
 return data;
 }
}
