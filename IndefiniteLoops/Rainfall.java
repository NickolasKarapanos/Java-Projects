// Reads temperatures from the user, computes average and # days above average.
import java.util.*;

public class Rainfall {

    public static void main(final String[] args) {

        // read data
        final Scanner console = new Scanner(System.in);
        final List<Double> rain = new ArrayList<>(); // list to store days' temperatures
        while (console.hasNextDouble()) {    // read/store each day's temperature
            final double value = console.nextDouble();
            if(value>=0){
            rain.add(value);


            final int pos = rain.size() - 1;
            System.out.println("temp[" + pos + "] = " + value);
                 }
            }

            // calculate results
            final RainfallStats result = Totals.calculateStats(rain);
            if (result != null) {
                //  if(!(rain.size() > 0)){  // checks if array has input, exists if not.
                //throw new NullPointerException(" no info added");
                //  System.exit(0);
                //  }
                //  else {
                // report results if size > 0
                System.out.println("Cumulative rainfall: " + result.sum);
                System.out.printf("Average Rainfall = %.1f\n", result.average);
                System.out.println("Number of rainy days: " + result.rainy_days);
                System.out.println("Days non-negative:  " + result.non_neg);
                System.out.println("Number of dry days: " + result.dry_days);
            }
        /*else
             System.out.println("No input detected");
            */

    }
}
