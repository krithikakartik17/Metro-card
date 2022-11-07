package com.metrocard.geektrust;

class Summary {
    int TOTAL_COLLECTION_CENTRAL;
    int TOTAL_COLLECTION_AIRPORT;
    int TOTAL_DISCOUNT_CENTRAL;
    int TOTAL_DISCOUNT_AIRPORT;
    PassengerTypeRecord Central, Airport;
    public Summary() {
        TOTAL_COLLECTION_CENTRAL = 0;
        TOTAL_COLLECTION_AIRPORT = 0;
        TOTAL_DISCOUNT_CENTRAL = 0;
        TOTAL_DISCOUNT_AIRPORT = 0;
        Central = new PassengerTypeRecord(0, 0, 0);
        Airport = new PassengerTypeRecord(0, 0, 0);
    }
    public void printSummary() {
        System.out.println("TOTAL_COLLECTION \t CENTRAL \t " + TOTAL_COLLECTION_CENTRAL + "\t" + TOTAL_DISCOUNT_CENTRAL);
        displayPassengerType(Central.noOfAdults, Central.noOfKids, Central.noOfSeniorCitizens);

        System.out.println("TOTAL_COLLECTION \t AIRPORT \t " + TOTAL_COLLECTION_AIRPORT + "\t" + TOTAL_DISCOUNT_AIRPORT);
        displayPassengerType(Airport.noOfAdults, Airport.noOfKids, Airport.noOfSeniorCitizens);
    }
    private void displayPassengerType(int a, int k, int s) {
        System.out.println("PASSENGER_TYPE_SUMMARY");
        int max = Math.max(a, Math.max(k, s));
        if(max == a)
            printOrder("ADULT", a, "KID", k, "SENIOR_CITIZEN", s);
        else if(max == k)
            printOrder("KID", k, "ADULT", a, "SENIOR_CITIZEN", s);
        else if(max == s)
            printOrder("SENIOR_CITIZEN", s, "ADULT", a, "KID", k);
    }
    private void printOrder(String a_name, int a, String b_name, int b, String c_name, int c) {
        System.out.println(a_name+"\t"+a);
        if(b >= c) {
            if(b != 0) System.out.println(b_name+"\t"+b);
            if(c != 0) System.out.println(c_name+"\t"+c);
        }
        else if(b < c) {
            if(c != 0) System.out.println(c_name+"\t"+c);
            if(b != 0) System.out.println(b_name+"\t"+b);
        }
    }

}