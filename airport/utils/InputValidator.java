package airport.utils;

public class InputValidator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String validateNotEmpty(String input, String fieldName) {
        if (isEmpty(input)) {
            return fieldName + " cannot be empty";
        }
        return null;
    }

    public static String validatePositiveInteger(int value, String fieldName) {
        if (value < 0) {
            return fieldName + " must be a positive number";
        }
        return null;
    }

    public static String validatePositiveDouble(double value, String fieldName) {
        if (value < 0) {
            return fieldName + " cannot be negative";
        }
        return null;
    }

    public static boolean isValidPassportNumber(String passport) {
        if (isEmpty(passport)) return false;
        return passport.matches("[A-Z]{1,2}[0-9]{6,9}");
    }

    public static boolean isValidNationalId(String id) {
        if (isEmpty(id)) return false;
        return id.matches("[0-9]{8,12}");
    }

    public static String validateIdDocument(String id, String idType) {
        if (isEmpty(id)) {
            return idType + " cannot be empty";
        }
        if (idType.equals("Passport") && !isValidPassportNumber(id)) {
            return "Invalid passport format (e.g., AB123456)";
        }
        if (idType.equals("National ID") && !isValidNationalId(id)) {
            return "Invalid ID format (8-12 digits required)";
        }
        return null;
    }

    public static String validatePassport(String passport) {
        return validateIdDocument(passport, "Passport");
    }

    public static String validateIdType(String idType) {
        if (isEmpty(idType)) {
            return "ID type cannot be empty";
        }
        String normalized = idType.trim().toLowerCase();
        if (!normalized.equals("passport") && !normalized.equals("national id") && !normalized.equals("id")) {
            return "ID type must be 'Passport' or 'National ID'";
        }
        return null;
    }

    public static boolean isValidFlightId(String flightId) {
        if (isEmpty(flightId)) return false;
        return flightId.matches("[A-Z]{2,3}[0-9]{3,4}");
    }

    public static String validateFlightId(String flightId) {
        if (isEmpty(flightId)) {
            return "Flight ID cannot be empty";
        }
        if (!isValidFlightId(flightId)) {
            return "Invalid flight ID format (e.g., AA123 or ABC1234)";
        }
        return null;
    }

    public static boolean isValidSeatNumber(String seat) {
        if (isEmpty(seat)) return false;
        return seat.matches("[0-9]{1,3}[A-F]");
    }

    public static String validateSeatNumber(String seat) {
        if (isEmpty(seat)) {
            return "Seat number cannot be empty";
        }
        if (!isValidSeatNumber(seat)) {
            return "Invalid seat format (e.g., 12A)";
        }
        return null;
    }

    public static boolean isValidPhoneNumber(String phone) {
        if (isEmpty(phone)) return false;
        return phone.matches("[+]?[0-9]{7,15}");
    }

    public static String validatePhoneNumber(String phone) {
        if (isEmpty(phone)) {
            return "Phone number cannot be empty";
        }
        if (!isValidPhoneNumber(phone)) {
            return "Invalid phone number format";
        }
        return null;
    }

    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) return false;
        return email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public static String validateClassType(String classType) {
        if (isEmpty(classType)) {
            return "Class type cannot be empty";
        }
        String normalized = classType.trim().toLowerCase();
        if (!normalized.equals("economy") && !normalized.equals("business") && !normalized.equals("first")) {
            return "Class type must be Economy, Business, or First";
        }
        return null;
    }

    public static String getValidationSummary(String... errors) {
        StringBuilder sb = new StringBuilder();
        for (String error : errors) {
            if (error != null) {
                sb.append("- ").append(error).append("\n");
            }
        }
        return sb.length() > 0 ? sb.toString() : null;
    }
}
