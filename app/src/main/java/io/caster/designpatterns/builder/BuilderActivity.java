package io.caster.designpatterns.builder;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import io.caster.designpatterns.R;

public class BuilderActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private EditText alertTitle;
    private RadioButton contentView, messageString;
    private Switch cancelable;
    private CheckBox positiveButton, negativeButton, neutralButton;

    private AlertDialog.Builder builder;

    private final DialogInterface.OnClickListener doNothingClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        setUpToolbar();

        builder = new AlertDialog.Builder(this);
        alertTitle = (EditText) findViewById(R.id.alertTitle);
        contentView = (RadioButton) findViewById(R.id.contentView);
        messageString = (RadioButton) findViewById(R.id.messageString);
        cancelable = (Switch) findViewById(R.id.cancelable);
        cancelable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCancelableStateChanged(isChecked);
            }
        });

        positiveButton = (CheckBox) findViewById(R.id.positiveButton);
        negativeButton = (CheckBox) findViewById(R.id.negativeButton);
        neutralButton = (CheckBox) findViewById(R.id.neutralButton);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFabClicked();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        cancelable.setChecked(true);
        alertTitle.setText(R.string.builder);
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void onCancelableStateChanged(boolean isChecked) {
        builder.setCancelable(isChecked);
    }

    private void onFabClicked() {
        if (contentView.isChecked()) {
            builder.setView(R.layout.custom_alert_dialog_view);
            builder.setMessage("");
        } else if (messageString.isChecked()) {
            builder.setMessage("Message from BuilderActivity");
            builder.setView(null);
        }

        if (positiveButton.isChecked()) {
            builder.setPositiveButton(R.string.builder_alert_positive_button_label, doNothingClickListener);
        }

        if (neutralButton.isChecked()) {
            builder.setNeutralButton(R.string.builder_alert_neutral_button_label, doNothingClickListener);
        }

        if (negativeButton.isChecked()) {
            builder.setNegativeButton(R.string.builder_alert_negative_button_label, doNothingClickListener);
        }

        builder.setTitle(alertTitle.getText().toString())
                .show();
    }

}
