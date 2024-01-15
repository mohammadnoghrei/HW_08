package utility;

import connection.Jdbcconnection;
import repository.UserReposority;

import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION ;
    private static final UserReposority USER_REPOSORITY;

    static {
        CONNECTION = Jdbcconnection.getConnection();
        USER_REPOSORITY = new UserReposority(CONNECTION);

    }
}
