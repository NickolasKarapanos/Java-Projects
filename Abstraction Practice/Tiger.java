public class Tiger extends AbstractAnimal {
    public Tiger(final String name, final double weight) {
        super(name,weight);
        // TODO your job
    }
    @Override public double getDailyFoodPercentage() {
        return 0.05;
    }

    @Override public String toString() {
        return "Tiger " + this.getName();
    }
}
