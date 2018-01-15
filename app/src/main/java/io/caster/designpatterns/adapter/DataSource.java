package io.caster.designpatterns.adapter;


import android.content.Context;
import io.caster.designpatterns.R;

public class DataSource {

    private final String[] patterns;

    public DataSource(Context context) {
        patterns = context.getResources().getStringArray(R.array.implemented_patterns);
    }

    public String[] getPatterns() {
        return patterns;
    }
}
