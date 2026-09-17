package org.firstinspires.ftc.teamcode.lib.fsm;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * from 23641 Cuberobot
 * A step in a state machine
 * Times are set in seconds
 */
public class State {
    private final List<Transition> transitions = new ArrayList<>();
    private final String name;
    private boolean finished = false;
    private Runnable entryRunnable;
    private Runnable updateRunnable;
    private Runnable exitRunnable;
    private double minTime = 0;
    private double maxTime = Double.POSITIVE_INFINITY;
    private String nextState; // fallback or transition result
    private final ElapsedTime timer = new ElapsedTime();

    public State() {
        this.name = null;
    }

    public State(String name) {
        this.name = name;
    }

    public void start() {
        timer.reset();
        finished = false;
        for (Transition transition : transitions) {
            transition.start();
        }
        if (entryRunnable != null) entryRunnable.run();
    }

    public void run() {
        if (finished) return;

        if (updateRunnable != null) updateRunnable.run();

        for (Transition transition : transitions) {
            if (transition.checkFinished() && timer.time(TimeUnit.SECONDS) >= minTime) {
                nextState = transition.getNextState();
                finish();
                return;
            }
        }

        if (timer.time(TimeUnit.SECONDS) >= maxTime) finish();
    }

    private void finish() {
        if (exitRunnable != null) exitRunnable.run();
        finished = true;
    }

    public State transition(Transition transition) {
        transitions.add(transition);
        return this;
    }

    public State onEnter(Runnable runnable) {
        this.entryRunnable = runnable;
        return this;
    }

    public State whileRunning(Runnable runnable) {
        this.updateRunnable = runnable;
        return this;
    }

    public State onExit(Runnable runnable) {
        this.exitRunnable = runnable;
        return this;
    }

    public State minTime(double minTime) {
        this.minTime = minTime;
        return this;
    }

    public State maxTime(double maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    public State fallbackState(String fallbackState) {
        if (fallbackState == null) throw new IllegalArgumentException("Fallback state cannot be null");
        this.nextState = fallbackState;
        return this;
    }

    public String getNextState() {
        return nextState;
    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return finished;
    }
}
