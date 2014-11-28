package nl.projects.mprog.npuzzle10247025.npuzzle10247025;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends ActionBarActivity {

    private static final int SLEEP_TIME_BLOCK1 = 20;
    private static final int SLEEP_TIME_BLOCK2 = 750;
    private static final int SLEEP_TIME_BLOCK3 = 1500;
    private static final int SLEEP_TIME_BLOCK4 = 2250;
    private static final int DURATION = 750;
    private static final int SCREEN_TIME = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView block1 = (ImageView) findViewById(R.id.block1);
        final ImageView block2 = (ImageView) findViewById(R.id.block2);
        final ImageView block3 = (ImageView) findViewById(R.id.block3);
        final ImageView block4 = (ImageView) findViewById(R.id.block4);

        TextView intro = (TextView) findViewById(R.id.intro);

        ObjectAnimator text_animator = ObjectAnimator.ofFloat(intro, "alpha", 0f, 1f);
        text_animator.setDuration(3000);
        intro.setVisibility(View.VISIBLE);
        text_animator.start();

        final ObjectAnimator animator = ObjectAnimator.ofFloat(block1, "alpha", 0f, 1f);
        final ObjectAnimator animator_out = ObjectAnimator.ofFloat(block1, "alpha", 1f, 0f);
        final ObjectAnimator animator_2_in = ObjectAnimator.ofFloat(block2, "alpha", 0f, 1f);
        final ObjectAnimator animator_2_out = ObjectAnimator.ofFloat(block2, "alpha", 1f, 0f);
        final ObjectAnimator animator_3_in = ObjectAnimator.ofFloat(block3, "alpha", 0f, 1f);
        final ObjectAnimator animator_3_out = ObjectAnimator.ofFloat(block3, "alpha", 1f, 0f);
        final ObjectAnimator animator_4_in = ObjectAnimator.ofFloat(block4, "alpha", 0f, 1f);
        final ObjectAnimator animator_4_out = ObjectAnimator.ofFloat(block4, "alpha", 1f, 0f);

        animator.setDuration(DURATION);
        animator_out.setDuration(DURATION);
        animator_2_in.setDuration(DURATION);
        animator_3_in.setDuration(DURATION);
        animator_4_in.setDuration(DURATION);
        animator_2_out.setDuration(DURATION);
        animator_3_out.setDuration(DURATION);
        animator_4_out.setDuration(DURATION);

        new Handler().postDelayed(new Runnable() {

            public void run() {
                animator.start();
                block1.setVisibility(View.VISIBLE);
                animator_out.start();
            }
        }, SLEEP_TIME_BLOCK1);

        new Handler().postDelayed(new Runnable() {
        @Override
            public void run() {
            animator_2_in.start();
            block2.setVisibility(View.VISIBLE);
            animator_2_out.start();
            }
        }, SLEEP_TIME_BLOCK2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animator_3_in.start();
                block3.setVisibility(View.VISIBLE);
                animator_3_out.start();
            }
        }, SLEEP_TIME_BLOCK3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animator_4_in.start();
                block4.setVisibility(View.VISIBLE);
                animator_4_out.start();
            }
        }, SLEEP_TIME_BLOCK4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, SCREEN_TIME);
    }

    @Override
    public void onBackPressed() {
        // Prevents closing the intro screen and later popping up the second activity.
    }
}
