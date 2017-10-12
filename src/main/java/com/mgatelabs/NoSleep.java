package com.mgatelabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.Calendar;


/**
 * Created by @mgatelabs (Michael Fuller) on 10/11/2017.
 */
public class NoSleep extends Thread {

    Robot robot;

    private Logger logger = LogManager.getLogger(NoSleep.class.getName());

    private volatile boolean canceled;

    public NoSleep() {
        try {
            robot = new Robot();
        } catch (Exception ex) {
            ex.printStackTrace();
            robot = null;
        }
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    private static final int DELAY = 2000;

    @Override
    public void run() {
        super.run();
        if (robot == null) {
            return;
        }

        logger.info("Robot Ready");

        boolean up = true;

        Calendar calendar = Calendar.getInstance();

        while (!canceled) {

            int minute = calendar.get(Calendar.MINUTE);

            while (!canceled) {
                calendar = Calendar.getInstance();
                if (minute != calendar.get(Calendar.MINUTE)) {
                    break;
                }
                robot.delay(DELAY);
            }

            logger.info("Moving Mouse-Wheel: " + (up ? "Up" : "Down"));

            robot.mouseWheel( up ? 1 : -1);
            up = !up;
        }
    }

}
