package pl.coderslab.dao;

import pl.coderslab.model.Solution;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {

    private static final String CREATE_QUERY = "INSERT INTO solution (created, updated, description, " +
            "exercise_id, users_id) VALUES (? ,? ,? ,? ,? )";
    private static final String READ_QUERY = "SELECT * FROM solution WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE solution SET created = ?, updated = ?, description = ?, " +
            "exercise_id = ?, users_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM solution";
    private static final String FIND_ALL_BY_USER_ID = "SELECT * FROM solution WHERE users_id = ?";
    private static final String FIND_ALL_BY_EXERCISE_ID = "SELECT * FROM solution WHERE exercise_id = ? ORDER BY created DESC";
    private static final String FIND_RECENT = "SELECT * FROM solution ORDER BY CREATED DESC LIMIT ?";

    public Solution create(Solution solution) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, solution.getCreated());
            statement.setTimestamp(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                solution.setId(rs.getInt("id"));
            }
            return solution;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Solution read(int id) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getTimestamp("created"));
                solution.setUpdated(rs.getTimestamp("updated"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));
                return solution;
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void update(Solution solution) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setTimestamp(1, solution.getCreated());
            statement.setTimestamp(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());
            statement.setInt(6, solution.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Solution> findAll() {
        try (Connection conn = DBUtil.createConnection()) {
            List<Solution> solutionList = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getTimestamp("created"));
                solution.setUpdated(rs.getTimestamp("updated"));
                solution.setDescription(rs.getString("description"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));
                solutionList.add(solution);
            }
            return solutionList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllByUserId(int id) {
        try (Connection conn = DBUtil.createConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_USER_ID)) {
            List<Solution> solutionList = new ArrayList<>();
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getTimestamp("created"));
                solution.setUpdated(rs.getTimestamp("updated"));
                solution.setDescription(rs.getString("description"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));
                solutionList.add(solution);
            }
            return solutionList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllByExerciseId(int id) {
        try (Connection conn = DBUtil.createConnection();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_EXERCISE_ID)) {
            List<Solution> solutionList = new ArrayList<>();
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Solution solution = new Solution();
                solution.setId(rs.getInt("id"));
                solution.setCreated(rs.getTimestamp("created"));
                solution.setUpdated(rs.getTimestamp("updated"));
                solution.setDescription(rs.getString("description"));
                solution.setExercise_id(rs.getInt("exercise_id"));
                solution.setUsers_id(rs.getInt("users_id"));
                solutionList.add(solution);
            }
            return solutionList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Solution> findRecent(int n) {
        try (Connection connection = DBUtil.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_RECENT)) {
            List<Solution> solutionList = new ArrayList<>();

            preparedStatement.setInt(1, n);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                solutionList.add(solution);
            }
            resultSet.close();
            return solutionList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
