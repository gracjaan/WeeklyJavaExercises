package ss.week3.password;

import java.lang.reflect.Array;

public class StrongChecker implements Checker{

    /**
     *
     * @param password to be checked
     * @return true if password starts with a letter and ends with a char, false otherwise
     */
    @Override
    public boolean acceptable(String password) {
        char s = password.charAt(0);
        char e = password.charAt(password.length()-1);
        if (password.length() >= 6 && password.split(" ").length <= 1) {
            if (!(Character.isDigit(s)) && Character.isDigit(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates password
     * @return acceptable password
     * */
    @Override
    public String generatePassword() {
        String suggestion = "";
        int random = 65 + (int) (Math.random()*57);
        for (int i=0;i<11;i++) {
            random = 65 + (int) (Math.random()*57);
            char c = (char) random;
            suggestion += c;
        }
        suggestion+=random;
        if (acceptable(suggestion)) {
            return suggestion;
        }
        else {
            return generatePassword();
        }

    }
}
