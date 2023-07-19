package org.chamasoft;

import org.chamasoft.algorithm.FairLotteryAlgorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a comma-separated list of this week's prizes' values: ");
        String prizesString = scanner.nextLine();
        System.out.print("Enter a comma-separated names of this week's winners: ");
        String weekWinners = scanner.nextLine();
        int[] weekPrizes = Arrays.stream(prizesString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] winnersArray = weekWinners.split(",");
        FairLotteryAlgorithm lotteryAlgorithm = new FairLotteryAlgorithm();

       //Call the Algorithm
        Map<String, List<Integer>> distributionMap = lotteryAlgorithm.distributePrizes(weekPrizes, winnersArray);

        List<Map.Entry<String, List<Integer>>> sortedPrizeDistribution = distributionMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(list -> -list.get(0))))
                .collect(Collectors.toList());

        for (Map.Entry<String, List<Integer>> entry : sortedPrizeDistribution) {
            String winner = entry.getKey();
            List<Integer> allocatedPrizes = entry.getValue();

            String winnerPrizes = allocatedPrizes.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));

            System.out.println(winner + ":" + winnerPrizes);
        }
    }
}

