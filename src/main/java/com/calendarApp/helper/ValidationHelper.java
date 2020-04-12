package com.calendarApp.helper;

import com.calendarApp.model.User;

import java.sql.Time;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class ValidationHelper {
    /**
     * check if user exists
     * @param id
     * @return
     */
    public static boolean isValidUser(UUID id, HashMap<UUID, User> users) {
        return users.containsKey(id);
    }

    public static boolean isValidUUID(UUID id) {
        return ((id != null) && !id.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
    }

    public static boolean checkForUserExistence(String userName, HashMap<UUID, User> users) {
        return users.values().stream()
                .anyMatch(user -> user.getName().trim().equals(userName.trim()));
    }

    public static boolean isSlotAvailable(UUID userId, LocalDate date, Time time,
                                          HashMap<UUID, HashMap<LocalDate, Set<Time>>> userAvailabilitySlotInfo) {
        HashMap<LocalDate, Set<Time>> dateAvailabilityMap = userAvailabilitySlotInfo.get(userId);
        if(!dateAvailabilityMap.containsKey(date)) {
            return false;
        }
        Set<Time> availableTimeSlots = dateAvailabilityMap.get(date);
        return availableTimeSlots.contains(time);
    };
}
