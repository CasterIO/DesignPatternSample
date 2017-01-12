package io.caster.designpatterns.observer.output;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.caster.designpatterns.R;

class OutputViewHolder extends RecyclerView.ViewHolder {
    private final TextView observerIcon;
    private final TextView observableIcon;
    private final TextView message;

    OutputViewHolder(View itemView) {
        super(itemView);

        observableIcon = (TextView) itemView.findViewById(R.id.observableIcon);
        observerIcon = (TextView) itemView.findViewById(R.id.observerIcon);
        message = (TextView) itemView.findViewById(R.id.message);
    }

    void bindTo(OutputModel model) {
        if (model.isObservable()) {
            observerIcon.setVisibility(View.GONE);
            observableIcon.setVisibility(View.VISIBLE);
        } else {
            observableIcon.setVisibility(View.GONE);
            observerIcon.setVisibility(View.VISIBLE);
        }

        message.setText(model.getMessage());
    }
}
