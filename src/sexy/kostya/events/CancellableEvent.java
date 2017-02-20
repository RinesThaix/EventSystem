package sexy.kostya.events;

/**
 * Created by RINES on 20.02.17.
 */
public abstract class CancellableEvent extends Event {

    private boolean cancelled = false;

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean value) {
        this.cancelled = value;
    }

}
