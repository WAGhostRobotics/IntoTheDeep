package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.component.Intake;
import org.firstinspires.ftc.teamcode.component.OuttakeSlides;
import org.firstinspires.ftc.teamcode.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.drivetrain.MecanumDrive;

public class Jerry {
    public static HardwareMap hardwareMap;
    public static Drivetrain drivetrain;
    public static double movementPower;
    public static Intake intake;
    public static OuttakeSlides outtake;

    public static void init(HardwareMap hwMap) {
        hardwareMap = hwMap;

        drivetrain = new MecanumDrive(hwMap);

        intake = new Intake();
        intake.init(hardwareMap, true);


        outtake = new OuttakeSlides();
        outtake.init(hwMap, false);
    }
}
