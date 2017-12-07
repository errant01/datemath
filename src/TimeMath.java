package src;

public class TimeMath {

    private static String time = "9:13 AM";
    private static String minutes = "200";



    public static void main(String[] args) {
        // when done accept args here and throw exception if arks.count != 2
//        String time = args[0];
//        String minutes = args[0];
        System.out.println("Adding " + minutes + " to " + time);
        Chronos timeUtil = new Chronos(time);
        timeUtil.addMinutes(minutes);
        System.out.println(timeUtil.serialize());
    }
}
