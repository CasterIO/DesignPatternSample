package io.caster.designpatterns.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.caster.designpatterns.R;

public class MainView {

    public interface OnPatternSelectedListener {
        void onPatternSelected(@NonNull String[] patterns, int selectedPattern);
    }

    private final class EmptyPatternSelectedListener implements OnPatternSelectedListener {
        @Override
        public void onPatternSelected(@NonNull String[] patterns, int selectedPattern) {
            Log.d("[MainView]", "Selected Pattern: " + patterns[selectedPattern]);
        }
    }

    private final String[] patterns;
    private final OnPatternSelectedListener listener;
    private final ListView patternsList;

    public static MainView with(@NonNull final Activity target) {
        return new MainView(target);
    }

    private MainView(@NonNull final Activity target) {
        patterns = target.getResources().getStringArray(R.array.implemented_patterns);
        listener = bindListenerFrom(target);
        patternsList = target.findViewById(R.id.patternList);
    }

    private OnPatternSelectedListener bindListenerFrom(Context context) {
        if (context instanceof OnPatternSelectedListener) {
            return (OnPatternSelectedListener) context;
        } else {
            return new EmptyPatternSelectedListener();
        }
    }

    public void init() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(patternsList.getContext(), android.R.layout.simple_list_item_1, patterns);
        patternsList.setAdapter(adapter);
        patternsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onPatternSelected(patterns, position);
            }
        });
    }
}
