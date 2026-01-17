package SoftwareConstruction;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class HotelManagementSystemTest {

    /* ======================= VALUE OBJECTS TESTS ======================= */

    @Test
    public void nameValidation() {
        Name name = new Name("Neha");
        assertEquals("Neha", name.getValue());

        try {
            new Name(null);
            fail("Expected exception for null name");
        } catch (IllegalArgumentException e) { }

        try {
            new Name("  ");
            fail("Expected exception for empty name");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void addressValidation() {
        Address addr = new Address("Karachi");
        assertEquals("Karachi", addr.getDetails());

        try {
            new Address(null);
            fail("Expected exception for null address");
        } catch (IllegalArgumentException e) { }

        try {
            new Address("");
            fail("Expected exception for empty address");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void creditCardValidation() {
        CreditCard card = new CreditCard("1234-5678");
        assertEquals("1234-5678", card.getCardNumber());

        try {
            new CreditCard(null);
            fail("Expected exception for null card");
        } catch (IllegalArgumentException e) { }

        try {
            new CreditCard("  ");
            fail("Expected exception for empty card");
        } catch (IllegalArgumentException e) { }
    }
    @Test
    public void moneyValidation() {
        Money money = new Money(100.0);
        assertEquals(100.0, money.getAmount(), 0.001);

        try {
            new Money(-5.0);
            fail("Expected exception for negative money");
        } catch (IllegalArgumentException e) { }
    }

    /* ======================= DOMAIN OBJECTS TESTS ======================= */

    @Test
    public void guestValidation() {
        Guest guest = Guest.create(new Name("Neha"), new Address("Karachi"));
        assertEquals("Neha", guest.getName().getValue());
        assertEquals("Karachi", guest.getAddress().getDetails());

        try {
            Guest.create(null, new Address("Karachi"));
            fail("Expected exception for null guest");
        } catch (IllegalArgumentException e) { }

        try {
            Guest.create(new Name("Neha"), null);
            fail("Expected exception for null address");
        } catch (IllegalArgumentException e) { }
    }
    @Test
    public void reservorPayerValidation() {
        ReservorPayer payer = ReservorPayer.create(1, new CreditCard("1234-5678"));
        assertNotNull(payer);

        try {
            ReservorPayer.create(0, new CreditCard("1234"));
            fail("Expected exception for invalid ID");
        } catch (IllegalArgumentException e) { }

        try {
            ReservorPayer.create(1, null);
            fail("Expected exception for null card");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void reservationValidation() {
        LocalDate today = LocalDate.now();
        Reservation res = Reservation.create(today, today.plusDays(1), today.plusDays(3), 1001);
        assertEquals(1001, res.getNumber());

        try {
            Reservation.create(today, today.plusDays(3), today.plusDays(1), 1001);
            fail("Expected exception for invalid date range");
        } catch (IllegalArgumentException e) { }

        try {
            Reservation.create(today, today.plusDays(1), today.plusDays(2), 0);
            fail("Expected exception for invalid reservation number");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void roomValidation() {
        Room room = new Room(101);
        assertTrue(room.isAvailable());

        Guest guest = Guest.create(new Name("Neha"), new Address("Karachi"));
        room.assignGuest(guest);
        assertFalse(room.isAvailable());

        room.removeGuest();
        assertTrue(room.isAvailable());

        try {
            new Room(0);
            fail("Expected exception for invalid room number");
        } catch (IllegalArgumentException e) { }

        try {
            room.assignGuest(null);
            fail("Expected exception for null guest");
        } catch (IllegalArgumentException e) { }

        Guest guest2 = Guest.create(new Name("Ali"), new Address("Lahore"));
        room.assignGuest(guest);
        try {
            room.assignGuest(guest2);
            fail("Expected exception for assigning to occupied room");
        } catch (IllegalStateException e) { }
    }
    @Test
    public void hotelValidation() {
        Hotel hotel = new Hotel(new Name("Avari"));
        Room room1 = new Room(101);
        hotel.addRoom(room1);
        assertEquals(room1, hotel.findAvailableRoom());

        LocalDate today = LocalDate.now();
        Reservation res = hotel.createReservation(today, today.plusDays(1), today.plusDays(3), 1001);
        assertEquals(1001, res.getNumber());

        try {
            new Hotel(null);
            fail("Expected exception for null hotel name");
        } catch (IllegalArgumentException e) { }

        try {
            hotel.addRoom(null);
            fail("Expected exception for null room");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void hotelChainValidation() {
        HotelChain chain = new HotelChain(new Name("Serena"));
        Hotel hotel = new Hotel(new Name("Avari"));
        chain.addHotel(hotel);

        ReservorPayer payer = chain.createReservorPayer(1, new CreditCard("1234-5678"));
        assertNotNull(payer);

        try {
            new HotelChain(null);
            fail("Expected exception for null chain name");
        } catch (IllegalArgumentException e) { }

        try {
            chain.addHotel(null);
            fail("Expected exception for null hotel");
        } catch (IllegalArgumentException e) { }
    }

    /* ======================= FULL SYSTEM FLOW TEST ======================= */

    @Test
    public void fullHotelManagementFlow() {
        HotelChain chain = new HotelChain(new Name("Serena Group"));
        Hotel hotel = new Hotel(new Name("Avari Towers Karachi"));
        Room room1 = new Room(101);
        Room room2 = new Room(102);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        chain.addHotel(hotel);

        Guest guest = Guest.create(new Name("Neha"), new Address("Karachi"));
        ReservorPayer payer = chain.createReservorPayer(1, new CreditCard("4562-7891"));
        assertNotNull(payer);

        LocalDate today = LocalDate.now();
        Reservation reservation = hotel.createReservation(today, today.plusDays(1), today.plusDays(3), 1001);
        assertEquals(1001, reservation.getNumber());

        Room availableRoom = hotel.findAvailableRoom();
        assertNotNull(availableRoom);
        availableRoom.assignGuest(guest);
        assertFalse(availableRoom.isAvailable());
        assertEquals("Neha", guest.getName().getValue());
        assertEquals(101, availableRoom.getNumber());

        availableRoom.removeGuest();
        assertTrue(availableRoom.isAvailable());
    }
}

    


