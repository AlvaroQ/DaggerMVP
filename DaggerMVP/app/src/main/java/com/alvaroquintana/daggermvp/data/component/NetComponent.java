package com.alvaroquintana.daggermvp.data.component;



import com.alvaroquintana.daggermvp.data.module.AppModule;
import com.alvaroquintana.daggermvp.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 *
 * Created by Alvaro Quintana on 24-Apr-18.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
}
