import java.util.ArrayList;

public abstract class Chef {
    /**
     * Koja jela iz kuvara sa receptima je moguce napraviti
     * sa namirnicama iz frizidera.
     * Vraca true ukoliko je moguce napraviti bar jedno jelo, u suprotnom false.
     */
    public static boolean whatFoodCanMade() {
        System.out.println("Jela koje je moguce napraviti sa namirnicama iz frizidera:\n");
        var atLeastOne = false;
        for (var recipe : Store.getCookBook().values()) {
            var possible = canItMade(recipe);
            if (possible) {
                System.out.println("    " + recipe.getId() + ". " + recipe.getRecipeName());
                atLeastOne = true;
            }
        }
        if (!atLeastOne) {
            System.out.println("    Nije moguce napraviti ni jedno jelo!\n");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Koja jela (pola porcije) iz kuvara sa receptima je moguce napraviti
     * sa namirnicama iz frizidera.
     * Vraca true ukoliko je moguce napraviti bar jedno jelo, u suprotnom false.
     * @return
     */
    public static boolean whatHalfFoodCanMade() {
        System.out.println("Jela (pola porcije) koje je moguce napraviti sa namirnicama iz frizidera:\n");
        var atLeastOne = false;
        var scaledRecipes = new ArrayList<Recipe>();

        // skalira sve recepte za 50% i dodaje u listu skaliranih recepata.
        for (var recipe : Store.getCookBook().values()){
            scaledRecipes.add(recipe.getScaledRecipe(50));
        }

        for (var recipe : scaledRecipes) {
            var possible = canItMade(recipe);
            if (possible) {
                System.out.println("    " + recipe.getId() + ". " + recipe.getRecipeName());
                atLeastOne = true;
            }
        }
        if (!atLeastOne) {
            System.out.println("    Nije moguce napraviti ni jedno jelo!\n");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Proverava da li je moguce napraviti jelo za uneti recept.
     * Vraca true ako jeste ili false ako nije moguce
     * @param recipe
     * @return
     */
    public static boolean canItMade(Recipe recipe) {
        for (var ingredient : recipe.getRecipeIngredients().values()) {
            var key = ingredient.getId();
            // proverava da li namirnica iz recepta postoji u frizideru
            if (Fridge.isInFridge(key)) {
                var ingredientInFridge = Fridge.getIngredientsInFridge().get(key);

                // proverava da li je kolicina namirnice u frizideru dovoljna za zadati recept
                if (ingredient.getWeight() > ingredientInFridge.getWeight()) {
                    // vraca false ako nema dovoljna kolicina namirnice u frizideru
                    return false;
                }
            } else {
                // vraca false ako namirnice iz recepta nema u frizideru
                return false;
            }
        }
        // ako prodje kroz sve namirnice iz recepta i ne vrati false,
        // znaci da je moguce napraviti jelo i vraca true
        return true;
    }

    /**
     * Uzima namirnice iz frizidera prema unetom receptu i pravi jelo.
     * Vraća true ako je jelo uspesno napravljeno ili false ako nije.
     * @param recipe
     * @return
     */
    public static boolean makeFood(Recipe recipe) {
        if (canItMade(recipe)) {
            for (var ingredient : recipe.getRecipeIngredients().values()) {
                Fridge.takeFromFridge(ingredient);
            }
            System.out.println("    Uspesno ste napravili " + recipe.getRecipeName() + "! Prijatno, uzivajte!\n");
            return true;
        } else {
            System.out.println("    U frizideru nema dovoljno namirnica da bi se napravilo navedeno jelo!\n");
            return false;
        }
    }
}
