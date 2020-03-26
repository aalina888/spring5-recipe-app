package com.aalina.spring5recipeapp.services;

import com.aalina.spring5recipeapp.commands.RecipeCommand;
import com.aalina.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
