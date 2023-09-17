package hw2.src;

public class ReservationService {
    private RankingService rankingService;

    public void reserve(Customer customer) {
        rankingService = new RankingService();
        int customerRank = rankingService.getRank(customer);
    }
}
