package com.mcfirm.abntechassignment.recipes;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @GetMapping
    @Operation(summary = "Find all recipes")
    List<Recipe> findAll() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    @Operation(summary = "Find all recipes by name")
    List<Recipe> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping("/search")
    @Operation(summary = "Find all recipes based on specified filters", description = "If you're using swagger UI, remove all fields you do not want to filter on")
    List<Recipe> findByAnything(@RequestBody(required = false) RecipeRequest recipeRequest) {
        return service.findByAnything(recipeRequest);
    }

    @PostMapping
    @Operation(summary = "Create a new recipe")
    Recipe save(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing recipe")
    Recipe update(@RequestBody Recipe recipe, @PathVariable Long id) {
        return service.update(recipe, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a recipe by id")
    void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
