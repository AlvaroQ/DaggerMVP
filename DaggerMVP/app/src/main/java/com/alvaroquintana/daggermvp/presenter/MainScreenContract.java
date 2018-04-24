package com.alvaroquintana.daggermvp.presenter;



import com.alvaroquintana.daggermvp.data.model.Dog;

import java.util.List;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public interface MainScreenContract {
    interface View {
        void showDogs(List<Dog> dogs);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadDogs();
    }
}
