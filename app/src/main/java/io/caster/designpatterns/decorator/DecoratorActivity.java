package io.caster.designpatterns.decorator;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import io.caster.decorator.Size;
import io.caster.designpatterns.R;

public class DecoratorActivity extends AppCompatActivity
        implements View.OnClickListener, RadioButton.OnCheckedChangeListener {

    private final DecoratorPresenter decoratorPresenter = new DecoratorPresenter();
    private DecoratorAnimator animator;

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        setupToolbar();
        setupUI();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupUI() {
        bindRadio(R.id.radio_size_xs);
        bindRadio(R.id.radio_size_s);
        bindRadio(R.id.radio_size_m);
        bindRadio(R.id.radio_size_l);
        bindRadio(R.id.radio_size_xl);

        bind(R.id.btnCoffee);
        bind(R.id.btnArabicCoffee);
        bind(R.id.toppingAlmondMilk);
        bind(R.id.toppingCaramel);
        bind(R.id.toppingChocolate);
        bind(R.id.toppingCream);
        bind(R.id.fab);
        bind(R.id.clear_button);

        animator = new DecoratorAnimator((ConstraintLayout) findViewById(R.id.rootView),
                (Group) findViewById(R.id.size_group),
                (Group) findViewById(R.id.coffee_group),
                (Group) findViewById(R.id.toppings_group),
                (FloatingActionButton) findViewById(R.id.fab));

        output = findViewById(R.id.price_recap);
    }

    @Override
    protected void onResume() {
        super.onResume();
        animator.showSize();
    }

    private void bindRadio(@IdRes int id) {
        ((RadioButton) findViewById(id)).setOnCheckedChangeListener(this);
    }

    private void bind(@IdRes int id) {
        findViewById(id).setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Size size;

        switch (compoundButton.getId()) {
            case R.id.radio_size_xs:
                size = Size.XS;
                break;
            case R.id.radio_size_s:
                size = Size.S;
                break;
            case R.id.radio_size_m:
                size = Size.M;
                break;
            case R.id.radio_size_l:
                size = Size.L;
                break;
            case R.id.radio_size_xl:
                size = Size.XL;
                break;
            default:
                throw new IllegalArgumentException("Size not supported!");
        }

        decoratorPresenter.pickSize(size);
        animator.showCoffee();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnCoffee:
                decoratorPresenter.pickCoffee();
                animator.showToppings();
                break;
            case R.id.btnArabicCoffee:
                decoratorPresenter.pickArabicCoffee();
                animator.showToppings();
                break;
            case R.id.toppingAlmondMilk:
                decoratorPresenter.addAlmondMilk();
                break;
            case R.id.toppingCaramel:
                decoratorPresenter.addCaramel();
                break;
            case R.id.toppingChocolate:
                decoratorPresenter.addChocolate();
                break;
            case R.id.toppingCream:
                decoratorPresenter.addCream();
                break;
            case R.id.fab:
                output.setText(decoratorPresenter.getCoffeeDescription());
                break;
            case R.id.clear_button:
                decoratorPresenter.clear();
                animator.showSize();
                output.setText("");
                break;
            default:
                throw new IllegalArgumentException("Coffee or topping not supported!");
        }
    }
}
