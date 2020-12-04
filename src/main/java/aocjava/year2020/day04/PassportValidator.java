package aocjava.year2020.day04;

import java.util.HashMap;
import java.util.Map;

public class PassportValidator {

    private final Map<String, String> fields = new HashMap<>();
    private static final String FIELD_SEPARATOR = "[ \n]";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String[] MANDATORY_FIELDS = {
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid"};

    PassportValidator(String passportString) {
        for(String keyValueString : passportString.split(FIELD_SEPARATOR)) {
            String[] keyValueArray = keyValueString.split(KEY_VALUE_SEPARATOR);
            fields.put(keyValueArray[0], keyValueArray[1]);
        }
    }

    boolean hasRequiredFields() {
        for(String fieldName : MANDATORY_FIELDS) {
            if(!fields.containsKey(fieldName)) {
                return false;
            }
        }
        return true;
    }

    boolean isValidPassport() {
        return hasRequiredFields() &&
                isDobValid() &&
                isIssueValid() &&
                isExpValid() &&
                isHeightValid() &&
                isHairValid() &&
                isEyeValid() &&
                isIdValid();
    }

    private boolean isDobValid() {
        return isYearValid(fields.get("byr"), 1920, 2002);
    }

    private boolean isIssueValid() {
        return isYearValid(fields.get("iyr"), 2010, 2020);
    }

    private boolean isExpValid() {
        return isYearValid(fields.get("eyr"), 2020, 2030);
    }

    private boolean isHeightValid() {
        String hgt = fields.get("hgt");
        if(hgt.endsWith("cm")) {
            int height = Integer.parseInt(hgt.replace("cm", ""));
            return 150 <= height && height <= 193;
        } else if(hgt.endsWith("in")) {
            int height = Integer.parseInt(hgt.replace("in", ""));
            return 59 <= height && height <= 76;
        } else {
            return false;
        }
    }

    private boolean isHairValid() {
        return fields.get("hcl").matches("#[0-9a-f]{6}");
    }

    private boolean isEyeValid() {
        String ecl = fields.get("ecl");
        return ecl.equals("amb") ||
                ecl.equals("blu") ||
                ecl.equals("brn") ||
                ecl.equals("gry") ||
                ecl.equals("grn") ||
                ecl.equals("hzl") ||
                ecl.equals("oth");
    }

    private boolean isIdValid() {
        return fields.get("pid").matches("[0-9]{9}");
    }

    private boolean isYearValid(String year, int from, int to) {
        if(year.length() != 4) {
            return false;
        }
        int yearInt = Integer.parseInt(year);
        return from <= yearInt && yearInt <= to;
    }
}