package com.example.newsfeed;
import com.google.gson.annotations.SerializedName;
public class NewsModel {
 @SerializedName("title")
 private String title;
 @SerializedName("description")
 private String description;
 @SerializedName("url")
 private String url;
 @SerializedName("urlToImage")
 private String urlToImage;
 @SerializedName("publishedAt")
 private String publishedAt;
 @SerializedName("source")
 private Source source;
 public String getTitle() { return title; }
 public String getDescription() { return description; }
 public String getUrl() { return url; }
 public String getUrlToImage() { return urlToImage; }
 public String getPublishedAt() { return publishedAt; }
 public Source getSource() { return source; }
 public static class Source {
 @SerializedName("name")
 private String name;
 public String getName() { return name; }
 }
}
