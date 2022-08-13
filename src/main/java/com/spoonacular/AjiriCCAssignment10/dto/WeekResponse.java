package com.spoonacular.AjiriCCAssignment10.dto;

public class WeekResponse 

{
	private Week week;

	public WeekResponse() 
	
	{
		
	}

	public Week getWeek() 
	
	{
		return week;
	}

	public void setWeek(Week week) 
	
	{
		this.week = week;
	}

	@Override
	public String toString() 
	
	{
		return "WeekResponse [week=" + week + "]";
	}

}
