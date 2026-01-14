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
