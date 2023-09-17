## Purpose

The purpose of this assignment is to develop hands-on experience writing test doubles and incorporating them into tests.

## Instructions

Expand the ReservationService and RankingService examples from the discussion into executable code with JUnit tests. You can choose to base your work on either your own example from the discussion or the instructor's example. You should have a working implementation of the ReservationService (exactly what it does is up to you, but there’s no need to make it do anything complicated) and both a real RankingService and a RankingService test double. You may redesign the classes as much as you’d like. Be sure that the real and fake RankingService classes have a different behavior, so that you can tell the difference when you run with each of them. Your tests should be designed so that they pass when run with the RankingService test double. Your tests may pass or fail with the real RankingService, but if they pass be sure to provide some other way (perhaps a print statement in the ReservationService) that shows what happened so that we can see the difference in behavior between the real and fake RankingService.

Use any one of the following seams to incorporate your RankingService test double:

- A compiler seam
- An inheritence seam without dependency injection
- An inheritence seam with dependency injection
- A mocking framework like Mockito or JMockit

Note: you are welcome to work in a group to complete this assignment but be sure to follow the guidelines in the "Module 3 Reminder: Working in groups to complete assignments" section.

## Deliverable

Submit report (.pdf preferred) explaining what you did in a way that is accessible to a typical software developer. In other words, someone who has only a very vague idea of what test doubles are should be able to read your story and understand test doubles and seams better. Part of the grading will be an assessment of how clear your story is. Be sure to identify and explain the seam(s) you exploited to insert your test double. Include a description or a copy of your source code and test code and include your test results.

1. A compiler seam (other solutions are possible)

public class ReservationService {
private boolean testMode = false;

public ReservationService (boolean testMode) {
this.testMode = testMode;
}

// instance variables, other methods omitted for now

public void reserve (Customer customer) {
RankingService rankingService;
int rank;

      // Use a "test mode" indicator (from the constructor) to compile
      // in the test double instead of the real RankingService
      if (testMode) {
         rankingService = new RankingServiceFake();
      } else {
         rankingService = new RankingService();
      }

      rank = rankingService.getRank();

      // more code that uses the rank provided by the getRank() call
    }

}

// Possible usage in a test
@Test public void testReservationService () {
ReservationService reservationService = new ReservationService(true);
// some assertion about reservationService.reserve(“John Smith”);
// some assertion about reservationService.reserve(“Jane Doe”);
}

Things to consider about this approach: what if a usage of testMode=true sneaks into the delivered software?

2. An inheritance seam without using dependency injection (other solutions are possible)

public class ReservationService {
private RankingService rankingService;

public ReservationService () {
this.rankingService = RankingServiceFactory.getRankingService();
}

// Define a method to put the class into "test mode" and get a fake
// ranking service using a factory class
public void setTestMode () {
this.rankingService = RankingServiceFactory.getRankingServiceFake();
}

// instance variables, other methods omitted for now

public void reserve (Customer customer) {
// more code that uses the ranking service by calling
// public Rank getRank(Customer customer)
// on the rankingService object.
}
}

// Possible usage in a test
@Test public void testReservationService () {
ReservationService reservationService = new ReservationService();
reservationService.setTestMode(); // enable unit test mode
// some assertion about reservationService.reserve(“John Smith”);
// some assertion about reservationService.reserve(“Jane Doe”);
}

Things to consider about this approach: what if a call to setTestMode() sneaks into the delivered software?

3. An inheritance seam using dependency injection (other solutions are possible)

public class ReservationService {
private RankingService rankingService;

// instance variables, constructors, other methods omitted for now

// Here we use a setter method to pass in the ranking service
// (either the real one or the fake one) and save it for later
// use; we could also pass it in using the constructor instead
public void setRankingService (RankingService rankingService) {
this.rankingService = rankingService;
}

public void reserve (Customer customer) {
// more code that uses the ranking service by calling
// public Rank getRank(Customer customer)
// on the rankingService object.
}
}

// Possible usage in a test

@Test public void testReservationService () {
ReservationService reservationService = new ReservationService();
RankingService rankingServiceFake = new RankingServiceFake(); // inherits from RankingService
reservationService.setRankingService(rankingServiceFake);
// some assertion about reservationService.reserve(“John Smith”);
// some assertion about reservationService.reserve(“Jane Doe”);
}

## Things to consider about this approach: it breaks encapsulation by forcing the caller of ReservationService to know about things that should ideally be kept internal to ReservationService.
