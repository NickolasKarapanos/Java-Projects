public class RainfallStats {

    public final int non_neg;
    public final double average;
    public final int rainy_days;
    public final int dry_days;
    public final double sum;

    public RainfallStats(final double average, final int rainy_days,final int non_neg,final int dry_days, double sum) {
        this.average = average;
        this.rainy_days = rainy_days;
        this.non_neg = non_neg;
        this.dry_days = dry_days;
        this.sum = sum;
    }

}