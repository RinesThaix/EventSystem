package sexy.kostya.events;

/**
 * Class, which implements IListener and also auto-registers itself in EventManager.
 * Created by RINES on 20.02.17.
 */
public class Listener implements IListener {

    public Listener() {
        EventManager.register(this);
    }

}
