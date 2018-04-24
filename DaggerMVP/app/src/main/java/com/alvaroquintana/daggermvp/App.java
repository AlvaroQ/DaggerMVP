package com.alvaroquintana.daggermvp;

import android.app.Application;

import com.alvaroquintana.daggermvp.data.component.DaggerNetComponent;
import com.alvaroquintana.daggermvp.data.component.NetComponent;
import com.alvaroquintana.daggermvp.data.module.AppModule;
import com.alvaroquintana.daggermvp.data.module.NetModule;


/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(getString(R.string.url_data_dog)))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
