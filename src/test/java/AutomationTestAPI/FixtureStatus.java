
package AutomationTestAPI;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FixtureStatus {

    @SerializedName("displayed")
    @Expose
    private Boolean displayed;
    @SerializedName("suspended")
    @Expose
    private Boolean suspended;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FixtureStatus() {
    }

    /**
     * 
     * @param displayed
     * @param suspended
     */
    public FixtureStatus(Boolean displayed, Boolean suspended) {
        super();
        this.displayed = displayed;
        this.suspended = suspended;
    }

    public Boolean getDisplayed() {
        return displayed;
    }

    public void setDisplayed(Boolean displayed) {
        this.displayed = displayed;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return "FixtureStatus{" +
                "displayed=" + displayed +
                ", suspended=" + suspended +
                '}';
    }
}
