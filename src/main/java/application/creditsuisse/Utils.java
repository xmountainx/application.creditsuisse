package application.creditsuisse;

public class Utils {

    public static boolean isNum(String strNum) {
        boolean ret = true;

        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            ret = false;
        }

        return ret;
    }

    public static boolean isNotNum(String strNum) {
        return !isNum(strNum);
    }

}
