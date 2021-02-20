package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GraphicDesigner;
import static models.EmployeeManagement.*;
import models.Programmer;
import models.TestSpecialist;

public class Utilities {

    public static void loadDB() {

        employees.add(new Programmer("Java", "Toros", "Kutlu", Gender.MALE, 50000.25));
        employees.add(new Programmer("Python", "Åsa", "Karlsson", Gender.FEMALE, 60000.50));
        employees.add(new Programmer("C#", "Ängla", "Karlsson", Gender.FEMALE, 60000.50));
        employees.add(new Programmer("C#", "Ängla", "Karlsson", Gender.OTHER, 60000.50));
        employees.add(new GraphicDesigner("PhotoShop", "Sara", "Anderson", Gender.FEMALE, 40000));
        employees.add(new GraphicDesigner("Gimp", "Urban", "Petri", Gender.MALE, 35000.999));
        employees.add(new GraphicDesigner("Gimp", "Öjar", "Urban", Gender.MALE, 35000.999));
        employees.add(new GraphicDesigner("Gimp", "Öjar", "Urban", Gender.OTHER, 35000.999));
        employees.add(new TestSpecialist(true, "Maria", "Pirat", Gender.FEMALE, 6500));
        employees.add(new TestSpecialist(false, "Björn", "Karlsson", Gender.MALE, 6500));
        employees.add(new TestSpecialist(false, "Björn", "Karlsson", Gender.OTHER, 6500));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.8776554435));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.3776554435));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.1776554435));

        employees.forEach(employee -> {
            employee.bonus();
        });

        printAllEmployees();
        System.out.println("");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;

    }

    public static String readString() {

        boolean loop = true;
        String str = null;

        while (loop) {
            try {
                str = sc.nextLine();
                if (!((str.isBlank() || str.isEmpty() || isNumeric(str)))) {
                    loop = false;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            }
        } // loop
        return str;
    }

    // below method becomes problematic if user inputs double such as 600 000
    // and 600,000. 
    // 600 000 becomes 600 instead of 600000.
    // 600,000 becomes 600000 instead of 600.00.
    // Decimal sign in Swedish (and some other languages) is , but in English it is .
    // Therefore the symbol , should be transformed into .
    // 600.000 becomes 600.00 which is correct.
    public static double readDouble() {

        boolean loop = true;
        double number = -1;

        while (loop) {
            try {
                number = sc.nextDouble();
                // sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                // sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            } finally {
                sc.nextLine();
            }
        } // loop
        return number;
    }

    // not used yet
    public static double readDouble2() {

        boolean loop = true;
        String userInputNumberAsString;
        double numberStringToDouble = -1;

        while (loop) {
            try {
                userInputNumberAsString = sc.nextLine();
                userInputNumberAsString = userInputNumberAsString.replace(" ", "");
                userInputNumberAsString = userInputNumberAsString.replace(",", ".");
                numberStringToDouble = Double.parseDouble(userInputNumberAsString);
                //sc.nextLine();
                loop = false;
            } catch (InputMismatchException ime) {
                //sc.nextLine();
                System.out.println("Invalid input (error: InputMismatchException). Please input number in the format \"600 550.56\" only. No commas (,) please. Please try again.");
            } catch (NumberFormatException nfe) {
                //sc.nextLine();
                System.out.println("Invalid input (error: NumberFormatException). Please input number in the format \"600 550.56\" only. No commas (,) please. Please try again.");
            } catch (Exception e) {
                //sc.nextLine();
                System.out.println("Invalid input (error: other Exception). Please input number in the format \"600 550.56\" only. No commas (,) please. Please try again.");
            }

        } // loop
        return numberStringToDouble;
    }

    public static boolean readBoolean() {

        boolean loop = true;
        boolean certificate = false;

        while (loop) {
            try {
                certificate = sc.nextBoolean();
                sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            }
        } // loop
        return certificate;
    }

    public static int readInt() {

        boolean loop = true;
        int number = -1;

        while (loop) {
            try {
                number = sc.nextInt();
                // sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                // sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            } finally {
                sc.nextLine();
            }
        } // loop
        return number;
    }

    public static int readInt2() {

        boolean loop = true;
        String userInputNumberAsString;
        int numberStringToInt = -1;

        while (loop) {
            try {
                userInputNumberAsString = sc.nextLine();
                userInputNumberAsString = userInputNumberAsString.replace(" ", "");
                userInputNumberAsString = userInputNumberAsString.replace(",", ".");
                numberStringToInt = Integer.parseInt(userInputNumberAsString);
                //sc.nextLine();
                loop = false;
            } catch (InputMismatchException ime) {
                //sc.nextLine();
                System.out.println("Invalid input (error: InputMismatchException). Please input number in the format \"600 550\" only. No commas (,) or points (.) please. Please try again.");
            } catch (NumberFormatException nfe) {
                //sc.nextLine();
                System.out.println("Invalid input (error: NumberFormatException). Please input number in the format \"600 550\" only. No commas (,) or points (.) please. Please try again.");
            } catch (Exception e) {
                //sc.nextLine();
                System.out.println("Invalid input (error: other Exception). Please input number in the format \"600 550\" only. No commas (,) or points (.) please. Please try again.");
            }

        } // loop
        return numberStringToInt;
    }

    public static String theStringTrimmer(String s) {
        if (s.length() <= 15) {
            int max = 15 - s.length();
            for (int i = 0; i <= max; i++) {
                s = s + " ";
            }
        } else {
            s = s.substring(0, 15);
        }
        return s;
    }

    public static void tableHeader() {
        System.out.println("ID              Name            Gender          Salary          Salary & Bonus  Qualifications");
    }

//    public static String readAlphabet(String s) {​​
//    Scanner sc = new Scanner(System.in);
//    boolean tryingAlphabet = true;
//    String text = s;
//    while (tryingAlphabet) {​​
//
//        String patternString = "[a-zA-Z]*$";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(text);
//        boolean matches = matcher.matches();
//        if (matches && !text.equals("")) {​​
//            tryingAlphabet = false;
//            return text;
//        }​​ else {​​
//            System.out.println("Only Alphabet valid!");
//            text = sc.nextLine();
//        }​​
//
//    }​​
//    return text;
//
//}​​
    public static void numberformatter() {
        Locale[] locales = NumberFormat.getAvailableLocales();
        double myNumber = -1234.56;
        NumberFormat form;
        for (int j = 0; j < 4; ++j) {
            System.out.println("FORMAT");
            for (int i = 0; i < locales.length; ++i) {
                if (locales[i].getCountry().length() == 0) {
                    continue; // Skip language-only locales
                }
                System.out.print(locales[i].getDisplayName());
                switch (j) {
                    case 0:
                        form = NumberFormat.getInstance(locales[i]);
                        break;
                    case 1:
                        form = NumberFormat.getIntegerInstance(locales[i]);
                        break;
                    case 2:
                        form = NumberFormat.getCurrencyInstance(locales[i]);
                        break;
                    default:
                        form = NumberFormat.getPercentInstance(locales[i]);
                        break;
                }
                if (form instanceof DecimalFormat) {
                    System.out.print(": " + ((DecimalFormat) form).toPattern());
                }
                System.out.print(" -> " + form.format(myNumber));
                try {
                    System.out.println(" -> " + form.parse(form.format(myNumber)));
                } catch (ParseException e) {
                }
            }
        }
    }

}
