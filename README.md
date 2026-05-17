# FRC SDS MK4i Kraken X60 Swerve Drive Code

This repository contains the control code for an FRC swerve drive chassis powered by 8 Talon FX Kraken X60 motors using SDS MK4i swerve modules.

The drivetrain uses 4 SDS MK4i swerve modules with:
- 1 drive motor per module
- 1 steering motor per module

Total:
- 8 Kraken X60 Motors
- 4 SDS MK4i Modules

---

## Overview

This project is designed for a high-performance FRC swerve drivetrain capable of:
- Holonomic movement
- Precision steering
- Fast acceleration
- High maneuverability
- Field-oriented driving

The codebase is built using WPILib and follows the standard FRC Java robot project structure.

---

## Hardware Configuration

### Swerve Modules
- SDS MK4i Swerve Modules

### Motors
- Talon FX Kraken X60 Motors

### Motor Controllers
- Integrated Talon FX Controllers

### Framework
- WPILib

### Programming Language
- Java

---

## Drivetrain Structure

Each swerve module contains:
- 1 Kraken X60 drive motor
- 1 Kraken X60 steering motor

Module Layout:
- Front Left
- Front Right
- Back Left
- Back Right

Total Motors:
- 4 Drive Motors
- 4 Steering Motors
- 8 Motors Overall

---

## Features

- Full swerve drive control
- Independent wheel steering
- Field-oriented driving support
- High-performance Kraken X60 motor integration
- SDS MK4i module configuration
- Expandable subsystem architecture
- Teleop and autonomous ready

---

## Project Structure

```text
src/main/java/frc/robot/
