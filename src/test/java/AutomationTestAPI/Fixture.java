
package AutomationTestAPI;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Fixture {

    @SerializedName("fixtureId")
    @Expose
    private String fixtureId;
    @SerializedName("fixtureStatus")
    @Expose
    private FixtureStatus fixtureStatus;
    @SerializedName("footballFullState")
    @Expose
    private FootballFullState footballFullState;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fixture() {
    }

    /**
     * 
     * @param footballFullState
     * @param fixtureId
     * @param fixtureStatus
     */
    public Fixture(String fixtureId, FixtureStatus fixtureStatus, FootballFullState footballFullState) {
        super();
        this.fixtureId = fixtureId;
        this.fixtureStatus = fixtureStatus;
        this.footballFullState = footballFullState;
    }

    public String getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }

    public FixtureStatus getFixtureStatus() {
        return fixtureStatus;
    }

    public void setFixtureStatus(FixtureStatus fixtureStatus) {
        this.fixtureStatus = fixtureStatus;
    }

    public FootballFullState getFootballFullState() {
        return footballFullState;
    }

    public void setFootballFullState(FootballFullState footballFullState) {
        this.footballFullState = footballFullState;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "fixtureId='" + fixtureId + '\'' +
                ", fixtureStatus=" + fixtureStatus +
                ", footballFullState=" + footballFullState +
                '}';
    }
}
