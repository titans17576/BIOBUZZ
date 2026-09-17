package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.Robot;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.lib.Alliance;

public class TeleopBase {

    private final Robot robot;
    private Follower follower;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final Gamepad gamepad1; // Only one gamepad, we only need one right?

    public TeleopBase(Alliance alliance, OpMode opMode) {
        this.telemetry = opMode.telemetry;
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad1 = opMode.gamepad1;
        this.robot = new Robot(alliance);
    }

    /**
     * This method is call once when init is played, it initializes the follower
     **/
    public void init() {
        robot.init(hardwareMap);
        follower = Constants.create(hardwareMap);
    }

    /**
     * This method is called continuously after Init while waiting to be started.
     **/
    public void init_loop() {

    }

    /**
     * This method is called once at the start of the OpMode.
     **/
    public void start() {

    }

    /**
     * This is the main loop of the opmode and runs continuously after play
     **/
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double lateral = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        follower.manual(forward, lateral, turn);
        follower.update();

        robot.update();

        telemetry.addData("team", robot.alliance);
        telemetry.update();
    }

    /**
     * Called once at the end of the OpMode
     */
    public void stop() {

    }
}
