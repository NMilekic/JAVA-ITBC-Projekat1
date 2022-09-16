import java.util.HashMap;

public abstract class Store {
    private static HashMap<Integer, WeightedIngredient> ingredientInStore = new HashMap<>();
    private static HashMap<Integer, Recipe> cookBook = new HashMap<>();

    // methods

    /**
     * Pocetni proizvodi i recepti u prodavnici.
     */
    public static void openStore() {
        WeightedIngredient sugar = new WeightedIngredient("sugar", 100, "kg"); // 0
        WeightedIngredient milk = new WeightedIngredient("milk", 105, "l"); // 1
        WeightedIngredient flour = new WeightedIngredient("flour", 75, "kg"); // 2
        WeightedIngredient egg = new WeightedIngredient("egg", 20, "kom"); // 3
        WeightedIngredient nuts = new WeightedIngredient("nuts", 1100, "kg"); // 4
        WeightedIngredient hazelnuts = new WeightedIngredient("hazelnuts", 1300, "kg"); // 5
        WeightedIngredient tomato = new WeightedIngredient("tomato", 130, "kg"); // 6
        WeightedIngredient honey = new WeightedIngredient("honey", 1125, "kg"); //7
        WeightedIngredient cheese = new WeightedIngredient("cheese", 850, "kg"); // 8
        WeightedIngredient plazma = new WeightedIngredient("plazma", 705, "kg"); // 9
        WeightedIngredient raspberries = new WeightedIngredient("raspberries", 600, "kg"); // 10
        WeightedIngredient orange = new WeightedIngredient("orange", 300, "kg"); // 11
        WeightedIngredient lemon = new WeightedIngredient("lemon", 320, "kg"); // 12
        WeightedIngredient bacon = new WeightedIngredient("bacon", 950, "kg"); // 13
        WeightedIngredient fish = new WeightedIngredient("fish", 1200, "kg"); // 14
        WeightedIngredient chicken = new WeightedIngredient("chicken", 650, "kg"); // 15
        WeightedIngredient potato = new WeightedIngredient("potato", 80, "kg"); // 16
        WeightedIngredient garlic = new WeightedIngredient("garlic", 300, "kg"); // 17
        WeightedIngredient oliveOil = new WeightedIngredient("olive oil", 1200, "l"); // 18
        WeightedIngredient carrot = new WeightedIngredient("carrot", 105, "kg"); // 19
        WeightedIngredient salt = new WeightedIngredient("salt", 170, "kg"); // 20
        WeightedIngredient pepper = new WeightedIngredient("pepper", 4000, "kg"); // 21
        WeightedIngredient peas = new WeightedIngredient("peas", 300, "kg"); // 22
        WeightedIngredient parsley = new WeightedIngredient("parsley", 1300, "kg"); // 23
        WeightedIngredient chocoCream = new WeightedIngredient("choco cream", 750, "kg"); // 24
        WeightedIngredient banana = new WeightedIngredient("banana", 170, "kg"); // 25

        // BEGINNER
        // smuti plazmaShake : plazma(0.08), banana (0.2), milk (0.25)
        Recipe plazmaShake = new Recipe("plazma shake", RecipeLevel.BEGINNER);
        plazmaShake.addIngredient(ingredientInStore.get(9), 0.08);
        plazmaShake.addIngredient(ingredientInStore.get(25), 0.2);
        plazmaShake.addIngredient(ingredientInStore.get(1), 0.25);

        // smuti tropicMix : lemon(0.15), orange (0.2), banana (0.1), honey (0.03)
        Recipe tropicMix = new Recipe("tropic mix", RecipeLevel.BEGINNER);
        tropicMix.addIngredient(ingredientInStore.get(12), 0.2);
        tropicMix.addIngredient(ingredientInStore.get(11), 0.2);
        tropicMix.addIngredient(ingredientInStore.get(25), 0.1);
        tropicMix.addIngredient(ingredientInStore.get(7), 0.03);

        // HARD
        // chickenSoup : chicken (1.0) , potato (0.5), carrot (0.5), peas (0.3), salt (0.0025), pepper (0.0015)
        Recipe chickenSoup = new Recipe("chicken soup", RecipeLevel.HARD);
        chickenSoup.addIngredient(ingredientInStore.get(15), 1.0);
        chickenSoup.addIngredient(ingredientInStore.get(16), 0.5);
        chickenSoup.addIngredient(ingredientInStore.get(19), 0.5);
        chickenSoup.addIngredient(ingredientInStore.get(22), 0.3);
        chickenSoup.addIngredient(ingredientInStore.get(20), 0.0025);
        chickenSoup.addIngredient(ingredientInStore.get(21), 0.0015);

        // peasPotash : chicken (1.2), potato (0.3), peas (0.7), salt (0.0025), pepper (0.0025), milk (0.2)
        Recipe peasPotash = new Recipe("peas potash", RecipeLevel.HARD);
        peasPotash.addIngredient(ingredientInStore.get(15), 1.2);
        peasPotash.addIngredient(ingredientInStore.get(16), 0.3);
        peasPotash.addIngredient(ingredientInStore.get(22), 0.3);
        peasPotash.addIngredient(ingredientInStore.get(20), 0.0025);
        peasPotash.addIngredient(ingredientInStore.get(21), 0.0015);
        peasPotash.addIngredient(ingredientInStore.get(1), 0.2);


        // MEDIUM
        // riba lemonFish : fish (1), potato(1), garlic(0.25), oliveOil(0.15), lemon (0.5)
        Recipe lemonFish = new Recipe("lemon fish", RecipeLevel.MEDIUM);
        lemonFish.addIngredient(ingredientInStore.get(14), 1.0);
        lemonFish.addIngredient(ingredientInStore.get(16), 1.0);
        lemonFish.addIngredient(ingredientInStore.get(17), 0.25);
        lemonFish.addIngredient(ingredientInStore.get(18), 0.15);
        lemonFish.addIngredient(ingredientInStore.get(12), 0.5);

        // piletina honeyChicken : chicken (2.5), potato(1.5), honey(0.125), bacon(0.5)
        Recipe honeyChicken = new Recipe("honey chicken", RecipeLevel.MEDIUM);
        honeyChicken.addIngredient(ingredientInStore.get(15), 2.5);
        honeyChicken.addIngredient(ingredientInStore.get(16), 1.5);
        honeyChicken.addIngredient(ingredientInStore.get(7), 0.125);
        honeyChicken.addIngredient(ingredientInStore.get(13), 0.5);

        // EASY
        // jaja poachedEgg : agg (3), cheese (0.1), tomatoes (0.15)
        Recipe poachedEggs = new Recipe("poached eggs", RecipeLevel.EASY);
        poachedEggs.addIngredient(ingredientInStore.get(3), 3);
        poachedEggs.addIngredient(ingredientInStore.get(8), 0.1);
        poachedEggs.addIngredient(ingredientInStore.get(6), 0.15);

        // jaja baconEggs: agg (3), bacon (0.1), tomatoes (0.15)
        Recipe baconEggs = new Recipe("bacon eggs", RecipeLevel.EASY);
        baconEggs.addIngredient(ingredientInStore.get(3), 3);
        baconEggs.addIngredient(ingredientInStore.get(13), 0.1);
        baconEggs.addIngredient(ingredientInStore.get(6), 0.15);

        // PRO
        // chocoCake : chocoCream (0.5), milk (1.0), hazelnuts (0.3), nuts (0.3), egg (2), sugar(0.1)
        Recipe chocoCake = new Recipe("choco cake", RecipeLevel.PRO);
        chocoCake.addIngredient(ingredientInStore.get(24), 0.5);
        chocoCake.addIngredient(ingredientInStore.get(1), 1.0);
        chocoCake.addIngredient(ingredientInStore.get(5), 0.3);
        chocoCake.addIngredient(ingredientInStore.get(4), 0.3);
        chocoCake.addIngredient(ingredientInStore.get(3), 2);
        chocoCake.addIngredient(ingredientInStore.get(0), 0.1);

        // fruitCake : raspberries (1), lemon(0.1), banana (0.5), hazelnuts(0.3), egg(1), flour(0.5), milk (0.4)
        Recipe fruitCake = new Recipe("fruit cake", RecipeLevel.PRO);
        fruitCake.addIngredient(ingredientInStore.get(10), 1);
        fruitCake.addIngredient(ingredientInStore.get(12), 0.1);
        fruitCake.addIngredient(ingredientInStore.get(25), 0.5);
        fruitCake.addIngredient(ingredientInStore.get(5), 0.3);
        fruitCake.addIngredient(ingredientInStore.get(3), 1);
        fruitCake.addIngredient(ingredientInStore.get(2), 0.5);
        fruitCake.addIngredient(ingredientInStore.get(2), 0.4);
    }

