package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if(color == null || color.isEmpty()) {
            return false;
        }
        StringBuilder colorBuilder = new StringBuilder(color);
        colorBuilder.deleteCharAt(0);
        String rgb = "";
        if(color.length() == 7 && Pattern.matches("\\#([0-9A-Fa-f]{6})", color)) {
            rgb = "" + Integer.parseInt(colorBuilder.substring(0, 1), 16)
                    + Integer.parseInt(colorBuilder.substring(2, 3), 16)
                    + Integer.parseInt(colorBuilder.substring(4, 5), 16) ;
        }else if(color.length() == 4 && Pattern.matches("\\#([0-9A-Fa-f]{3})", color)) {

            rgb = "" + Integer.parseInt(colorBuilder.substring(0), 16)
                    + Integer.parseInt(colorBuilder.substring(1), 16)
                    + Integer.parseInt(colorBuilder.substring(2), 16) ;
        }else return false;

        Pattern pattern = Pattern.compile("[1-2]?[0-9]?[0-9]");
        Matcher m = pattern.matcher(rgb);

        if(m.find()) {
            return true;
        }
        return false;
    }

    public static int[] getRGB(final String rgb)
    {
        final int[] ret = new int[3];
        for (int i = 0; i < 3; i++)
        {
            ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }
}




