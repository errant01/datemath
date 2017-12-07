public class TimeMath {

    public static void main(String[] args) {
        // when done accept args here and throw exception if arks.count != 2
        if (args.length != 2) {
            throw new IllegalArgumentException("You have passed in the wrong mumber of arguments, it is possible you did not use quotes around your time.\nPlease use the format: TimeMath \"[H]H:MM {AM|PM}\" <minutesToAdd>");
        }
        String time = args[0];
        String minutes = args[1];
        System.out.println("Adding " + minutes + " to " + time);
        Chronos timeUtil = new Chronos(time);
        timeUtil.addMinutes(minutes);
        System.out.println(timeUtil.serialize());
    }
}
