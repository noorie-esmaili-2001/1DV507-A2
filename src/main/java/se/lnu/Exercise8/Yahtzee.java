package se.lnu.Exercise8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Yahtzee extends Application {

	private int cnt;
	private Image[] images;
	private ImageView[] imageViews;
	private CheckBox[] checkBoxes;
	private int[] arrTable;

	public void checkDices() {
		arrTable = new int[6];
		for (int i = 0; i < 5; i++) {
			if (imageViews[i].getImage() == images[0]) {
				arrTable[0]++;
			} else if (imageViews[i].getImage() == images[1]) {
				arrTable[1]++;
			} else if (imageViews[i].getImage() == images[2]) {
				arrTable[2]++;
			} else if (imageViews[i].getImage() == images[3]) {
				arrTable[3]++;
			} else if (imageViews[i].getImage() == images[4]) {
				arrTable[4]++;
			} else if (imageViews[i].getImage() == images[5]) {
				arrTable[5]++;
			}
		}
    }

	public boolean isYahtzee() {
		checkDices();
        for (int j : arrTable) {
            if (j == 5) {
                return true;
            }
        }
		return false;
	}

	public boolean isFourOfAKind() {
        for (int j : arrTable) {
            if (j == 4)
                return true;
        }
		return false;
	}

	public boolean isFullHouse() {
		boolean three = false;
		boolean two = false;
        for (int j : arrTable) {
            if (j == 3) {
                three = true;
            }
            if (j == 2) {
                two = true;
            }
        }
        return three && two;
    }

	public boolean isThreeOfAKind() {
        for (int j : arrTable) {
            if (j == 3) {
                return true;
            }
        }
		return false;
	}

	public boolean isPair() {
        for (int j : arrTable) {
            if (j == 2) {
                return true;
            }
        }
		return false;
	}

	public boolean isSmallStraight() {
		return arrTable[0] == 1 && arrTable[1] == 1 && arrTable[2] == 1 && arrTable[3] == 1 && arrTable[4] == 1;
	}

	public boolean isLargeStraight() {
		return arrTable[1] == 1 && arrTable[2] == 1 && arrTable[3] == 1 && arrTable[4] == 1 && arrTable[5] == 1;
	}

	@Override
	public void start(Stage primaryStage) {
		TextFlow textFlow = new TextFlow();
		Font font = new Font("Tahoma", 20);

		Text text1 = new Text("Yahtzee");
		text1.setFill(Color.PURPLE);
		text1.setFont(font);
		textFlow.getChildren().addAll(text1);
		GridPane.setConstraints(textFlow, 0, 0, 2, 1);

		images = new Image[] { new Image( "1.png"),
				new Image("2.png"),
				new Image("3.png"),
				new Image("4.png"),
				new Image("5.png"),
				new Image("6.png") };

		imageViews = new ImageView[5];
		checkBoxes = new CheckBox[5];
		for (int i = 0; i < imageViews.length; i++) {
			imageViews[i] = new ImageView();
			imageViews[i].setFitHeight(35);
			imageViews[i].setFitWidth(35);
			imageViews[i].setImage(images[i]);
			GridPane.setConstraints(imageViews[i], i, 1);
			checkBoxes[i] = new CheckBox();
			checkBoxes[i].setDisable(true);
			GridPane.setConstraints(checkBoxes[i], i, 3);
		}

		CheckBox box1 = new CheckBox();
		box1.setDisable(true);
		GridPane.setConstraints(box1, 0, 3);

		CheckBox box2 = new CheckBox();
		box2.setDisable(true);
		GridPane.setConstraints(box2, 1, 3);

		CheckBox box3 = new CheckBox();
		box3.setDisable(true);
		GridPane.setConstraints(box3, 2, 3);

		CheckBox box4 = new CheckBox();
		box4.setDisable(true);
		GridPane.setConstraints(box4, 3, 3);

		CheckBox box5 = new CheckBox();
		box5.setDisable(true);
		GridPane.setConstraints(box5, 4, 3);

		Button btn = new Button("Roll dices");
		GridPane.setConstraints(btn, 0, 4, 2, 2);

		btn.setOnMouseClicked(t -> {

			for (CheckBox a : checkBoxes) {
				a.setDisable(false);
			}

			if (cnt > 2) {
				btn.setDisable(true);
			}
		});

		Label result = new Label("You have 3 rolls");
		GridPane.setConstraints(result, 2, 4, 2, 2);

		btn.setOnAction(e -> {

			for (int i = 0; i < 5; i++) {
				if (!checkBoxes[i].isSelected()) {
					imageViews[i].setImage(images[(int) (Math.random() * 6)]);
				}
			}

			cnt++;
			if (cnt < 3) {
				result.setText("You have " + (3 - cnt) + " roll(s)");
			} else if (isYahtzee()) {
				result.setText("Yahtzee! ^.^");
			} else if (isFourOfAKind()) {
				result.setText("Four of a kind!");
			} else if (isThreeOfAKind()) {
				result.setText("Three of a kind!");
			} else if (isPair()) {
				result.setText("Pair");
			} else if (isFullHouse()) {
				result.setText("Full house!");
			} else if (isLargeStraight()) {
				result.setText("Large straight!");
			} else if (isSmallStraight()) {
				result.setText("Small straight!");
			} else {
				result.setText("-.- Nothing at all -.-");
			}
		});

		GridPane gridPane = myGridPane();
		gridPane.getChildren().addAll(btn, textFlow, result);
		Scene scene = new Scene(gridPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Yahtzee");
		primaryStage.show();

	}

	public GridPane myGridPane() {

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 30, 30));
		gridPane.setVgap(20);
		gridPane.setHgap(20);

		gridPane.getChildren().addAll(checkBoxes);
		gridPane.getChildren().addAll(imageViews);
		return gridPane;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
