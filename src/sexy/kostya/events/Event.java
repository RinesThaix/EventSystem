package sexy.kostya.events;

/**
 * Created by RINES on 20.02.17.
 */
public abstract class Event {

    /**
     * Calls this event.
     * @see EventManager#call(Event) for more info.
     */
    public final Event call() {
        EventManager.call(this);
        return this;
    }

}
