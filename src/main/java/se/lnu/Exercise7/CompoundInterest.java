package se.lnu.Exercise7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompoundInterest extends Application {
	private final TextField startAmount = new TextField();
	private final TextField interest = new TextField();
	private final TextField years = new TextField();
	private final Button btCalculate = new Button("Calculate");
	private final Text text = new Text();

	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Start amount:"), 0, 0);
		gridPane.add(startAmount, 1, 0);
		gridPane.add(new Label("Interest:"), 0, 1);
		gridPane.add(interest, 1, 1);
		gridPane.add(new Label("Number of years:"), 0, 2);
		gridPane.add(years, 1, 2);
		gridPane.add(btCalculate, 1, 5);
		gridPane.add(text, 0, 6);

		gridPane.setAlignment(Pos.CENTER);
		startAmount.setAlignment(Pos.BOTTOM_LEFT);
		interest.setAlignment(Pos.BOTTOM_LEFT);
		years.setAlignment(Pos.BOTTOM_LEFT);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);

		btCalculate.setOnAction(e -> calculateFinalAmount());

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Compound Interest");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void calculateFinalAmount() {
		double amount = Double.parseDouble(startAmount.getText());
		int year = Integer.parseInt(years.getText());
		double Interest = Double.parseDouble(interest.getText());

		Calculate compoundInterest = new Calculate(amount, Interest, year);
		text.setText(compoundInterest.toString());
	}

	public static void main(String[] args) {
		launch(args);
	}
}