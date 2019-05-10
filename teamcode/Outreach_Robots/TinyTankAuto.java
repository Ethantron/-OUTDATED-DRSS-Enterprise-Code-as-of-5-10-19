package org.firstinspires.ftc.teamcode.Outreach_Robots;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "TinyTankAuto", group= "Outreach_Robots")
public class TinyTankAuto extends LinearOpMode {
    double step = 0;
    Servo Servoleft;
    Servo Servoright;
    DcMotor Light;
    Servo Pan;
    Servo Tilt;

    public void runOpMode() {

        Servoleft = hardwareMap.servo.get("Servoleft");
        Servoleft.setDirection(Servo.Direction.FORWARD);

        Servoright = hardwareMap.servo.get("Servoright");
        Servoright.setDirection(Servo.Direction.FORWARD);

        Light = hardwareMap.dcMotor.get("RedLight");
        Light.setDirection(DcMotorSimple.Direction.FORWARD);

        Pan = hardwareMap.servo.get("Pan"); //Continuous Rotation Servo
        Tilt = hardwareMap.servo.get("Tilt"); //180 Degree Servo

        Tilt.setPosition(0.5); //Sets servo into "Zero" position
        Pan.setPosition(0.5);
        Servoright.setPosition(0.5);
        Servoleft.setPosition(0.5);
        Light.setPower(-1);

        waitForStart();

        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();
        go();

    }
    public void go(){
        //Square
        /*if (step == 0) { //States that if step = 0, then run this
            Servoleft.setPosition(0);//Set Left Motor to full Power
            Servoright.setPosition(0);//Set Right Motor to full Power
            sleep(3500); //Wait for robot to move to position
            Servoleft.setPosition(.45); //Set Left Motor to partial power to prevent dragging
            Servoright.setPosition(0); //Set Right Motor to full Power
            sleep(2200); //Wait for robot to move to position
            step++; //Move to step 1
        }

        if (step == 1) { //States that if step = 1, then run this
            sleep(1); //Wait 1 millisecond
            step = 0; //Set to step 0, restart loop
        } */

        //Spiral
        if (step == 0) {
            Servoleft.setPosition(0);
            Servoright.setPosition(.35);
            sleep(1000000);
            step++;
        }

        if (step == 1) {
            sleep(1);
            step = 0;
        }



    }
}
