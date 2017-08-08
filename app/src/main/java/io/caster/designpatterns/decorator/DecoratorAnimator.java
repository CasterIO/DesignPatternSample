package io.caster.designpatterns.decorator;


import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.TransitionManager;
import android.view.View;

public class DecoratorAnimator {

    private final ConstraintLayout root;
    private final Group sizeGroup, coffeeGroup, toppingGroup;
    private final FloatingActionButton showIngredients;

    public DecoratorAnimator(ConstraintLayout root,
                             Group sizeGroup,
                             Group coffeeGroup,
                             Group toppingGroup, FloatingActionButton showIngredients) {
        this.root = root;
        this.sizeGroup = sizeGroup;
        this.coffeeGroup = coffeeGroup;
        this.toppingGroup = toppingGroup;
        this.showIngredients = showIngredients;
    }

    public void showSize() {
        TransitionManager.beginDelayedTransition(root);
        sizeGroup.setVisibility(View.VISIBLE);
        coffeeGroup.setVisibility(View.GONE);
        toppingGroup.setVisibility(View.GONE);
        showIngredients.hide();
    }

    public void showCoffee() {
        TransitionManager.beginDelayedTransition(root);
        sizeGroup.setVisibility(View.GONE);
        coffeeGroup.setVisibility(View.VISIBLE);
        toppingGroup.setVisibility(View.GONE);
    }

    public void showToppings() {
        TransitionManager.beginDelayedTransition(root);
        sizeGroup.setVisibility(View.GONE);
        coffeeGroup.setVisibility(View.GONE);
        toppingGroup.setVisibility(View.VISIBLE);
        showIngredients.show();
    }
}
