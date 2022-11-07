package com.metrocard.geektrust;

import java.util.HashSet;
import java.util.Objects;

class CheckinRecords {
    HashSet<Integer> CENTRAL_CHECKIN, AIRPORT_CHECKIN;
    public CheckinRecords() {
        CENTRAL_CHECKIN= new HashSet<>();
        AIRPORT_CHECKIN = new HashSet<>();
    }
    void update(String FROM_STATION, int METROCARD_NUMBER) {
        if(Objects.equals(FROM_STATION, "CENTRAL"))
            CENTRAL_CHECKIN.add(METROCARD_NUMBER);
        if(Objects.equals(FROM_STATION, "AIRPORT"))
            AIRPORT_CHECKIN.add(METROCARD_NUMBER);
    }
    boolean isReturnJourney(String FROM_STATION, int METROCARD_NUMBER) {
        boolean ans = false;
        if(Objects.equals(FROM_STATION, "CENTRAL"))
            ans = AIRPORT_CHECKIN.contains(METROCARD_NUMBER);
        else if(Objects.equals(FROM_STATION, "AIRPORT"))
            ans = CENTRAL_CHECKIN.contains(METROCARD_NUMBER);
        return ans;
    }
}