    /**
     * Dodaje proizvod u prodavnicu.
     * Vraca true ukoliko je dodata namirnica u frizider, u suprotnom false.
     * @param ingredient
     * @return
     */
    public static boolean addIngredientInStore(WeightedIngredient ingredient) {
        var key = ingredient.getId();
        if (!isItemInStore(key)){
            ingredientInStore.put(key, ingredient);
            return true;
        }
        return false;
    }

    /**
     * Proverava da li je proizvod u prodavnici.
     * Vraca true ili false.
     * @param key
     * @return
     */
    public static boolean isItemInStore(int key) {
        var value = ingredientInStore.get(key);
        return value != null;
    }

    /**
     * Proverava da li je recept u kuvaru.
     * Vraca true ili false.
     * @param key
     * @return
     */
    public static boolean isRecipeInCookBook(int key) {
        var value = cookBook.get(key);
        return value != null;
    }

    /**
     * Vraca string sa svim namirnicama koje se nalaze u prodavnici prodavnici.
     * @return
     */
    public static String itemsInStore() {
        var namirnice = "";
        var count = 1;
        for (var ingredient : ingredientInStore.entrySet()) {
            if (count++ % 8 == 0) {
                namirnice += "\n\n";
            }
            namirnice += ingredient.getKey() + " : " + ingredient.getValue().getIngredientName() + " | ";
        }
        return namirnice;
    }

    /**
     * Dodaje recept u kuvar.
     * Ukoliko recept pod tim nazivom već postoji, naziv ostaje isti, a menja se recept.
     * @param recipe
     */
    public static void addRecipeCookBook(Recipe recipe) {
        cookBook.put(recipe.getId(), recipe);
    }

    /**
     * Vraca HashMap sa svim receptima u prodavnici.
     * @return
     */
    public static HashMap<Integer, Recipe> getCookBook() {
        return cookBook;
    }

    /**
     * Vraca odredjeni recept iz kuvara prema unetom id recepta.
     * @param key
     * @return
     */
    public static Recipe getRecipeFromCookBook(int key) {
        return cookBook.get(key);
    }

    /**
     * Vraca string sa spiskom svih recepata u prodavnici.
     * @return
     */
    public static String recipesInCookBook() {
        var recepti = "";
        for (var recipe : cookBook.entrySet()) {
            recepti += recipe.getValue().toString() + "\n";
        }
        return recepti;
    }

    /**
     * Vraca odredjenu namirnicu iz prodavnice prema unetom id namirnice.
     * @param key
     * @return
     */
    public static WeightedIngredient getItemFromStore(int key) {
        return ingredientInStore.get(key);
    }
}
