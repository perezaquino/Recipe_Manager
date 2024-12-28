/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package RecipeBox;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alexander Perez-Aquino
 * @version 1.0
 */


public class RecipeBox {
  ArrayList<Recipe> listOfRecipes = new ArrayList<>(); 

  /**
   * @param listOfRecipes (ArrayLIst)
   * Sets the list of Recipes
   */
  public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
    this.listOfRecipes = listOfRecipes;
  }

  /**
   * @return list of Recipes (ArrayList)
   * Returns the current recipes in the list
   */
  public ArrayList<Recipe> getListOfRecipes() {
    return listOfRecipes;
  }

  // Iniating Constructor

    /**
     *
     */
  public RecipeBox() {
    this.listOfRecipes = new ArrayList<>();
  }

  //Overloaded Constructor

    /**
     *
     * @param listOfRecipes
     */
  public RecipeBox(ArrayList<Recipe> listOfRecipes) {
    this.listOfRecipes = listOfRecipes;
  }

  // Method to print all of the Recipe names in the list of Recipes

    /**
     *
     */
  public void printAllRecipeNames() {
    for (int i = 0; i < listOfRecipes.size(); i++) {
      System.out.println(listOfRecipes.get(i).getRecipeName());
    }
  }

  /**
   * 
   * @param selectedRecipeName (String)
   * Prints all the details of the user selected Recipe Name
   * If Recipe name is not found then error message prints instead
   */
  public void printAllRecipeDetails(String selectedRecipeName) {
    for (Recipe recipe : listOfRecipes) {
      if (recipe.getRecipeName().equals(selectedRecipeName)) {
        recipe.printRecipe();
        return;
      } else {
        System.out.println("Recipe not found!");
      }
    }
  }

 /**
  * 
  * @param tempRecipe of type "Recipe"
  * Method to add a new Recipe to the current list of Recipes
  */
  public void addNewRecipe(Recipe tempRecipe) {
    listOfRecipes.add(tempRecipe);
  }

  // Custom method to delete a recipe

    /**
     *
     */
  public void deleteRecipe() {
    Scanner deleteScnr = new Scanner(System.in);
    System.out.println("Enter the name of the recipe to delete:");
    String recipeToDelete = deleteScnr.nextLine();
    boolean recipeFound = false;
    for (int j = 0; j < listOfRecipes.size(); j++) {
      if (listOfRecipes.get(j).getRecipeName().equals(recipeToDelete)) {
        listOfRecipes.remove(j);
        recipeFound = true;
        System.out.println("Recipe: " + recipeToDelete + " has been deleted.");
        break;
      }
    }
    if (!recipeFound) {
      System.out.println("Recipe not found! Please try again later.");
    }
  }

  // Custom method to add instructions to an existing recipe

    /**
     *
     */
  public void addRecipeInstructions() {
    Scanner instructionScnr = new Scanner(System.in);
    System.out.println("Enter the name of the recipe to add instructions to:");
    String recipeName = instructionScnr.nextLine();
    for (Recipe recipe : listOfRecipes) {
      if (recipe.getRecipeName().equals(recipeName)) {
        recipe.addInstructions();
        return;
      }
    }
    System.out.println("Recipe not found! Please try again later.");
  }

  //Main method
  // Start Menu

    /**
     *
     * @param args
     */
  public static void main(String[] args) {
      
    //creates new RecipeBox called myRecipeBox
    RecipeBox myRecipeBox = new RecipeBox();
    Scanner menuScnr = new Scanner(System.in);

    //Menu Options
    System.out.println("Menu:\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" 
            + "3. Print All Recipe Names\n"
        + "4. Delete a Recipe\n" + "5. Add Recipe Instructions\n" + "6. Exit program\n");

    //While loop to have the menu print after user selects and
    //completes an option
    boolean continueProgram = true;
    while (continueProgram) {
      int input = menuScnr.nextInt();
      menuScnr.nextLine();

      // switch cases to handle execution of methods once user input is detected
      switch (input) {
        case 1:
          Recipe newRecipe = new Recipe().createNewRecipe();
          myRecipeBox.addNewRecipe(newRecipe);
          break;
        case 2:
          System.out.println("Which recipe?");
          String selectedRecipeName = menuScnr.next();
          myRecipeBox.printAllRecipeDetails(selectedRecipeName);
          break;
        case 3:
          myRecipeBox.printAllRecipeNames();
          break;
        case 4:
          myRecipeBox.deleteRecipe();
          break;
        case 5:
          myRecipeBox.addRecipeInstructions();
          break;
        case 6:
          continueProgram = false;
          System.out.println("Exiting the program. Good-Bye!");
          break;
        default:
          System.out.println("Invalid option. Please select from the menu.");
          break;
      }
      System.out.println("Menu:\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + 
              "3. Print All Recipe Names\n"
          + "4. Delete a Recipe\n" + "5. Add Recipe Instructions\n" + "6. Exit program\n");
    }
  }
}