package com.practice;


import java.util.ArrayList;
import java.util.List;

/*

        Assumption if it arrives at the same time - allot different platforms

        Input: arr[] = {9:00, 9:40, 9:40, 11:00, 15:00, 18:00}
               dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
        Output: 3



        Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
               dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
        Output: 3

        Explanation: There are at-most three trains at a time (time between 11:00 to 11:20)

        Input: arr[] = {9:00, 9:40}
               dep[] = {9:10, 12:00}
        Output: 1

platform 1  [910]
900
910
departuresPerPlatform[910]

platform 1
940
1200
departuresPerPlatform[1200]

platform 2
9:50
11:20
departuresPerPlatform[1200,1120]

platform 3
11:00
11:30
departuresPerPlatform[1200,1120,1100]

platform 1
15:00
19:00
departuresPerPlatform[1900,1120,1100]

platform
18:00
20:00
departuresPerPlatform[1900,1800,1100]

if(arrival > any element in the departure array) {
  // replace the value
}
else{
  //add the value to the array
}
departuresPerPlatform[910]

questions to be asked?
- is arrival & departure always paired?


*/
public class MinimumPlatformsInStation {

    private static int numberOfMinimumPlatforms(int[] arrivals, int[] departures) {

        if (arrivals.length != departures.length) {
            throw new RuntimeException("Size of arrivals & departures don't match");
        }

        List<Integer> departuresPerPlatform = new ArrayList<>();
        boolean found = false;
        for (int trainIndex = 0; trainIndex < arrivals.length; ++trainIndex) {
            found = false;
            for (int depIndex = 0; depIndex < departuresPerPlatform.size(); ++depIndex) {
                if (departuresPerPlatform.get(depIndex) < arrivals[trainIndex]) {
                    departuresPerPlatform.set(depIndex, departures[trainIndex]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                departuresPerPlatform.add(departures[trainIndex]);
            }
        }
        System.out.println("Trains last departed from different platforms " + departuresPerPlatform);
        return departuresPerPlatform.size();
    }

    public static void main(String[] args) {

        int[] arrivals = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departures = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(numberOfMinimumPlatforms(arrivals, departures));

        arrivals = new int[]{900, 940, 940, 1100, 1500, 1800};
        departures = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(numberOfMinimumPlatforms(arrivals, departures));

        arrivals = new int[]{900};
        departures = new int[]{910};
        System.out.println(numberOfMinimumPlatforms(arrivals, departures));

        arrivals = new int[]{};
        departures = new int[]{};
        System.out.println(numberOfMinimumPlatforms(arrivals, departures));

        arrivals = new int[]{900, 920};
        departures = new int[]{910};
        System.out.println(numberOfMinimumPlatforms(arrivals, departures));

    }

}
