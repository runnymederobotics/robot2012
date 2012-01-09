/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

public class MyRobot extends IterativeRobot {
    
    // <editor-fold defaultstate="collapsed" desc="Constants">
    
    /*------------------------------------------------------------------------*/
    /*                                                                        */
    /*                                CONSTANTS                               */
    /*                                                                        */
    /*------------------------------------------------------------------------*/
    
    public static final double GYRO_SENSITIVITY = 1.0; //IDK actual value
    
    //Constants for the Driver joystick and functions
    public class Driver {
        public static final int DRIVE_AXIS = 1;
        public static final int TURN_AXIS = 2; //IDK what these actually are
    };
    
    //Constants for the Operator joystick and functions
    public class Operator {
        
    };
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    /*------------------------------------------------------------------------*/
    /*                                                                        */
    /*                               VARIABLES                                */
    /*                                                                        */
    /*------------------------------------------------------------------------*/
    
    RobotDrive robotDrive;
    KinectStick kinectStick;
    
    Jaguar jagLeft, jagRight;
    
    Gyro gyro;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Init">
    
    /*------------------------------------------------------------------------*/
    /*                                                                        */
    /*                              INIT METHODS                              */
    /*                                                                        */
    /*------------------------------------------------------------------------*/
    
    public void robotInit() {
        jagLeft = new Jaguar(1);
        jagRight = new Jaguar(2);
        
        robotDrive = new RobotDrive(jagLeft, jagRight);
        kinectStick = new KinectStick(0);
        
        gyro = new Gyro(1);
        gyro.setSensitivity(GYRO_SENSITIVITY);
        gyro.reset();
    }
    
    public void disabledInit() {
    }

    public void autonomousInit() {
    }

    public void teleopInit() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Continuous">
    
    /*------------------------------------------------------------------------*/
    /*                                                                        */
    /*                           CONTINUOUS METHODS                           */
    /*                                                                        */
    /*------------------------------------------------------------------------*/
    
    public void disabledContinuous(){
        
    }

    public void autonomousContinuous() {

    }

    public void teleopContinuous() {
        double speed = kinectStick.getY(GenericHID.Hand.kLeft), rotation = kinectStick.getY(GenericHID.Hand.kRight);
        robotDrive.arcadeDrive(speed, rotation, true); //Squared inputs
    }
    
    public void doAutoBalance() {
        
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Periodic">
    
    /*------------------------------------------------------------------------*/
    /*                                                                        */
    /*                            PERIODIC METHODS                            */
    /*                                                                        */
    /*------------------------------------------------------------------------*/
    
    public void disabledPeriodic() {
        printPeriodic("Disabled");
    }

    public void autonomousPeriodic() {
        printPeriodic("Autonomous");
    }

    public void teleopPeriodic() {
        printPeriodic("Teleop");
    }
    
    public void printPeriodic(String mode) {
        System.out.println("[" + mode + "]");
        
        System.out.println(""); //Print data here
    }
    
    // </editor-fold>
    
}
