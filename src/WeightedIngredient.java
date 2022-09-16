public class WeightedIngredient extends Ingredient {
    // object attributes
    private double weight;
    private double pricePerUnit;
    private String unitOfMeasure;

    // constructors
    public WeightedIngredient(String ingredientName, double pricePerUnit, String unitOfMeasure) {
        super(ingredientName);
        this.pricePerUnit = pricePerUnit;
        this.unitOfMeasure = unitOfMeasure;
        Store.addIngredientInStore(this);
    }
    // copy constructor
    public WeightedIngredient(WeightedIngredient wIngredient, double weight) {
        super(wIngredient);
        this.pricePerUnit = wIngredient.getPricePerUnit();
        this.unitOfMeasure = wIngredient.getUnitOfMeasure();
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @Override
    public double getPrice() {
        return this.weight * this.pricePerUnit;
    }
}
