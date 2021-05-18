import java.util.List;

public class Totals{

    public static RainfallStats calculateStats(final List<Double> rain) {
        if(rain.size() ==0) {
            return null;
        }

        double sum = 0;
        int non_neg = 0;

        for (final double current: rain) {    // read/store each day's temperature

            if (current > 0) {
                sum += current;
                ++non_neg;
            }
        }



        final double average = sum / rain.size();


        int dry_days = 0 ;
        int rainy_days = 0;                      // see if each day is above average which is rainy days.
        for (final double current: rain) {      // or if below 5% average for dry days.
            if (current > average) {
                rainy_days++;
            }
            else if (current <= (.05 * average)) {
                dry_days++;
            }
        }




        return new RainfallStats(average, rainy_days, non_neg, dry_days, sum );
    }//end of calculatestats

}
