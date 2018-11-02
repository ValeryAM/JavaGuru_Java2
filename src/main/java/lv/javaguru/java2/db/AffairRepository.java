package lv.javaguru.java2.db;

import lv.javaguru.java2.domain.Affair;

import java.util.List;
import java.util.Optional;

public interface AffairRepository {

    void addAffair(Affair affair);
    boolean removeAffair(Affair affair);

    Optional<Affair> findAffairByTitle(String title);

    List<Affair> getAllAffairs();
}
