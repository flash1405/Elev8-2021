// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.io.*;
import java.util.ArrayList;
import frc.robot.subsystems.DriveSubsystem;

public class AutoNav extends CommandBase{
  /** Creates a new AutoNav. */
  File file;
  BufferedReader br;
  long end;
  DriveSubsystem driveSubsystem;
  ArrayList<String> listOfLines;
  public AutoNav(DriveSubsystem driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    try{
      file = new File("D:\\Aryan\\IB\\FRC\\csv_deduped.txt"); 
      br = new BufferedReader(new FileReader(file)); 
      listOfLines = new ArrayList<>();
    }
    catch(Exception ie){}
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    try{
      File file; 
      BufferedReader br;
      ArrayList<String> listOfLines;
      file = new File("D:\\Aryan\\IB\\FRC\\csv_deduped.txt"); 
      br = new BufferedReader(new FileReader(file)); 
      listOfLines = new ArrayList<>();
      int temp;
      int temp2;
      double joyY=0.0d;
      double joyZ=0.0d;
      String st;
      while ((st = br.readLine()) != null){
          listOfLines.add(st);
          //st = br.readLine();
      }
      String line1=listOfLines.get(0);
      String lastline= listOfLines.get(listOfLines.size()-1);
      int end = Integer.parseInt(lastline.substring(0,lastline.indexOf(',')));

      for(int i = 1; i<end-1; i++){
          for(int j = 1; j <= listOfLines.size(); j++) {
              line1 = listOfLines.get(j-1);
              if(Long.parseLong(line1.substring(0,line1.indexOf(',')))==i)
              {
                  temp = line1.indexOf('"');
                  temp2 = line1.indexOf('"',temp+1);
                  if(line1.substring(temp+1,temp2).equals("Joy Y"))
                  {
                      joyY = Double.parseDouble(line1.substring(line1.indexOf('"', temp2+1)+1,line1.lastIndexOf('"')));
                  }
                  if(line1.substring(temp+1,temp2).equals("Joy Z"))
                  {
                      joyZ = Double.parseDouble(line1.substring(line1.indexOf('"', temp2+1)+1,line1.lastIndexOf('"')));
                  }
                  break;
              }
              //System.out.println(listOfLines.get(i));
          }
          driveSubsystem.arcadeInbuilt(joyY, joyZ);
          SmartDashboard.putNumber("Y", joyY);
          SmartDashboard.putNumber("Z", joyZ);
      }
    }
    catch(Exception ie){}
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
