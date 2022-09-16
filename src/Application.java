public class Application {
    public static void main(String[] args) {

        // Dodaje pocetne namirnice i recepte
        Store.openStore();

        int userInput;
        boolean flag = true;

        while (flag) {
            Menu.menu();
            userInput = User.mainMenuChose(0, 11);
            switch (userInput) {
                case 1:
                    // Add to the Fridge
                    flag = Menu.addInFridge();
                    break;
                case 2:
                    // Remove from the Fridge
                    flag = Menu.removeFromFridge();
                    break;
                case 3:
                    // What Food can make with item from fridge?
                    flag = Menu.whatFoodCanMade();
                    break;
                case 4:
                    // What Food (half) can make with item from fridge?
                    flag = Menu.whatHalfFoodCanMade();
                    break;
                case 5:
                    // Made chosen food
                    flag = Menu.madeFood();
                    break;
                case 6:
                    // What food can make with entered money
                    flag = Menu.availableFood();
                    break;
                case 7:
                    // View of recipe by difficulty
                    flag = Menu.viewRecipeByDifficulty();
                    break;
                case 8:
                    // What food from specific category can make with entered money
                    flag = Menu.availableFoodFromCategory();
                    break;
                case 9:
                    // Sort recipe by level
                    flag = Menu.sortRecipeByLevel();
                    break;
                case 10:
                    // Sort recipe by price
                    flag = Menu.sortRecipeByPrice();
                    break;
                case 11:
                    // Users favorite recipes
                    flag = Menu.favoriteRecipe();
                    break;
                case 0:
                    // Leave app
                    flag = false;
                    break;
                default:
                    System.out.println("\nPogresan unos! Pokusajte ponovo!");
            }
            System.out.println("\nHvala vam sto koristili nase usluge! Prijatan dan!");
        }

    }
}
