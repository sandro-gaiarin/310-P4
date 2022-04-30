import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * A class representing a user's profile in the MasonConnect social media program.
 * @author Alessandro Gaiarin
 * @version 0.9
 */
public class Profile {
    /**
     * Full name of the user.
     */
    String name;
    /**
     * User's status (specified by the user).
     */
    String status;
    /**
     * Arraylist of profiles of the user's friends.
     */
    ArrayList<Profile> friendProfiles;


    /*----------------------------------------------------------
    Constructors
     ---------------------------------------------------------*/

    /**
     * Default constructor, initializes strings to empty strings and
     * gives friendProfiles a default ArrayList.
     */
    Profile() {
        name = "";
        status = "";
        friendProfiles = new ArrayList<>();
    }

    /**
     * Initializes attributes.
     * @param name name of user.
     * @param status status of user.
     * @param friendProfiles list of profiles of user's friends.
     */
    Profile(String name, String status, ArrayList<Profile> friendProfiles) {
        this.name = name;
        this.status = status;
        this.friendProfiles = friendProfiles;
    }

    /**
     * Initializes attributes, gives friendProfiles a default (empty) ArrayList.
     * @param name name of user.
     * @param status status of user.
     */
    Profile(String name, String status) {
        this.name = name;
        this.status = status;
        friendProfiles = new ArrayList<>();
    }

    /**
     * Setter for name of the user.
     * @param firstName user's first name.
     * @param lastName user's last name.
     */
    public void setName(String firstName, String lastName) {
        name = firstName + " " + lastName;
    }

    /**
     * Getter for name of the user.
     * @return name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for status.
     * @param status user's new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for status.
     * @return user's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * toString method.
     * @return string displaying the user's name, status, and their number of friends.
     */
    @Override
    public String toString() {
        return ("Name: " + name + "\n\tStatus: " + status + "\n\tNumber of friend profiles: " + friendProfiles.size() + "\n"); //TODO deleted newline at the end of this
    }

    /**
     * Displays this profile, and the friends' profiles.
     */
    public void display() {
        System.out.print(this);
        System.out.print("Friends:\n"); //no newline since toString() already does one
        friendProfiles.forEach((profile) -> System.out.println("\t" + profile.getName()));
    }

    /**
     * Getter for the friend profiles list.
     * @return the friendProfiles ArrayList.
     */
    public ArrayList<Profile> getFriendProfiles() {
        return friendProfiles;
    }

    /**
     * Adds a friend.
     * @param user new friend.
     */
    public void addFriend(Profile user) {
        friendProfiles.add(user);
    }

    /**
     * Unfriends a friend.
     * @param user former friend.
     * @return true if the removal was successful, false otherwise.
     */
    public boolean unFriend(Profile user) {
        try {
            friendProfiles.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}