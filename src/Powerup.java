/**
 *  This is an abstract class that every different powerup will have to extend from.
 */
public abstract class Powerup {
    private String powerupName;
    private String powerupDescription;
    private boolean active;

    /**
     *  Constructor which gives the powerup its name, a description of what it does, and then sets its
     *  boolean field named active to false.
     * @param name is the name of the specific powerup
     * @param description is a short description of what the powerup does
     */
    public Powerup (String name, String description) {
        this.powerupName = name;
        this.powerupDescription = description;
        this.active = false;
    }

    /**
     *  Sets the boolean field named active to true, which means the powerup will be in play.
     */
    public void activate() {
        this.active = true;
    }

    /**
     *  Sets the boolean field named active to false, which means the powerup will not be in play.
     */
    public void deactivate() {
        this.active = false;
    }

    /**
     *  Abstract class which all powerups will override and make changes to the game depending on
     *  what the powerup is supposed to do.
     */
    abstract void makeChanges();
}
