package io.caster.designpatterns.chain.output;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.caster.designpatterns.R;


class ValueAdapter extends RecyclerView.Adapter<ValueViewHolder> {
    private List<Value> values = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public ValueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chain_value_item_layout, parent, false);
        return new ValueViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ValueViewHolder holder, int position) {
        holder.bindTo(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void addValue(@NonNull Value value) {
        values.add(value);
        notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(values.size() - 1);
    }
}
