package com.alvaroquintana.daggermvp.presenter;


import com.alvaroquintana.daggermvp.data.Net.Services;
import com.alvaroquintana.daggermvp.data.model.Dog;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public class MainScreenPresenter implements MainScreenContract.Presenter {

    public Retrofit retrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadDogs() {
        retrofit.create(Services.DogService.class).getDogsList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Dog>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Dog> dogs) {
                        mView.showDogs(dogs);
                    }
                });
    }


}
