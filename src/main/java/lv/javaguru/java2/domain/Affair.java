package lv.javaguru.java2.domain;

public class Affair {

    private Long id;
    private String title;
    private String description;
//    private String affairDeadline;
//    private AffairStatus affairStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    /*
    public void setAffairDeadline(String affairDeadline) {
        this.affairDeadline = affairDeadline;
    }

    public void setAffairStatus(AffairStatus affairStatus) {
        this.affairStatus = affairStatus;
    }

    public String getAffairDeadline() {
        return affairDeadline;
    }

    public AffairStatus getAffairStatus() {
        return affairStatus;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Affair affair = (Affair) o;

        if (id != null ? !id.equals(affair.id) : affair.id != null) return false;
        if (title != null ? !title.equals(affair.title) : affair.title != null) return false;
        return description != null ? description.equals(affair.description) : affair.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "Affair { " + "id= " + id + " Title: " + title +
                    " Description: " + description
//                + " Execution date: " + affairDeadline + " Status: " + affairStatus
                    ;
    }
}
