package io.caster.designpatterns;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import io.caster.designpatterns.main.MainView;
import io.caster.designpatterns.observer.ObserverActivity;

public class MainActivity extends AppCompatActivity implements MainView.OnPatternSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainView.with(this).init();
    }

    @Override
    public void onPatternSelected(@NonNull String[] patterns, int selectedPattern) {
        //TODO Fix me when we know more
        if (selectedPattern == 0) {
            startActivity(new Intent(this, ObserverActivity.class));
        }
    }
}
