package ss.week3.password;

public interface Checker {


    /**
     * @param parameter given parameter
     * @return true if the parameter is acceptable
     * */

    default boolean acceptable(String parameter){
        assert parameter != null;
        return parameter.length() >= 6 && parameter.split(" ").length <= 1;
    }

    /**
     * generates a password
     * @return an acceptable String
     */
    String generatePassword();


}
