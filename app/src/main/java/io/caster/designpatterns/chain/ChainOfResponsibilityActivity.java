package io.caster.designpatterns.chain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.caster.designpatterns.R;
import io.caster.designpatterns.chain.output.OutputManager;
import io.caster.designpatterns.chain.output.ValueCallback;
import io.caster.designpatterns.chain.output.ValueManager;

public class ChainOfResponsibilityActivity extends AppCompatActivity implements ValueCallback{
    private OutputManager outputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_of_responsibility);
        ValueManager.with(this).init();
        outputManager = OutputManager.with(this);
    }

    @Override
    public void onNewValueSelected(int value) {
        outputManager.onNewValueSelected(value);
    }
}
