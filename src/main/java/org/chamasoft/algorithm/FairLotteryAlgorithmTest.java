package org.chamasoft.algorithm;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FairLotteryAlgorithmTest {
    @Test
    public void testDistributePrizes_Fairly() {
        int[] prizes = {100, 800, 200, 500, 400, 1000};
        String[] winners = {"Joshua", "Mahesh","Lillian"};
        FairLotteryAlgorithm lotteryAlgorithm = new FairLotteryAlgorithm();
        Map<String, List<Integer>> distribution = lotteryAlgorithm.distributePrizes(prizes, winners);

        assertEquals(3, distribution.size());

        assertAll("Winners Prize Distribution",
                ()-> assertEquals(Arrays.asList(1000), distribution.get("Joshua")),
                ()->assertEquals(Arrays.asList(800,200), distribution.get("Mahesh")),
                ()->assertEquals(Arrays.asList(500, 400,100), distribution.get("Lillian")));
    }
    @Test
    public void testDistributePrizes_extraPrize() {
        int[] prizes = {100, 800, 200, 500, 400, 1000, 300};
        String[] winners = {"j", "m", "k", "l"};
        FairLotteryAlgorithm lotteryAlgorithm = new FairLotteryAlgorithm();
        Map<String, List<Integer>> distribution = lotteryAlgorithm.distributePrizes(prizes, winners);

        assertEquals(4, distribution.size());

        assertAll("Winners Prize Distribution",
                ()-> assertEquals(Arrays.asList(1000), distribution.get("j")),
                ()->assertEquals(Arrays.asList(800), distribution.get("m")),
                ()->assertEquals(Arrays.asList(500, 200,100), distribution.get("k")),
                ()-> assertEquals(Arrays.asList(400, 300), distribution.get("l")));
    }

    @Test
    public void testDistributePrizes_ExtraWinner_LessPrizes() {
        int[] prizes = {100, 200, 300};
        String[] winners = {"a", "b", "c", "d"};
        FairLotteryAlgorithm lotteryAlgorithm = new FairLotteryAlgorithm();
        Map<String, List<Integer>> distribution = lotteryAlgorithm.distributePrizes(prizes, winners);

        assertEquals(4, distribution.size());

        assertAll("Winners Prize Distribution",
                ()-> assertEquals(Arrays.asList(300), distribution.get("a")),
                ()->assertEquals(Arrays.asList(200), distribution.get("b")),
                ()->assertEquals(Arrays.asList(100), distribution.get("c")),
                ()->assertEquals(Arrays.asList(), distribution.get("d")));
    }
    @Test
    public void testDistributePrizes_UnfairDistribution() {
        int[] prizes = {400,400,500,600};
        String[] winners = {"Barry", "Sheilla", "Onyango", "Wekesa"};
        FairLotteryAlgorithm lotteryAlgorithm = new FairLotteryAlgorithm();
        Map<String, List<Integer>> distribution = lotteryAlgorithm.distributePrizes(prizes, winners);

        assertEquals(4, distribution.size());
        assertAll("Winners Prize Distribution",
                ()->assertEquals(Arrays.asList(600), distribution.get("Barry")),
                ()->assertEquals(Arrays.asList(500), distribution.get("Sheilla")),
                ()->assertEquals(Arrays.asList(400), distribution.get("Onyango")),
                ()->assertEquals(Arrays.asList(400), distribution.get("Wekesa")));
    }
}
