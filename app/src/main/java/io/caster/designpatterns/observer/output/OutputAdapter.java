package io.caster.designpatterns.observer.output;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.caster.designpatterns.R;

class OutputAdapter extends RecyclerView.Adapter<OutputViewHolder>{
    private List<OutputModel> models = new ArrayList<>();
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
    public OutputViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.observer_output_item_layout, parent, false);
        return new OutputViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(OutputViewHolder holder, int position) {
        holder.bindTo(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    private void addNewElement(OutputModel newModel) {
        models.add(newModel);
        notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(models.size() - 1);
    }

    void addNotifyingObserversEvent() {
        addNewElement(OutputModel.forNotifyingObservers());
    }

    void addClearingObserversEvent() {
        addNewElement(OutputModel.forClearingObservers());
    }

    void onObserverUpdateEvent(String message) {
        addNewElement(OutputModel.forObserverUpdate(message));
    }

    void addObserverEvent() {
        addNewElement(OutputModel.forAddingObserver());
    }

}
