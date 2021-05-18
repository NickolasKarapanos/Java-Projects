import java.util.Scanner;

public class SingleQueueService {

  /** Service time per customer in ms. */
  static final int SERVICE_TIME = 2000;

  public static void main(final String[] args) throws InterruptedException {
    // queue for customer names
    final SimpleQueue<String> queue = new FixedArrayQueue<>(5);

// TODO read successive input lines until EOF and try to add them to the queue
    final var input1 = new Scanner(System.in);

    while (input1.hasNextLine()) {

    if(!queue.offer(input1.nextLine())) {
      break;
    }

    }

    // lock object for thread safety
    final var lock = new Object();

    // background activity for serving customers
    final Thread consumer =
        new Thread(
            () -> {
              while (true) {
                String current;
		        int remaining;
                synchronized (lock) {
                  current = queue.poll(); // TODO try to take next name from queue // poll
		          remaining = queue.size(); // TODO determine resulting size of queue
                }
                if (current == null) {
                  System.out.println("no one waiting");
                } else {
                  System.out.println(current + " is being served, " + remaining + " still waiting");
                }
                try { //  puts a wait on thread.
                  Thread.sleep(SERVICE_TIME);
                } catch (final InterruptedException ex) {
                  return;
                }
              }
            });
    consumer.setDaemon(true);
    consumer.start();

    // foreground activity for reading customer names from input
    final var input = new Scanner(System.in);

    System.out.print("enter next customer: ");
    while (input.hasNextLine()) {
      final var name = input.nextLine();
      var result = false;
      synchronized (lock) {
        // TODO try to add this name to the queue
       result= queue.offer(name);
      }
      if (result) {
        System.out.println(name + " has joined the queue");
      } else {
        System.out.println("queue full, " + name + " unable to join");
      }
    }
  }
}
