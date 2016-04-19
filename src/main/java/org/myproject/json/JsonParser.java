package org.myproject.json;

import org.myproject.state.State;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonParser {
	
	public static State parse(String jsonLine) {
	    JsonElement jelement = new com.google.gson.JsonParser().parse(jsonLine);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    double rx = jobject.get("rx").getAsDouble();
	    double ry = jobject.get("ry").getAsDouble();
	    double rz = jobject.get("rz").getAsDouble();
	    double rt = jobject.get("rt").getAsDouble();
	    String operation = jobject.get("operation").getAsString();
	    return new State(rx,ry,rz,rt,operation);
	}

}
