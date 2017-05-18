package com.newrdev.experimental.lolchampions.data.net;

import com.newrdev.experimental.lolchampions.data.entity.Champion;
import com.newrdev.experimental.lolchampions.data.entity.ChampionsResponse;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by rudolph on 5/16/17.
 */

public interface Api {

    @GET("static-data/v3/champions?champListData=image&dataById=true&api_key=d3e17416-2f31-459e-88b5-c231d8799816")
    Observable<ChampionsResponse> getChampions();

    class Client {
        private static Api client;

        public static Api getInstance() {
            if (client == null) {
                client = buildService();
            }
            return client;
        }

        private static Api buildService() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(logging);

            // Create service
            // https://na1.api.riotgames.com/lol/static-data/v3/champions?champListData=all&dataById=true&api_key=d3e17416-2f31-459e-88b5-c231d8799816
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://na1.api.riotgames.com/lol/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
                    .build();

            return retrofit.create(Api.class);
        }
    }
}
