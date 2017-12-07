import org.junit.Test;

import static org.junit.Assert.*;

public class ChronosTest {


    @Test
    public void testAssignedExample() throws Exception {
        Chronos time = new Chronos("9:13 AM");
        time.addMinutes("200");
        assertEquals("12:33 PM", time.serialize());
    }

    @Test
    public void testPMStart() throws Exception {
        Chronos time = new Chronos("9:13 AM");
        time.addMinutes("200");
        assertEquals("12:33 PM", time.serialize());
    }

    @Test
    public void testAMDayWrap() throws Exception {
        Chronos time = new Chronos("9:13 AM");
        time.addMinutes("920");
        assertEquals("12:33 AM", time.serialize());
    }

    @Test
    public void testPMDayWrap() throws Exception {
        Chronos time = new Chronos("9:13 PM");
        time.addMinutes("920");
        assertEquals("12:33 PM", time.serialize());
    }

    @Test
    public void testAM12HrWrap() throws Exception {
        Chronos time = new Chronos("12:13 PM");
        time.addMinutes("720");
        assertEquals("12:13 AM", time.serialize());
    }

    @Test
    public void testPM12HrWrap() throws Exception {
        Chronos time = new Chronos("12:13 AM");
        time.addMinutes("720");
        assertEquals("12:13 PM", time.serialize());
    }

    // negative cases, validations
    @Test(expected = IllegalArgumentException.class)
    public void parseDateNoInput() throws Exception {
        new Chronos(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTooManyColons() throws Exception {
        new Chronos("12:34:33 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateNoColons() throws Exception {
        new Chronos("120333 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTooManySpaces() throws Exception {
        new Chronos("12: 33 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateNoSpace() throws Exception {
        new Chronos("12:34AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTooManyHours() throws Exception {
        new Chronos("14:34 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTooFewHours() throws Exception {
        new Chronos("0:34 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateNegHours() throws Exception {
        new Chronos("-2:34 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTooManyMinutes() throws Exception {
        new Chronos("11:60 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateNegMinutes() throws Exception {
        new Chronos("2:-34 AM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateBadMeridiem() throws Exception {
        new Chronos("12:20 dd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNoMinutesInput() throws Exception {
        Chronos time = new Chronos("12:20 AM");
        time.addMinutes(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLetterMinutesInput() throws Exception {
        Chronos time = new Chronos("12:20 AM");
        time.addMinutes("QWE");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFloatMinutesInput() throws Exception {
        Chronos time = new Chronos("12:20 AM");
        time.addMinutes("23.34");
    }

}