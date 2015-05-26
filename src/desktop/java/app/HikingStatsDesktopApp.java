package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import models.AlexPoints3D;
import models.Travel;
import org.joda.time.DateTime;
import org.xml.sax.SAXException;
import parsers.XmlParser;
        

/**
 *
 * @author Alex Proulx
 */
public class HikingStatsDesktopApp extends Application {
    
    public static final String MAIN_VIEW_FXML = "MainViewWindow.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource(MAIN_VIEW_FXML));
        
        Scene scene = new Scene(root);
        
        stage.setTitle(Strings.StringsRessources.STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }

}
