package io.caster.designpatterns.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import io.caster.designpatterns.R;

public class DecoratorActivity extends AppCompatActivity implements View.OnClickListener{

    private SeekBar seekValue;
    private TextView outputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        setupToolbar();
        setupUI();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupUI() {
        seekValue = (SeekBar) findViewById(R.id.seekAddValue);
        outputText = (TextView) findViewById(R.id.outputTxt);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnDouble).setOnClickListener(this);
        findViewById(R.id.fab).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
