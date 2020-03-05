
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControlCircleWithMouseAndKey extends Application {
  private CirclePane circlePane = new CirclePane();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	  
    // Hold two buttons in an HBox
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btEnlarge = new Button("Enlarge");
    Button btShrink = new Button("Shrink");
    hBox.getChildren().add(btEnlarge);
    hBox.getChildren().add(btShrink);
    
    // Create and register the handler
    btEnlarge.setOnAction(e -> circlePane.enlarge());
    btShrink.setOnAction(e -> circlePane.shrink());
    

   
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(circlePane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 300, 250);
    primaryStage.setTitle("ControlCircle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    

    
    /*
     * Add mouse events to circlePane
     * Clicking on the primary button enlarges the circle
     * 
     * setOn______
     * 
     * getButton()
     * 
     * MouseButton.PRIMARY
     * 
     */
    
    
    /*
     * Add Key events to circlePane
     * Up key enlarges the circle
     * Down key shrinks the circle
     * 
     * setOn______
     * 
     * getCode()
     * 
     * KeyCode.UP
     * 
     */
    scene.setOnKeyPressed(e -> {
    if	(e.getCode() == KeyCode.DOWN){
    	circlePane.shrink();
    }
    if (e.getCode() == KeyCode.UP) {
    	circlePane.enlarge();
    }
    }
    );
    
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

class CirclePane extends StackPane {
	  private Circle circle = new Circle(50); 
	  
	  public CirclePane() {
	    getChildren().add(circle);
	    circle.setStroke(Color.BLACK);
	    circle.setFill(Color.WHITE);
	  }
	  
	  public void enlarge() {
	    circle.setRadius(circle.getRadius() + 2);
	  }
	  
	  public void shrink() {
	    circle.setRadius(circle.getRadius() > 2 ? 
	      circle.getRadius() - 2 : circle.getRadius());
	  }
}