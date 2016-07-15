package core.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wymstar on 7/14/16.
 */
public interface PreparedStatementSetter {
    void setParameters(PreparedStatement pstmt) throws SQLException;
}
