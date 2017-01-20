package it.tiwiz.chain.of.responsibility;


public abstract class BaseElement<T> {
    private BaseElement<T> next;

    public void setNext(BaseElement<T> next) {
        this.next = next;
    }

    public void onRequest(T request) {
        if (canManage(request)) {
            manage(request);
        } else {
            next.onRequest(request);
        }
    }

    protected abstract void manage(T request);

    protected abstract boolean canManage(T request);
}
