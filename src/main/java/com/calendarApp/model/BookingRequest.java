package com.calendarApp.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableSet;
import org.immutables.value.Value;
import com.calendarApp.model.ImmutableBookingRequest;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableBookingRequest.class)
@JsonDeserialize(as = ImmutableBookingRequest.class)

public interface BookingRequest {
    UUID getAttendee();
    LocalDate getDate();
    Time getTime();
}
