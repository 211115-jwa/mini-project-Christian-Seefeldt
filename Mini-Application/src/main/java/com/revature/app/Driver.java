package com.revature.app;

import io.javalin.Javalin;

public class Driver {
	static Food[] foods;
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex=0;
		foods = new Food[10];
		
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
			
			foods[currentIndex] = food;
			currentIndex++;
			
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
