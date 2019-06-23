package com.aravindchowdary.kodewaala;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerAPI {

    private static final String key = "AIzaSyAHmJweeqtAFHUf-9p7ert6P1Uz7YIBrj8";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/7293562182615085581/posts/";

    public static PostService postService = null;

    public static PostService getService()
    {
        if (postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(url)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }


    public interface PostService {
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }
}

