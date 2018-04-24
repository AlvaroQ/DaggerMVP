package com.alvaroquintana.daggermvp.Activity;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.alvaroquintana.daggermvp.App;
import com.alvaroquintana.daggermvp.R;
import com.alvaroquintana.daggermvp.data.adapter.DogAdapter;
import com.alvaroquintana.daggermvp.data.component.DaggerMainScreenComponent;
import com.alvaroquintana.daggermvp.data.model.Dog;
import com.alvaroquintana.daggermvp.data.module.MainScreenModule;
import com.alvaroquintana.daggermvp.presenter.MainScreenContract;
import com.alvaroquintana.daggermvp.presenter.MainScreenPresenter;
import com.alvaroquintana.daggermvp.util.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public class MainActivity extends AppCompatActivity implements MainScreenContract.View {
    private RecyclerView mRecyclerView;
    private DogAdapter mAdapter;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Inject
    MainScreenPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Usar esta línea para mejorar el rendimiento
        // si sabemos que el contenido no va a afectar
        // el tamaño del RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);


        //Increment the counter before making a network request
        EspressoIdlingResource.increment();

        //Call the method in MainPresenter to make Network Request
        mainPresenter.loadDogs();
    }

    @Override
    public void showDogs(List<Dog> dogs) {

        //Loop through the dogs and get the title of the dogs and add it to our list object
        for (int i = 0; i < dogs.size(); i++) {
            list.add(dogs.get(i).getName());
        }

        // Asociamos un adapter (ver más adelante cómo definirlo)
        mAdapter = new DogAdapter(this, dogs);
        mRecyclerView.setAdapter(mAdapter);

        //Decrement after loading the dogs
        EspressoIdlingResource.decrement();
    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

        // If there is no network connection we get an error and decrement the counter because the call has finished
        EspressoIdlingResource.decrement();
    }

    @Override
    public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();

    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }
}
