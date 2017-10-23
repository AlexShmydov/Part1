package com.company;

import Enums.Texts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TournamentProcessor {

    private String[] runnersNames;
    private int[] runnersTime;
    private Map<Integer, String> data = new HashMap<Integer, String>();
    private ArrayList<Integer> sortedArrayList = new ArrayList<>();

    public TournamentProcessor(String[] runnersNames, int[] runnersTime) {
        this.runnersNames = runnersNames;
        this.runnersTime = runnersTime;

        int counter = 0;
        while (counter < this.runnersNames.length) {
            this.data.put(this.runnersTime[counter], runnersNames[counter]);
            counter++;
        }

        for (Integer place : runnersTime) {
            sortedArrayList.add(place);
        }
    }

    public void printResultsOfTournament() {
        Collections.sort(sortedArrayList);
        System.out.println(Texts.ALL_RUNNERS_SORTED_MSG.getValue());
        for (Integer place : sortedArrayList) {
            System.out.println(String.format(Texts.TEMPLATE_RUNNER.getValue(), data.get(place), getKeyByValue(data, data.get(place))));
        }
    }

    public void printBestRunner(){
        System.out.println(String.format(Texts.BEST_RUNNER_MSG.getValue(), data.get(sortedArrayList.get(0)), sortedArrayList.get(0)));
    }

    public void printRunnerByPlace(int place){
        System.out.println(String.format(Texts.RUNNER_MSG.getValue(), place, data.get(sortedArrayList.get(place-1)), getKeyByValue(data, data.get(sortedArrayList.get(place-1)))));
    }

    private static Object getKeyByValue(Map<Integer, String> data, Object value) {
        for (Map.Entry<Integer, String> record : data.entrySet()) {
            if (record.getValue().equals(value)) {
                return record.getKey();
            }
        }
        return null;
    }
}