package com.alvaroquintana.daggermvp.data.Net;

import com.alvaroquintana.daggermvp.data.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Quintana on 30/3/18.
 */

public interface Services {

    String BASE_URL = "http://losapuntesdelprogramador.com/dogs/";
    String FLAG_URL = "http://losapuntesdelprogramador.com/dogs/flag_iso/";

    interface DogService {
        @GET("dogs/get_dogs_es.php")
        Observable<List<Dog>> getDogsList();
    }
}
