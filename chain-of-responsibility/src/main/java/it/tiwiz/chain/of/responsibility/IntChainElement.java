package it.tiwiz.chain.of.responsibility;


import android.support.annotation.NonNull;
import android.util.Log;

public class IntChainElement extends BaseElement<Integer>{
    private static final String TAG = "[" + IntChainElement.class.getSimpleName() + "]";
    private final int managedRequest;

    public IntChainElement(int managedRequest) {
        this.managedRequest = managedRequest;
    }

    @Override
    protected void manage(Integer request) {
        String message = getMemoryAddress() + " managing request " + request;
        Log.d(TAG, message);
    }

    @Override
    protected boolean canManage(Integer request) {
        return request == managedRequest;
    }

    @NonNull
    private String getMemoryAddress() {
        String fullName = this.toString();
        int atPosition = fullName.indexOf("@") + 1;
        return fullName.substring(atPosition);
    }
}
