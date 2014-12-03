package fun.seleniumtesting.stackoverflow.domain;

/**
 * Created by James on 11/3/14.
 * Represents a User on StackOverflow, and specifies methods that return information for that User.
 */
public interface User {

    /**
     * Gets the StackOverflow User's username.  This is what is used to look up the User's account on StackOverflow.
     * @return the username
     */
    String getUsername();

    /**
     * Gets the real name of this StackOverflow User.  If not specified, returns the username.
     * @return the real name
     */
    String getName();

    /**
     * Gets the url to the user's profile.
     * @return the url to the user's profile
     */
    String profileUrl();
}
