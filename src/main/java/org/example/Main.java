package org.example;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    var designs = new ArrayList<Design>();
    var votingThreads = new ArrayList<Thread>();
    var countingThreads = new ArrayList<Thread>();
    var votingRunnables = new ArrayList<VotingRunnable>();
    var countingRunnables = new ArrayList<CountingRunnable>();
    for (int i = 1; i <= 3; i++) {
      designs.add(new Design(i, "D" + i));
      var votingRunnable = new VotingRunnable(designs.get(i - 1));
      var countingRunnable = new CountingRunnable(designs.get(i - 1));
      votingRunnables.add(votingRunnable);
      countingRunnables.add(countingRunnable);
      votingThreads.add(new Thread(votingRunnable));
      countingThreads.add(new Thread(countingRunnable));
    }
    for (var votingThread : votingThreads) {
      votingThread.start();
    }
    for (var countingThread : countingThreads) {
      countingThread.start();
    }

    // print current time human-readable using formatted string
    System.out.printf("Current time: %tc\n", System.currentTimeMillis());
    // wait 30s before stopping voting and counting threads
    try {
      Thread.sleep(30000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (var votingRunnable : votingRunnables) {
      votingRunnable.stop();
    }
    for (var countingRunnable : countingRunnables) {
      countingRunnable.stop();
    }

    // print out the total votes for each design
    for (var design : designs) {
      System.out.printf("Voting has stopped for design %s. Current Time: %tc\n", design.getName(),
          System.currentTimeMillis());
      System.out.println("Total votes for " + design.getName() + ": " + design.getVotes().size());
    }
  }
}