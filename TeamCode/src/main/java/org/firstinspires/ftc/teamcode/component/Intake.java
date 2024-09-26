package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {
    private final double rollerPower = 0.8;
    private Servo extendo;
    private CRServo roller;

    private ColorSensor colorSensor;

    public enum ExtensionPosition {
        RETRACTED(0), EXTENDED(0.4);
        private final double value;

        ExtensionPosition(double value) {
            this.value = value;
        }

        public double getPosition() {
            return value;
        }
    }

    public void init(HardwareMap hwMap, boolean auto) {
        roller = hwMap.get(CRServo.class, "roller");
        extendo = hwMap.get(Servo.class, "intakeSlides");
        colorSensor = hwMap.get(ColorSensor.class, "colSensor");
        extendo.setPosition(0);
    }



    public void setTargetPosition(int targetPos) { // in ticks
        extendo.setPosition(targetPos);
    }

    public double getPosition() {return extendo.getPosition();}


    public void rollerIn() {
        roller.setPower(rollerPower);
    }
    public void rollerOut() {
        roller.setPower(-rollerPower);
    }

    public String getRGB() {
        return "R: " + colorSensor.red() +
                "\n G: " + colorSensor.green() +
                "\n B: " + colorSensor.blue();
    }

}
