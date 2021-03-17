// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoNavPathC extends SequentialCommandGroup {
  /** Creates a new AutoNavPathC. */
  public AutoNavPathC(DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new SwerveCoordinateCommand(driveSubsystem, new ArrayList<double[]>(Arrays.asList(new double[]{-2d, 2d}))));
    addCommands(new MoveByAngleCommand(driveSubsystem,180));
    addCommands(new SwerveCoordinateCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{-2d, 4d}))));
    addCommands(new SwerveCoordinateCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{-4d, 1d}))));
    addCommands(new MoveByAngleCommand(driveSubsystem,180));
    addCommands(new SwerveCoordinateCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{-1d, 4d}))));
    addCommands(new CoordinateFollowingCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{0d, 0d}))));
    addCommands(new SwerveCoordinateCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{-4d,1d}))));
    addCommands(new MoveByAngleCommand(driveSubsystem,180));
    addCommands(new SwerveCoordinateCommand(driveSubsystem, new ArrayList<double[]>(Arrays.asList(new double[]{-2d, 2d}))));
  }
}
