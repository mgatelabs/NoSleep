package com.mgatelabs;

import com.mgatelabs.utils.ConsoleInput;

/**
 * Created by @mgatelabs (Michael Fuller) on 10/11/2017.
 */
public class Runner {


    public static void main(String [] args) {


        NoSleep sleep = new NoSleep();

        System.out.print("Waiting for a number to start keep alive: ");
        ConsoleInput.getInt();

        sleep.start();

        System.out.print("Waiting for a number to end keep alive: ");
        ConsoleInput.getInt();

        sleep.setCanceled(true);
    }

}
