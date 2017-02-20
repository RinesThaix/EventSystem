package sexy.kostya.events.example;

import sexy.kostya.events.CancellableEvent;
import sexy.kostya.events.EventHandler;
import sexy.kostya.events.EventManager;
import sexy.kostya.events.Listener;

/**
 * Created by RINES on 20.02.17.
 */
public class SyncExample {

    public static void main(String[] args) {
        EventManager.initialize(true);
        new CustomListener();
        for(int i = 0; i < 5; ++i) {
            CustomEvent e = (CustomEvent) new CustomEvent(8).call();
            System.out.println(e.isCancelled() + " " + e.getNumber());
            System.out.println();
        }
    }

    static class CustomEvent extends CancellableEvent {

        private int number;

        public CustomEvent(int number) {
            this.number = number;
        }

        public int getNumber() {
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

    }

    private static class CustomListener extends Listener {

        @EventHandler(priority = -1)
        public void setToOne(CustomEvent event) {
            System.out.println("#1 Got CustomEvent with number=" + event.getNumber());
            event.setNumber(1);
        }

        @EventHandler
        private void setToTwo(CustomEvent event) {
            System.out.println("#2 Got CustomEvent with number=" + event.getNumber());
            event.setNumber(2);
            event.setCancelled(true);
        }

        @EventHandler(priority = 1)
        protected void setToThree(CustomEvent event) {
            System.out.println("#3 Got CustomEvent with number=" + event.getNumber());
            event.setNumber(3);
        }

        @EventHandler(ignoreCancelled = false, priority = 2)
        final void setToFour(CustomEvent event) {
            System.out.println("#4 Got CustomEvent with number=" + event.getNumber());
            event.setNumber(4);
        }

    }

}
