package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.lib.fsm.State;
import org.firstinspires.ftc.teamcode.lib.fsm.StateMachine;

/**
 * Shows how to use StateMachine
 */
@Autonomous(name="Test")
public class TestAuton extends OpMode {

    private static StateMachine stateMachine;

    static {
        stateMachine = new StateMachine(
                new State()
        );
    }


    @Override
    public void init() {

    }

    @Override
    public void loop() {
        stateMachine.update();
    }
}
