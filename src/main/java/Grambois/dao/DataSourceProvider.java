package Grambois.dao;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceProvider {

    protected static MariaDbDataSource dataSource;


    public static DataSource getDataSource() throws SQLException {
        if (dataSource == null) {
            dataSource = new MariaDbDataSource();
            dataSource.setServerName("zpj83vpaccjer3ah.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("an5vxj92eupvl1fj");
            dataSource.setUser("gmm9prmz7xx2ng8i");
            dataSource.setPassword("w4j0wd4lyqu41lfq");
        }
        return dataSource;
    }

}
