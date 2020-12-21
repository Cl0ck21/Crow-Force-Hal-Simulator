package system.gui.event;

import util.control.Button;

/**
 * An event that is injected whenever a boolean button is released.
 * <p>
 * Creation Date: 5/17/20
 *
 * @author Cole Savage, Level Up
 * @version 1.0.0
 * @see ClickEvent
 * @see Event
 * @see GamepadEventGenerator
 * @see Button
 * @since 1.1.0
 */
public class OnClickReleaseEvent extends ClickEvent<Button<Boolean>> {

    /**
     * The constructor for OnClickReleaseEvent.
     *
     * @param priority The event's priority.
     * @param button   The button being released.
     */
    public OnClickReleaseEvent(int priority, Button<Boolean> button) {
        super(priority, button);
    }
}
