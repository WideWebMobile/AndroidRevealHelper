package com.wideweb.revealator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import io.codetail.animation.ViewAnimationUtils;

import static com.wideweb.revealator.RevealPosition.*;
/**
 * Created by Miko on 16.07.2016
 * for Wide-Web Company.
 */
public class RevealHelper
{
    private static final int STATUS_BAR_HEIGHT = 50;
    //--------------------------------------------------------------------------------------------//
    static int[] getRevealPosition(View targetView, int reveal_position)
    {
        int x = 0;
        int y = 0;

        switch (reveal_position)
        {
            case CENTER:
                x = (targetView.getLeft() + targetView.getRight()) / 2;
                y = (targetView.getTop() + targetView.getBottom()) / 2;
                break;
            case BOTTOM_RIGHT:
                x = targetView.getRight();
                y = targetView.getBottom();
                break;
            case BOTTOM_LEFT:
                x = targetView.getLeft();
                y = targetView.getBottom();
                break;
            case BOTTOM_CENTER:
                x = (targetView.getLeft() + targetView.getRight()) / 2;
                y = targetView.getBottom();
                break;
            case TOP_RIGHT:
                x = targetView.getRight();
                y = targetView.getTop();
                break;
            case TOP_LEFT:
                x = targetView.getLeft();
                y = targetView.getTop();
                break;
            case TOP_CENTER:
                x = (targetView.getLeft() + targetView.getRight()) / 2;
                y = targetView.getTop();
                break;
        }

        return new int[]{x, y};
    }
    //--------------------------------------------------------------------------------------------//
    static void reveal(View revealView, int x, int y, float startRadius, float endRadius, long duration, long delay, RevealListener revealListener)
    {
        expand(revealView, x, y, startRadius, endRadius, duration, delay, revealListener);
    }

    private static void expand(final View revealView, int x, int y, float startRadius, float endRadius, long duration, long delay, final RevealListener revealListener)
    {
        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, startRadius, endRadius);
        anim.setDuration(duration);
        anim.setStartDelay(delay);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                revealView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(revealListener != null)
                    revealListener.onEndAnimation();
            }
        });
        anim.start();
    }
    //--------------------------------------------------------------------------------------------//
    static void unreveal(View revealView, int x, int y, float startRadius, float endRadius, long duration, long delay, RevealListener revealListener)
    {
        collapse(revealView, x, y, startRadius, endRadius, duration, delay, revealListener);
    }

    private static void collapse(final View revealView, int x, int y, float startRadius, float endRadius, long duration, long delay, final RevealListener revealListener)
    {
        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, startRadius, endRadius);
        anim.setDuration(duration);
        anim.setStartDelay(delay);
        anim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                revealView.setVisibility(View.INVISIBLE);
                if(revealListener != null)
                    revealListener.onEndAnimation();
            }
        });
        anim.start();
    }
}
