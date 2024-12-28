/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecipeBox;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alexander Perez-Aquino
 * @version 1.0
 */
public class Recipe {

  // Initiating variables for use within Recipe class
  private String recipeName;
  private int servings;
  private ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
  private ArrayList<String> recipeInstructions = new ArrayList<>();
  private double totalCalories;

  // Getter and Setter methods
  
  /**
   * @return recipeName (String)
   * Returns the name of the recipe
   */
  public String getRecipeName() {
    return recipeName;
  }

  /**
   * @param recipeName (String)
   * Sets the name of the recipe
   */
  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }
  
  /**
   * 
   * @return servings  (int)
   * Returns the number of servings as an integer 
   */
  public int getServings() {
    return servings;
  }

  /**
   * 
   * @param servings (int)
   * Sets the number of servings
   */
  public void setServings(int servings) {
    this.servings = servings;
  }
  
  /**
   * 
   * @return recipeIngredients (ArrayList)
   * Returns the Ingredients of the recipe
   */
  public ArrayList<Ingredient> getRecipeIngredients() {
    return recipeIngredients;
  }
  
  /**
   * 
   * @param recipeIngredients (ArrayList)
   * Sets the Ingredients for the recipe
   */
  public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }

  /**
   * 
   * @return recipeInstructions (ArrayList)
   * Returns the Instructions for the recipe
   */
  public ArrayList<String> getRecipeInstructions() {
    return recipeInstructions;
  }
  
  /**
   * 
   * @param recipeInstructions (ArrayList)
   * Sets the instructions for the recipe
   */
  public void setRecipeInstructions(ArrayList<String> recipeInstructions) {
    this.recipeInstructions = recipeInstructions;
  }

  // Recipe constructor

    /**
     *
     */
  public Recipe() {
    this.recipeName = "";
    this.servings = 0;
    this.recipeIngredients = new ArrayList<>();
    this.recipeInstructions = new ArrayList<>();
    this.totalCalories = 0.0;
  }

  // Overloaded constructor

    /**
     *
     * @param recipeName
     * @param servings
     * @param recipeIngredients
     * @param recipeInstructions
     * @param totalCalories
     */
  public Recipe(String recipeName, int servings,
      ArrayList<Ingredient> recipeIngredients,
      ArrayList<String> recipeInstructions, double totalCalories) {
    this.recipeName = recipeName;
    this.servings = servings;
    this.recipeIngredients = recipeIngredients;
    this.recipeInstructions = recipeInstructions;
    this.totalCalories = totalCalories;
  }

  // Custom method to add instructions to the Recipe

    /**
     *
     */
  public void addInstructions() {
    String instruction = "";
    boolean addMoreInstructions = true;
    Scanner scnr = new Scanner(System.in);
    do {
      System.out.println("Please enter an instruction or type 'end' if you "
              + "are done with instructions: ");
      instruction = scnr.nextLine();
      if (instruction.toLowerCase().equals("end")) {
        addMoreInstructions = false;
      } else {
        recipeInstructions.add(instruction);
        addMoreInstructions = true;
      }
    } while (addMoreInstructions);
  }

  // Method to print the Recipe

    /**
     *
     */
  public void printRecipe() {
    System.out.println("Recipe: " + recipeName);
    System.out.println("Serves: " + servings);
    System.out.println("Ingredients: ");
    for (Ingredient ingredient : recipeIngredients) {
      System.out.println(ingredient.getIngredientAmount() + " " 
              + ingredient.getUnitMeasurement() + " of "
          + ingredient.getNameOfIngredient() + " which has " 
              + ingredient.getNumberOfCaloriesPerUnit() + " calories per "
          + ingredient.getUnitMeasurement());
    }
    System.out.println("Total Calories: " + totalCalories);
    System.out.println("Instructions: ");
    for (int i = 0; i < recipeInstructions.size(); i++) {
      String instruction = recipeInstructions.get(i);
      System.out.println((i + 1) + ": " + instruction);
    }
  }

  // Method to create a new Recipe

    /**
     *
     * @return
     */
  public Recipe createNewRecipe() {
    ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
    boolean addMoreIngredients = true;
    double totalCalories = 0.0;

    Scanner scnr = new Scanner(System.in);

    System.out.println("Please enter the recipe name: ");
    recipeName = scnr.nextLine(); // user input for the name of recipe

    System.out.println("Please enter the number of servings: ");
    int servings = scnr.nextInt(); // user input for number of servings
    scnr.nextLine(); // Consume the newline left by nextInt()

    // do while loop to add all the recipe ingredients the user wants to input
    do {
      Ingredient newIngredient = new Ingredient().addIngredient("");
      double ingredientCalories = newIngredient.getIngredientAmount() 
              * newIngredient.getNumberOfCaloriesPerUnit();
      newIngredient.setTotalCalories(ingredientCalories);
      totalCalories += ingredientCalories;

      recipeIngredients.add(newIngredient); // adding ingredients

      System.out.println("Would you like to add another ingredient? (yes or no): ");
      String response = scnr.nextLine();
      if (response.equalsIgnoreCase("no")) {
        addMoreIngredients = false;
      }
    } while (addMoreIngredients);

    Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients,
        recipeInstructions, totalCalories); //creating new Recipe called recipe1

    System.out.println("Would you like to add instructions to the recipe? (yes or no): ");
    String newInstruction = scnr.nextLine();

    if (newInstruction.equalsIgnoreCase("yes")) {
      recipe1.addInstructions();
    }

    recipe1.printRecipe(); //print recipe1
    return recipe1; //return recipe1 which is of type Recipe
  }
}