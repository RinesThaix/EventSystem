package sexy.kostya.events;

/**
 * Events could be handled (and their handle-methods could be marked with @EventHandler) only
 * inside of classes implementing IListener. Also, you need to call EventManager.registerListener(IListener)
 * in order to make your handle-methods work.
 * Created by RINES on 20.02.17.
 */
public interface IListener {}