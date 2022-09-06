package com.mcfirm.abntechassignment.recipes;

import java.util.List;

public interface IRecipeService {

    List<Recipe> findAll();
    List<Recipe> findByName(String name);
    List<Recipe> findByAnything(RecipeRequest recipeRequest);

    Recipe save(Recipe recipe);
    Recipe update (Recipe recipe, Long id);

    void deleteById(Long id);
}
