package hw2.src;

public class ReservationService {
    private RankingService rankingService = new RankingService();

    public int reserve(int customerId) {
        return rankingService.getRank(customerId);
    }

    public void setRankingService(RankingService rs) {
        this.rankingService = rs;
    }
}
