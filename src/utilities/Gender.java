package utilities;

import models.Employee;
import models.EmployeeManagement;

public enum Gender {

    MALE(1, "Male"), FEMALE(2, "Female"), OTHER(3, "Other");

    private int code;
    private String text;

    private Gender(int code, String text) {
        this.code = code;
        this.text = text;
    }

    // Gender by code.
    public static Gender getGenderByNumericCode(int code) {
        for (Gender gender : Gender.values()) {

            switch (code) {

                case 1 -> {
                    return Gender.MALE;
                }
                case 2 -> {
                    return Gender.FEMALE;
                }
                case 3 -> {
                    return Gender.OTHER;
                }
                default -> {
                }
            }
        }
        return null;
    }

    //Gender by String
    public static Gender getGenderByTextCode(String code) {
        for (Gender gender : Gender.values()) {

            switch (code.toLowerCase()) {

                case "male" -> {
                    return Gender.MALE;
                }
                case "female" -> {
                    return Gender.FEMALE;
                }
                case "other" -> {
                    return Gender.OTHER;
                }
                default -> {
                }
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //take input from user and check for integer or string and call respective function.
    public static void readGender(Employee employee) throws NumberFormatException {

        boolean boolReadGender = false;

        do {
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");

            String genderChoice = EmployeeManagement.sc.nextLine();

            if (Utilities.isNumeric(genderChoice)) {

                if (getGenderByNumericCode(Integer.parseInt(genderChoice)) == null) {
                    
                    boolReadGender = true; 
                    System.out.println("Invalid input. Please try again.");

                } else {
                    
                    employee.setGender(getGenderByNumericCode(Integer.parseInt(genderChoice)));
                    boolReadGender = false;
                }
            } else {

                if (getGenderByTextCode(genderChoice) == null) {
                    
                    boolReadGender = true;
                    System.out.println("Invalid input. Please try again.");

                } else {
                    
                    employee.setGender(getGenderByTextCode(genderChoice));
                    boolReadGender = false;
                }
            }
        } while (boolReadGender);

    }
}
