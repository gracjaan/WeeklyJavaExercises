package ss.week3.password;

public class BasicPassword extends Object {

    public static final String INITIAL = "admin8";


    /**
     * constructs a password with initial value
     * */
    private String currentPassword;
    public BasicPassword() {
        assert !testWord(INITIAL);
        this.currentPassword = INITIAL;
    }

    /**
     * @test if a given string is acceptable; not acceptable: a word with less than 6 characters or a word that contains space
     * @param suggestion word that should be tested
     * @return true if suggestion is acceptable
     * @require suggestion != null
     * @ensure returns true if the suggestion has at least 6 characters and no spaces
     * */
    public boolean acceptable(String suggestion){
        assert suggestion != null;
        return suggestion.length() >= 6 && suggestion.split(" ").length <= 1;
    }

    /**
     * @test if a given word is equal to the current password.
     * @param test word that should be tested
     * @return true If test is equal to the current password
     * @require test != null;
     * */
    public boolean testWord(String test){
        assert test != null;
        return test.equals(currentPassword);
    }

    /**
     * Change this password
     * @param oldPass The current password
     * @param newPass The new password
     * @return true If oldPass is equal to the current password and newpass is an acceptable password
     * @require oldpass != null, newpass != null
     * @ensure returns true if the old password is correct and the new one is acceptable
     * */
    public boolean setWord(String oldPass, String newPass){
        assert oldPass != null;
        assert newPass != null;
        if (oldPass.equals(currentPassword) && acceptable(newPass)) {
            this.currentPassword = newPass;
            return true;
        }
        return false;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }



}
