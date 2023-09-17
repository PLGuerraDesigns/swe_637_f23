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
