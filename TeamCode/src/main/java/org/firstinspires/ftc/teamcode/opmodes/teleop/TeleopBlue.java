package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.lib.Alliance;

/**
 * A wrapper around TeleopBase for the blue alliance
 * Most edits should go in the TeleopBase class, so it makes changing teleop simple
 */
@TeleOp(name="Blue Teleop")
public class TeleopBlue extends OpMode {
    private TeleopBase teleop;

    @Override
    public void init() {
        teleop = new TeleopBase(Alliance.BLUE, this);
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
