// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ArrayList;
import java.util.List;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class GalacticSearchPathACommand extends SequentialCommandGroup {
  /** Creates a new PathACommand. */
  public GalacticSearchPathACommand(DriveSubsystem driveSubsystem) {
    List<double[]> coordinates = new ArrayList<double[]>();
    if(SmartDashboard.getNumber("Radius",1)>Constants.radiusThreshold)
    {
      // AR
      coordinates.add(new double[]{0d, 3d});
      coordinates.add(new double[]{1d, 5d});
      coordinates.add(new double[]{-2d, 6d});
      coordinates.add(new double[]{0d, 11.3d});
    }
    else{
      // AB
      coordinates.add(new double[]{0d, 3d});
      coordinates.add(new double[]{2d, 6d});
      coordinates.add(new double[]{-1d, 7d});
      coordinates.add(new double[]{0d, 9d});
      coordinates.add(new double[]{0d, 11.3d});
    }
    addCommands(new CoordinateFollowingCommand(driveSubsystem, coordinates));
  }
}
