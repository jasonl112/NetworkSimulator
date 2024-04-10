public class SimpleHost extends Host {

  @Override
  protected void receive(Message msg) {
    // Determine the message type by looking at the value of the string message (ie,
    // come up with a unique string for each message type).

    // If receiving a ping request, you’ll need to reply with a ping response.

    // If receiving a ping response, compute the RTT.
  }

  @Override
  protected void timerExpired(int eventId) {

  }

  @Override
  protected void timerCancelled(int eventId) {

  }

  public void sendPings(int destAddr, int interval, int duration) {
    // Use timers for this

  }

}
