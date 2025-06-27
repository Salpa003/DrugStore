package util;

public class PathToJsp {
    private static String FORMAT = "WEB-INF/pages/%s";
    public static String create(String fileName) {
        return FORMAT.formatted(fileName);
    }
}
