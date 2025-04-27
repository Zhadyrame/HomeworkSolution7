import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equals("MAYDAY")) {
            clearRunway();
            sender.receive("Runway cleared for emergency landing.");
        } else {
            System.out.println(sender.getId() + ": " + msg);
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a instanceof PassengerPlane) {
            landingQueue.add(a);
        } else if (a instanceof CargoPlane) {
            landingQueue.add(a);
        } else {
            takeoffQueue.add(a);
        }
        return true;
    }

    private void clearRunway() {
        System.out.println("Runway cleared for emergency.");
        landingQueue.clear();
        takeoffQueue.clear();
    }

    public void processQueues() {
        if (!landingQueue.isEmpty()) {
            Aircraft a = landingQueue.poll();
            System.out.println(a.getId() + " is landing.");
        }

        if (!takeoffQueue.isEmpty()) {
            Aircraft a = takeoffQueue.poll();
            System.out.println(a.getId() + " is taking off.");
        }
    }
}
