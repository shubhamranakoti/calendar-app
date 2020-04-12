package com.calendarApp.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import com.calendarApp.model.ImmutableBooking;

import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableBooking.class)
@JsonDeserialize(as = ImmutableBooking.class)
public interface Booking {
    default UUID getId() {
        return UUID.randomUUID();
    };
    UUID getHost();
    UUID getAttendee();
    LocalDate getDate();
    Time getTime();
}
