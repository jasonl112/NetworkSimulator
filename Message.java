public class Message extends Event {

  @Override
  public void setInsertionTime(int currentTime) {

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
    return 0;
  }

  public int getDestAddress() {
    return 0;
  }

  public int setNextHop(Host desination, int distance) {
    return 0;
  }

}
