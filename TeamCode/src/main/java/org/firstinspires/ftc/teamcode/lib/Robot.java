package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Subsystem;

import java.util.ArrayList;

/**
 * Basically a container for all the robot information and subsystems to be initialized and updated easier
 */
public class Robot {
    public final Alliance alliance;
    private ArrayList<Subsystem> subsystems;

    public Robot(Alliance alliance) {
        this.alliance = alliance;
    }

    public void init(HardwareMap h) {
        for (Subsystem subsystem : subsystems) {
            subsystem.init(h);
        }
    }

    public void update() {
        for (Subsystem subsystem : subsystems) {
            subsystem.update();
        }
    }
}
