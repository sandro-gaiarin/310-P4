import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MasonConnect {
    /**
     * ArrayList of the users in MasonConnect.
     */
    ArrayList<Profile> users; //TODO Might be able to get away with an ArrayList here, I'm not sure.

    /**
     * Constructor.
     */
    MasonConnect() {
        users = new ArrayList<>();
    }

    /**
     * Adds a user to MasonConnect.
     * @param p the profile of the new user.
     */
    public void addUser(Profile p) {
        users.add(p);
    }

    /**
     * Removes a user from MasonConnect.
     * @param p user profile to be removed.
     * @return the removed user's profile.
     */
    public Profile removeUser(Profile p){
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i) == p) {
                return users.remove(i);
            }
        }
        return null;
    }

    /**
     * Create a friendship between two profiles.
     * @param a first profile.
     * @param b second profile.
     * @return true if friendship is created successfully.
     */
    public boolean createFriendship(Profile a, Profile b) {
        try {
            a.addFriend(b);
            b.addFriend(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Remove friendship between two profiles.
     * @param a first profile.
     * @param b second profile.
     * @return true if the friendship is removed from EACH profile successfully.
     */
    public boolean removeFriendship(Profile a, Profile b) {
        if (a.unFriend(b) && b.unFriend(a)){
            return true;
        }
        return false;
    }

    /**
     * Check if two profiles are friends.
     * @param a first profile.
     * @param b second profile.
     * @return true if BOTH profiles has the other registered as a friend.
     */
    public boolean hasFriendship(Profile a, Profile b) {
        if (a.getFriendProfiles().contains(b) && b.getFriendProfiles().contains(a)) {
            return true;
        }
        return false;
    }

    /**
     * Display each profile's information and friends, starting from startPoint profile.
     * @param startPoint first profile to display (root).
     */
    public void traverse(Profile startPoint) {
        ArrayList<Profile> displayedProfiles = new ArrayList<>(); //list to store displayed profiles in
        ArrayList<Profile> undisplayedProfiles = new ArrayList<>(); //list to store undisplayed profiles in
        startPoint.display(); //output
        displayedProfiles.add(startPoint); //add to displayed profiles
        startPoint.getFriendProfiles().forEach((Profile) -> undisplayedProfiles.add(Profile)); //add each friend of startPoint to undisplayedProfiles
        while (undisplayedProfiles.size() > 0) {
            if (displayedProfiles.contains(undisplayedProfiles.get(0))) { //if profile has already been displayed then it gets removed
                undisplayedProfiles.remove(0);
            }
            else { //else, profile gets displayed, and all its neighbors are added to undisplayedProfiles
                undisplayedProfiles.get(0).display();
                System.out.println(); //newline after each profile displayed
                displayedProfiles.add(undisplayedProfiles.get(0));
                undisplayedProfiles.get(0).getFriendProfiles().forEach((Profile) -> undisplayedProfiles.add(Profile));
                undisplayedProfiles.remove(0);
            }
        }
    }

    /**
     * Returns true if a specified profile exists within MasonConnect.
     * @param user profile we're checking for.
     * @return true if the user exists within MasonConnect, false otherwise.
     */
    public boolean exists(Profile user) {
        if (users.contains(user)) {
            return true;
        }
        return false;
    }

    public List<Profile> friendSuggestion(Profile user) {
        //TODO
        return null;
    }

    public int friendshipDistance(Profile a, Profile b) {
        //TODO
        return 0;
    }

}
