
package AutomationTestAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Goal {

    @SerializedName("clockTime")
    @Expose
    private Integer clockTime;
    @SerializedName("confirmed")
    @Expose
    private Boolean confirmed;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ownGoal")
    @Expose
    private Boolean ownGoal;
    @SerializedName("penalty")
    @Expose
    private Boolean penalty;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("playerId")
    @Expose
    private Integer playerId;
    @SerializedName("teamId")
    @Expose
    private String teamId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Goal() {
    }

    /**
     * 
     * @param period
     * @param penalty
     * @param teamId
     * @param id
     * @param confirmed
     * @param ownGoal
     * @param clockTime
     * @param playerId
     */
    public Goal(Integer clockTime, Boolean confirmed, Integer id, Boolean ownGoal, Boolean penalty, String period, Integer playerId, String teamId) {
        super();
        this.clockTime = clockTime;
        this.confirmed = confirmed;
        this.id = id;
        this.ownGoal = ownGoal;
        this.penalty = penalty;
        this.period = period;
        this.playerId = playerId;
        this.teamId = teamId;
    }

    public Integer getClockTime() {
        return clockTime;
    }

    public void setClockTime(Integer clockTime) {
        this.clockTime = clockTime;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(Boolean ownGoal) {
        this.ownGoal = ownGoal;
    }

    public Boolean getPenalty() {
        return penalty;
    }

    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "clockTime=" + clockTime +
                ", confirmed=" + confirmed +
                ", id=" + id +
                ", ownGoal=" + ownGoal +
                ", penalty=" + penalty +
                ", period='" + period + '\'' +
                ", playerId=" + playerId +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
