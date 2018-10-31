package domain;

public class Affair {

    private String affairTitle;
    private String affairDescription;
    private String affairDeadline;
    private AffairStatus affairStatus;
/*
    public domain.Affair(String affairTitle, String affairDescription, String affairDeadline) {
        this.affairTitle = affairTitle;
        this.affairDescription = affairDescription;
        this.affairDeadline = affairDeadline;
        this.affairStatus = domain.AffairStatus.NOT_STARTED;
    }
*/
    public void setAffairTitle(String affairTitle) {
        this.affairTitle = affairTitle;
    }

    public void setAffairDescription(String affairDescription) {
        this.affairDescription = affairDescription;
    }

    public void setAffairDeadline(String affairDeadline) {
        this.affairDeadline = affairDeadline;
    }

    public void setAffairStatus(AffairStatus affairStatus) {
        this.affairStatus = affairStatus;
    }

    public String getAffairTitle() {
        return affairTitle;
    }

    public String getAffairDescription() {
        return affairDescription;
    }

    public String getAffairDeadline() {
        return affairDeadline;
    }

    public AffairStatus getAffairStatus() {
        return affairStatus;
    }

    @Override
    public String toString() {
        String result;
        result = "Title: " + affairTitle +
                    "\t Description: " + affairDescription +
                    "\t Execution date: " + affairDeadline +
                    "\t Status: " + affairStatus;
        return result;
    }
}
