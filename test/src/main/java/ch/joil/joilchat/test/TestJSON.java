package ch.joil.joilchat.test;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by bananatreedad on 14/06/16.
 */
public class TestJSON {
    public static void main(String[] args) throws ParseException {

        JSONObject object = new JSONObject();

        object.put("Name", "Ilian");
        object.put("Age", 22);
        object.put("1", 1);
        object.put("2", 2);
        object.put("3", 3);
        object.put("4", 4);
        object.put("5", 5);
        object.put("6", 6);

        System.out.println(object.toString());

        String string = "{\"1\":1,\"2\":2,\"3\":3,\"4\":4,\"5\":5,\"6\":6,\"Age\":22,\"Name\":\"Ilian\"}";


        JSONParser parser = new JSONParser();

        Object obj = parser.parse(string);
        JSONObject jsonObj = (JSONObject) obj;

        System.out.println(jsonObj.toJSONString());

        string = "\\to joni";
        System.out.println(string.replace(" ", ""));

        System.out.println(string);
        System.out.println(string.startsWith("\\"));
    }
}
