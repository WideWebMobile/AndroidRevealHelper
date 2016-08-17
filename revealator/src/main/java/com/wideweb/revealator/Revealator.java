package com.wideweb.revealator;

import android.support.annotation.NonNull;
import android.view.View;

import static com.wideweb.revealator.RevealPosition.*;
/**
 * Created by Miko on 16.07.2016
 * for Wide-Web Company.
 */
public class Revealator
{
    public static RevealBuilder revealView(@NonNull final View revealView) {
        return new RevealBuilder(revealView);
    }

    public static class RevealBuilder
    {
        private View revealView;

        private View targetView;

        private long duration = 450;

        private long delay = 0;

        private int reveal_position = CENTER;

        private RevealListener revealListener = null;

        private RevealBuilder(@NonNull final View revealView) {
            this.revealView = revealView;
        }

        public RevealBuilder targetView(@NonNull final View targetView) {
            this.targetView = targetView;
            return this;
        }

        public RevealBuilder setDuration(final long duration) {
            this.duration = duration;
            return this;
        }

        public RevealBuilder setDelay(final long delay) {
            this.delay = delay;
            return this;
        }

        public RevealBuilder setRevealPosition(final int reveal_position) {
            this.reveal_position = reveal_position;
            return this;
        }

        public RevealBuilder onEndCallback(final RevealListener revealListener) {
            this.revealListener = revealListener;
            return this;
        }

        public void startReveal()
        {
            if(this.targetView == null)
                this.targetView = this.revealView;

            final int[] xy = RevealHelper.getRevealPosition(this.targetView, this.reveal_position);

            final int x = xy[0];
            final int y = xy[1];

            final int dx = Math.max(x, this.targetView.getWidth() - x);
            final int dy = Math.max(y, this.targetView.getHeight() - y);

            final float radius = (float) Math.hypot(dx, dy);

            RevealHelper.reveal(this.revealView, x, y, 0, radius, this.duration, this.delay, this.revealListener);
        }

        public void startUnreveal()
        {
            if(this.targetView == null)
                this.targetView = this.revealView;

            final int[] xy = RevealHelper.getRevealPosition(this.targetView, this.reveal_position);

            final int x = xy[0];
            final int y = xy[1];

            final int dx = Math.max(x, this.targetView.getWidth() - x);
            final int dy = Math.max(y, this.targetView.getHeight() - y);

            final float radius = (float) Math.hypot(dx, dy);

            RevealHelper.unreveal(this.revealView, x, y, radius, 0, this.duration, this.delay, this.revealListener);
        }
    }
}
