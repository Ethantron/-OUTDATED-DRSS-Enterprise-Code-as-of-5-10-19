package org.firstinspires.ftc.teamcode.Season_Robots.Tests.WIP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "New Camera Test", group= "team")
public class New_Camera_Test extends OpMode {
    Servo Pan;

    public void init(){
        Pan = hardwareMap.servo.get("Pan");
        Pan.setPosition(0.5);
    }

    public void loop(){
        if (gamepad1.dpad_up){
            Pan.setPosition(.5);
        }
        if (gamepad1.dpad_left){
            Pan.setPosition(1);
        }
        if (gamepad1.dpad_right){
            Pan.setPosition(0);
        }
    }
}