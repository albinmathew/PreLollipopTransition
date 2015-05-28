package com.albinmathew.transitions;

import android.app.Activity;

import com.albinmathew.transitions.core.MoveData;
import com.albinmathew.transitions.core.TransitionAnimation;

public class ExitActivityTransition {
    private final MoveData moveData;


    public ExitActivityTransition(MoveData moveData) {
        this.moveData = moveData;
    }

    public void exit(final Activity activity) {
        TransitionAnimation.startExitAnimation(moveData, new Runnable() {
            @Override
            public void run() {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        });
    }

}
