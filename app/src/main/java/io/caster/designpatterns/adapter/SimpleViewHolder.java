package io.caster.designpatterns.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    public SimpleViewHolder(View itemView) {
        super(itemView);
    }

    public void bindTo(String pattern) {
        ((TextView) itemView).setText(pattern);
    }
}
