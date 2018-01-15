package io.caster.designpatterns.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.caster.designpatterns.R;

public class AdapterActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView patternList;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        patternList = findViewById(R.id.patternList);
        layoutManager = new LinearLayoutManager(this);

        patternList.setLayoutManager(layoutManager);

        createDataSource();
    }

    private void createDataSource() {
        DataSource source = new DataSource(this);
        SimpleAdapter adapter = new SimpleAdapter(source);

        patternList.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLmLinear) {
            updateTo(new LinearLayoutManager(this));
        } else {
            updateTo(new GridLayoutManager(this, 2));
        }
    }

    private void updateTo(RecyclerView.LayoutManager newLayoutManager) {
        patternList.setLayoutManager(newLayoutManager);
    }
}
