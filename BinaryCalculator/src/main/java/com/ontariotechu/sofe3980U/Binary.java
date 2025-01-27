package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
    private String number = "0"; // String containing the binary value, default is "0"

    /**
     * Constructor that generates a Binary object.
     *
     * @param number a String of binary values. It should contain only zeros or
     *               ones with any length and order. Otherwise, the value "0" will
     *               be stored. Trailing zeros will be excluded, and an empty string
     *               will be considered as zero.
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0"; // Default to "0" for null or empty input
            return;
        }

        // Validate the binary string (only '0' or '1' allowed)
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0"; // Default to "0" for invalid input
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        this.number = (beg == number.length()) ? "0" : number.substring(beg);

        // Ensure number is not empty
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable.
     *
     * @return the binary value in string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables. For more information, visit
     * <a href="https://www.wikihow.com/Add-Binary-Numbers">Add-Binary-Numbers</a>.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;

        int carry = 0;
        String num3 = ""; // Resultant binary string

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            carry = sum / 2;
            sum = sum % 2;
            num3 = ((sum == 0) ? "0" : "1") + num3;
        }

        return new Binary(num3);
    }

    /**
     * Performs a bitwise OR operation between two binary variables.
     *
     * @param num1 The first binary number
     * @param num2 The second binary number
     * @return A binary variable with the value of num1 OR num2.
     */
    public static Binary or(Binary num1, Binary num2) {
        int maxLength = Math.max(num1.number.length(), num2.number.length());
        String value1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
        String value2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char bit1 = value1.charAt(i);
            char bit2 = value2.charAt(i);
            result.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

    /**
     * Performs a bitwise AND operation between two binary variables.
     *
     * @param num1 The first binary number
     * @param num2 The second binary number
     * @return A binary variable with the value of num1 AND num2.
     */
    public static Binary and(Binary num1, Binary num2) {
        int maxLength = Math.max(num1.number.length(), num2.number.length());
        String value1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
        String value2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char bit1 = value1.charAt(i);
            char bit2 = value2.charAt(i);
            result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

    /**
     * Multiplies two binary variables.
     *
     * @param num1 The first binary number
     * @param num2 The second binary number
     * @return A binary variable with the value of num1 * num2.
     */
    public static Binary multiply(Binary num1, Binary num2) {
        Binary result = new Binary("0");
        String value2 = num2.getValue();

        for (int i = value2.length() - 1; i >= 0; i--) {
            if (value2.charAt(i) == '1') {
                String shifted = num1.getValue() + "0".repeat(value2.length() - 1 - i);
                result = Binary.add(result, new Binary(shifted));
            }
        }

        return result;
    }
}