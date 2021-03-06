package org.firstinspires.ftc.teamcode.teamcode.Subsystems.ForMainRobot;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import system.config.ConfigParam;
import system.config.TeleopConfig;
import system.gui.menus.TelemetryMenu;
import system.robot.Robot;
import system.robot.SubSystem;
import util.control.Button;
import util.control.CustomizableGamepad;
import util.control.Toggle;

public class FoundationGrabberSubsystem extends SubSystem {

    private final String ARMBUTTON = "armToggleButton";
    private final String ARMUPBUTTON = "armUpButton";
    Servo armL;
    CRServo arm;
    Servo armR;
    private final double UP = .5;
    private final int DOWN = 0;
    CustomizableGamepad gpad;
    Toggle toggle;
    TelemetryMenu fMenu;

    public FoundationGrabberSubsystem(Robot r, String servoNameL, String servoNameR) {
        super(r);
        armL = r.hardwareMap.servo.get(servoNameL);
        armR = r.hardwareMap.servo.get(servoNameR);
        usesConfig = true;
        toggle = new Toggle(Toggle.ToggleTypes.flipToggle, false);
    }


    @Override
    public void init()  {
        if (robot.usesGUI()) {
            fMenu = new TelemetryMenu();
            robot.gui.addRootMenu(fMenu);
        }
    }


    @Override
    public void init_loop()  {

    }

    @Override
    public void start()  {
        gpad = robot.pullControls(this);
    }

    @Override
    public void handle()  {
        toggle.updateToggle(gpad.getInput("armToggleButton"));
        if (toggle.getCurrentState()) {
            armL.setPosition(-1);
            armR.setPosition(-1);
        }
         else {
            armL.setPosition(1);
            armR.setPosition(1);
        }


        //for toggle
        //toggle.updateToggle(gpad.getBooleanInput(ARMUPBUTTON));


    }

    @Override
    public void stop()  {

    }


    public void toggleDown() {
        long startTime = System.currentTimeMillis();
        armL.setPosition(1);
        armR.setPosition(1);
    }

    public void toggleUp() {
        long startTime = System.currentTimeMillis();
        armL.setPosition(-1);
        armR.setPosition(-1);


    }
    
    public void toggleOff(){arm.setPower(.5);}

    public void pullUp(int timeMs)  {
        toggleUp();

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeMs && robot.opModeIsActive()) {

        }

        toggleOff();
    }

    @TeleopConfig
    public static ConfigParam[] teleopConfig() {
        return new ConfigParam[] {
                new ConfigParam("armToggleButton", Button.BooleanInputs.a,2),
        };
    }
}