package org.example;

public class VotingRunnable implements Runnable {

  private Design d;
  protected boolean doStop = false;

  public VotingRunnable(Design d) {
    this.d = d;
  }

  @Override
  public void run() {
    System.out.println("Voting going on for design " + d.getName());
    while (!doStop) {
      d.getVotes().add(1L);

      // pause voting for a random time interval between 0 and 5s
      try {
        Thread.sleep((long) (Math.random() * 5000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    doStop = true;
  }

}
