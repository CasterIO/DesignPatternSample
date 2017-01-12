package io.caster.observer;

public interface Observer<T> {

    void onDataAvailable(T data);
}
