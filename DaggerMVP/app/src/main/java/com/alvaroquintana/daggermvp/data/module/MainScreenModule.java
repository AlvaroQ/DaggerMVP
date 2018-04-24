package com.alvaroquintana.daggermvp.data.module;



import com.alvaroquintana.daggermvp.presenter.MainScreenContract;
import com.alvaroquintana.daggermvp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
