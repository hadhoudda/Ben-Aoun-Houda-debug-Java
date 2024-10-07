package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        //read symptoms
        List<String> listSymtoms  = analyticsCounter.getSymptoms();
        System.out.println(listSymtoms);
        //count symptoms
        Map<String, Integer> countSymptoms  = analyticsCounter.countSymptoms(listSymtoms);
        System.out.println(countSymptoms);
       //sorts symptots in alphabetical order
        Map<String, Integer> countSymptomsOrder  = analyticsCounter.sortSymptoms(countSymptoms);
        System.out.println(countSymptomsOrder);
        //write to file result.out
        analyticsCounter.writeSymptoms(countSymptomsOrder);
        System.out.println("write to file");

        //analyticsCounter.writeSymptoms((analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()))));
    }
}
