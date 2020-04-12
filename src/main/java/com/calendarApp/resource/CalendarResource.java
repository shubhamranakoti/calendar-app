package com.calendarApp.resource;

import com.calendarApp.helper.DatabaseMockHelper;
import com.calendarApp.model.BookingRequest;
import com.calendarApp.model.SlotAvailabilityRequest;
import com.calendarApp.model.User;
import com.calendarApp.model.ValidationResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/v1/calendar")
@Produces(MediaType.APPLICATION_JSON)
public class CalendarResource {

    static Logger LOGGER = Logger.getLogger("Calendar Resource");

    @POST
    @Path("/user")
    public Response registerUser(User user) {
        try {
            ValidationResult result = DatabaseMockHelper.addUser(user);
            if(!result.getErrors().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
            }
            LOGGER.log(Level.INFO, "Successfully created User");
            return Response.status(Response.Status.CREATED).entity(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/user/{id}/slots")
    public Response addSlotsAvailability(SlotAvailabilityRequest request, @PathParam("id") UUID id) {
        try {
            ValidationResult result = DatabaseMockHelper.addAvailableSlots(request, id);
            if(!result.getErrors().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
            }
            LOGGER.log(Level.INFO, "Successfully added slots");
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/user/{id}/bookSlots")
    public Response bookSlotsAvailability(BookingRequest request, @PathParam("id") UUID hostId) {
        try {
            ValidationResult result = DatabaseMockHelper.processReserveRequest(request, hostId);
            if(!result.getErrors().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
            }
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}