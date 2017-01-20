package io.caster.designpatterns.chain.output;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import io.caster.designpatterns.R;

public class ValueManager implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{
    private final SeekBar seekBar;
    private final TextView outputText;
    private final ValueCallback callback;

    public static ValueManager with(@NonNull AppCompatActivity target) {
        return new ValueManager(target);
    }

    private ValueManager(@NonNull AppCompatActivity target) {
        callback = bindCallbackFrom(target);
        outputText = (TextView) target.findViewById(R.id.seekbarValue);
        seekBar = ((SeekBar) target.findViewById(R.id.seekbar));

        target.findViewById(R.id.sendNewValueButton).setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
    }

    public void init() {
        outputText.setText(String.valueOf(0));
    }

    private ValueCallback bindCallbackFrom(AppCompatActivity target) {
        if (target instanceof ValueCallback) {
            return (ValueCallback) target;
        } else {
            return new EmptyValueCallback();
        }
    }

    @Override
    public void onClick(View v) {
        callback.onNewValueSelected(seekBar.getProgress());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        outputText.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
