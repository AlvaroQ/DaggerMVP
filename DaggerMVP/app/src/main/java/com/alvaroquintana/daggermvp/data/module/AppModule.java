package com.alvaroquintana.daggermvp.data.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}
