package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    private Servo arm;
    private Servo microDump;

    public enum ArmPos {
        LOAD(0), DUMP(0.4);
        private final double pos;

        ArmPos(double val) {
            this.pos = val;
        }

        public double getTicks() {
            return pos;
        }
    }
    private double armPos;
    private double dumpPos;

    public void init(HardwareMap hwMap) {
        arm = hwMap.get(Servo.class, "arm");
        microDump = hwMap.get(Servo.class, "microDump");
        arm.setPosition(0);
        microDump.setPosition(0);
    }

    public void liftArm() {
        armPos+=0.001;
        setArmPosition();
    }
    public void lowerArm() {
        armPos-=0.001;
        setArmPosition();
    }

    public void liftDump() {
        dumpPos+=0.001;
        setDumpPosition();
    }

    public void lowerDump() {
        dumpPos-=0.001;
        setDumpPosition();
    }

    private void setArmPosition() {
        arm.setPosition(armPos);
    }

    private void setDumpPosition() {
        microDump.setPosition(dumpPos);
    }
}
