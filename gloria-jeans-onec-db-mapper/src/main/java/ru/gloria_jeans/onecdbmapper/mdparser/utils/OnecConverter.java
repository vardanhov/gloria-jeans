package ru.gloria_jeans.onecdbmapper.mdparser.utils;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnecConverter {
    private static final String poz = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Pattern regex = Pattern.compile("\"([^\"]*?)\",?");
    private static final Pattern regexForDoubleSemicolons = Pattern.compile("\"\"[\\w\u0400-\u04FF]+\"\"");

    public static int getUnsignedShort(byte[] bytes) {
        return ((bytes[0] & 0xFF) | (bytes[1] & 0xFF) << 8);
    }

    public static long getUnsignedInt(byte[] bytes) {
        return ((bytes[0] & 0xFF) | (bytes[1] & 0xFF) << 8 | (bytes[2] & 0xFF) << 16 | (long) (bytes[3] & 0xFF) << 24);
    }

    public static String[] toStringArray(String inp) {
        Matcher matcher = regexForDoubleSemicolons.matcher(inp);

        while (matcher.find()) {
            inp = inp.replace(matcher.group(), matcher.group().replace("\"\"", "'"));
        }

        inp = inp.replace(",,", ",\"\",");

        if (inp.charAt(inp.length() - 1) == ',') {
            inp += "\"\"";
        }

        matcher = regex.matcher(inp);
        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add(matcher.group(1));
        }

        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    public static String trim(String content) {
        content = content.replace(",", "");
        content = content.replace("\"", "");
        return content;
    }

    public static String toBase36(String input) {
        int deci = Integer.parseInt(input);
        String rez = "";

        while (true) {
            int prom = deci / 36;
            rez = poz.charAt(deci - (prom * 36)) + rez;
            if (prom == 0) break;
            deci = prom;
        }

        return Strings.padEnd(Strings.padStart(rez, 6, ' '), 9, ' ');
    }
}
