package numbers;

import java.util.*;
import static java.lang.Math.*;

public class Analyzer {

    public void analyze( ArrayList<Integer> numbers )
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

    public static double mean(ArrayList<Integer> numbers)
    {
        double sum = 0;
        int count = numbers.size();
        for( int i = 0; i < count; ++i )
        {
            sum += numbers.get(i);
        }
        return sum/count;
    }

    public static double median(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> temp = numbers;
        temp.sort(Comparator.naturalOrder());
        if( temp.size() % 2 == 1)
        {
            // odd size
            return temp.get( (int)floor( temp.size()/2 ) );
        }
        else
        {
            // even size
            int i2 = temp.get( temp.size()/2 );
            int i1 = temp.get( temp.size()/2 - 1 );
            ArrayList<Integer> interim = new ArrayList<Integer>();
            interim.add(i1);
            interim.add(i2);
            return mean( interim );
        }

    }

    public static int[] mode(ArrayList<Integer> numbers)
    {
        HashMap<Integer, Integer> modeTable = new HashMap<Integer, Integer>();
        int entry;
        for(int i = 0; i < numbers.size(); ++i )
        {
            entry = numbers.get(i);
            if(modeTable.get(entry) == null )
            {
                modeTable.put(entry,0);
            }
            modeTable.put(entry, modeTable.get(entry)+1);
        }

        // Objects to help parse dictionary results and pass them between methods.
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        ArrayList<Integer> keyList = new ArrayList<Integer>();
        valueList.addAll(modeTable.values());
        keyList.addAll(modeTable.keySet());

        int[] maxFrequency = maximumValue( valueList );
        int[] retVal = {keyList.get(maxFrequency[1]), valueList.get(maxFrequency[1])};
        return retVal;
    }

    public static double variance(ArrayList<Integer> numbers)
    {
        double s = mean(numbers);
        double l_sum = 0;
        for(int i = 0; i< numbers.size(); ++i )
        {
            l_sum += pow( numbers.get(i) - s, 2);
        }
        return l_sum/(numbers.size()-1);
    }

    public static double standardDeviation(ArrayList<Integer> numbers)
    {
        return sqrt(variance(numbers));
    }

    public static int[] minimumValue(ArrayList<Integer> numbers)
    {
        int min = numbers.get(0);
        int minIndex = 0;
        for(int i = 0; i < numbers.size(); ++i )
        {
            if( numbers.get(i) < min)
            {
                min = numbers.get(i);
                minIndex = i;
            }
        }
        int[] retVal = {min, minIndex};
        return retVal;
    }

    public static int[] maximumValue(ArrayList<Integer> numbers)
    {
        int max = numbers.get(0);
        int maxIndex = 0;
        for(int i = 0; i < numbers.size(); ++i )
        {
            if( numbers.get(i) > max)
            {
                max = numbers.get(i);
                maxIndex = i;
            }
        }
        int[] retVal = {max, maxIndex};
        return retVal;
    }
}
