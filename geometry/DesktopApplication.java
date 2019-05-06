package geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DesktopApplication extends Application{

	public static int getSCALE() {
		return SCALE;
	}

	private static final int SCALE = 50;
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		GeometricObject[] drawings=new GeometricObject[1];
		
		drawings[0] = new Quatrefoil(new Point(3,2), 1, 1);
		Shape[] shapes=new Shape[1];
		for(int index=0; index<shapes.length; index++) {
			Shape shape=drawings[index].createShape(SCALE);
			shape.setStroke(Color.BLACK);
			shape.setFill(Color.WHITE);
			shapes[index]=shape;
		}
		
		Label informationLabel=new Label();
		informationLabel.setLayoutX(300);
		
		Pane root=new Pane();
		root.getChildren().addAll(shapes);
		root.getChildren().add(informationLabel);
		root.setOnMouseClicked(new MouseClickHandler(drawings, shapes, informationLabel, SCALE));

		Scene scene = new Scene(root, 1000, 1000);
		primaryStage.setTitle("Geometrie");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}