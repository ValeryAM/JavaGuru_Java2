package lv.javaguru.java2.services;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;

public class AddAffairService {

    private AffairRepository database;

    public AddAffairService(AffairRepository database) {
        this.database = database;
    }

    public void add(String title, String description) {
        Affair affair = new Affair();
        affair.setTitle(title);
        affair.setDescription(description);
//        affair.setAffairDeadline(deadline);
//        affair.setAffairStatus(status);

        database.addAffair(affair);
    }
}
