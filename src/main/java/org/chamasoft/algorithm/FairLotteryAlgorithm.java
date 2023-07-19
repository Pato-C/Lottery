package org.chamasoft.algorithm;

import java.util.*;

public class FairLotteryAlgorithm {

    public Map<String, List<Integer>> distributePrizes(int[] prizesArray, String[] winnersArray) {
        //Store the distributions
        Map<String, List<Integer>> distributionMap = new HashMap<>();
        Arrays.sort(prizesArray);
        int prizeIndex = prizesArray.length - 1;
        for (String winner : winnersArray) {
            distributionMap.put(winner, new ArrayList<>());
        }

        //Get the first maximums and distribute them on the first loop
        for (String winner : winnersArray) {
            if (prizeIndex >= 0) {
                distributionMap.get(winner).add(prizesArray[prizeIndex]);
                prizeIndex--;
            } else {
                break; //breaks when there is no more prizes
            }
        }

        int currentPrizeIndex = prizeIndex;
        while (currentPrizeIndex >= 0) {
            String minimalWin = findWinnerWithMinimumPrize(distributionMap);
            if (minimalWin == null) {
                break; //Breaks when there is no longer a minimum winner
            }
            distributionMap.get(minimalWin).add(prizesArray[currentPrizeIndex]);
            currentPrizeIndex--;
        }

        return distributionMap;
    }

    public String findWinnerWithMinimumPrize(Map<String, List<Integer>> distribution) {
        String minWinner = null;
        int minPrizeSum = Integer.MAX_VALUE;
        for (Map.Entry<String, List<Integer>> entry : distribution.entrySet()) {
            String winner = entry.getKey();
            List<Integer> allocatedPrizes = entry.getValue();
            int prizeSum = allocatedPrizes.stream().mapToInt(Integer::intValue).sum();
            if (prizeSum < minPrizeSum) {
                minWinner = winner;
                minPrizeSum = prizeSum;
            }
        }
        return minWinner;
    }
}

