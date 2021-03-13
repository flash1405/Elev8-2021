// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class PathBCommand extends CommandBase {
  /** Creates a new PathACommand. */
  DriveSubsystem driveSubsystem;
  public PathBCommand(DriveSubsystem driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    List<double[]> coordinates = new ArrayList<double[]>();
    if(SmartDashboard.getNumber("Radius",1)>Constants.radiusThreshold)
    {
      // BR, B = 0, start the robot on B1
      coordinates.add(new double[]{0d, 2.6d});
      coordinates.add(new double[]{2.4d, 5d});
      coordinates.add(new double[]{0d, 6.7d});
      coordinates.add(new double[]{0.4d, 11d});
    }
    else{
      //BB, B = 0, start the robot on B1
      coordinates.add(new double[]{0d, 1.5d});
      coordinates.add(new double[]{2.25d, 6d});
      coordinates.add(new double[]{-0.3d, 8d});
      coordinates.add(new double[]{2.35d, 10d});
      coordinates.add(new double[]{2d, 11d});
    }
    new CoordinateFollowingCommand(this.driveSubsystem, coordinates);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
