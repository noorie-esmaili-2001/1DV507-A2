package ne222hz_assign2.Exercise6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Snowman extends Application
{
    public void start(Stage primaryStage)
    {       
        Group snowman = generateSnowman(0, 0);

        Circle sun = new Circle(600, 80, 40);
        sun.setFill(Color.GOLD);

        Rectangle ground = new Rectangle(0, 400, 700, 100);
        ground.setFill(Color.WHITE);

        Group root = new Group(ground, sun, snowman);
        Scene scene = new Scene(root, 700, 500, Color.BLUE);

        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Group generateSnowman(int dx, int dy)
    {
        Circle base = new Circle(200, 280, 70);
        base.setFill(Color.WHITE);

        Circle middle = new Circle(200, 160, 50);
         middle.setFill(Color.WHITE);

        Circle head = new Circle(200, 80 , 30);
        head.setFill(Color.WHITE);

        Circle rightEye = new Circle(185, 70, 5);
        Circle leftEye = new Circle(215, 70 , 5);
        Line mouth = new Line(180, 90, 220 , 90);

        Circle topButton = new Circle(200, 120 , 6);
         topButton.setFill(Color.BLACK);
        Circle midButton = new Circle(200, 150 , 6);
        midButton.setFill(Color.BLACK);
        Circle bottomButton = new Circle(200, 180 , 6);
        bottomButton.setFill(Color.BLACK);

        Rectangle hat1 = new Rectangle(190, 0 , 40, 50);
        Rectangle hat2 = new Rectangle(180, 50, 60, 5);
        Group hat = new Group(hat1, hat2);
        hat.setTranslateX(10);
        hat.setRotate(15);
        
        Group snowman = new Group(base,  middle, head, leftEye, rightEye,
            mouth,  topButton, midButton, bottomButton, hat);
        snowman.setTranslateX(170);
        snowman.setTranslateY(50);
        
        return snowman;
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}