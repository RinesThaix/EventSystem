package sexy.kostya.events.example;

import sexy.kostya.events.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by RINES on 20.02.17.
 */
public class AsyncExample {

    public static void main(String[] args) {
        EventManager.initialize(false);
        EventManager.register(new CustomListener());
        for(int i = 0; i < 3; ++i)
            new EventGenerator();
    }

    private static void print(int id, CustomEvent event) {
        System.out.println(
                String.format("#%d Got CustomEvent with identifier=%d, number=%d",
                        id, event.getIdentifier(), event.getNumber())
        );
    }

    private static class EventGenerator extends Thread {

        private EventGenerator() {
            super(EventGenerator::generateEvents);
            super.start();
        }

        private static void generateEvents() {
            for(int i = 0; i < 3; ++i) {
                CustomEvent e = new CustomEvent(7);
                e.call();
                print(5, e);
            }
        }

    }

    private static class CustomEvent extends CancellableEvent {

        private final int identifier;
        private int number;

        public CustomEvent(int number) {
            this.identifier = ThreadLocalRandom.current().nextInt(1000);
            this.number = number;
        }

        public int getIdentifier() {
            return this.identifier;
        }

        public int getNumber() {
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

    }

    private static class CustomListener implements IListener {

        @EventHandler(priority = -1)
        private void setToOne(CustomEvent event) {
            print(1, event);
            event.setNumber(1);
        }

        @EventHandler
        protected void setToTwo(CustomEvent event) {
            print(2, event);
            event.setNumber(2);
            event.setCancelled(true);
        }

        @EventHandler(priority = 1)
        public void setToThree(CustomEvent event) {
            print(3, event);
            event.setNumber(3);
        }

        @EventHandler(ignoreCancelled = false, priority = 2)
        final void setToFour(CustomEvent event) {
            print(4, event);
            event.setNumber(4);
        }

    }

}
