package io.caster.observer;

interface Observable<T> {

    void addObserver(Observer<T> observer);
}
