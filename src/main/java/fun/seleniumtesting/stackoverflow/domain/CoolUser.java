package fun.seleniumtesting.stackoverflow.domain;

/**
 * Created by James on 11/3/14.
 * A simple, cool implementation of {@link User}.
 */
public class CoolUser implements User {

    private String username;
    private String name;
    private int accountId;

    public CoolUser(String username, String name){
        this.username = username;
        this.name = name;
    }

    public CoolUser(String username) {
        this(username, username);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getName() {
        return name;
    }

    public CoolUser setName(String name) {
        this.name = name;
        return this;
    }

    public CoolUser setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String profileUrl() {
        return ((accountId!= 0 && username != null)
                ? String.format("http://stackoverflow.com/users/%d/%s", accountId, username)
                : null
        );
    }
}
