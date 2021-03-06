package org.firstinspires.ftc.teamcode.teamcode.OpModes.OneTimeOp;


import com.qualcomm.robotcore.hardware.DcMotor;
import system.robot.Robot;
import system.robot.SubSystem;

public class MotorTest extends SubSystem {

    /**
     * Constructor for subsystem.
     *
     * @param robot - The robot the subsystem is contained within.
     */
    public MotorTest(Robot robot) {
        super(robot);
    }

    DcMotor motor1;

    @Override
    public void init()  {
        motor1 = robot.hardwareMap.dcMotor.get("1");
    }

    @Override
    public void init_loop()  {

    }

    @Override
    public void start()  {

    }

    @Override
    public void handle()  {
        if(robot.gamepad1.a){
            motor1.setPower(1);
        }
        else if(robot.gamepad1.b){
            motor1.setPower(.3);
        }
        else if(robot.gamepad1.y){
            motor1.setPower(-1);
        }
        else if(robot.gamepad1.x){
            motor1.setPower(-.3);
        }
        else{
            motor1.setPower(0);
        }
    }

    @Override
    public void stop()  {

    }
}
