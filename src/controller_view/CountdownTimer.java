package controller_view;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.Duration;
import java.time.LocalTime;

public class CountdownTimer extends Application {
    private int hours;
    private int minutes;
    private int seconds;

    private Label timerLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours");
        TextField minutesField = new TextField();
        minutesField.setPromptText("Minutes");
        TextField secondsField = new TextField();
        secondsField.setPromptText("Seconds");

        Button startButton = new Button("Start Timer");
        startButton.setOnAction(event -> {
            // Parse user input for hours, minutes, and seconds
            hours = Integer.parseInt(hoursField.getText());
            minutes = Integer.parseInt(minutesField.getText());
            seconds = Integer.parseInt(secondsField.getText());

            // Start the countdown timer
            startCountdown();
        });

        root.getChildren().addAll(hoursField, minutesField, secondsField,   startButton, timerLabel);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Countdown Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startCountdown() {
        LocalTime end = LocalTime.now()
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Duration remaining = Duration.between(LocalTime.now(), end);
                if (!remaining.isNegative()) {
                    timerLabel.setText(format(remaining));
                } else {
                    timerLabel.setText(format(Duration.ZERO));
                    stop();
                }
            }

            private String format(Duration remaining) {
                return String.format("%02d:%02d:%02d",
                        remaining.toHoursPart(),
                        remaining.toMinutesPart(),
                        remaining.toSecondsPart()
                );
            }
        };

        timer.start();
    }
}