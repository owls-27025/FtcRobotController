package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard4;
@TeleOp()
public class MotorOpMode extends OpMode {
    ProgrammingBoard4 board = new ProgrammingBoard4();

    @Override
    public void init() {
        board.init(hardwareMap);
        board.gripper.setPosition(0);
        board.pitch.setPosition(0.5);
        board.yaw.setPosition(0.9);
    }

    @Override
    public void loop() {
        board.gripper.setPosition(0);
        board.setForwardMotorSpeed(0.5, 1376);
        board.arm.setTargetPosition(-1150);
        board.slides.setTargetPosition(-1000);
        board.yaw.setPosition(0);
        board.sleep(300);
        board.pitch.setPosition(0.7);
        board.sleep(300);
        board.setBackwardMotorSpeed(0.5,500);
        board.runMotors();
        board.sleep(1000);
        board.gripper.setPosition(0.5);
        board.sleep(1000);
        board.arm.setTargetPosition(186);
        board.slides.setTargetPosition(-150);
        board.sleep(1000);
        board.pitch.setPosition(0.5);
        board.yaw.setPosition(0.9);
        board.sleep(1500);
    }
}