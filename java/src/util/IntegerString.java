package util;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.regex.Pattern;


public class IntegerString implements Comparable {

    private String value;
    private boolean isPositive = true;
    public IntegerString(String s){
        if (!Pattern.compile("\\d*").matcher(s).matches()) {
            throw new InputMismatchException("Input should contain only digits");
        }
        int j=0;
        if (s.charAt(0)=='-') {
            isPositive = false;
            j++;
        }
        // Find first non-zero digit from left
        while(j<s.length() && s.charAt(j)=='0') {
            j++;
        };
        if (j==s.length()) {
            // Number is 0
            value ="0";
        } else if (j==0) {
            // No leading Zeros
            value = s;
        } else {
            // Some leading Zeros
            value = s.substring(j);
        }
    }
    public String getString() {
        return value;
    }

    private byte getDigitValue(char c) {
        return (byte)(c - '0');
    }

    public IntegerString get10sComplement() {
        char[] tensComplement= new char[this.getString().length()];
        for (int i=0; i<this.getString().length();i++) {
            tensComplement[i] = (char)('9' - value.charAt(i) + '0');
        }
        return new IntegerString(new String(tensComplement));
    }

    public IntegerString subtract(IntegerString rhs) {
        return new IntegerString("blah");
    }

    public IntegerString add(IntegerString rhs) {
        int misMatch = this.getString().length() - rhs.getString().length();
        char[] zeroes = new char[Math.abs(misMatch)];
        Arrays.fill(zeroes, '0');
        String arg1;
        String arg2;
        if (misMatch > 0) {
            arg1 = this.getString();
            arg2 = new String(zeroes).concat(rhs.getString());
        } else if (misMatch < 0) {
            arg1 = new String(zeroes).concat(this.getString());
            arg2 = rhs.getString();
        } else {
            arg1 = this.getString();
            arg2 = rhs.getString();
        }
        // Sum may result in an extra digit
        char[] sum = new char[arg1.length()+1];
        byte carry = 0;
        for (int i=arg1.length()-1; i>=0; i--) {
            byte currDigitSum = (byte)(getDigitValue(arg1.charAt(i)) + getDigitValue(arg2.charAt(i))+carry);
            carry = (byte)(currDigitSum > 9 ? 1 : 0);
            sum[i+1] = (char)(currDigitSum % 10 + '0');
        }
        sum[0] = (char)(carry + '0');
        return new IntegerString(new String(sum));
    }
    @Override
    public int compareTo(Object o) {

        if (!(o instanceof IntegerString)) {
            throw new InputMismatchException("Input should be IntegerString");
        }
        IntegerString rhs = (IntegerString)o;
        if (this.getString() == rhs.getString()) {
            return 0;
        }
        if (this.getString().length() < rhs.getString().length()) {
            return -1;
        }
        if (this.getString().length() > rhs.getString().length()) {
            return 1;
        }

        for (int i = 0; i<this.getString().length(); i++) {
            if (this.getString().charAt(i) < rhs.getString().charAt(i)) {
                return -1;
            }
            if (this.getString().charAt(i) > rhs.getString().charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}
