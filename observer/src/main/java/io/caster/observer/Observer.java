package io.caster.observer;

interface Observer<T> {

    void onDataAvailable(T data);
}
