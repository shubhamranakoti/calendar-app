package com.calendarApp.state;

import com.calendarApp.model.Booking;
import com.calendarApp.model.User;
import com.calendarApp.model.UserDateInfo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

/**
 * Singleton class to mock database
 */
public final class DatabaseMock {
    private HashMap<UUID, HashMap<LocalDate, UserDateInfo>> userAvailabilitySlotInfo;
    private HashMap<UUID, User> users;
    private HashMap<UUID, Booking> bookingsInfo;

    static DatabaseMock database = null;

    private DatabaseMock() {
        userAvailabilitySlotInfo = new HashMap<>();
        users = new HashMap<>();
        bookingsInfo = new HashMap<>();
    }

    public static DatabaseMock getInstance() {
        if(database == null){
            database = new DatabaseMock();
        }
        return database;
    }

    public HashMap<UUID, HashMap<LocalDate, UserDateInfo>> getUserSlotInfo() {
        return userAvailabilitySlotInfo;
    }

    public HashMap<UUID, User> getUsers() {
        return users;
    }
    public HashMap<UUID, Booking> getBookingsInfo() {
        return bookingsInfo;
    }
}
