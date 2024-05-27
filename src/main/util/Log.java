package adp.src.main.util;

public class Log {
    public static System.Logger logger = System.getLogger("Logger");
    public static String msg01 = "Info";
    public static String msg02 = "Warning";
    public static String msg03 = "Error";
    public static String msg04 = "Debug";
    public static String msg05 = "Trace";

    public static System.Logger.Level info = System.Logger.Level.INFO;
    public static System.Logger.Level warning = System.Logger.Level.WARNING;
    public static System.Logger.Level error = System.Logger.Level.ERROR;
    public static System.Logger.Level debug = System.Logger.Level.DEBUG;
    public static System.Logger.Level trace = System.Logger.Level.TRACE;

    public static void main(String[] args) {
        logger.log(info, msg01);
    }
}
