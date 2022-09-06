package com.mcfirm.abntechassignment.recipes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer servings; // Spring JPA query by example does not ignore primitive default values

    @Enumerated(EnumType.STRING)
    private Course course;
    @Enumerated(EnumType.STRING)
    private Diet diet;

    @ElementCollection
    private List<String> ingredients;

    private String instructions;

    public Recipe() {}

    public Recipe(String name, int servings, Course course, Diet diet, List<String> ingredients, String instructions) {
        this.name = name;
        this.servings = servings;
        this.course = course;
        this.diet = diet;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }



    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", servings=" + servings +
                ", course=" + course +
                ", diet=" + diet +
                ", ingredient=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
