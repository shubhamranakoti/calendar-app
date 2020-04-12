package com.calendarApp;

import com.calendarApp.resource.CalendarResource;
import com.calendarApp.state.DatabaseMock;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DemoApplication extends Application<DemoConfiguration> {

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(new String[] {"server", "config.yml"});
    }

    public void run(DemoConfiguration configuration, Environment environment) {
        // Initialize database mock class
        DatabaseMock.getInstance();

        //Setup resources
        final CalendarResource resource = new CalendarResource();

        // register resources
        environment.jersey().register(resource);
    }
}