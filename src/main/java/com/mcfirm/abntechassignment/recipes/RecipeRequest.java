package com.mcfirm.abntechassignment.recipes;

import lombok.Data;

import java.util.List;

@Data
public class RecipeRequest {
    private Integer servings;
    private Course course;
    private Diet diet;
    private List<String> ingredients;
    private String instructions;
}
