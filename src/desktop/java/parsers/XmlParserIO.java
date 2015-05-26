package parsers;

import Strings.StringsRessources;
import java.util.ArrayList;
import java.util.TreeMap;
import org.joda.time.DateTime;

/**
 *
 * @author Alex
 */
public abstract class XmlParserIO {
    
    public static TreeMap readCsvToTreeMap(){
        
        TreeMap<String, String> map = new TreeMap<>();
         
        return map;
    }
    
    public static String writeTreeMapToCsv(TreeMap<String, String> map){
        
        String message = StringsRessources.MESSAGE_CSV_CREATE;
        
        //create a point just before the first point of the param map
        DateTime keyFirstDate = new DateTime(map.firstKey());
        keyFirstDate.minusSeconds(1);
        String   valueDumbCoord = "0 0 0";
        //add key value to received map
        map.put(keyFirstDate.toString(), valueDumbCoord);
        
        /*
        if file exist {
            TreeMap oldMap = readCsvToTreeMap();
            message = HikingStats.MESSAGE_CSV_UPDATE;
        } else {
            create file
        } then
        
        write TreeMap in CSV (key, value)
        (if write == false : message = HikingStats.MESSAGE_CSV_WRITE_ERROR)
        */
        
        return message;
        
    }
    
    public static ArrayList readCsvToArrayList(){
        
        ArrayList list = new ArrayList();
        
        return list;
        
    }
    
    
}
