package core.jdbc;

import next.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wymstar on 7/14/16.
 */
public class JdbcTemplate<T> {


    public void update (String query, PreparedStatementSetter setter) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(query);
            setter.setParameters(pstmt);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<T> queryForList(String query, PreparedStatementSetter setter, RowMapper mapper) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(query);
            setter.setParameters(pstmt);

            rs = pstmt.executeQuery();

            List<T> list = new ArrayList<>();
            while (rs.next()) {
                list.add((T) mapper.mapRow(rs));
            }

            return list;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public T queryForObject(String query, PreparedStatementSetter setter, RowMapper mapper) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(query);
            setter.setParameters(pstmt);

            rs = pstmt.executeQuery();

            T obj = null;
            if (rs.next()) {
                obj = (T)mapper.mapRow(rs);
            }

            return obj;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
