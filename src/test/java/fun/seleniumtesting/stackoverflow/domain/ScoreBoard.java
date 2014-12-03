package fun.seleniumtesting.stackoverflow.domain;

import java.util.*;

/**
 * Created by James on 11/3/14.
 */
public class ScoreBoard {

    private LinkedHashMap<User, Integer> board = new LinkedHashMap<User, Integer>();
    private ArrayList<User> placementOrder = new ArrayList<User>();

    public void setScore(User user, int score) {
        int index = 0;
        for(User userOnBoard : placementOrder) {
            if(board.get(userOnBoard) >= score){
                index++;
            } else {
                break;
            }
        }
        placementOrder.remove(user);
        placementOrder.add(index, user);
        List<User> lowerScores = usersWhoScoredLowerThan(user);
        Map<User, Integer> temporaryBoardForLowerScores = new LinkedHashMap<User, Integer>();
        board.remove(user);
        for(User userWithLowerScore : lowerScores) {
            temporaryBoardForLowerScores.put(userWithLowerScore, board.get(userWithLowerScore));
            board.remove(userWithLowerScore);
        }
        board.put(user, score);
        board.putAll(temporaryBoardForLowerScores);
    }

    public int getScore(User user) {
        return board.get(user);
    }

    public User getUserByPlacement(int placement) {
        if(placement <= placementOrder.size()) {
            return placementOrder.get(placement - 1);
        } else {
            return null;
        }
    }

    public List<User> usersWhoScoredHigherThan(User user) {
        if(placementOrder.contains(user)) {
            return rangeOfList(placementOrder, 0, placementOrder.indexOf(user));
        } else {
            return new ArrayList<User>(placementOrder);
        }
    }

    public List<User> usersWhoScoredLowerThan(User user) {
        if(placementOrder.contains(user)) {
            return rangeOfList(placementOrder, placementOrder.indexOf(user) + 1, placementOrder.size());
        } else {
            return new ArrayList<User>(placementOrder);
        }
    }

    public List<User> getContestants() {
        return new ArrayList<User>(placementOrder);
    }

    private static <T> List<T> rangeOfList(List<T> list, int start, int end) {
        List<T> range = new ArrayList<T>();
        for(int index = start; index < end; index++) {
            range.add(list.get(index));
        }
        return range;
    }
}
