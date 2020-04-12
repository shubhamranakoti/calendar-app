package com.calendarApp.state;

import com.calendarApp.model.Booking;
import com.calendarApp.model.User;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * Singleton class to mock database
 */
public final class DatabaseMock {
    private HashMap<UUID, HashMap<LocalDate, Set<Time>>> userAvailabilitySlotInfo;
    private HashMap<UUID, User> users;
    HashMap<LocalDate, ArrayList<Booking>> calendarBookings;

    static DatabaseMock database = null;

    private DatabaseMock() {
        userAvailabilitySlotInfo = new HashMap<>();
        users = new HashMap<>();
        calendarBookings = new HashMap<>();
    }

    public static DatabaseMock getInstance() {
        if(database == null){
            database = new DatabaseMock();
        }
        return database;
    }

    public HashMap<UUID, HashMap<LocalDate, Set<Time>>> getUserSlotInfo() {
        return userAvailabilitySlotInfo;
    }

    public HashMap<UUID, User> getUsers() {
        return users;
    }

    public HashMap<LocalDate, ArrayList<Booking>> getCalendarBookings() {
        return calendarBookings;
    }
}