import java.util.*;

public abstract class Menu {
    // Menu

    /**
     * Ispisuje opcije aplikacije
     */
    public static void menu() {

        System.out.println("\n-------------------MENU--------------------\n");

        System.out.println("Izaberite stavku iz MENIJA:\n");
        System.out.println("1.  Dodajte namirnicu u frizider");
        System.out.println("2.  Izbacite namirnicu iz frizidera");
        System.out.println("3.  Koja jela je moguce napraviti sa namirnicama iz frizidera?");
        System.out.println("4.  Koja jela (pola porcije) je moguce napraviti sa namirnicama iz frizidera?");
        System.out.println("5.  Izaberite koje jelo zelite da napravite");
        System.out.println("6.  Koja jela mogu da napravim za uneti iznos novca, sa namirnicama iz frizidera?");
        System.out.println("7.  Pogledajte recepte iz odredjene kategorije");
        System.out.println("8.  Izaberite kategoriju prema tezini jela, unesite iznas novca da proverite koja je jela moguce napraviti sa namirnicama iz frizidera?");
        System.out.println("9.  Pogledajte spisak jela sortiranih po tezini");
        System.out.println("10. Pogledajte spisak jela sortiranih po ceni");
        System.out.println("11. Pogledajte listu vasih omiljenih jela");
        System.out.println("0.  Napustite kuhinju\n");
    }

    // Menu...Choice - 1. Add to the Fridge

