package io.caster.designpatterns.chain.output;


import android.support.annotation.NonNull;

interface OutputCallback {

    void onNewValueReceived(@NonNull Value value);
}
