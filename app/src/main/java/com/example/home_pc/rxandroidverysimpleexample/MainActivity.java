package com.example.home_pc.rxandroidverysimpleexample;

import android.os.AsyncTask;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.home_pc.rxandroidverysimpleexample.Api.RootObject;
import com.example.home_pc.rxandroidverysimpleexample.Api.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoad;
    ListView listView;
    public static final String BASE_URL = "http://api.icndb.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = findViewById(R.id.btnSet);
        btnLoad.setOnClickListener(this);
        listView = findViewById(R.id.listView);
    }

    @Override
    public void onClick(View v) {
        useRxJava();
    }

    private void setAdapter(ArrayList<String> jokes) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jokes);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> sentRequest() {
        ArrayList<String> jokes = new ArrayList<>();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        JokeRetrofitInterface client = retrofit.create(JokeRetrofitInterface.class);

        Call<RootObject> call = client.getJokes();
        RootObject rootObject = null;
        try {
            rootObject = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Value[] values = rootObject.getValue();
        for (Value value : values) {
            String joke = value.getJoke();
            jokes.add(joke);
        }
        return jokes;
    }


    private void useRxJava() {

        Observable observable = Observable.create(new ObservableOnSubscribe<ArrayList<String>>() {
            @Override
            public void subscribe(ObservableEmitter<ArrayList<String>> emitter) throws Exception {

                ArrayList<String> myJokes = new ArrayList<>();
                myJokes = sentRequest();
                emitter.onNext(myJokes);
            }
        });

        observable.subscribe(new Consumer<ArrayList<String>>() {
            @Override
            public void accept(ArrayList<String> jokes) throws Exception {
                setAdapter(jokes);
            }
        });
    }
}


//class MyTask extends AsyncTask<Void, Void, Void> {
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        sentRequest();
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        super.onPostExecute(aVoid);
//        setAdapter();
//    }
//}


//        Observable observable = Observable.create(new ObservableOnSubscribe<ArrayList<String>>() {
//                                                      @Override
//                                                      public void subscribe(ObservableEmitter<ArrayList<String>> emitter) throws Exception {
//
//                                                          ArrayList<String> myJokes = new ArrayList<>();
//                                                          myJokes = sentRequest();
//                                                          emitter.onNext(urls);
//
//                                                      }
//                                                  }
//
//                observable.subscribe(new Consumer<ArrayList<String>>()
//
//                {
//                    @Override
//                    public void accept(ArrayList<String> strings) throws Exception {
//                        Model model = Model.getModelInstance();
//                        ArrayList<Picture> pictures = new ArrayList<>();
//                        pictures = model.createPictureObjectsWithUrls(strings);
//                        callback.response(pictures);
//                    }
//                });


//        call.enqueue(new Callback<RootObject>() {
//            @Override
//            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
//
//                Value[] values = new Value[0];
//                values = response.body().getValue();
//                for (Value value : values) {
//                    String joke = value.getJoke();
//                    jokes.add(joke);
//                }
//                setAdapter();
//            }
//
//            @Override
//            public void onFailure(Call<RootObject> call, Throwable t) {
//            }
//        });