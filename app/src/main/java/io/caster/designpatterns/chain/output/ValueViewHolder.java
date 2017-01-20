package io.caster.designpatterns.chain.output;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.caster.designpatterns.R;

public class ValueViewHolder extends RecyclerView.ViewHolder{
    private final TextView managedIcon, unmanagedIcon, message, numbers;

    public ValueViewHolder(View itemView) {
        super(itemView);

        managedIcon = (TextView) itemView.findViewById(R.id.managedIcon);
        unmanagedIcon = (TextView) itemView.findViewById(R.id.unmanagedIcon);
        message = (TextView) itemView.findViewById(R.id.message);
        numbers = (TextView) itemView.findViewById(R.id.numbers);
    }

    public void bindTo(Value value) {
        if (value.isManaged()) {
            showManagedUi(value);
        } else {
            showUnmanagedUi(value);
        }
    }

    private void showManagedUi(Value value) {
        updateUi(View.VISIBLE, View.GONE, value);
    }

    private void showUnmanagedUi(Value value) {
        updateUi(View.GONE, View.VISIBLE, value);
    }

    private void updateUi(int managedUiVisibility, int unmanagedUiVisibility, Value value) {
        managedIcon.setVisibility(managedUiVisibility);
        unmanagedIcon.setVisibility(unmanagedUiVisibility);

        message.setText(value.getElement());
        numbers.setText(String.format("(%d,%d)", value.getManageableItem(), value.getRequestedItem()));
    }
}
