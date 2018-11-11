package lv.javaguru.java2.db.jdbc;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;
import org.springframework.stereotype.Component;

//import lv.javaguru.java2.db.jdbc.JDBCRepository;
//import lv.javaguru.java2.db.AffairRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AffairRepositoryImpl
            extends JDBCRepository
            implements AffairRepository {

        @Override
        public void addAffair(Affair affair) {
            Connection connection = null;
            try {
                connection = getConnection();
                String sql = "insert into AFFAIRS(id, title, description) values(default, ?, ?)";
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, affair.getTitle());
                preparedStatement.setString(2, affair.getDescription());

                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()){
                    affair.setId(rs.getLong(1));
                }
            } catch (Throwable e) {
                System.out.println("Exception while execute AffairDAOImpl.addAffair()");
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                closeConnection(connection);
            }
        }

        @Override
        public Optional<Affair> findAffairByTitle(String title) {
            Connection connection = null;

            try {
                connection = getConnection();
                String sql = "select * from AFFAIRS where title = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, title);
                ResultSet resultSet = preparedStatement.executeQuery();
                Affair affair = null;
                if (resultSet.next()) {
                    affair = new Affair();
                    affair.setId(resultSet.getLong("id"));
                    affair.setTitle(resultSet.getString("title"));
                    affair.setDescription(resultSet.getString("description"));
                }
                return Optional.ofNullable(affair);
            } catch (Throwable e) {
                System.out.println("Exception while execute AffairDAOImpl.findByTitle()");
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                closeConnection(connection);
            }
        }

        @Override
        public boolean removeAffair(Affair affair) {
            Connection connection = null;
            try {
                connection = getConnection();
                String sql = "delete from AFFAIRS where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, affair.getId());
                int numOfRowsDeleted = preparedStatement.executeUpdate();
                return numOfRowsDeleted == 1;
            } catch (Throwable e) {
                System.out.println("Exception while execute AffairDAOImpl.remove()");
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                closeConnection(connection);
            }
        }

        @Override
        public List<Affair> getAllAffairs() {
            List<Affair> affairs = new ArrayList<>();
            Connection connection = null;
            try {
                connection = getConnection();
                String sql = "select * from AFFAIRS";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Affair affair = new Affair();
                    affair.setId(resultSet.getLong("id"));
                    affair.setTitle(resultSet.getString("title"));
                    affair.setDescription(resultSet.getString("description"));
                    affairs.add(affair);
                }
            } catch (Throwable e) {
                System.out.println("Exception while getting customer list AffairDAOImpl.getAll()");
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                closeConnection(connection);
            }
            return affairs;
        }
}
