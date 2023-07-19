# Lottery
**This approach ensures fairness in the following way:**
The algorithm first takes in the prizes and the winners and then distribute all the maximum prizes to the winners on the first loop.
The algorithm achieves this by sorting the prizes in an array in a descending order.The algorithm then initializes a map with empty lists for all the winners to be stored with the highest values from the array with prizes. 
The algorithm then distributes the remaining prizes by checking which whinner from the previous loop received the minimum amount and this time the winner is given a higher amount to try and balance the amounts received.It continues allocating the remaining prizes, starting from the highest remaining value, to the winner who had the minimum value at the end of previous loop. This process continues until all the prizes are distributed accordingly.

**Note: The algorithm assumes that the number of winners is equal to or less than the number of prizes available.
If there are more winners than prizes, the algorithm may not produce the desired results.**
