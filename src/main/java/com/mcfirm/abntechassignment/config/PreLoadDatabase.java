package com.mcfirm.abntechassignment.config;

import com.mcfirm.abntechassignment.recipes.Course;
import com.mcfirm.abntechassignment.recipes.Diet;
import com.mcfirm.abntechassignment.recipes.Recipe;
import com.mcfirm.abntechassignment.recipes.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PreLoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(PreLoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RecipeRepository recipeRepository) {
        List<String> ingredients1 = List.of("garlic", "pepper", "morning glory");
        List<String> ingredients2 = List.of("chicken", "rice");
        List<String> ingredients3 = List.of("flower", "sugar");

        Recipe friedMorningGlory = new Recipe("Fried Morning Glory", 4, Course.STARTER, Diet.VEGAN, ingredients1, "Deep fry everything in a wok.");
        Recipe chickenCurry = new Recipe("Chicken Curry", 2, Course.MAIN, Diet.REGULAR, ingredients2, "Cook the chicken properly.");
        Recipe stickyRicePie = new Recipe("Sticky Rice Pie", 6, Course.DESSERT, Diet.VEGETARIAN, ingredients3, "Bake it in the oven.");
        List<Recipe> recipeEntities = List.of(friedMorningGlory, chickenCurry, stickyRicePie);

        return args -> {
            log.info("Preloading db with recipes " + recipeRepository.saveAll(recipeEntities));
        };
    }
}
