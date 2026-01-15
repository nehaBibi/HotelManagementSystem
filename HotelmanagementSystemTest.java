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
