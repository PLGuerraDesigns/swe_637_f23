package hw2.src;

public class FakeRankingService extends RankingService {

    @Override
    public int getRank(int customerId) {
        return customerId * 2;
    }

}
