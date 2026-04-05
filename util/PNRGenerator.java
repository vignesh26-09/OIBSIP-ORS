package util;

public class PNRGenerator {

    public static String generatePNR() {
        return "PNR" + System.currentTimeMillis();
    }
}