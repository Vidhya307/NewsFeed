package com.example.newsfeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ApiInterface {
 @GET("top-headlines")
 Call<NewsResponse> getNews(
 @Query("country") String country,
 @Query("category") String category,
 @Query("apiKey") String apiKey
 );
}
