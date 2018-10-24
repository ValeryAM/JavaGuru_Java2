import java.util.Date;

public class Affair {

    private String affairName;
    private String affairDescription;
    private String affairDeadline;
    private AffairStatus affairStatus;

    public Affair(String affairName, String affairDescription, String affairDeadline) {
        this.affairName = affairName;
        this.affairDescription = affairDescription;
        this.affairDeadline = affairDeadline;
        this.affairStatus = AffairStatus.НЕ_НАЧАТА;
    }

    public void setAffairName(String affairName) {
        this.affairName = affairName;
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

    public String getAffairName() {
        return affairName;
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
        if (affairDescription.length() > 70) {
            result = "Название: " + "\u001B[32m" + affairName + "\u001B[0m" +
                    "\t Описание: " + "\u001B[32m" + affairDescription.substring(0,69) + "..." + "\u001B[0m" +
                    "\t Дата выполнения: " + "\u001B[32m" + affairDeadline + "\u001B[0m" +
                    "\t Статус: " + "\u001B[32m" + affairStatus + "\u001B[0m";
        } else {
            result = "Название: " + "\u001B[32m" + affairName + "\u001B[0m" +
                    "\t Описание: " + "\u001B[32m" + affairDescription + "\u001B[0m" +
                    "\t Дата выполнения: " + "\u001B[32m" + affairDeadline + "\u001B[0m" +
                    "\t Статус: " + "\u001B[32m" + affairStatus + "\u001B[0m";
        }
        return result;
    }
}
