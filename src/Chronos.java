public class Chronos {

    private int minutes;
    private int hours;
    private String meridiem;

    public Chronos(String dateString) {
        parseDateString(dateString);
    }

    public void addMinutes(String minsToAdd) {
        // choosing to use exceptions for error propagation and handling for messages to user.
        // For larger systems with performance in mind, should use something lighter weight
        int mins = parseIntWithMsg(minsToAdd, "Minutes being added must be an integer");

        // add minutes
        minutes = minutes + mins;

        recalculate();
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(hours).append(":");
        sb.append(minutes).append(" ");
        sb.append(meridiem);
        return sb.toString();
    }

    private void recalculate() {
        // convert hours to 24 by meridiem
        if (hours == 12) {
            hours = 0;
        }
        if (meridiem.equals("PM")) {
            hours = hours + 12;
        }

        System.out.println("24: " + hours + ":" + minutes);

        // sum all to minutes
        int newMinutes = hours * 60 + minutes;
        minutes = newMinutes % 60;
        hours = newMinutes / 60;
        hours = hours % 24; // trim off days

        // convert hours from 24 to 12 w/ meridiem
        if (hours >= 12) {
            meridiem = "PM";
            hours = hours - 12;
        }
        if (hours == 0) {
            hours = 12;
        }
    }

    private void parseDateString(String dateString) {
        // format "[H]H:MM {AM|PM}"
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Your time must be of the form '[H]H:MM {AM|PM}'");
        }

        int idxColon = dateString.indexOf(":");
        if (idxColon == -1 || dateString.indexOf(":", idxColon + 1) >= 0) {
            throw new IllegalArgumentException("Your time must be of the form '[H]H:MM {AM|PM}', containing one and only one colon ':'");
        }

        int idxSpace = dateString.indexOf(" ");
        if (idxSpace == -1 || dateString.indexOf(" ", idxSpace + 1) >= 0) {
            throw new IllegalArgumentException("Your time must be of the form '[H]H:MM {AM|PM}', containing one and only one space ' '");
        }

        String hourSegment = dateString.substring(0,idxColon);
        String minuteSegment = dateString.substring(idxColon + 1, idxSpace);
        meridiem = dateString.substring(idxSpace + 1).toUpperCase();
//        System.out.println(hourSegment);
//        System.out.println(minuteSegment);
//        System.out.println(meridiem);

        hours = parseIntWithMsg(hourSegment, "Hours must be represented as an integer 1 thru 12");
        if (hours < 1 || hours > 12) {
            throw new IllegalArgumentException("Hours must be represented as an integer 1 thru 12");
        }
        System.out.println(hours);

        minutes = parseIntWithMsg(minuteSegment, "Minutes must be represented as string integer '00' thru '59'");
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Hours must be represented as an integer 1 thru 12");
        }
        System.out.println(minutes);

        if (!(meridiem.equals("AM") || meridiem.equals("PM"))) {
            throw new IllegalArgumentException("The meridiem must be represented with 'AM' or 'PM'");
        }
        System.out.println(meridiem);
    }

    private int parseIntWithMsg(String intString, String errorMessage) {
        int mins = 0;
        try {
            mins = Integer.parseInt(intString);
        } catch (Exception e) {
            throw new IllegalArgumentException(intString);
        }
        return mins;
    }
}
