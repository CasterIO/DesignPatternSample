package io.caster.designpatterns.observer.output;

class OutputModel {
    private final boolean isObservable;
    private final String message;

    private OutputModel(boolean isObservable, String message) {
        this.isObservable = isObservable;
        this.message = message;
    }

    boolean isObservable() {
        return isObservable;
    }

    String getMessage() {
        return message;
    }

    static OutputModel forNotifyingObservers() {
        return new OutputModel(true, "Notify Observers");
    }

    static OutputModel forClearingObservers() {
        return new OutputModel(true, "Clearing Observers");
    }

    static OutputModel forAddingObserver() {
        return new OutputModel(true, "Adding Observer");
    }

    static OutputModel forObserverUpdate(String message) {
        return new OutputModel(false, message);
    }
}
