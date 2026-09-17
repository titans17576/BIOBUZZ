package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.lib.Alliance;

/**
 * A wrapper around TeleopBase for the red alliance
 * Most edits should go in the TeleopBase class, so it makes changing teleop simple
 */
@TeleOp(name="Red Teleop")
public class TeleopRed extends OpMode {
    private TeleopBase teleop;

    @Override
    public void init() {
        teleop = new TeleopBase(Alliance.RED, this);
        teleop.init();
    }

    @Override
    public void init_loop() {
        teleop.init_loop();
    }

    @Override
    public void loop() {
        teleop.loop();
    }

    @Override
    public void start() {
        teleop.start();
    }

    @Override
    public void stop() {
        teleop.stop();
    }
}
