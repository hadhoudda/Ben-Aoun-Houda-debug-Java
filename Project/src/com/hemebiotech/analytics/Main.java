package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project/Resources/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("Project/Resources/result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        //read symptoms from file "symptoms.txt"
        List<String> listSymptoms  = analyticsCounter.getSymptoms();
        System.out.println(listSymptoms);
        //count symptoms
        Map<String, Integer> countSymptoms  = analyticsCounter.countSymptoms(listSymptoms);
        System.out.println(countSymptoms);
       //sorts symptoms in alphabetical order
        Map<String, Integer> countSymptomsOrder  = analyticsCounter.sortSymptoms(countSymptoms);
        System.out.println(countSymptomsOrder);
        //write to file result.out
        analyticsCounter.writeSymptoms(countSymptomsOrder);
        System.out.println("write to file");
    }
}