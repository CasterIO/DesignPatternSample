package io.caster.observer;


public class SimpleObserver implements Observer<Integer>{

    @Override
    public void onDataAvailable(Integer data) {
        System.out.println("[SimpleObserver] onDataAvailable: " + data);
    }
}
