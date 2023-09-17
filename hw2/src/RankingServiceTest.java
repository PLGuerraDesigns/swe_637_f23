package hw2.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RankingServiceTest {

    @Test
    public void testReserveFakeRanking() {
        ReservationService reservationService = new ReservationService();
        RankingService fakeRankingService = new FakeRankingService();

        reservationService.setRankingService(fakeRankingService);

        int actualRank = reservationService.reserve(15);
        assertEquals(30, actualRank);
    }

    @Test
    public void testReserve() {
        ReservationService reservationService = new ReservationService();

        int actualRank = reservationService.reserve(15);
        assertEquals(30, actualRank);

    }

}