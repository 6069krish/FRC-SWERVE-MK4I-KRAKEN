# FRC SDS MK4i Kraken X60 Swerve Drive Code

This repository contains the control code for an FRC swerve drive chassis powered by 8 Talon FX Kraken X60 motors using SDS MK4i swerve modules.

The drivetrain uses YAGSL (Yet Another Generic Swerve Library) for swerve kinematics and odometry.

---

## Overview

This project implements a high-performance swerve drivetrain capable of:

- Holonomic (omnidirectional) movement
- Field-oriented control
- Precise rotation and translation
- Smooth autonomous path following
- Real-time odometry tracking using YAGSL

Built using WPILib and structured for competitive FRC robotics.

---

## Hardware Configuration

### Swerve Modules
- SDS MK4i Swerve Modules

### Motors
- 8x Talon FX Kraken X60 Motors

### Motor Controllers
- Integrated Talon FX (Kraken X60)

### Control System
- WPILib (FRC Framework)
- YAGSL (Swerve Drive Library)

---

## Drivetrain Structure

Each SDS MK4i module contains:

- 1 Kraken X60 drive motor
- 1 Kraken X60 steering motor

### Module Layout
- Front Left
- Front Right
- Back Left
- Back Right

### Total Motors
- 4 Drive Motors
- 4 Steering Motors
- 8 Total Motors

---

## Key Features

- Full swerve drive implementation
- Independent wheel steering control
- Field-oriented driving
- High-performance Kraken X60 integration
- SDS MK4i module configuration
- YAGSL-based kinematics and odometry
- Real-time robot pose tracking
- Autonomous-ready architecture

---

## YAGSL Integration

This project uses YAGSL for:

- Swerve kinematics calculations
- Odometry (robot position tracking)
- Module state management
- Trajectory following support

YAGSL simplifies:
- Drive calculations
- Encoder integration
- Field-relative movement
- Pose estimation

---

## Project Structure

```text
src/main/java/frc/robot/
