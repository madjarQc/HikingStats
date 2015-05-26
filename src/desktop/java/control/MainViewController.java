package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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
public class MainViewController implements Initializable {

    @FXML
    private DatePicker datePicker1;
    @FXML
    private TextFlow textFlow1;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private TextFlow textFlow2;
    @FXML
    private DatePicker datePicker3;
    @FXML
    private TextFlow textFlow3;
    @FXML
    private DatePicker datePicker4;
    @FXML
    private TextFlow textFlow4;
    
    Travel travel;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("initialise!!!");

        //Fetch data to put in table... all known stuff from forever!
        //blockOfPoints = XmlParserIO.readCsvToArrayList();
        DateTime date1 = new DateTime(System.currentTimeMillis());
        date1 = date1.minusDays(50);

        DateTime date2 = new DateTime();

        try {
            XmlParser parse = new XmlParser("doc.kml");

            Map<String, String> map;

            List<AlexPoints3D> points;

            map = parse.getParsedContent();

            //test if sorted
            Set keySet = map.keySet();
            ArrayList<AlexPoints3D> listOfPoints = new ArrayList<>();

            for (Iterator i = keySet.iterator(); i.hasNext();) {

                String key = (String) i.next();
                String value = (String) map.get(key);

                //System.out.println(key + " -> " + value);
                DateTime date = new DateTime(key);
                //System.out.println("date " + key);

                double x;
                double y;
                double z;

                String[] split = value.split(" ");

                x = Double.parseDouble(split[0]);
                y = Double.parseDouble(split[1]);
                z = Double.parseDouble(split[2]);

                //System.out.println("x - y - z " + x + " - " + y + " - " + z);
                AlexPoints3D point = new AlexPoints3D(date, x, y, z);
                listOfPoints.add(point);

                

            }
            
            travel = new Travel(new DateTime(), new DateTime(), listOfPoints);

        } catch (ParserConfigurationException | IOException | SAXException ex) {

        }
                Text distanceTitle1 = new Text(Strings.StringsRessources.DISTANCE_TITLE);
                    distanceTitle1.setFont(Font.font(20));
                Text distance1 = new Text(travel.getDistance() + "\n");
                
                Text durationTitle1 = new Text(Strings.StringsRessources.DURATION_TITLE);
                    durationTitle1.setFont(Font.font(20));
                Text duration1 = new Text(travel.getDuration() + "\n");
                
                Text avgSpTitle1 = new Text(Strings.StringsRessources.AVG_SP_TITLE);
                    avgSpTitle1.setFont(Font.font(20));
                Text avgSp1 = new Text(travel.getAvgSp() + "\n");
                
                Text avgMovSpTitle1 = new Text(Strings.StringsRessources.AVG_MOV_SP_TITLE);
                    avgMovSpTitle1.setFont(Font.font(20));
                Text avgMovSp1 = new Text(travel.getAvgMovSp() + "\n");    
                
                Text minAltitudeTitle1 = new Text(Strings.StringsRessources.MIN_ALTITUDE_TITLE);
                    minAltitudeTitle1.setFont(Font.font(20));
                Text minAltitude1 = new Text(travel.getMinAltitude() + "\n");
                
                Text maxAltitudeTitle1 = new Text(Strings.StringsRessources.MAX_ALTITUDE_TITLE);
                    maxAltitudeTitle1.setFont(Font.font(20));
                Text maxAltitude1 = new Text(travel.getMaxAltitude() + "\n");
                
                Text gainTitle1 = new Text(Strings.StringsRessources.GAIN_TITLE);
                    gainTitle1.setFont(Font.font(20));
               Text gain1 = new Text(travel.getGain() + "\n");     
                Text pitchTitle1 = new Text(Strings.StringsRessources.PITCH_TITLE);
                    pitchTitle1.setFont(Font.font(20));
                Text pitch1 = new Text(travel.getPitch() + "\n");    
                
                
                Text distanceTitle2 = new Text("Total distance of the journey\n");
                
                
                Text distanceTitle3 = new Text("Total distance of the journey\n");
                
                
                Text distanceTitle4 = new Text("Total distance of the journey\n");
                
                
                textFlow1.getChildren().add(distanceTitle1);
                textFlow1.getChildren().add(distance1);
                textFlow1.getChildren().add(durationTitle1);
                textFlow1.getChildren().add(duration1);
                textFlow1.getChildren().add(avgSpTitle1);
                textFlow1.getChildren().add(avgSp1);
                textFlow1.getChildren().add(avgMovSpTitle1);
                textFlow1.getChildren().add(avgMovSp1);
                textFlow1.getChildren().add(minAltitudeTitle1);
                textFlow1.getChildren().add(minAltitude1);
                textFlow1.getChildren().add(maxAltitudeTitle1);
                textFlow1.getChildren().add(maxAltitude1);
                textFlow1.getChildren().add(gainTitle1);
                textFlow1.getChildren().add(gain1);
                textFlow1.getChildren().add(pitchTitle1);
                textFlow1.getChildren().add(pitch1);
                    
                
                textFlow2.getChildren().add(distanceTitle2);
                
                textFlow3.getChildren().add(distanceTitle3);
                
                textFlow4.getChildren().add(distanceTitle4);
 
    }

}
