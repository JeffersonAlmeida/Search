package com.almeida.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.almeida.search.network.Service;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getApplicationComponents().inject(this);

        EditText search = (EditText) findViewById(R.id.search_text);

        RxTextView.afterTextChangeEvents(search).subscribe(e -> {
            Log.e("TAG", "E: " + e.editable().toString());
        });


        service.fetchUser("jeffersonalmeida")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.e("TAG", "E: " + user.toString());
                });


    }
}
