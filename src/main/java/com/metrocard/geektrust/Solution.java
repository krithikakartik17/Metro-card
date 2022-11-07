package com.metrocard.geektrust;
import java.util.*;
public class Solution {
    final int charges_for_adult = 200;
    final int charges_for_seniorCitizen = 100;
    final int charges_for_kid = 50;
    final float discountPercent = 0.5f;
    Summary summary = new Summary();
    CheckinRecords checkinRecords = new CheckinRecords();
    public Summary compute(HashMap<Integer, MetroCard> metroCards, ArrayList<CHECK_IN> check_in_list) {
        for(CHECK_IN info: check_in_list) {
            MetroCard card = metroCards.get(info.METROCARD_NUMBER);
            int discount = 0;
            int COST = 0;
            int recharge_fee = 0;
            boolean isReturnJourney = checkinRecords.isReturnJourney(info.FROM_STATION, info.METROCARD_NUMBER);
            if(isReturnJourney)  {
                    discount = calculateDiscount(info.PASSENGER_TYPE);
            }
            else checkinRecords.update(info.FROM_STATION, info.METROCARD_NUMBER);

            COST = calculateCost(info.PASSENGER_TYPE);

            if(Objects.equals(info.FROM_STATION, "CENTRAL"))
                summary.Central.countPassengers(info.PASSENGER_TYPE);
            else if(Objects.equals(info.FROM_STATION, "AIRPORT"))
                summary.Airport.countPassengers(info.PASSENGER_TYPE);

            int net_cost = COST - discount;
            int balance = card.deductBalance(net_cost);
            if(balance < 0)
                recharge_fee = card.autoRecharge(Math.abs(balance));

            if (Objects.equals(info.FROM_STATION, "CENTRAL")) {
                summary.TOTAL_COLLECTION_CENTRAL += (COST - discount + recharge_fee);
                summary.TOTAL_DISCOUNT_CENTRAL += discount;
            } else if (Objects.equals(info.FROM_STATION, "AIRPORT")) {
                summary.TOTAL_COLLECTION_AIRPORT += (COST - discount + recharge_fee);
                summary.TOTAL_DISCOUNT_AIRPORT += discount;
            }
        }
        return summary;
    }
    private int calculateDiscount(String PASSENGER_TYPE) {

        float discount = 0f;

        if(Objects.equals(PASSENGER_TYPE, "ADULT")) discount = charges_for_adult * discountPercent ;
        if(Objects.equals(PASSENGER_TYPE, "KID")) discount = charges_for_kid * discountPercent ;
        if(Objects.equals(PASSENGER_TYPE, "SENIOR_CITIZEN")) discount = charges_for_seniorCitizen * discountPercent;
        return (int)discount;
    }
    private int calculateCost(String PASSENGER_TYPE) {
        int cost = 0;
        if(Objects.equals(PASSENGER_TYPE, "ADULT")) cost = charges_for_adult;
        if(Objects.equals(PASSENGER_TYPE, "KID")) cost = charges_for_kid;
        if(Objects.equals(PASSENGER_TYPE, "SENIOR_CITIZEN")) cost = charges_for_seniorCitizen;
        return cost;
    }
}