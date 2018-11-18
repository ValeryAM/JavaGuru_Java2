package lv.javaguru.java2.services;

import lv.javaguru.java2.db.jdbc.AffairRepositoryImpl;
import lv.javaguru.java2.domain.Affair;

public class AffairRepositoryMock extends AffairRepositoryImpl {

    private boolean isAffairSaved = false;

    @Override
    public void save(Affair affair) {
        isAffairSaved = true;
    }

    public boolean isAffairSaved() {
        return isAffairSaved;
    }
}
