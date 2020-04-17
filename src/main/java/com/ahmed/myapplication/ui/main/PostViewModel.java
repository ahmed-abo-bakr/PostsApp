package com.ahmed.myapplication.ui.main;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahmed.myapplication.data.PostsClient;
import com.ahmed.myapplication.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class PostViewModel extends ViewModel {


    MutableLiveData<List<PostModel>> mutableLiveData = new MutableLiveData<>();

    public void getPosts() {

        Single<List<PostModel>> observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        CompositeDisposable disposable = new CompositeDisposable();

        disposable.add(observable.subscribe(o -> mutableLiveData.setValue(o), e -> Log.d("Look", "" + e)));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
