package com.wideweb.androidrevealhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.wideweb.revealator.RevealPosition;
import com.wideweb.revealator.Revealator;

/**
 * Created by Miko on 17.08.2016
 * for Wide-Web Company.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private AppCompatButton mRevealButton, mUnrevealButton;
    private View mRevealView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRevealButton = (AppCompatButton) findViewById(R.id.main_reveal_button);
        mUnrevealButton = (AppCompatButton) findViewById(R.id.main_unreveal_button);

        mRevealView = findViewById(R.id.main_reveal_view);

        mUnrevealButton.setOnClickListener(this);
        mRevealButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.main_reveal_button:
                Revealator.revealView(mRevealView)
                        .targetView(mRevealButton)
                        .setRevealPosition(RevealPosition.CENTER)
                        .setDuration(450)
                        .startReveal();

                break;
            case R.id.main_unreveal_button:
                Revealator.revealView(mRevealView)
                        .targetView(mUnrevealButton)
                        .setRevealPosition(RevealPosition.CENTER)
                        .setDuration(450)
                        .startUnreveal();
                break;
        }
    }
}
