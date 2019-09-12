import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class parsedJSON {
    public static void parsedJSON(ArrayList<String> json) throws ParseException, SQLException {
        Number start_timestamp = 0;
        Number end_timestamp = 0;
        int duration;
        String alert;
        int j;
        int i;
        JSONParser jsonparser = new JSONParser();
        JSONObject objectjson;
        JSONObject objectjsonpos;
        String type;
        String host;

        for (i = 0; i < json.size(); i++) {
            //Parse JSON to get keys
            String jdata = json.get(i);
            objectjson = (JSONObject) jsonparser.parse(jdata);

            if (objectjson.get("state").equals("STARTED")) {
                start_timestamp = (Number) objectjson.get("timestamp");
            } else {
                end_timestamp = (Number) objectjson.get("timestamp");
            }

            for (j = (i + 1); j < json.size(); j++) {
                String jdata_pos = json.get(j);
                objectjsonpos = (JSONObject) jsonparser.parse(jdata_pos);
                if (objectjson.get("id").equals(objectjsonpos.get("id")) && objectjsonpos.get("state").equals("STARTED")) {
                    start_timestamp = (Number) objectjsonpos.get("timestamp");
                    duration = end_timestamp.intValue() - start_timestamp.intValue();
                    if (duration >= 8) {
                        alert = "true";
                    } else {
                        alert = "false";
                    }
                    if( objectjsonpos.get("type") == null){
                        type = "null";
                    }else{
                        type = objectjsonpos.get("type").toString();
                    }
                    if( objectjsonpos.get("host") == null){
                        host = "null";
                    }else{
                        host = objectjsonpos.get("host").toString();
                    }
                    //insert data in database
                    insertdata.insertdatabase(objectjsonpos.get("id"), objectjsonpos.get("state"), duration, type, host , alert);
                }else if(objectjson.get("id").equals(objectjsonpos.get("id")) && objectjsonpos.get("state").equals("FINISHED")) {
                    end_timestamp = (Number) objectjsonpos.get("timestamp");
                    duration = end_timestamp.intValue() - start_timestamp.intValue();
                    if (duration >= 8) {
                        alert = "true";
                    } else {
                        alert = "false";
                    }
                    if(objectjsonpos.get("type") == null){
                        type = "null";
                    }else{
                        type = objectjsonpos.get("type").toString();
                    }
                    if( objectjsonpos.get("host") == null){
                        host = "null";
                    }else{
                        host = objectjsonpos.get("host").toString();
                    }
                    //insert data in database
                    insertdata.insertdatabase(objectjsonpos.get("id"), objectjsonpos.get("state"), duration, type, host , alert);
                }
            }
        }
        System.out.println("Data inserted in database");
    }
}
