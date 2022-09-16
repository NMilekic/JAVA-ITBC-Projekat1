public abstract class Ingredient implements Priceable{
    // class attributes
    private static int classId = 0;

    // object attributes
    private String ingredientName;
    protected final int id;

    // constructor
    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
        this.id = classId++;
    }
    // copy constructor
    public Ingredient(Ingredient ingredient) {
        this.id = ingredient.id;
        this.ingredientName = ingredient.ingredientName;
    }

    // methods

    public int getId() {
        return id;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
