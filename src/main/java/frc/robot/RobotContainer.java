package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

import frc.robot.Constants.OIConstants;
import frc.robot.Commands.DriveCommand;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.FeederSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

/**
 * RobotContainer wires all subsystems, commands, and controller bindings.
 *
 * ── Controller 0 (Driver) — Swerve only ──────────────────────────────────────
 *   Left  stick       → translate (field-relative)
 *   Right stick X     → rotate
 *   Cross (×)         → zero gyro heading
 *   Touchpad          → zero gyro heading (alternative)
 *
 * ── Controller 1 (Operator) — Mechanisms only ────────────────────────────────
 *   Intake:
 *     R2 (hold)       → deploy arm + run rollers IN
 *     L2 (hold)       → deploy arm + run rollers OUT (eject)
 *     Circle (○)      → retract / stow arm
 *
 *   Feeder:
 *     R1 (hold)       → run feeder forward
 *     L1 (hold)       → run feeder reverse (unjam)
 *
 *   Shooter:
 *     Triangle (△)    → spin up all 3 shooter motors (hold)
 *     Square (□)      → reverse shooter (unjam, hold)
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class RobotContainer {

    // ─── Subsystems ───────────────────────────────────────────────────────────
    private final DriveSubsystem   driveSubsystem   = new DriveSubsystem();
    private final IntakeSubsystem  intakeSubsystem  = new IntakeSubsystem();
    private final FeederSubsystem  feederSubsystem  = new FeederSubsystem();
    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    // ─── Controllers ──────────────────────────────────────────────────────────
    // Joystick 0 — driver (swerve only)
    private final CommandPS5Controller driverController =
        new CommandPS5Controller(OIConstants.DRIVER_CONTROLLER_PORT);

    // Joystick 1 — operator (all mechanisms)
    private final CommandPS5Controller operatorController =
        new CommandPS5Controller(OIConstants.OPERATOR_CONTROLLER_PORT);

    public RobotContainer() {
        // Default command: field-relative swerve drive on joystick 0
        driveSubsystem.setDefaultCommand(
            new DriveCommand(driveSubsystem, driverController));

        configureBindings();
    }

    private void configureBindings() {

        // ── Controller 0 — Swerve ─────────────────────────────────────────────
        driverController.cross().onTrue(
            new InstantCommand(driveSubsystem::zeroHeading, driveSubsystem));

        driverController.touchpad().onTrue(
            new InstantCommand(driveSubsystem::zeroHeading, driveSubsystem));

        // ── Controller 1 — Intake ─────────────────────────────────────────────
        // R2 held → deploy arm + intake rollers IN; release → stop rollers
        operatorController.R2().whileTrue(
            new StartEndCommand(
                () -> { intakeSubsystem.deploy(); intakeSubsystem.runRollerIntake(); },
                ()  -> intakeSubsystem.stopRoller(),
                intakeSubsystem));

        // L2 held → deploy arm + rollers OUT (eject); release → stop rollers
        operatorController.L2().whileTrue(
            new StartEndCommand(
                () -> { intakeSubsystem.deploy(); intakeSubsystem.runRollerOuttake(); },
                ()  -> intakeSubsystem.stopRoller(),
                intakeSubsystem));

        // Circle (○) → retract / stow arm
        operatorController.circle().onTrue(
            new InstantCommand(intakeSubsystem::retract, intakeSubsystem));

        // ── Controller 1 — Feeder ─────────────────────────────────────────────
        // R1 held → feeder forward; release → stop
        operatorController.R1().whileTrue(
            new StartEndCommand(
                feederSubsystem::runFeeder,
                feederSubsystem::stopFeeder,
                feederSubsystem));

        // L1 held → feeder reverse (unjam); release → stop
        operatorController.L1().whileTrue(
            new StartEndCommand(
                feederSubsystem::reverseFeeder,
                feederSubsystem::stopFeeder,
                feederSubsystem));

        // ── Controller 1 — Shooter ────────────────────────────────────────────
        // Triangle (△) held → spin up all 3 shooter motors; release → stop
        operatorController.triangle().whileTrue(
            new StartEndCommand(
                shooterSubsystem::spinUp,
                shooterSubsystem::stop,
                shooterSubsystem));

        // Square (□) held → reverse shooter (unjam); release → stop
        operatorController.square().whileTrue(
            new StartEndCommand(
                shooterSubsystem::reverse,
                shooterSubsystem::stop,
                shooterSubsystem));
    }

    public edu.wpi.first.wpilibj2.command.Command getAutonomousCommand() {
        return new edu.wpi.first.wpilibj2.command.PrintCommand("No auto configured.");
    }
}
