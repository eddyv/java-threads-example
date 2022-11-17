package org.example;

public class CountingRunnable implements Runnable {

  private Design d;
  protected boolean doStop = false;

  public CountingRunnable(Design d) {
    this.d = d;
  }

  @Override
  public void run() {
    System.out.println("Counting going on for design " + d.getName());
    while (!doStop) {
      System.out.println("Design " + d.getName() + " has " + d.getVotes().size() + " votes");
      // pause thread for 2s
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    doStop = true;
  }
}