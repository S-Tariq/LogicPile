package stariq.designs.hotelmanagement;

import java.util.Date;
import java.util.List;

public class Hotel {
    String name;
    Integer id;
    Location location;
    List<Floor> floorList;
    List<Room> roomList;
}

class Location {
    String number;
    String street;
    String city;
    String country;
    String postcode;
}

class Floor {
    String number;
    List<Room> roomList;
}

class Room {
    String number;
    RoomStyle style;
    RoomStatus status;
    double price;
    List<KeyCard> keys;
    List<HouseKeeping> housekeeping;
}

enum RoomStyle {
    SINGLE, DOUBLE, KING, QUEEN;
}

enum RoomStatus {
    AVAILABLE, NOT_AVAILABLE, RESERVED, OCCUPIED, SERVICE_IN_PROGRESS;
}

class KeyCard {
    String id;
    String barcode;
    Date issued;
    boolean isActive;

    public void assignRoom(Room room) {

    }
}

abstract class Person {
    String name;
    Account accountDetail;
    String phone;
}

class Account {
    String username;
    String password;
    AccountStatus status;
}

enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {

    public List<Room> getRoomsServiced(Date date) {
        return null;
    }
}

class HouseKeeping {
    String description;
    Date started;
    int duration;
    HouseKeeper houseKeeper;

    public void serviceRoom(Room room) {

    }

    public void scanKeyCard(KeyCard card) {

    }
}

class Customer extends Person {
    Search search;
    Booking book;
    Payment makePayment;

    public List<RoomBooking> getRoomsBooked() {
        return null;
    }

    public void checkIn(RoomBooking info) {

    }

    public void checkOut(RoomBooking info) {

    }

    public void scanKeyCard(KeyCard card) {

    }
}

class Receptionist extends Person {
    Search search;
    Booking book;
    Payment takePayment;

    public void checkInGuest(Customer customer, RoomBooking info) {

    }

    public void checkOutGuest(Customer customer, RoomBooking info) {

    }
}

class Search {

    public List<Room> searchRoom(RoomStyle style, Date date, int duration) {
        return null;
    }
}

class Booking {

    public RoomBooking createBooking(Customer customer) {
        return null;
    }

    public RoomBooking updateBooking(int bookingId) {
        return null;
    }

    public RoomBooking cancelBooking(int bookingId) {
        return null;
    }
}

class RoomBooking {
    String id;
    Date date;
    int duration;
    List<Customer> customerList;
    List<Room> roomList;
}

class Payment {
    String type;
    RoomBooking room;
    Customer customer;
    boolean isSuccessful;
}

class Admin extends Person {

    public void addRoom(Room room) {

    }

    public void deleteRoom(String id) {

    }

    public void editRoom(Room room) {

    }

    public void monitorResources(Resource resource) {

    }
}

enum Resource {
    ELECTRICITY, GAS, WATER, LIFT;
}






