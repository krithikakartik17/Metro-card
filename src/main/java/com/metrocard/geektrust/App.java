package com.metrocard.geektrust;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class App {
    public static void main( String[] args )throws IOException {
        int METROCARD_NUMBER = 0;
        int BALANCE_IN_THE_METROCARD = 0;
        String PASSENGER_TYPE = "";
        String FROM_STATION = "";

        ArrayList<CHECK_IN> check_in_list = new ArrayList<>();
        Solution solution = new Solution();
        Summary summary = new Summary();
        HashMap<Integer, MetroCard> metroCards = new HashMap<>();

        FileInputStream input_file = new FileInputStream(args[0]);
        Scanner sc = new Scanner(input_file);
        while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] cmd = input.split(" ");

                switch (cmd[0]) {
                    case "BALANCE":
                        METROCARD_NUMBER = Integer.parseInt(cmd[1].substring(2));
                        BALANCE_IN_THE_METROCARD =  Integer.parseInt(cmd[2]);
                        MetroCard card = new MetroCard(METROCARD_NUMBER, BALANCE_IN_THE_METROCARD);
                        metroCards.put(METROCARD_NUMBER, card);
                        break;
                    case "CHECK_IN":
                        METROCARD_NUMBER = Integer.parseInt(cmd[1].substring(2));
                        PASSENGER_TYPE =  cmd[2];
                        FROM_STATION = cmd[3];
                        CHECK_IN info = new CHECK_IN(METROCARD_NUMBER, PASSENGER_TYPE, FROM_STATION);
                        check_in_list.add(info);
                        break;
                    case "PRINT_SUMMARY":
                        summary = solution.compute(metroCards, check_in_list);
                        summary.printSummary();
                        break;
                }
        }
        sc.close();
    }
}