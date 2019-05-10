
//The code that is required for the robot to be identified and function.

package org.firstinspires.ftc.teamcode.Outreach_Robots;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.Math.abs;


@TeleOp(name = "Tiny_Tank", group= "team")
public class Tiny_Tank extends OpMode {

    //Introduces the programmable parts of the robot and sets different variables.

    Servo Servoleft;
    Servo Servoright;
    DcMotor Light;
    Servo Pan;
    Servo Tilt;
    // DcMotor Relay;
    double TiltActive = 1;
    double relayset = 0;
    double step = 0;
    double slowtggl = 0;
  //  double slewrate = 0.1;

    //Initializes the different movable parts of the robot and sets the direction.

    public void init() {
        Servoleft = hardwareMap.servo.get("Servoleft");
        Servoleft.setDirection(Servo.Direction.FORWARD);

        Servoright = hardwareMap.servo.get("Servoright");
        Servoright.setDirection(Servo.Direction.FORWARD);

        Light = hardwareMap.dcMotor.get("RedLight");
        Light.setDirection(DcMotorSimple.Direction.FORWARD);

        //  Relay = hardwareMap.dcMotor.get("Relay");
        //  Relay.setDirection(DcMotorSimple.Direction.FORWARD);

        Pan = hardwareMap.servo.get("Pan"); //Continuous Rotation Servo
        Tilt = hardwareMap.servo.get("Tilt"); //180 Degree Servo

        Tilt.setPosition(0.5); //Sets servo into "Zero" position
        Pan.setPosition(0.5);
        Servoright.setPosition(0.5);
        Servoleft.setPosition(0.5);
    //    TiltActive = 1;


    }

    //Start of the actual code.

    public void loop() {

        //Sets the relay's power to speed.

        //  Relay.setPower(relayset);

        //Allows you to press one button to turn on or off the relay.

    /*    if (currentstep == 0){
            if (gamepad1.a){
                Relay.setPower(relayset = 1);
                currentstep ++;
            }
        }

        if (currentstep == 1){
            if(gamepad1.a){
                Relay.setPower(relayset = 0);
                currentstep --;
            }
        }*/

        //The code that allows the wheels to be controlled by the joysticks on the controllers.

        double joy = gamepad1.left_stick_y;
        double Valadjust = (joy * joy * joy) / 2 + 0.5;
        double Joy = gamepad1.right_stick_y;
        double ValAdjust = (Joy * Joy * Joy) / 2 + 0.5;

      //  Servoright.setPosition(ValAdjust);
      //  Servoleft.setPosition(Valadjust);

   /*     double slew (Servoright.getPosition(), Valadjust, slewrate){
            if (slewrate < (abs(Servoright.getPosition() - Valadjust))) {
                if (Servoright.getPosition() - Valadjust < 0) return (Servoright.getPosition() + slewrate);
                else return (Servoright.getPosition() - slewrate);
            }
            else return Valadjust;
        } */
   if (gamepad1.left_bumper && slowtggl == 0){
       slowtggl = 1;
   }
   else if (gamepad1.left_bumper && slowtggl == 1){
       slowtggl = 0;
   }


       if (slowtggl == 0) {
           //Right Wheel
           double Rightup = abs(Servoright.getPosition() + 0.0075); //0.0075 is the rate that the speed is changed at per frame
           double Rightdown = abs(Servoright.getPosition() - 0.0075);
           if (Servoright.getPosition() < Valadjust) {
               Servoright.setPosition(Rightup);
           }
           if (Servoright.getPosition() > Valadjust) {
               Servoright.setPosition(Rightdown);
           } else if (!(Servoright.getPosition() < Valadjust) && !(Servoright.getPosition() > Valadjust) && gamepad1.right_trigger <= 0.3) {
               Servoright.setPosition(Valadjust);
           }

           //Left Wheel
           double Leftup = abs(Servoleft.getPosition() + 0.0075);
           double Leftdown = abs(Servoleft.getPosition() - 0.0075);
           if (Servoleft.getPosition() < ValAdjust) {
               Servoleft.setPosition(Leftup);
           }
           if (Servoleft.getPosition() > ValAdjust) {
               Servoleft.setPosition(Leftdown);
           }

           if (gamepad1.right_trigger > .3) {
               Servoleft.setPosition(0.5);
               Servoright.setPosition(0.5);
           } else if (!(Servoleft.getPosition() < ValAdjust) && !(Servoleft.getPosition() > ValAdjust) && gamepad1.right_trigger <= 0.3) {
               Servoleft.setPosition(ValAdjust);
           }
       }
       else if (slowtggl == 1){
           Servoleft.setPosition(ValAdjust);
           Servoright.setPosition(Valadjust);
       }

        if (joy < 0 || joy > 0 || Joy < 0 || Joy > 0) {
            Light.setPower(-1);
        }
        else {
            Light.setPower(0);
        }

        if (gamepad1.dpad_down){
            Tilt.setPosition(.75);
        }
        if (gamepad1.dpad_up){
            Tilt.setPosition(.25);
        }
        if (gamepad1.a){
            Tilt.setPosition(.51);
        }
        if (gamepad1.dpad_right){
            Pan.setPosition(1);
        }
        if (gamepad1.dpad_left){
            Pan.setPosition(0);
        }
        else if (!gamepad1.dpad_left && !gamepad1.dpad_right){
            Pan.setPosition(.5);
        }

        if (slowtggl == 0) {
            telemetry.addData("Slow mode:", "on");
        }
        if (slowtggl == 1) {
            telemetry.addData("Slow mode:", "off");
        }
    }
}