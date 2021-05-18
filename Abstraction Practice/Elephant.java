public class Elephant extends AbstractAnimal {
    public Elephant(final String name, final double weight) {
        super(name,weight);
        // TODO your job
    }
    @Override public double getDailyFoodPercentage() {
        return 0.1;
    }

    @Override public String toString() {
        return "Elephant " + this.getName();
    }
    // TODO override toString so that the elephant reports its name (as in the output)
}
