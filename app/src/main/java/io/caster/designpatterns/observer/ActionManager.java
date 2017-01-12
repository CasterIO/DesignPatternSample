package io.caster.designpatterns.observer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.caster.designpatterns.R;

class ActionManager implements Toolbar.OnMenuItemClickListener {
    private final ActionSelectedListener listener;

    static ActionManager with(@NonNull final Activity target) {
        return new ActionManager(target);
    }

    private ActionManager(final Activity target) {
        this.listener = bindListenerTo(target);
        manageToolbar(target);
    }

    private ActionSelectedListener bindListenerTo(Activity target) {
        if (target instanceof ActionSelectedListener) {
            return (ActionSelectedListener) target;
        } else {
            return new EmptyActionSelectedListener();
        }
    }

    private void manageToolbar(Activity target) {
        final Toolbar toolbar = (Toolbar) target.findViewById(R.id.actions);
        toolbar.inflateMenu(R.menu.observer_menu);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addSimpleObserver:
                listener.onAddObserverSelected();
                break;
            case R.id.notifyObservers:
                listener.onNotifyObserversSelected();
                break;
            case R.id.clearObservers:
            default:
                listener.onClearObserversSelected();
                break;
        }
        return true;
    }
}
