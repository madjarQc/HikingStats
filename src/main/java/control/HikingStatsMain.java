package control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Annie
 */
public class HikingStatsMain extends Application {

    public static final String MESSAGE_CSV_CREATE = "CSV FILE CREATED";
    public static final String MESSAGE_CSV_UPDATE = "CSV FILE UPDATED";
    public static final String MESSAGE_CSV_WRITE_ERROR = "WRITTING ERROR IN CSV";
    public static final String KML_PARENT = "gx:Track";
    public static final String KML_CHILD_TIME = "when";
    public static final String KML_CHILD_COORDINATE = "gx:coord";

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
