package com.calendarApp.model;

import com.calendarApp.model.ImmutableSlotAvailabilityRequest;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableSlotAvailabilityRequest.class)
@JsonDeserialize(as = ImmutableSlotAvailabilityRequest.class)

public interface SlotAvailabilityRequest {
    LocalDate getDate();
    Set<Time> getSlots();
}
