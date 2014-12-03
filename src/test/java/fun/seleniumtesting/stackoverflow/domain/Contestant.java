package fun.seleniumtesting.stackoverflow.domain;

import fun.seleniumtesting.stackoverflow.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fun.seleniumtesting.stackoverflow.domain.League.*;

/**
 * Created by James on 11/3/14.
 * This enum provides a quick and handy way to access commonly referenced Users
 * (such as users that are members of Catalyst).
 */
public enum Contestant implements User {

    JAMES_DUNN("TJamesBoone", FANATICS),
    NATHAN_WESTLAKE("CorayThan", FANATICS),
    PAT_MEEKER(FANATICS),
    BRENTON_PYL("CrazyBS");

    private final User user;
    private final List<League> leagues;

    private Contestant(String username, String name, League... leagues) {
        this.user = new CoolUser(username, name);
        this.leagues = new ArrayList<League>();
        this.leagues.add(ALL);
        this.leagues.addAll(Arrays.asList(leagues));
    }

    private Contestant(String username, League... leagues) {
        this(username, null, leagues);
    }

    private Contestant(League... leagues) {
        this(null, leagues);
    }

    @Override
    public String getUsername() {
        if(user.getUsername() == null) {
            ((CoolUser)user).setUsername(Strings.toTitleCase(this.name()));
        }
        return user.getUsername();
    }

    @Override
    public String getName() {
        if(user.getName() == null) {
            ((CoolUser)user).setName(Strings.toTitleCase(this.name()));
        }
        return user.getName();
    }

    @Override
    public String profileUrl() {
        return user.profileUrl();
    }

    @Override
    public String toString() {
        return Strings.toTitleCase(this.name());
    }

    public static Contestant[] values(League league) {
        List<Contestant> contestants = new ArrayList<Contestant>();
        for(Contestant contestant : values()) {
            if(contestant.leagues.contains(league)) {
                contestants.add(contestant);
            }
        }
        return contestants.toArray(values());
    }
}
