public class Message extends Event {

  @Override
  public void setInsertionTime(int currentTime) {

  }

  private int srcAddress;
  private int destAddress;

  public Message(int srcAddress, int destAddress) {
    this.srcAddress = srcAddress;
    this.destAddress = destAddress;
  }

  @Override
  public void cancel() {

  }

  @Override
  public void handle() {

  }

  public String getMessage() {
    return null;
  }

  public int getSrcAddress() {
    return this.srcAddress;
  }

  public int getDestAddress() {
    return this.destAddress;
  }

  public int setNextHop(Host desination, int distance) {
    return 0;
  }

}
