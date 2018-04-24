package com.alvaroquintana.daggermvp.data.component;


import com.alvaroquintana.daggermvp.data.module.MainScreenModule;
import com.alvaroquintana.daggermvp.Activity.MainActivity;
import com.alvaroquintana.daggermvp.util.CustomScope;

import dagger.Component;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
