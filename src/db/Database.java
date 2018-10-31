package db;

import domain.Affair;
import domain.AffairStatus;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addAffair(Affair affair);
    boolean removeAffair(Affair affair);

    Optional<Affair> findAffairByTitle(String title);

    List<Affair> getAllAffairs();
}
