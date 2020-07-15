package Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		ArrayList<Data> sets = new ArrayList<Data>();
		
		sets.add(new Data("Device","On"));
		sets.add(new Data("Device2","On"));
		sets.add(new Data("Device3","On"));
		
		Data semple = new Data("Device4","Off");
		String json = gson.toJson(sets);

		System.out.println(json);
		Type type = new TypeToken<ArrayList<Data>>() {}.getType();
		ArrayList<Data> getData = gson.fromJson(json, type);
		
		System.out.println(getData.get(0).getMotion());
		
		
		
	}

}

class Data {
	private String name;
	private String motion;
	
	public Data(String name, String motion) {
		this.name = name;
		this.motion = motion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}
	
	

}