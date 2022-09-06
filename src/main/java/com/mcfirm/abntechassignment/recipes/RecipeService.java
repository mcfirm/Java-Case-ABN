package com.mcfirm.abntechassignment.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class RecipeService implements IRecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> findByName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }

    /*
    * Using Spring query by example (QBE), we allow for dynamic query creation.
    * For more information see https://docs.spring.io/spring-data/jpa/docs/2.0.0.RC2/reference/html/#query-by-example
     */
    @Override
    public List<Recipe> findByAnything(RecipeRequest recipeRequest) {
        var recipe = new Recipe();
        recipe.setServings(recipeRequest.getServings());
        recipe.setCourse(recipeRequest.getCourse());
        recipe.setDiet(recipeRequest.getDiet());
        recipe.setIngredients(recipeRequest.getIngredients());
        recipe.setInstructions(recipeRequest.getInstructions());

        var matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("ingredients", contains().ignoreCase())
                .withMatcher("instructions", contains().ignoreCase());

        var example = Example.of(recipe, matcher);

        return recipeRepository.findAll(example);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe update(Recipe newRecipe, Long id) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setName(newRecipe.getName());
                    recipe.setServings(newRecipe.getServings());
                    recipe.setCourse(newRecipe.getCourse());
                    recipe.setDiet(newRecipe.getDiet());
                    recipe.setIngredients(newRecipe.getIngredients());
                    recipe.setInstructions(newRecipe.getInstructions());
                    return recipeRepository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setId(id);
                    return recipeRepository.save(newRecipe);
                });
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
