package com.jonsaraco.interview.ood;

import java.awt.*;
import java.util.Map;
import java.util.Set;

/**
 * Sample solution for an OOD-type question "How would you design Uber's backend?"
 */
public class Uber {

    Set<Driver> drivers;

    Map<Driver, Customer> currentUbers;

    Map<Driver, Set<Rating>> driverRatings;

    private void findDriverForCustomer(Customer customer, Location destination) {
        // Check for drivers in customer's area
        // Narrow down to available drivers with acceptable rating
        // Choose one, and send a request to the driver
    }

    public Route getRoute(Location start, Location end) {
        return null;
    }

    public Rating calculateAverageRating(Driver driver) {
        return null;
    }

    public void verifyPickup(Driver driver, Customer customer) {}

    class Driver {
        Integer id;
        String firstName;
        String lastName;
        Car car;
        Rating rating = calculateAverageRating(this);
        Location location;
        Route route;
        Customer currentCustomer;

        private void receiveRequest(Customer customer, Location destination) {
            // Create route from current location to customer location
            // Confirm pickup
            this.currentCustomer = customer;
            this.route = getRoute(this.location, customer.location);
            drive();
            confirmPickup(customer);
            this.route = getRoute(this.location, destination);
            drive();
        }

        private void drive() {}

        public void confirmPickup(Customer customer) {}

        public boolean isAvailable() {
            return currentCustomer == null;
        }
    }

    class Car {
        LicensePlate licensePlate;
        String model;
        Color color;
    }

    class LicensePlate {
        String plateNumber;
        String expiryDate;
    }

    class Route  {
        Location start;
        Location end;
    }

    class Rating {
        double rating; // Decimal number between 0 and 5
    }

    class Customer {
        Integer id;
        String firstName;
        String lastName;
        Location location;
        private void requestRide(Location destination) {
            // Send a request to Uber's backend
            confirmPickup(null);
            confirmArrival();

        }

        public void confirmPickup(Driver driver) {

        }

        public void rateDriver(Driver driver) {

        }

        public void confirmArrival() {}
    }

    class RideRequest {
        Location location;
        Location destination;
    }

    class Location {
        int latitude;
        int longitude;

        public Location(int latitude, int longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
