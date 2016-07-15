package next.dao;

import core.jdbc.JdbcTemplate;
import next.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
	public void insert(User user) throws SQLException {
		new JdbcTemplate()
				.update("INSERT INTO USERS VALUES (?, ?, ?, ?)", pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });
	}

	public void update(User user) throws SQLException {
		new JdbcTemplate()
				.update("UPDATE USERS SET userid = ?,password=? , name = ?, email = ? WHERE userid = ?",
				pstmt -> {
                    pstmt.setString(1, user.getUserId());
                    pstmt.setString(2, user.getPassword());
                    pstmt.setString(3, user.getName());
                    pstmt.setString(4, user.getEmail());
                    pstmt.setString(5, user.getUserId());
                });
	}

	public List<User> findAll() throws SQLException {
		return new JdbcTemplate<User>().queryForList("SELECT userId, password, name, email FROM USERS",
				pstmt -> {},
				rs -> new User(
						rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email")));
	}

	public User findByUserId(String userId) throws SQLException {
		return new JdbcTemplate<User>().queryForObject("SELECT userId, password, name, email FROM USERS WHERE userid=?",
				pstmt -> pstmt.setString(1, userId),
				rs -> new User(
						rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email")));
	}
}
