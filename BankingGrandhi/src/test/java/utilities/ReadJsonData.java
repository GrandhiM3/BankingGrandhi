package utilities;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ReadJsonData {
static String strings;
static String st1; 
static String st2; 

	public static Map<String, Object> jsonData() throws Throwable {
		return new ObjectMapper().readValue( new FileReader("C:\\Grandhi\\resources\\TestData.json"),new TypeReference<Map<String,Object>>(){});
	}
	
	
	
	
	public static void a() throws Throwable {
		List<Object> details = (List<Object>) ReadJsonData.jsonData().get("CustomerDetails");
		//System.out.println(details);
		
		List<String> strings = new ArrayList<>(details.size());
		for (Object object : details) {
		    strings.add(Objects.toString(object, null));
		    
		  st1 = strings.get(0);
		  st2 = strings.get(1);
		  
		   System.out.println(st1);
		   System.out.println(st2);
		   
		}
		
		
	}
	public static void main(String[] args) throws Throwable {
		ReadJsonData.a();
	}
	}
