public class SimpleHost extends Host {

  private int destAddress;
  private int interval;
  private int timerIDInterval;
  private int timerIDDuration;
  private int currentTime = 0;
  private static int previousCurrentTime = 0;

  @Override
  protected void receive(Message msg) {
    switch (msg.getMessage()) {
      case "Request":
        System.out.println(
            "[" + this.getCurrentTime() + "ts] Host " + msg.getSrcAddress() + ": Ping request from host "
                + msg.getDestAddress());
        Message newMessage = new Message(msg.getSrcAddress(), msg.getDestAddress(), "Response");
        this.sendToNeighbor(newMessage);
        break;
      case "Response":
        int RTT = this.getCurrentTime() - previousCurrentTime;

        System.out.println(
            "[" + this.getCurrentTime() + "ts] Host " + msg.getSrcAddress() + ": Ping response from host "
                + msg.getDestAddress() + " (RTT = " + RTT + "ts)");

        // Calculate RTT Time

    }
  }

  @Override
  protected void timerExpired(int eventId) {
    if (eventId == timerIDInterval) {
      System.out.println(
          "[" + this.getCurrentTime() + "ts] Host " + this.getHostAddress() + ": Sent ping to host "
              + this.destAddress);

      previousCurrentTime = this.getCurrentTime();
      Message newMessage = new Message(this.getHostAddress(), destAddress, "Request");
      this.sendToNeighbor(newMessage);
      timerIDInterval = this.newTimer(interval);
    }

    if (eventId == timerIDDuration) {
      System.out.println(
          "[" + this.getCurrentTime() + "ts] Host " + this.getHostAddress() + ": Stopped sending pings");
      this.cancelTimer(timerIDInterval);

    }

  }

  @Override
  protected void timerCancelled(int eventId) {
    // send a ping print(timer was cancelled);
  }

  public void sendPings(int destAddr, int interval, int duration) {
    this.destAddress = destAddr;
    this.interval = interval;

    timerIDInterval = this.newTimer(interval);
    timerIDDuration = this.newTimer(duration);
    // timer.handle()
    //
  }

}
