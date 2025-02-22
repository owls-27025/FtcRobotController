package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ProgrammingBoard4 {
    private DcMotor FR;
    private DcMotor FL;
    private DcMotor BR;
    private DcMotor BL;
    public DcMotor arm;
    public DcMotor slides;
    public Servo gripper;
    public Servo yaw;
    public Servo pitch;
    public double ticksPerRotation;

    public void init(HardwareMap hwMap) {

            FR = hwMap.get(DcMotor.class, "FR");
            ticksPerRotation = FR.getMotorType().getTicksPerRev();
            FL = hwMap.get(DcMotor.class, "FL");
            ticksPerRotation = FL.getMotorType().getTicksPerRev();
            BR = hwMap.get(DcMotor.class, "BR");
            ticksPerRotation = BR.getMotorType().getTicksPerRev();
            BL = hwMap.get(DcMotor.class, "BL");
            ticksPerRotation =BL.getMotorType().getTicksPerRev();
            FL.setDirection(DcMotor.Direction.REVERSE);
            BL.setDirection(DcMotor.Direction.REVERSE);
            FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            arm = hwMap.get(DcMotor.class, "Arm");
            slides = hwMap.get(DcMotor.class, "Slide");
            arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            arm.setTargetPosition(0);
            slides.setTargetPosition(0);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1);
            slides.setPower(1);
            pitch = hwMap.get(Servo.class, "Pitch");
            yaw = hwMap.get(Servo.class, "Yaw");
            gripper = hwMap.get(Servo.class, "Gripper");
    }



    public void setForwardMotorSpeed(double speed, int distance){
        FR.setPower(speed);
        FL.setPower(speed);
        BR.setPower(speed);
        BL.setPower(speed);
        FR.setTargetPosition(distance);
        FL.setTargetPosition(distance);
        BR.setTargetPosition(distance);
        BL.setTargetPosition(distance);

    }
    public void setBackwardMotorSpeed(double speed, int distance){
        FR.setPower(-speed);
        FL.setPower(-speed);
        BR.setPower(-speed);
        BL.setPower(-speed);
        FR.setTargetPosition(-distance);
        FL.setTargetPosition(-distance);
        BR.setTargetPosition(-distance);
        BL.setTargetPosition(-distance);
    }
    public void runMotors(){
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public double getMotorRotations(){
        return FR.getCurrentPosition();
    }
    public void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}