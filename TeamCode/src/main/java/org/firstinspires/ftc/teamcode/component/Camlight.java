package org.firstinspires.ftc.teamcode.component;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class Camlight {
    private Limelight3A limelight;
    public void init(HardwareMap hwMap) {
        limelight = hwMap.get(Limelight3A.class, "limelight");
//        telemetry.setMsTransmissionInterval(11); // Idk if we needs this
        limelight.pipelineSwitch(0); // or this3
        limelight.start();
    }

    public Pose3D getRobotPose() {
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            return result.getBotpose();
        }
        return null;
    }
}
