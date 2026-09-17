package org.firstinspires.ftc.teamcode.lib.fsm;

import java.util.function.Supplier;

/**
 * from 23641 Cuberobot
 * Represents a condition that blocks a state from finishing while it is not true
 */
public class Transition {
    private boolean finished = false;
    private final Supplier<Boolean> condition;
    private final String nextStateName;

    public Transition(Supplier<Boolean> condition, String nextStateName) {
        this.condition = condition;
        this.nextStateName = nextStateName;
    }

    public Transition(Supplier<Boolean> condition) {
        this(condition, null);
    }

    public void start() {
        finished = false;
    }

    public String getNextState() {
        return nextStateName;
    }

    /**
     * Evaluates the condition and returns if finished
     * @return true, if the condition is or has ever been true. false otherwise
     */
    public boolean checkFinished() {
        if (!finished) {
            finished = condition.get();
        }
        return finished;
    }
}

