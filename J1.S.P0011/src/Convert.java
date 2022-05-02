
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Copyright 2022 DucPTMHE160517
 */
/**
 *
 * @author DucPTMHE160517
 */
class Convert {

    private String HEX_CHARACTER = "0123456789ABCDEF";

    public String convertBase(int fromBase, int toBase, String value) {
        int base = 0;

        switch (toBase) {
            case 1:
                base = 2;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 16;
                break;
        }

        switch (fromBase) {
            case 1:
                return fromBinTo(base, value);
            case 2:
                return fromDecTo(base, value);
            case 3:
                return fromHexTo(base, value);
            default:
                return null;
        }
    }

    private String fromDecTo(int base, String value) {
        int remainder = 0;
        String charRemainder = "", resultString = "";
        ArrayList<String> remainderList = new ArrayList<>();
        BigInteger decInputValue = parseBigInteger(value);

        //Loop while DEC input value is greater than 0
        while (decInputValue.compareTo(BigInteger.ZERO) > 0) {
            remainder = decInputValue.mod(BigInteger.valueOf((long) base)).intValue();

            //Check if base equals 16
            if (base == 16) {
                charRemainder = toHexCharacter(remainder);
            } else {
                charRemainder = Integer.toString(remainder);
            }

            remainderList.add(charRemainder);
            decInputValue = decInputValue.divide(BigInteger.valueOf((long) base));
        }
        Collections.reverse(remainderList);
        resultString = String.join("", remainderList);
        return resultString;
    }

    private String fromBinTo(int base, String value) {
        String decimalString = "";
        BigInteger binaryBase = new BigInteger("2");
        BigInteger decimalNumber = new BigInteger("0");

        //Loop to get each value character's index from starting to ending
        for (int i = 0; i < value.length(); i++) {
            int position = value.length() - i - 1;
            String digit = Character.toString(value.charAt(i));
            BigInteger factor = new BigInteger(digit);
            decimalNumber = decimalNumber.add(factor.multiply(binaryBase.pow(position)));
        }

        decimalString = decimalNumber.toString();

        //Check if base equals 10
        if (base == 10) {
            return decimalString;
        } else {
            return fromDecTo(base, decimalString);
        }
    }

    private String fromHexTo(int base, String value) {
        String decimalString = "";
        BigInteger hexadecimalBase = new BigInteger("16");
        BigInteger decimalNumber = new BigInteger("0");

        //Loop to get each value character's index from starting to ending
        for (int i = 0; i < value.length(); i++) {
            int position = value.length() - i - 1;
            String digit = Integer.toString(HEX_CHARACTER.indexOf(value.charAt(i)));
            BigInteger factor = new BigInteger(digit);
            decimalNumber = decimalNumber.add(factor.multiply(hexadecimalBase.pow(position)));
        }

        decimalString = decimalNumber.toString();

        //Check if base equals 10
        if (base == 10) {
            return decimalString;
        } else {
            return fromDecTo(base, decimalString);
        }
    }

    private String toHexCharacter(int remainder) {
        switch (remainder) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return Integer.toString(remainder);
        }
    }

    private BigInteger parseBigInteger(String value) {
        BigInteger decimalNumber = null;
        decimalNumber = new BigInteger(value);
        return decimalNumber;
    }
}
