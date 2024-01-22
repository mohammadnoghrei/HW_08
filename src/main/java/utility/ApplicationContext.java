package utility;

import connection.Jdbcconnection;
import repository.Brandrepository;
import repository.ShareholderRepository;
import repository.UserReposority;
import service.Brandservice;
import service.ShareholderService;
import service.Userservice;

import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION ;
    private static final UserReposority USER_REPOSORITY;
    private static final Userservice USERSERVICE;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final Brandrepository BRANDREPOSITORY;
    private static final Brandservice BRANDSERVICE;
    static {
        CONNECTION = Jdbcconnection.getConnection();
        USER_REPOSORITY = new UserReposority(CONNECTION);
        USERSERVICE = new Userservice(USER_REPOSORITY);
        SHAREHOLDER_REPOSITORY = new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE =new ShareholderService(SHAREHOLDER_REPOSITORY);
        BRANDREPOSITORY =new Brandrepository(CONNECTION);
        BRANDSERVICE=new Brandservice(BRANDREPOSITORY);
    }
    public static Userservice getUserService(){
        return USERSERVICE;
    }
public static ShareholderService getShareholderService(){return SHAREHOLDER_SERVICE;}
    public static Brandservice getBrandservice(){return BRANDSERVICE;}

}
