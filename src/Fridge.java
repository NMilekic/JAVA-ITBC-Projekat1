import java.util.HashMap;

public abstract class Fridge {
    private static HashMap<Integer, WeightedIngredient> ingredientsInFridge = new HashMap<>();

    /**
     * Dodaje namirnicu u frizider. Ukoliko namirnica već postoji u frizideru dodaje
     * na postojeću količinu koja se nalazi u frizideru. Ukoliko namirnica ne postoji
     * u frižideru, dodaje namirnicu.
     * @param ingredient
     * @param weight
     */
    public static void addInFridge(WeightedIngredient ingredient, double weight) {
        // ako namirnica postoji u frizideru, dodaje na postojecu kolicinu
        var key = ingredient.getId();
        if(isInFridge(key)) {
            var ingredientInFridge = ingredientsInFridge.get(key);
            ingredientInFridge.setWeight(ingredientInFridge.getWeight() + weight);
        //ako ne postoji dodaje novu namirnicu u frizider
        } else {
            addNewInFridge(ingredient, weight);
        }
    }

    /**
     * Proverava da li je namirnica u frizideru.
     * Vraća true ili false.
     * @param key
     * @return
     */
    public static boolean isInFridge(int key) {
        var value = ingredientsInFridge.get(key);
        return value != null;
    }

    /**
     * Dodaje novu namirnicu u frizider.
     * @param ingredient
     * @param weight
     */
    private static void addNewInFridge(WeightedIngredient ingredient, double weight) {
        var key = ingredient.getId();
        var ingredientForAdding = new WeightedIngredient(ingredient, weight);
        ingredientsInFridge.put(key, ingredientForAdding);
    }

    /**
     * Uzima određenu namirnicu iz frizidera. Ako nakon uzimanja namirnice
     * u frizideru bude kolicina te namirnice 0, brise namirnicu iz frizidera.
     * @param ingredient
     */
    public static void takeFromFridge(WeightedIngredient ingredient) {
        var key = ingredient.getId();
        var ingredientInFridge = ingredientsInFridge.get(key);
        ingredientInFridge.setWeight(ingredientInFridge.getWeight() - ingredient.getWeight());

        if (ingredientInFridge.getWeight() < 0.001) {
            removeFromFridge(key);
        }
    }

    /**
     * Uklanja namirnicu iz frizidera.
     * @param key
     */
    public static void removeFromFridge(int key) {
        ingredientsInFridge.remove(key);
    }

    public static HashMap<Integer, WeightedIngredient> getIngredientsInFridge() {
        return ingredientsInFridge;
    }

    /**
     * Vraca string koje se sve namirnice nalaze u frizideru.
     * @return
     */
    public static String itemInFridge() {
        var namirnice = "";
        var count = 1;
        for (var ingredient : ingredientsInFridge.entrySet()) {
            if (count++ % 5 == 0) {
                namirnice += "\n\n";
            }
            namirnice += ingredient.getKey() + " : " + ingredient.getValue().getIngredientName() + " - " + ingredient.getValue().getWeight() + " " + ingredient.getValue().getUnitOfMeasure() + " | ";
        }

        return namirnice;
    }
}
