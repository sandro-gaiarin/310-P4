import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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

    /**
     * Returns a list of profiles who have a mutual friend with the given profile,
     * but are not friends.
     * @param user profile who is being suggested new friends.
     * @return a list of profiles with mutual friends, or null if there are no
     * applicable friend suggestions (or if the user does not exist).
     */
    public List<Profile> friendSuggestion(Profile user) {
        try {
            List<Profile> returnList = new ArrayList<>();
            user.getFriendProfiles().forEach((mutual -> { //i've never used forEach like this before
                mutual.getFriendProfiles().forEach((friendProfile) -> { //it's really useful
                    if (!user.getFriendProfiles().contains(friendProfile) && !returnList.contains(friendProfile) && friendProfile != user) {
                        returnList.add(friendProfile);
                    }
                });
            }));
            if (returnList.isEmpty()) { //return null if there are no applicable friends to suggest
                return null;
            }
            return returnList;
        } catch (Exception e) { //return null if the user does not exist
            return null;
        }
    }

    /**
     * Returns friendship distance between two profiles, starting with 1 if they are friends.
     * @param a first profile.
     * @param b second profile.
     * @return Friendship distance, or -1 if either profile is not on MasonConnect.
     */
    public int friendshipDistance(Profile a, Profile b) {
        //TODO !!!
        ArrayList<Profile> usersCopy = new ArrayList<>();
        usersCopy.addAll(users);
        Stack<Profile> friendshipStack = new Stack<>();
        ArrayList<Profile> checkedProfiles = new ArrayList<>();
        ArrayList<Profile> toCheckProfiles = new ArrayList<>();
        friendshipStack.push(a); //add first profile to friendship stack
        toCheckProfiles.add(a); //add first profile to toCheck line
        while (!toCheckProfiles.isEmpty()) {
            Profile stackTop = friendshipStack.peek(); //current top profile on stack

            if (!stackTop.getFriendProfiles().contains(b)) {

            }
            else { //else we've reached the destination
                int returnInt = 0;
                while (!friendshipStack.isEmpty()) {
                    friendshipStack.pop();
                    returnInt += 1;
                }
                return returnInt;
            }
        }

        return -1; //if we're here, something broke, i guess
    }

}
