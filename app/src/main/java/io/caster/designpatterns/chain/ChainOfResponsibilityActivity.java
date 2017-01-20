package io.caster.designpatterns.chain;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.caster.designpatterns.R;
import io.caster.designpatterns.chain.output.ValueCallback;
import io.caster.designpatterns.chain.output.ValueManager;

public class ChainOfResponsibilityActivity extends AppCompatActivity implements ValueCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_of_responsibility);
        ValueManager.with(this).init();
    }

    @Override
    public void onNewValueSelected(int value) {

    }
}
