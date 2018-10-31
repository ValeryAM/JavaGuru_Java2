package services;

import db.Database;
import domain.Affair;
import domain.AffairStatus;

public class AddAffairService {

    private Database database;

    public AddAffairService(Database database) {
        this.database = database;
    }

    public void add(String title, String description, String deadline, AffairStatus status) {
        Affair affair = new Affair();
        affair.setAffairTitle(title);
        affair.setAffairDescription(description);
        affair.setAffairDeadline(deadline);
        affair.setAffairStatus(status);

        database.addAffair(affair);
    }
}
