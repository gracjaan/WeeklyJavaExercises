package ss.week3.password;

public class BasicChecker implements Checker{

    /**
     * Validates password
     * @return true if password is acceptable, otherwise false
     * */
    @Override
    public boolean acceptable(String parameter) {
        return Checker.super.acceptable(parameter);
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
