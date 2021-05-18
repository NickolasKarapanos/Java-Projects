import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TotalTester {

    final static double DELTA = 0.000000001;

    @Test
    public void testAverage1() {
        final List<Double> temps = Arrays.asList(3.4);
        final RainfallStats actual = Totals.calculateStats(temps);
        assertEquals(3.4, actual.average, DELTA);
        assertEquals(0, actual.dry_days);
        assertEquals(1, actual.non_neg);
        assertEquals(0, actual.rainy_days);
        assertEquals(3.4, actual.sum, DELTA);
    }


    @Test
    public void testAverage2() {
        final List<Double> temps = Arrays.asList(3.4, 3.6);
        final RainfallStats actual = Totals.calculateStats(temps);
        assertEquals(3.5, actual.average, DELTA);
        assertEquals(0, actual.dry_days);
        assertEquals(2, actual.non_neg);
        assertEquals(1, actual.rainy_days);
        assertEquals(7, actual.sum, DELTA);

    }


    @Test
    public void testAverage3() {
        final List<Double> temps = Arrays.asList();
        final RainfallStats actual = Totals.calculateStats(temps);
        assertNull(actual);
    }

}
