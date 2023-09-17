package hw2.src;

public class RankingService {

    public int getRank(int customerId) {
        int min = 0;
        int max = 50;

        int rank = (int) Math.floor(Math.random() * (max - min + 1) + min);

        return rank;
    }

}
