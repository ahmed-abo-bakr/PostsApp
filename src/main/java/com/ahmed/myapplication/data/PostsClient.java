package com.ahmed.myapplication.data;

import com.ahmed.myapplication.pojo.PostModel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PostsClient INSTANCE;
    private PostInterface postInterface;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Single<List<PostModel>> getPosts() {
        return postInterface.getPosts();
    }

}
