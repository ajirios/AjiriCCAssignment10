package com.spoonacular.AjiriCCAssignment10.dto;

import java.util.List;

public class DayResponse 

{
	private List<Meal> meals;
	private Nutrients nutrients;

	public DayResponse() 
	
	{
		this.meals = null;
		this.nutrients = null;
	}

	public List<Meal> getMeals() 
	
	{
		return meals;
	}

	public void setMeals(List<Meal> meals) 
	
	{
		this.meals = meals;
	}

	public Nutrients getNutrients() 
	
	{
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) 
	
	{
		this.nutrients = nutrients;
	}

	@Override
	public String toString() 
	
	{
		return "DayResponse [meals=" + meals + ", nutrients=" + nutrients + "]";
	}

}
