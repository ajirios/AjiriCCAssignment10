package com.spoonacular.AjiriCCAssignment10.web;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spoonacular.AjiriCCAssignment10.dto.DayResponse;
import com.spoonacular.AjiriCCAssignment10.dto.WeekResponse;

@RestController
public class MealPlanController 

{
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${api.key}")
	private String apiKey;					
	
	@Value("${spoonacular.urls.base}")
	private String urlBase;					
	
	@Value("${spoonacular.urls.mealplan}")
	private String urlMealPlan;				
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam Optional<String> numCalories, @RequestParam Optional<String> diet, @RequestParam Optional<String> exclusions)
	
	{
		URI uri = UriComponentsBuilder.fromHttpUrl(urlBase.concat(urlMealPlan))
					.queryParam("timeFrame", "week")
					.queryParamIfPresent("diet", diet)
					.queryParamIfPresent("targetCalories", numCalories)
					.queryParamIfPresent("exclude", exclusions)
					.queryParam("apiKey", apiKey)
					.build()
					.toUri();
		ResponseEntity<WeekResponse> weekResponseEntity = restTemplate.getForEntity(uri, WeekResponse.class);
		return weekResponseEntity;
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam Optional<String> numCalories, @RequestParam Optional<String> diet, @RequestParam Optional<String> exclusions)
	
	{
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
					.queryParam("timeFrame", "day")
					.queryParamIfPresent("diet", diet)
					.queryParamIfPresent("targetCalories", numCalories)
					.queryParamIfPresent("exclude", exclusions)
					.queryParam("apiKey", apiKey)
					.build()
					.toUri();
		ResponseEntity<DayResponse> dayResponseEntity = restTemplate.getForEntity(uri, DayResponse.class);
		return dayResponseEntity;
	}
}
