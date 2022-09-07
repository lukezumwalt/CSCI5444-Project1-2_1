package numbers;

import java.util.*;
import static java.lang.Math.*;

public class Analyzer {

    public void analyze( ArrayList<Double> numbers )
    {
        System.out.println( "+------------------------------------------------+");
        System.out.println( "| Reporting Statistical Analysis on Provided Set |");
        System.out.println( "+------------------------------------------------+");
        System.out.println( "Mean: " + mean( numbers ) );
        System.out.println( "Median: " + median(numbers) );
        System.out.println( "Mode: " + mode(numbers)[0] );
        System.out.println( "Variance: " + variance(numbers) );
        System.out.println( "Standard Deviation: " + standardDeviation(numbers) );
        System.out.println( "Minimum Value: " + minimumValue(numbers)[0] );
        System.out.println( "Maximum Value: " + maximumValue(numbers)[0] );
        System.out.println( "Maximum Occurrence: " + Arrays.toString(mode(numbers)) );
    }

    private static double mean(ArrayList<Double> numbers)
    {
        double sum = 0;
        int count = numbers.size();
        for (Double number : numbers) {
            sum += number;
        }
        return sum/count;
    }

    private static double median(ArrayList<Double> numbers)
    {
        numbers.sort(Comparator.naturalOrder());
        if( numbers.size() % 2 == 1)
        {
            // odd size
            return numbers.get( (int)floor( numbers.size()/2. ) );
        }
        else
        {
            // even size
            double i2 = numbers.get( numbers.size()/2 );
            double i1 = numbers.get( numbers.size()/2 - 1 );
            ArrayList<Double> interim = new ArrayList<>();
            interim.add(i1);
            interim.add(i2);
            return mean( interim );
        }

    }

    private static double[] mode(ArrayList<Double> numbers)
    {
        HashMap<Double, Double> modeTable = new HashMap<>();
        double entry;
        for (Double number : numbers) {
            entry = number;
            modeTable.putIfAbsent(entry, 0.0);
            modeTable.put(entry, modeTable.get(entry) + 1);
        }

        // Objects to help parse dictionary results and pass them between methods.
        ArrayList<Double> valueList = new ArrayList<>(modeTable.values());
        ArrayList<Double> keyList = new ArrayList<>(modeTable.keySet());

        double[] maxFrequency = maximumValue( valueList );
        return new double[]{keyList.get((int)maxFrequency[1]), valueList.get((int)maxFrequency[1])};
    }

    private static double variance(ArrayList<Double> numbers)
    {
        double s = mean(numbers);
        double l_sum = 0;
        for (Double number : numbers) {
            l_sum += pow(number - s, 2);
        }
        return l_sum/(numbers.size()-1);
    }

    private static double standardDeviation(ArrayList<Double> numbers)
    {
        return sqrt(variance(numbers));
    }

    private static double[] minimumValue(ArrayList<Double> numbers)
    {
        double min = numbers.get(0);
        int minIndex = 0;
        for(int i = 0; i < numbers.size(); ++i )
        {
            if( numbers.get(i) < min)
            {
                min = numbers.get(i);
                minIndex = i;
            }
        }
        return new double[]{min, minIndex};
    }

    private static double[] maximumValue(ArrayList<Double> numbers)
    {
        double max = numbers.get(0);
        int maxIndex = 0;
        for(int i = 0; i < numbers.size(); ++i )
        {
            if( numbers.get(i) > max)
            {
                max = numbers.get(i);
                maxIndex = i;
            }
        }
        return new double[]{max, maxIndex};
    }
}
