package avs;
import org.json.JSONObject;

public class HelloWorld {

	public static void main(String args[]){
	       JSONObject jo = new JSONObject("{\"name\":\"John Doe\",\"street\":\"123 Main St\",\"city\":\"Springfield\",\"state\":\"IL\",\"zip_code\":\"62704\",\"country\":\"USA\",\"phone\":\"555-1234\",\"email\":\"johndoe@example.com\"}");
	       //System.out.println(jo);
	       System.out.println(jo.get("street"));
	       
	    }
}
