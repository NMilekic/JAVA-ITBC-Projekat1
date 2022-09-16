import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    // class attributes
    private static ArrayList<Recipe> favoriteRecipe = new ArrayList<>();

    // static methods

    /**
     * Korisnikov izbor u glavnom meniju.
     * Validacija unosa korisnika za pocetni meni.
     * Vraca int, korisnikov izbor opcije iz menija.
     * @param num1
     * @param num2
     * @return
     */
    public static int mainMenuChose(int num1, int num2) {
        int userInput;
        Scanner sc = new Scanner(System.in);

        System.out.print("Vas izbor: ");
        try {
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Pogresan unos! Pokusajte ponovo!");
            return mainMenuChose(num1, num2);
        }

        if (!isValidChoiceInput(userInput, num1, num2)) {
            System.out.println("Pogresan unos! Pokusajte ponovo!");
            return mainMenuChose(num1, num2);
        }

        return userInput;
    }
    /**
     * Proverava da li je korisnik uneo broj za izbor opcije, u ponudjenom opsegu.
     * Vraca true ili false.
     * @param num1
     * @param num2
     * @return
     */
    public static boolean isValidChoiceInput(int userInput, int num1, int num2) {
        return  (userInput >= num1 && userInput <= num2);
    }

    /**
     * Korisnikov unos, npr. za iznos novca za koji zeli da proveri dostupnost namirnica.
     * Validacija da li je unos pozitivan i ceo broj. Da li je korisnik uneo ceo broj.
     * Vraca int, korisnikov unos.
     * @return
     */
    public static int secondMenuChoice() {
        int userInput;
        Scanner sc = new Scanner(System.in);

        System.out.print("\nVas izbor: ");
        try {
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Pogresan unos, unos moze biti samo pozitivan ceo broj, bez slova i znakova! Pokusajte ponovo!");
            return secondMenuChoice();
        }
        if (userInput < 0) {
            System.out.println("Pogresan unos, unos moze biti samo pozitivan ceo broj! Pokusajte ponovo!");
            return secondMenuChoice();
        }
        return userInput;
    }

    // User Weight Input

    /**
     * Unos kolicine korisnika.
     * @param userInput
     */
    public static void weightInput(int userInput) {

        // proverava da li je unos tip podatka koji nije double,
        // ako jeste vraca korisnika na unos kolicine
        var weight = weightInputValidate();

        // ako je vrednost kolicine negativna vraca korisnika na unos
        if (weight < 0) {
            System.out.println("Pogresan unos, kolicina mora biti pozitivan broj! Pokusajte ponovo!");
            weightInput(userInput);
        }  else {
            var item = Store.getItemFromStore(userInput);
            Fridge.addInFridge(item, weight);
        }
    }

    /**
     * Unos korisnika za kolicinu namirnica.
     * Validacija korisnikovog unosa kolicine.
     * Vraca double, korisnikov unos kolicine.
     * @return
     */
    private static double weightInputValidate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Unesite kolicinu: ");
        try {
            var weight = sc.nextDouble();
            return weight;
        } catch (Exception e) {
            System.out.println("Pogresan unos, mozete uneti samo broj, bez znakova i slova! Pokusajte ponovo!");
            return weightInputValidate();
        }
    }

    /**
     * Ispisuje sve recepte koji se nalaze u omiljenim receptima.
     * Vraca true ako ima bar jedan recept, u suprotnom false.
     * @return
     */
    public static boolean allFavoriteRecipe() {
        var allFavoriteRecipes = "";
        if (favoriteRecipe.size() == 0) {
            System.out.println("    U omiljenim jelima nema ni jedno jelo!");
            return false;
        } else {
            System.out.println(recipesInFavorites());
            return true;
        }
    }

    /**
     * Dodaje recept u omiljene recepte.
     * @param recipe
     */
    public static void addRecipeInFavorites(Recipe recipe) {
        favoriteRecipe.add(recipe);
    }

    /**
     * Brise recept iz omiljenih recepata.
     * @param id
     */
    public static void removeRecipeFromFavorites(int id) {
        for (var i = 0; i < favoriteRecipe.size(); i++) {
            if (favoriteRecipe.get(i).getId() == id) {
                favoriteRecipe.remove(i);
                break;
            }
        }
        System.out.println("");
    }

    /**
     * Vraca string sa svim receptima iz omiljenih recepata.
     * @return
     */
    public static String recipesInFavorites() {
        var recepti = "";
        for (var recipe : favoriteRecipe) {
            recepti += recipe.toString() + "\n";
        }
        return recepti;
    }

    /**
     * Proverava da li u omiljenim receptima postoji odredjeni recept.
     * Provera se vrsi prema id-u recepta.
     * Vraca true ili false.
     * @param id
     * @return
     */
    public static boolean isRecipeInFavorites(int id) {
        for (var recipe : favoriteRecipe) {
            if (recipe.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Recipe> getFavoriteRecipe() {
        return favoriteRecipe;
    }
}
