import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Создаём случайных самолётов
        Aircraft[] aircrafts = new Aircraft[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int type = rand.nextInt(3);
            switch (type) {
                case 0:
                    aircrafts[i] = new PassengerPlane("Passenger " + i);
                    break;
                case 1:
                    aircrafts[i] = new CargoPlane("Cargo " + i);
                    break;
                case 2:
                    aircrafts[i] = new Helicopter("Heli " + i);
                    break;
            }
        }

        // Каждый самолет случайным образом отправляет запросы
        scheduler.scheduleAtFixedRate(() -> {
            int index = rand.nextInt(10);
            Aircraft aircraft = aircrafts[index];
            System.out.println(aircraft.getId() + " is requesting runway.");
            tower.requestRunway(aircraft);
            tower.processQueues();
        }, 0, 1, java.util.concurrent.TimeUnit.SECONDS);
    }
}
