package core.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wymstar on 7/14/16.
 */
public interface RowMapper {
    Object mapRow(ResultSet rs) throws SQLException;
}
