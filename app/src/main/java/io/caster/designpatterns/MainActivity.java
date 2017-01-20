package io.caster.designpatterns;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import io.caster.designpatterns.chain.ActivityChainManager;
import io.caster.designpatterns.main.MainView;

public class MainActivity extends AppCompatActivity implements MainView.OnPatternSelectedListener{
    private ActivityChainManager chainManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainView.with(this).init();
        chainManager = new ActivityChainManager(this);
    }

    @Override
    public void onPatternSelected(@NonNull String[] patterns, int selectedPattern) {
        chainManager.onPatternReceived(selectedPattern);
    }
}
