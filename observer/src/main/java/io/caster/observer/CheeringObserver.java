package io.caster.observer;


public class CheeringObserver implements Observer<Integer>{
    @Override
    public void onDataAvailable(Integer data) {
        System.out.println("[CheeringObserver] onDataAvailable: YAY! I got a new value of " + data + "! That's great!");
    }
}
