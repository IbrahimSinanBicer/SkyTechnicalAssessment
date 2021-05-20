
package AutomationTestAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Team {

    @SerializedName("association")
    @Expose
    private String association;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("teamId")
    @Expose
    private String teamId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Team() {
    }

    /**
     * 
     * @param teamId
     * @param name
     * @param association
     */
    public Team(String association, String name, String teamId) {
        super();
        this.association = association;
        this.name = name;
        this.teamId = teamId;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "association='" + association + '\'' +
                ", name='" + name + '\'' +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
