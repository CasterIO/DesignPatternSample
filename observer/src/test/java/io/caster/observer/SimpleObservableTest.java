package io.caster.observer;

import org.junit.Test;

public class SimpleObservableTest {

    @Test
    public void settingMoreObserversTriggersThemAll() throws Exception {
        Observable<Integer> observable = new SimpleObservable();
        Observer<Integer> simpleObserver = new SimpleObserver();
        Observer<Integer> cheeringObserver = new CheeringObserver();

        observable.addObserver(simpleObserver);
        observable.addObserver(cheeringObserver);
        observable.notifyObservers();
    }
}