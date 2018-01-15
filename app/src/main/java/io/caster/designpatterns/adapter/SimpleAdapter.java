package io.caster.designpatterns.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.caster.designpatterns.R;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>{
    private final DataSource dataSource;

    public SimpleAdapter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_adapter_activity_element, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bindTo(dataSource.getPatterns()[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.getPatterns().length;
    }
}
