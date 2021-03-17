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
public class AutoNavPathA extends SequentialCommandGroup {
  /** Creates a new AutoNavPathA. */
  public AutoNavPathA(DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    double radius = 1.3;
    addCommands(new CoordinateFollowingCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{0d, 4.8d}))));
    quartercircle(driveSubsystem, radius, 4, 1);
    addCommands(new CoordinateFollowingCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{0d, 3d}))));
    quartercircle(driveSubsystem, 1.05, 3, -1);
    addCommands(new SwerveCoordinateCommand(driveSubsystem, new ArrayList<double[]>(Arrays.asList(new double[]{-3d, 3d}))));
    quartercircle(driveSubsystem, 1.05, 2, -1);
    addCommands(new CoordinateFollowingCommand(driveSubsystem,new ArrayList<double[]>(Arrays.asList(new double[]{0d, 10d}))));
  }
  public void quartercircle(DriveSubsystem driveSubsystem, double radius,int n, int direction)
  {
    for(int i = 0; i<n; i++)
    {
      addCommands(new SwerveCommand(driveSubsystem, direction*45, (0.5*Math.PI*radius+(2*Math.PI*radius/72))));
      addCommands(new MoveByAngleCommand(driveSubsystem,direction*55));
    }
  }
}
