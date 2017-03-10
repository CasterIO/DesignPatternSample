package io.caster.designpatterns.decorator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import io.caster.decorator.AdditionIntDecorator;
import io.caster.decorator.BaseIntContainer;
import io.caster.decorator.DoubleIntDecorator;
import io.caster.decorator.SimpleIntContainer;
import io.caster.designpatterns.R;

public class DecoratorActivity extends AppCompatActivity implements View.OnClickListener{
    private SimpleIntContainer decorator = init();

    @NonNull
    private BaseIntContainer init() {
        return new BaseIntContainer(1);
    }

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
        switch(v.getId()) {
            case R.id.btnDouble:
                manageDoubleDecorator();
                break;
            case R.id.btnAdd:
                manageAddDecorator();
                break;
            case R.id.fab:
                showFormattedValue();
                break;
            default:
                break;
        }
    }

    private void manageDoubleDecorator() {
        decorator = new DoubleIntDecorator(decorator);
    }

    private void manageAddDecorator() {
        decorator = new AdditionIntDecorator(decorator, seekValue.getProgress() + 1);
        seekValue.setProgress(0);
    }

    private void showFormattedValue() {
        outputText.setText(decorator.getFormattedValue());
        decorator = init();
    }
}
