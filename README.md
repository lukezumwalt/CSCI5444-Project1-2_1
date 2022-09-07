# CSCI5444-Project1-2_1
### Lukas Zumwalt
* Java Version: Oracle openjdk-18.0.2.1

> This compiled package serves to meet CU Boulder course requirements for CSCI 5444 Project 1.2, Program 1



### This package conducts a statistical analysis on an incrementally provided set of real, rational numbers.

```
+ Mean
+ Median
+ Mode
+ Variance (of the sample)
+ Standard Deviation (of the sample)
+ Minimum Value (in natural order of the set)
+ Maximum Value (in natural order of the set)
+ Max Occurrence of a value, its literal-value and its count
```

## How To Use:
* Build and Run the main **_run.java_** file, a run terminal will pop up
* User provides **only** real numbers to the terminal stream
* Once a desired value is provided to terminal, carriage return (hit enter)
* After all values are provided, carriage return an empty line
* Statistical analysis is output to the user via terminal stream


## Important Notes:
* Mode will return the first most-occurring real number by natural order
    * i.e. if a provided set contained {1,1,2,3,3}, then **_mode(set)_** would return [1]
    * _although there are bi-modal/tri-modal/multi-modal cases, this was not explicit in the provided requirements, so this ought to suffice_
* Methods for **_maximumValue(set)_** and **_minimumValue(set)_** yield the outputs:
    * OUT[0] = max/min _value_ of the given set
    * OUT[1] = _index_ of max/min value of the given set
* There is no explicit functionality for **Max Occurrence**, rather **_mode(set)_** uses a dictionary to track value and its occurrence, and passes it to **_maximumValue(set)_**.  The terminal is set to show only the value when calling **_mode(set)_**, but shows both value and count for **Max Occurrence**, yielding:
    * OUT[0] = most occurring _value_ in the set (dict key)
    * OUT[1] = _count_ of most occurring _value_ in the set (dict value)
