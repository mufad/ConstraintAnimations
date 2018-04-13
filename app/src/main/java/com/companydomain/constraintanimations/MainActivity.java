package com.companydomain.constraintanimations;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout root;
    private ImageView ivAndroid;

    boolean set = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        animate();
    }


    private void initViews() {
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);
        ivAndroid = findViewById(R.id.iv_android);
    }

    private void animate() {

        final ConstraintSet constraintSetOne = new ConstraintSet();
        final ConstraintSet constraintSetTwo = new ConstraintSet();


        constraintSetOne.clone(root);
        constraintSetTwo.clone(this, R.layout.activity_main_alternative);
        ivAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(root);

                if (set) {
                    constraintSetTwo.applyTo(root);
                    set = !set;
                } else {
                    constraintSetOne.applyTo(root);
                    set = !set;
                }
            }
        });
    }
}
