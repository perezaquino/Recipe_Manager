/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecipeBox;

import java.util.Scanner;

/**
 *
 * @author Alexander Perez-Aquino
 * @version 1.0
 */
public class Ingredient {

  private String nameOfIngredient = "";
  private double ingredientAmount = 0.0;
  private int numberOfCaloriesPerUnit = 0;
  private double totalCalories = 0.0;
  private String unitMeasurement = "";
  private final int MAX_AMOUNT = 100;
  private final int MAX_CALORIES = 1000;

  /**
   * @return the nameOfIngredient (String)
   * Returns the name of the Ingredient
   */
  public String getNameOfIngredient() {
    return nameOfIngredient;
  }

  /**
   * @param nameOfIngredient (String)
   * Sets the name of the Ingredient
   */
  public void setNameOfIngredient(String nameOfIngredient) {
    this.nameOfIngredient = nameOfIngredient;
  }

  /**
   * @return the unitMeasurement (String)
   * Returns the unit of measurement for the Ingredient
   */
  public String getUnitMeasurement() {
    return unitMeasurement;
  }

  /**
   * @param unitMeasurement the unitMeasurement to set (String
   * Sets the unit of measurement for the Ingredient
   */
  public void setUnitMeasurement(String unitMeasurement) {
    this.unitMeasurement = unitMeasurement;
  }

  /**
   * @return ingredientAmount (double)
   * Returns the amount of the ingredient
   */
  public double getIngredientAmount() {
    return ingredientAmount;
  }

  /**
   * @param ingredientAmount (double)
   * Sets the amount of the Ingredient
   */
  public void setIngredientAmount(double ingredientAmount) {
    this.ingredientAmount = ingredientAmount;
  }

  /**
   * @return the numberOfCaloriesPerUnit (int)
   * Returns the number of calories per unit of measurement of Ingredient
   */
  public int getNumberOfCaloriesPerUnit() {
    return numberOfCaloriesPerUnit;
  }

  /**
   * @param numberOfCaloriesPerUnit (int)
   * Sets the number of calories per unit of measurement of Ingredient
   */
  public void setNumberOfCaloriesPerUnit(int numberOfCaloriesPerUnit) {
    this.numberOfCaloriesPerUnit = numberOfCaloriesPerUnit;
  }

  /**
   * @return the totalCalories (double)
   * Returns the total Calories of the amount of Ingredient
   */
  public double getTotalCalories() {
    return totalCalories;
  }

  /**
   * @param totalCalories (double)
   * Sets the total number of calories
   */
  public void setTotalCalories(double totalCalories) {
    this.totalCalories = totalCalories;
  }

  // Initializing Constructor

    /**
     *
     */
  public Ingredient() {
    this.nameOfIngredient = "";
    this.unitMeasurement = "";
    this.ingredientAmount = 0;
    this.numberOfCaloriesPerUnit = 0;
    this.totalCalories = 0.0;
  }

  // Overloaded Constructor

    /**
     *
     * @param nameOfIngredient
     * @param unitMeasurement
     * @param ingredientAmount
     * @param numberOfCaloriesPerUnit
     * @param totalCalories
     */
  public Ingredient(String nameOfIngredient, String unitMeasurement,
      double ingredientAmount, int numberOfCaloriesPerUnit, double totalCalories) {
    this.nameOfIngredient = nameOfIngredient;
    this.unitMeasurement = unitMeasurement;
    this.ingredientAmount = ingredientAmount;
    this.numberOfCaloriesPerUnit = numberOfCaloriesPerUnit;
    this.totalCalories = totalCalories;
  }

  // method to create a new Ingredient to be used in Recipe

    /**
     *
     * @param tempNameOfIngredient
     * @return
     */
  public Ingredient addIngredient(String tempNameOfIngredient) {
    Scanner scnr = new Scanner(System.in);

    // Creates New Ingredient "newIngredient" of type "Ingredient"
    Ingredient newIngredient = new Ingredient();

    // Prompt user to input the name of the ingredient
    System.out.println("Please enter the name of the ingredient: ");
    newIngredient.setNameOfIngredient(scnr.nextLine());

    // Prompt user to enter the unit of measurement for this ingredient
    System.out
        .println("Please enter the unit of measurement for this ingredient. "
                + "Enter one of the following options: ");
    System.out.println("Cup(s), Tbsp(s), Gram(s), Tsp(s), Oz(s)");
    newIngredient.setUnitMeasurement(scnr.next().toLowerCase());
    scnr.nextLine(); // Consume the newline

    // Validate the unit of measurement
    while (!(newIngredient.getUnitMeasurement().equals("cup(s)") ||
        newIngredient.getUnitMeasurement().equals("tbsp(s)") ||
        newIngredient.getUnitMeasurement().equals("tsp(s)") ||
        newIngredient.getUnitMeasurement().equals("gram(s)") ||
        newIngredient.getUnitMeasurement().equals("oz(s)"))) {
      System.out.println("Please enter one of the mentioned options.");
      newIngredient.setUnitMeasurement(scnr.next().toLowerCase());
      scnr.nextLine(); // Consume the newline
    }

    // Prompt user to enter the amount of ingredient
    System.out.println("Please enter the number of " + newIngredient.getUnitMeasurement() + " of "
        + newIngredient.getNameOfIngredient() + " we'll need (between 1 and 100): ");

    // Validate acceptable amount of ingredient based on MAX_AMOUNT allowed
    if (scnr.hasNextInt()) {
      newIngredient.setIngredientAmount(scnr.nextInt());
      scnr.nextLine(); // Consume the newline
      if (newIngredient.getIngredientAmount() < 1 || newIngredient.getIngredientAmount() > MAX_AMOUNT) {
        System.out.println("Invalid amount. Please enter a number between 1 and 100.");
      }
    } else {
      System.out.println("Error: That is not a number. Please try again.");
    }

    // Prompt user to enter the amount of calories contained in the selected
    // unitMeasurement
    System.out.println("Please enter the amount of calories per " 
            + newIngredient.getUnitMeasurement() + ": ");

    // Validating acceptable number of calories per based on MAX_CALORIES allowed
    if (scnr.hasNextInt()) {
      newIngredient.setNumberOfCaloriesPerUnit(scnr.nextInt());
      scnr.nextLine(); // Consume the newline
      if (newIngredient.getNumberOfCaloriesPerUnit() < 0 || newIngredient.getNumberOfCaloriesPerUnit() 
              > MAX_CALORIES) {
        System.out.println("Invalid amount. Please enter a number between 0 "
                + "and 1000.");
      }
    } else {
      System.out.println("Error: That is not a number. Please try again.");
    }

    // Calculate the totalCalories
    newIngredient.setTotalCalories(newIngredient.getIngredientAmount() 
            * newIngredient.getNumberOfCaloriesPerUnit());

    // Print to the console to confirm name of ingredient and corresponding details
    System.out.println("The amount of " + newIngredient.getNameOfIngredient() + " required is "
        + newIngredient.getIngredientAmount() + " " + newIngredient.getUnitMeasurement()
        + " for a total of " + newIngredient.getTotalCalories() + " calories.");

    return newIngredient; // return newIngredient of whic is of type Ingredient
  }
}
