package io.caster.observer;


import java.util.ArrayList;
import java.util.List;

public class SimpleObservable implements Observable<Integer>{
    private List<Observer<Integer>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<Integer> observer) {
        observers.add(observer);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
           for (Observer<Integer> observer : observers) {
               observer.onDataAvailable(i);
           }
        }
    }
}
