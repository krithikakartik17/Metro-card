package com.metrocard.geektrust;

import java.util.Objects;

class PassengerTypeRecord {
    int noOfAdults;
    int noOfKids;
    int noOfSeniorCitizens;

    public PassengerTypeRecord(int noOfAdults, int noOfKids, int noOfSeniorCitizens) {

        this.noOfAdults = noOfAdults;
        this.noOfKids = noOfKids;
        this.noOfSeniorCitizens = noOfSeniorCitizens;
    }

    void countPassengers(String PASSENGER_TYPE) {
        if(Objects.equals(PASSENGER_TYPE, "ADULT"))
            noOfAdults++;
        if(Objects.equals(PASSENGER_TYPE, "KID"))
            noOfKids++;
        if(Objects.equals(PASSENGER_TYPE, "SENIOR_CITIZEN"))
            noOfSeniorCitizens++;
    }

}