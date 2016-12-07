package cz.zcu.fav.pro;

/**
 * Pomocní třída pro výpis na výstup
 */
public final class OutputFormater {

    private static final boolean HUMAN_READ = true;
    private static final String DELIMITER = ",";

    private OutputFormater() {throw new UnsupportedOperationException();}

    public static void format(String what, Object ... args) {
        if (HUMAN_READ) {
            System.out.format(what, args);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                sb.append(arg).append(DELIMITER);
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
//            System.out.println(String.join(",", args));
        }
    }

}
