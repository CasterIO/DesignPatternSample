package io.caster.designpatterns.observer.output;


import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.caster.designpatterns.R;
import io.caster.designpatterns.observer.ObserverActivity;

public class OutputManager {
    private final OutputAdapter adapter = new OutputAdapter();

    public static OutputManager with(@NonNull ObserverActivity target) {
        RecyclerView list = (RecyclerView) target.findViewById(R.id.outputList);
        return new OutputManager(list);
    }

    private OutputManager(RecyclerView outputList) {
        outputList.setLayoutManager(new LinearLayoutManager(outputList.getContext()));
        outputList.setAdapter(adapter);
    }

    public void onNotifyObserversSelected() {
        adapter.addNotifyingObserversEvent();
    }

    public void onClearObserversSelected() {
        adapter.addClearingObserversEvent();
    }

    public void printMessage(@NonNull String message) {
        adapter.onObserverUpdateEvent(message);
    }

    public void onAddObserverSelected() {
        adapter.addObserverEvent();
    }

}
