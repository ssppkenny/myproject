package myproject;

import static spark.Spark.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.myproject.json.JsonParser;
import org.myproject.json.JsonTransformer;
import org.myproject.operation.Operation;
import org.myproject.operation.impl.Addition;
import org.myproject.operation.impl.Division;
import org.myproject.operation.impl.Multiplication;
import org.myproject.operation.impl.Subtraction;
import org.myproject.state.State;



import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class Main {
	
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

	public static void main(String[] args) {
		
		port(getHerokuAssignedPort());
		staticFileLocation("/public");

		get("/", (req, res) -> {
			
			Map<String, Object> model = new HashMap<>();
			model.put("title", "Programmable Calculator");
			return new ModelAndView(model, "template.vm");
		}, new VelocityTemplateEngine());

		post("/operation", "application/json", (req, res) -> {
			
			String body = req.body();
			State state = JsonParser.parse(body);
			
			Operation operator = null;
			String operation = state.getOperation();
			
			switch ( operation )
			{
			case "+":
			    operator= new Addition(state);
				
				break;
			case "*":
				operator= new Multiplication(state);
				break;
			case "/":
				operator= new Division(state);
				break;
			case "-":
				operator= new Subtraction(state);
				break;
			default:
				break;
			}
			
			if ( operator != null )
			{
				state = operator.apply();
			}
			
			
			Map<String, Object> model = new HashMap<>();
			
			model.put("state", state);
			return state;
			
		}, new JsonTransformer());
		

	}

}
