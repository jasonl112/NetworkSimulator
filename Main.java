import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    LinkedEventList eventList = new LinkedEventList();

    File myFile = new File("simulation1.txt");
    Scanner myScnr = new Scanner(myFile);

    String line = "";
    while (myScnr.hasNext()) {
      line = myScnr.nextLine();
      String[] split = line.split("\\s");
      System.out.println(split);
      for (String element : split) {
        if (split.length == 1) {
          Integer address = Integer.parseInt(element);
          System.out.println(address);
        } else if (split.length == 2) {
          Integer address = Integer.parseInt(element);
          if (address != null) {
            Integer dist = Integer.parseInt(element);
            System.out.println(address + " " + dist);
          }
          continue;

        }

        /*
         * Integer parsedInt = Integer.parseInt(element);
         * if (parsedInt == -1)
         * return;
         * 
         * 
         * System.out.println(parsedInt);
         */
      }

      /*
       * if (temp == -1)
       * break;
       * 
       * if (temp == 5) {
       * System.out.println("created");
       * SimpleHost newSimpleHost = new SimpleHost();
       * newSimpleHost.setHostParameters(temp, eventList);
       * }
       * System.out.println(temp);
       * SimpleHost Host = new SimpleHost();
       * Host.setHostParameters(temp, eventList);
       * newSimpleHost.addNeighbor(Host, dist)
       */
    }

    myScnr.close();

  }
}
