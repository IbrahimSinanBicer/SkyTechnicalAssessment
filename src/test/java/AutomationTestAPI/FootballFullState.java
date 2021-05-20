
package AutomationTestAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FootballFullState {

    @SerializedName("homeTeam")
    @Expose
    private String homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private String awayTeam;
    @SerializedName("finished")
    @Expose
    private Boolean finished;
    @SerializedName("gameTimeInSeconds")
    @Expose
    private Integer gameTimeInSeconds;
    @SerializedName("goals")
    @Expose
    private List<Goal> goals = null;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("possibles")
    @Expose
    private List<Object> possibles = null;
    @SerializedName("corners")
    @Expose
    private List<Object> corners = null;
    @SerializedName("redCards")
    @Expose
    private List<Object> redCards = null;
    @SerializedName("yellowCards")
    @Expose
    private List<Object> yellowCards = null;
    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("started")
    @Expose
    private Boolean started;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FootballFullState() {
    }

    /**
     * 
     * @param period
     * @param teams
     * @param awayTeam
     * @param finished
     * @param started
     * @param redCards
     * @param possibles
     * @param gameTimeInSeconds
     * @param corners
     * @param startDateTime
     * @param homeTeam
     * @param yellowCards
     * @param goals
     */
    public FootballFullState(String homeTeam, String awayTeam, Boolean finished, Integer gameTimeInSeconds, List<Goal> goals, String period, List<Object> possibles, List<Object> corners, List<Object> redCards, List<Object> yellowCards, String startDateTime, Boolean started, List<Team> teams) {
        super();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.finished = finished;
        this.gameTimeInSeconds = gameTimeInSeconds;
        this.goals = goals;
        this.period = period;
        this.possibles = possibles;
        this.corners = corners;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
        this.startDateTime = startDateTime;
        this.started = started;
        this.teams = teams;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Integer getGameTimeInSeconds() {
        return gameTimeInSeconds;
    }

    public void setGameTimeInSeconds(Integer gameTimeInSeconds) {
        this.gameTimeInSeconds = gameTimeInSeconds;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Object> getPossibles() {
        return possibles;
    }

    public void setPossibles(List<Object> possibles) {
        this.possibles = possibles;
    }

    public List<Object> getCorners() {
        return corners;
    }

    public void setCorners(List<Object> corners) {
        this.corners = corners;
    }

    public List<Object> getRedCards() {
        return redCards;
    }

    public void setRedCards(List<Object> redCards) {
        this.redCards = redCards;
    }

    public List<Object> getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(List<Object> yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "FootballFullState{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", finished=" + finished +
                ", gameTimeInSeconds=" + gameTimeInSeconds +
                ", goals=" + goals +
                ", period='" + period + '\'' +
                ", possibles=" + possibles +
                ", corners=" + corners +
                ", redCards=" + redCards +
                ", yellowCards=" + yellowCards +
                ", startDateTime='" + startDateTime + '\'' +
                ", started=" + started +
                ", teams=" + teams +
                '}';
    }
}