    /**
     * Dodaje namirnice u frizider
     * @return
     */
    public static boolean addInFridge() {
        System.out.println("------------------ 1. DODAVANJE NAMIRNICA U FRIZIDER ------------------\n");
        System.out.println("\nUnesite kod namirnice koju zelite da dodate u frizider:\n");
        System.out.println(Store.itemsInStore());

        var userInput = User.secondMenuChoice();

        // proverava da li namirnica postoji u prodavnici
        if (Store.isItemInStore(userInput)) {

            // dodaje namirnicu u frizider ukoliko je unos kolicine ispravan
            User.weightInput(userInput);

            var addedItem = Store.getItemFromStore(userInput).getIngredientName();
            System.out.println("Uspesno ste dodali " + addedItem + " u frizider!");

        }else {
            System.out.println("Ne postoji namirnica sa navedenim kodom! Pokusajte ponovo!\n\n");
            return addInFridge();
        }

        System.out.println("\nDa li zelite da dodate jos neki proizvod u frizider?");
        System.out.println("1.  Dodajte jos namirnica u frizider");
        System.out.println("2.  Povratak u glavni meni");
        System.out.println("3.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 3);

        switch (userInput2){
            case 1:
                return addInFridge();
            case 3:
                return false;
            default:
                return true;
        }
    }

    // Menu...Choice - 2. Remove from the Fridge

    /**
     * Uklanja namirnice iz frizidera
     * @return
     */
    public static boolean removeFromFridge() {
        System.out.println("------------------ 2. UKLANJANJE NAMIRNICA IZ FRIZIDERA ------------------\n");

        var itemInFridge = Fridge.itemInFridge();

        // provera da li u vrizideru ima bar jedna namirnica
        if (itemInFridge.length() < 2) {
            System.out.println("U frizideru nema ni jedna namirnica!");

            return menuManager2();

        } else {
            System.out.println("Unesite kod namirnice koju zelite da uklonite iz frizidera:");
            System.out.println(itemInFridge);

            var userInput = User.secondMenuChoice();

            // provera da li je namirnica u frizideru
            if (Fridge.isInFridge(userInput)) {
                Fridge.removeFromFridge(userInput);

                var deletedItem = Store.getItemFromStore(userInput).getIngredientName();
                System.out.println("Uspesno ste uklonili " + deletedItem + " iz frizidera!");
            } else {
                System.out.println("U frizideru ne postoji namirnica sa navedenim kodom! Pokusajte ponovo!\n");
            }

            System.out.println("\nDa li zelite da uklonite jos neki proizvod iz frizidera?");
            System.out.println("1.  Uklonite jos namirnica iz frizidera");
            System.out.println("2.  Povratak u glavni meni");
            System.out.println("3.  Napustanje aplikacije");

            var userInput2 = User.mainMenuChose(1, 3);

            switch (userInput2){
                case 1:
                    return removeFromFridge();
                case 2:
                    return true;
                default:
                    return false;
            }
        }
    }

    /**
     * Nudi opcije nakon izvrsenja izabrane opcije iz menija.
     * Povratak u glavni meni ili napustanje aplikacije.
     * Vraca true ili false.
     * @return
     */
    private static boolean menuManager2() {
        System.out.println("\nVratite se nazad i dodajte namirnice u frizider: ");
        System.out.println("1.  Povratak u glavni meni");
        System.out.println("2.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 2);

        switch (userInput2){
            case 1:
                return true;
            default:
                return false;
        }
    }

    /**
     * Nudi opcije nakon izvrsenja izabrane opcije iz menija.
     * Opcija za odlazak u deo aplikacije koja pravi novo jelo, povratak u glavni meni ili napustanje aplikacije.
     * Vraca true ili false.
     * @return
     */
    private static boolean menuManager3() {
        System.out.println("\nZelite li da napravite neko jelo?");
        System.out.println("1.  Napravite jelo");
        System.out.println("2.  Povratak u glavni meni");
        System.out.println("3.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 3);

        switch (userInput2){
            case 1:
                return madeFood();
            case 2:
                return true;
            default:
                return false;
        }
    }

    // Menu...Choice - 3. What Food can make with item from fridge?

    /**
     * Ispisuje koja jela je moguce napraviti sa namirnicama iz frizidera.
     * Vraca true ili false.
     * @return
     */
    public static boolean whatFoodCanMade() {
        System.out.println("------------------ 3. JELA KOJA JE MOGUCE NAPRAVITI SA NAMIRNICAMA IZ FRIZIDERA ------------------\n");

        var foodCanMake = Chef.whatFoodCanMade();

        if (foodCanMake) {
            return menuManager3();
        } else {
            return menuManager2();
        }

    }

    // Menu...Choice - 4. What Food (half) can make with item from fridge?

    /**
     * Ispisuje koja jela (pola porcije) je moguce napraviti sa namirnicama iz frizidera.
     * Vraca true ili false.
     * @return
     */
    public static boolean whatHalfFoodCanMade() {
        System.out.println("------------------ 4. JELA (POLA PORCIJE) KOJA JE MOGUCE NAPRAVITI SA NAMIRNICAMA IZ FRIZIDERA ------------------\n");

        var foodCanMake = Chef.whatHalfFoodCanMade();

        if (foodCanMake) {
            return menuManager3();
        } else {
            return menuManager2();
        }

    }

    // Menu...Choice - 5. Made chosen food

    /**
     * Pravi jelo izabrano od strane korisnika.
     * Vraca true ili false.
     * @return
     */
    public static boolean madeFood() {
        System.out.println("------------------ 5. PRIPREMA JELA ------------------");

        System.out.println("\nUnesite sifru jela koje zelite da napravite:\n");
        System.out.println(Store.recipesInCookBook());

        var userInput = User.secondMenuChoice();

        // provera da li kod izabranog jela odgovara id recepta iz kuvara
        if (Store.isRecipeInCookBook(userInput)) {
            Chef.makeFood(Store.getRecipeFromCookBook(userInput));
        } else {
            System.out.println("U kuvaru ne postoji recept sa navedenom sifrom! Pokusajte ponovo!");
        }

        System.out.println("\nZelite li da napravite neko drugo jelo?");
        System.out.println("1.  Napravi drugo jelo");
        System.out.println("2.  Povratak u glavni meni");
        System.out.println("3.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 3);

        switch (userInput2){
            case 1:
                return madeFood();
            case 2:
                return true;
            default:
                return false;
        }
    }

    // Menu...Choice - 6. What food can make with entered money

    /**
     * Ispisuje koja su jela dostupna za uneti novac.
     * Vraca true ili false.
     * @return
     */
    public static Boolean availableFood() {
        System.out.println("------------------ 6. DOSTUPNA JELA ZA NAVEDENI NOVAC ------------------\n");
        System.out.println("Unesite iznos novca za koji zelite da proverite dostupnost jela:");
        var userInput = User.secondMenuChoice();

        // true ukoliko je moguce napraviti bar jedno jelo u suprotnom false
        var foodCanMake = whatFoodForThatMoney(userInput, Store.getCookBook());

        // provera koji meni da prikaze, nakon ispisa dospupnih jela
        if (foodCanMake) {
            System.out.println("\nDa li zelite da proverite dostupnost jela za drugi iznos novca?");
            System.out.println("1.  Provera dostupnosti za drugi iznos");
            System.out.println("2.  Napravite jelo");
            System.out.println("3.  Povratak u glavni meni");
            System.out.println("4.  Napustanje aplikacije");

            var userInput2 = User.mainMenuChose(1, 4);

            switch (userInput2){
                case 1:
                    return availableFood();
                case 2:
                    return madeFood();
                case 3:
                    return true;
                default:
                    return false;
            }
        } else {
            System.out.println("\nDa li zelite da proverite dostupnost jela za drugi iznos novca?");
            System.out.println("1.  Provera dostupnosti za drugi iznos");
            System.out.println("2.  Povratak u glavni meni");
            System.out.println("3.  Napustanje aplikacije");

            var userInput2 = User.mainMenuChose(1, 3);

            switch (userInput2){
                case 1:
                    return availableFood();
                case 2:
                    return true;
                default:
                    return false;
            }
        }
    }

    /**
     * Ispisuje koja jela su dostupna za uneti novac.
     * Ispisuje koja jela je moguce napraviti u zavisnosti od namirnica u frizideru.
     * Vraca true ili false.
     * @param money
     * @param recipes
     * @return
     */
    public static boolean whatFoodForThatMoney(int money, HashMap<Integer, Recipe> recipes) {
        var canMakeButNoIngredients = "      ";
        var availableFood = "      ";

        var countNoAvailable = 1;
        var countAvailable = 1;

        for (var recipe : recipes.values()) {
            // provera da li je moguce napraviti odredjeno jelo za uneti novac
            if (recipe.getPrice() < money) {
                // proverava da li ima dovoljno namirnica u frizideru za uneto jelo
                if (!Chef.canItMade(recipe)) {
                    canMakeButNoIngredients += recipe.getId() + ". " + recipe.getRecipeName() + " | ";
                    countNoAvailable++;
                    if (countNoAvailable % 6 == 0) {
                        canMakeButNoIngredients += "\n      ";
                    }
                } else {
                    availableFood += recipe.getId() + ". " + recipe.getRecipeName() + " - " + recipe.getPrice() + " | ";
                    countAvailable++;
                    if (countAvailable % 6 == 0) {
                        availableFood += "\n\n      ";
                    }
                }
            }
        }

        if (countNoAvailable > 1) {
            System.out.println("Dostupna jela za navedeni novac, ali trenutno nemamo namirnica za pripremu:\n");
            System.out.println(canMakeButNoIngredients);
        }

        if (countAvailable == 1) {
            System.out.println("\nZa navedeni iznos nije moguce napraviti ni jedno jelo!");
            return false;
        } else {
            System.out.println("Dostupna jela za navedeni novac: \n");
            System.out.println(availableFood);
            return true;
        }
    }

    // Menu...Choice - 7. View of recipe by difficulty

    /**
     * Ispisuje recepte u zavisnosti od unete kategorije, tj. tezine recepta.
     * Vraca true ili false.
     * @return
     */
    public static boolean viewRecipeByDifficulty() {
        System.out.println("------------------ 7. RECEPTI IZ ODREDJENE KATEGORIJE ------------------\n");

        // izbor kategorije
        var choice = Menu.choseCategory();

        // ispis svih jela iz navedene kategorije
        Recipe.showRecipeFromCategory(choice);

        System.out.println("\nDa li zelite da da pogledate recepte za drugu kategoriju?");
        System.out.println("1.  Pogledaj recepte za drugu kategoriju");
        System.out.println("2.  Napravite jelo");
        System.out.println("3.  Povratak u glavni meni");
        System.out.println("4.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 4);

        switch (userInput2){
            case 1:
                return viewRecipeByDifficulty();
            case 2:
                return madeFood();
            case 3:
                return true;
            default:
                return false;
        }
    }

    /**
     * Nudi korisniku da izabere odredjenu kategorijiju
     * @return
     */
    public static RecipeLevel choseCategory() {
        System.out.println("Unesite kategoriju jela koju zelite da vidite:");
        System.out.println("1. BEGINNER");
        System.out.println("2. EASY");
        System.out.println("3. MEDIUM");
        System.out.println("4. HARD");
        System.out.println("5. PRO\n");

        RecipeLevel choice = null;
        var userInput = User.mainMenuChose(1, 5);

        switch (userInput) {
            case 1:
                choice = RecipeLevel.BEGINNER;
                break;
            case 2:
                choice = RecipeLevel.EASY;
                break;
            case 3:
                choice = RecipeLevel.MEDIUM;
                break;
            case 4:
                choice = RecipeLevel.HARD;
                break;
            case 5:
                choice = RecipeLevel.PRO;
                break;
            default:
        }
        return choice;
    }

    // Menu...Choice - 8. What food from specific category can make with entered money

    /**
     * Ispisuje dosptupna jela za unetu kategoriju i novac.
     * Vraca true ili false.
     * @return
     */
    public static boolean availableFoodFromCategory(){
        System.out.println("------------------ 8. DOSTUPNA JELA IZ ODREDJENE KATEGORIJE ZA NAVEDENI NOVAC ------------------\n");

        System.out.println("\nUnesite iznos kategorije iz koje zelite da proverite dostupnost jela:");
        var choice = Menu.choseCategory();

        System.out.println("\nUnesite iznos novca za koji zelite da proverite dostupnost jela:");
        var money = User.secondMenuChoice();

        // recepti iz unete kategorije
        var recipes = Recipe.recipeFromCategory(choice);
        whatFoodForThatMoney(money, recipes);

        System.out.println("\nDa li zelite da pogledate dostupna jela za drugu kategoriju za odredjeni novac?");
        System.out.println("1.  Pogledaj recepte za drugu kategoriju");
        System.out.println("2.  Napravite jelo");
        System.out.println("3.  Povratak u glavni meni");
        System.out.println("4.  Napustanje aplikacije");

        var userInput2 = User.mainMenuChose(1, 4);

        switch (userInput2){
            case 1:
                return availableFoodFromCategory();
            case 2:
                return madeFood();
            case 3:
                return true;
            default:
                return false;
        }
    }

    // Menu...Choice - 9. Sort recipe by level

    /**
     * Sortira jela prema kategorijama.
     * Vraca true ili false.
     * @return
     */
    public static boolean sortRecipeByLevel() {
        System.out.println("------------------ 9. SORTIRANJE RECEPATA PREMA TEZINI ------------------\n");
        var recipes = new ArrayList<>(Store.getCookBook().values());
        recipes.sort(Comparator.comparing(Recipe::getRecipeLevel).thenComparing(Recipe::getRecipeLevel));

        for (var recipe : recipes) {
            System.out.println(recipe);
        }

        return menuManager3();
    }

    // Menu...Choice - 10. Sort recipe by price

    /**
     * Sortira jela prema ceni.
     * Vraca true ili false.
     * @return
     */
    public static boolean sortRecipeByPrice() {
        System.out.println("------------------ 10. SPORTIRANJE RECEPATA PREMA CENI ------------------\n");

        var recipes = new ArrayList<>(Store.getCookBook().values());
        recipes.sort(Comparator.comparing(Recipe::getPrice).thenComparing(Recipe::getPrice));

        for (var recipe : recipes) {
            System.out.println(recipe);
        }

        return menuManager3();
    }

    // Menu...Choice - 11. Favorite recipe

    /**
     * Prikazuje omiljena jela i u zavisnosti od izbora korisnika dodaje ili brise omiljena jela.
     * Vraca true ili false.
     * @return
     */
    public static boolean favoriteRecipe() {
        System.out.println("------------------ 11. OMILJENA JELA ------------------\n");
        var allFavoriteRecipe = User.allFavoriteRecipe();

        if (allFavoriteRecipe) {
            System.out.println("\nDa li zelite da dodate jelo u omiljena jela?");
            System.out.println("1.  Dodaj jelo u omiljena jela");
            System.out.println("2.  Izbaci jelo iz omiljenih jela");
            System.out.println("3.  Proverite dostupnost omiljenih jela za odredjeni novac");
            System.out.println("4.  Povratak u glavni meni");
            System.out.println("5.  Napustanje aplikacije");

            var userInput2 = User.mainMenuChose(1, 5);

            switch (userInput2){
                case 1:
                    return addFavorite();
                case 2:
                    return removeFavorite();
                case 3:
                    return availableFoodFromFavorites();
                case 4:
                    return true;
                default:
                    return false;
            }
        } else {
            System.out.println("\nDa li zelite da dodate jelo u omiljena jela?");
            System.out.println("1.  Dodaj jelo u omiljena jela");
            System.out.println("2.  Povratak u glavni meni");
            System.out.println("3.  Napustanje aplikacije");

            var userInput2 = User.mainMenuChose(1, 3);

            switch (userInput2){
                case 1:
                    return addFavorite();
                case 2:
                    return true;
                default:
                    return false;
            }

        }
    }

    /**
     * Dodaje  jelo u omiljena jela.
     * @return
     */
    private static boolean addFavorite() {
        System.out.println("\nUnesite sifru jela koje zelite da dodate u omiljena jela: \n");
        System.out.println(Store.recipesInCookBook());

        var userInput = User.secondMenuChoice();

        if (Store.isRecipeInCookBook(userInput)){
            if (User.isRecipeInFavorites(userInput)) {
                System.out.println("    Navedeno jelo se vec nalazi u omiljenim jelima!");
                return favoriteRecipe();
            } else {
                User.addRecipeInFavorites(Store.getRecipeFromCookBook(userInput));
                System.out.println("    Uspesno ste dodali jelo u omiljena jela!");
                return favoriteRecipe();
            }
        } else {
            System.out.println("    Jelo sa navedenom sifrom ne postoji u kuvaru!");
            return favoriteRecipe();
        }
    }

    /**
     * Brise jelo iz omiljenih jela.
     * @return
     */
    private static boolean removeFavorite() {
        System.out.println("\nUnesite sifru jela koje zelite da izbacite iz omiljenih jela: \n");
        System.out.println(User.recipesInFavorites());

        var userInput = User.secondMenuChoice();

        if (User.isRecipeInFavorites(userInput)) {
            User.removeRecipeFromFavorites(userInput);
            System.out.println("    Uspesno ste izbacili jelo iz omiljenih jela!");
            return favoriteRecipe();
        } else {
            System.out.println("    Jelo sa navedenom sifrom nije u omiljenim jelima!");
            return favoriteRecipe();
        }
    }

    /**
     * Proverava dostupnost omiljenih jela za uneti iznos.
     * @return
     */
    private static boolean availableFoodFromFavorites() {
        System.out.println("\nUnesite iznos novca za koji zelite da proverite dostupnost omiljenih jela:");

        var userInput = User.secondMenuChoice();

        var availableFood = "";
        for (var recipe : User.getFavoriteRecipe()) {
            if (recipe.getPrice() < userInput) {
                availableFood += recipe.toString() + "\n";
            }
        }

        if (availableFood.length() < 1) {
            System.out.println("\n    Za navedeni novac nema dostupnih omiljenih jela!\n");
            return favoriteRecipe();
        } else {
            System.out.println("\nDostupna jela za uneti novac su:\n");
            System.out.println(availableFood + "\n");
            return favoriteRecipe();
        }
    }
}
