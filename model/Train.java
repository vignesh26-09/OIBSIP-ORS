package model;

import java.util.HashMap;

public class Train {

    private static HashMap<Integer, String> trainMap = new HashMap<>();

    static {
        trainMap.put(101, "Chennai Express");
        trainMap.put(102, "Madurai Express");
        trainMap.put(103, "Coimbatore Superfast");
    }

    public static String getTrainName(int trainNo) {
        return trainMap.getOrDefault(trainNo, "Unknown Train");
    }
}