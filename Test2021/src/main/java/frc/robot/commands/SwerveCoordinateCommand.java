// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SwerveCoordinateCommand extends SequentialCommandGroup {
  /** Creates a new SwerveCoordinateCommand. */
  public SwerveCoordinateCommand(DriveSubsystem driveSubsystem, List<double[]> coordinates) {
    double prevX = 0;
    double prevY = 0;
    double prevAngle = 0;

    for (int i=0; i<coordinates.size(); i++) {

      double x = coordinates.get(i)[0];
      double y = coordinates.get(i)[1];

      double deltaX = x - prevX;
      double deltaY = y - prevY;

      double slopeReciprocal = (deltaX / deltaY);

      double desiredAngle = Math.toDegrees(Math.atan(slopeReciprocal)) - prevAngle;
      //double desiredDistance = (Math.PI*Math.pow(2,0.5)*Math.pow((Math.max(deltaX,deltaY)),2)+Math.pow((Math.min(deltaX,deltaY)),2))*Constants.FIELD/4;
      double desiredDistance = 2* Math.PI*Math.pow((deltaX*deltaX+deltaY*deltaY)/2,0.5)*Constants.FIELD/4;
      addCommands(new SwerveCommand(driveSubsystem,desiredAngle,desiredDistance));
      if(desiredAngle>0)
        addCommands(new MoveByAngleCommand(driveSubsystem,(90-desiredAngle)));
      else if(desiredAngle<0)
        addCommands(new MoveByAngleCommand(driveSubsystem,(Math.abs(desiredAngle)-90)));
   }
  } 
}
