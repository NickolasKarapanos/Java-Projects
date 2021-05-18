public class Monkey extends AbstractAnimal {
    public Monkey(final String name, final double weight) {
        super(name,weight);
        // TODO your job
    }
    @Override public double getDailyFoodPercentage() {
        return 0.25;
    }

    @Override public String toString() {
        return "Monkey " + this.getName();
    }
}
