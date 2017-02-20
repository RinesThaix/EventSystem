package sexy.kostya.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for handling events methods.
 * Created by RINES on 20.02.17.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface EventHandler {

    /**
     * Priority of execution.
     * All methods, which are handling the same event as the method, marked with this annotation,
     * will be executed in order from Byte.MIN_VALUE to Byte.MAX_VALUE priority.
     * @return execution priority of this method.
     */
    byte priority() default 0;

    /**
     * Determines, whether or not this method should handle events that were cancelled
     * (maybe, on previous handler-methods).
     * @return whether this method ignores cancelled events
     */
    boolean ignoreCancelled() default true;

}
