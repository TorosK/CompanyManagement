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

            System.out.println("The code input is: " + code);
            switch (code.toLowerCase()) {
                case "male" -> {
                    return Gender.MALE;
                }
                case "female" -> {
                    return Gender.FEMALE;
                }
                case "unknown" -> {
                    return Gender.UNKNOWN;
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

    public static void readGender(Employee employee) throws NumberFormatException {
        
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Unknown");
        
        String genderChoice = EmployeeManagement.sc.nextLine();
        
        if (Utilities.isNumeric(genderChoice)) {
        
            employee.setGender(getGenderByNumericCode(Integer.parseInt(genderChoice)));
        } 
        else {
        
            employee.setGender(getGenderByTextCode(genderChoice));
        }
    }
}
