package io.caster.designpatterns.chain;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Locale;

import io.caster.designpatterns.utils.MemoryUtils;
import it.tiwiz.chain.of.responsibility.BaseElement;

public class ActivityChainElement extends BaseElement<Integer>{
    private final int managedPattern;
    private final Intent patternIntent;
    private final AppCompatActivity host;

    private static final String TAG ="[" + ActivityChainElement.class.getSimpleName() + "]";
    private static final String MESSAGE_TEMPLATE = "[%s] manages [%d]";

    public ActivityChainElement(int managedPattern,
                                Intent patternIntent,
                                AppCompatActivity host) {

        this.managedPattern = managedPattern;
        this.patternIntent = patternIntent;
        this.host = host;
    }

    @Override
    protected boolean canManage(Integer request) {
        return request == managedPattern;
    }

    @Override
    protected void manage(Integer request) {
        Log.d(TAG, String.format(Locale.getDefault(), MESSAGE_TEMPLATE, MemoryUtils.findMemoryAddressOf(this), request));
        host.startActivity(patternIntent);
    }
}
