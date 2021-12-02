package com.revature.app;

import java.util.ArrayList;
import java.util.List;
import io.javalin.Javalin;

public class Driver {

	static List<Food> foods = new ArrayList <Food>();
	
	
	public static void main(String[] args) {

		foodList();
	}
		public static void foodList() {
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.get("/foods", ctx -> {
			
		});
		
		
		app.post("/foods", ctx -> {
			Food food = new Food();
			food.name = ctx.formParam("name");
			food.description = ctx.formParam("description");
			food.calories = Integer.parseInt(ctx.formParam("calories"));
			food.price = Integer.parseInt(ctx.formParam("price"));
			
			foods.add(food);
			
			String responseText = "";
			
			for (Food eachFood : foods) {
				System.out.println(eachFood);
				if (eachFood != null) {
					responseText += eachFood.name + "<br>";
					}
				}
			
			ctx.html(responseText);		});
		}
	}

