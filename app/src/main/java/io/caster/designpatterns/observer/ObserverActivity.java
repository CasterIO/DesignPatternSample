package io.caster.designpatterns.observer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

import io.caster.designpatterns.R;
import io.caster.designpatterns.observer.output.OutputManager;
import io.caster.designpatterns.observer.output.OutputMessageUtils;
import io.caster.observer.Observer;
import io.caster.observer.SimpleObservable;

public class ObserverActivity extends AppCompatActivity implements ActionSelectedListener{
    private SimpleObservable observable = new SimpleObservable();
    private OutputManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        manager = OutputManager.with(this);
        ActionManager.with(this);
    }

    @Override
    public void onAddObserverSelected() {
        manager.onAddObserverSelected();
        observable.addObserver(new Observer<Integer>() {
            @Override
            public void onDataAvailable(Integer data) {
                printMessage(OutputMessageUtils.elaborateMessageFrom(this, data));
            }
        });
    }

    private void printMessage(String message) {
        manager.printMessage(message);
    }

    @Override
    public void onNotifyObserversSelected() {
        manager.onNotifyObserversSelected();
        observable.notifyObservers();
    }

    @Override
    public void onClearObserversSelected() {
        manager.onClearObserversSelected();
        observable = new SimpleObservable();
    }
}
