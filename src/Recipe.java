import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Recipe implements Priceable{
    private static int classId = 0;
    // object attributes
    private int id;
    private String recipeName;
    private RecipeLevel recipeLevel;
    private HashMap<Integer, WeightedIngredient> recipeIngredients;

    // constructor

    public Recipe() {
    }

    public Recipe(String recipeName, RecipeLevel recipeLevel) {
        this.id = classId++;
        this.recipeName = recipeName;
        this.recipeLevel = recipeLevel;
        this.recipeIngredients = new HashMap<>();
        Store.addRecipeCookBook(this);
    }

    //copy constructor
    public Recipe(Recipe recipe, double scaleFactor){
        this.id = recipe.getId();
        this.recipeName = recipe.recipeName + scaleFactor + "%";
        this.recipeLevel = recipe.recipeLevel;
        this.recipeIngredients = new HashMap<>();
    }

    // methods

    public int getId() {
        return id;
    }

    /**
     * Skalira recept - pravi novi recept za veću ili manju količinu jela u odnosu na primarni recept.
     * Vraca objekat klase Recipte, skalirani recept za uneti Scale Factor.
     * @param scaleFactor
     * @return
     */
    public Recipe getScaledRecipe(double scaleFactor) {
        var scaledRecipe = new Recipe(this, scaleFactor);

        for (var ingredient : this.recipeIngredients.entrySet()) {
            var weight = ingredient.getValue().getWeight() * (scaleFactor / 100);
            scaledRecipe.addIngredient(ingredient.getValue(), weight);
        }

        return scaledRecipe;
    }


    /**
     * Dodaje sastojke u recept.
     * @param ingredient
     * @param weight
     */
    public void addIngredient(WeightedIngredient ingredient, double weight) {
        var key = ingredient.getId();
        var ingredientForAdding = new WeightedIngredient(ingredient, weight);
        this.recipeIngredients.put(key, ingredientForAdding);
    }

    /**
     * Brise sastojke iz recepta.
     * @param ingredientId
     * @return
     */
    public boolean removeIngredient(int ingredientId) {
        for (var i = 0 ; i < recipeIngredients.size(); i++) {
            if (recipeIngredients.get(i).getId() == ingredientId) {
                recipeIngredients.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Vraća listu svih sastojaka koji cine recept.
     * @return
     */
    public HashMap<Integer, WeightedIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * Vraca ukupnu cenu recepta.
     * @return
     */
    @Override
    public double getPrice() {
        var price = 0.0;
        for(var ingredient : this.recipeIngredients.values()) {
            price += ingredient.getPrice();
        }
        return price;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public RecipeLevel getRecipeLevel() {
        return recipeLevel;
    }

    @Override
    public String toString() {
        var ingredients = "";
        for (var ingredient : this.recipeIngredients. values()) {
            ingredients += ingredient.getIngredientName() + "(" + ingredient.getWeight() + ") ";
        }
        return this.getId() + ". " + this.recipeName + " (" + this.recipeLevel + ")" + "\n    Ingredients : " + ingredients + "\n    Price: " + String.format("%.2f", this.getPrice());

    }

    /**
     * Ispisuje sve recepte iz odredjene kategorije.
     * @param level
     */
    public static void showRecipeFromCategory(RecipeLevel level) {
        var recipeByCategory = level + ":\n";
        for (var recipe : Store.getCookBook().values()) {
            if (recipe.getRecipeLevel() == level) {
                recipeByCategory += recipe + "\n";
            }
        }
        System.out.println(recipeByCategory);
    }

    /**
     * Kreira HashMap sa receptima iz odredjene kategorije.
     * @param level
     * @return
     */
    public static HashMap<Integer, Recipe> recipeFromCategory(RecipeLevel level) {
        var recipeByCategory = new HashMap<Integer, Recipe>();
        for (var recipe : Store.getCookBook().entrySet()) {
            if (recipe.getValue().getRecipeLevel() == level) {
                recipeByCategory.put(recipe.getKey(), recipe.getValue());
            }
        }
        return recipeByCategory;
    }
}
