package utility;

import connection.Jdbcconnection;
import repository.*;
import service.*;

import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION;
    private static final UserReposority USER_REPOSORITY;
    private static final Userservice USERSERVICE;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final Brandrepository BRANDREPOSITORY;
    private static final Brandservice BRANDSERVICE;
    private static Shareholder_Brand_repository SHAREHOLDER_BRAND_REPOSITORY;
    private static final Shareholde_Brand_service SHAREHOLDE_BRAND_SERVICE;
    private static final CategoryReposority CATEGORY_REPOSORITY;
    private static final CategoryService CATEGORY_SERVICE;
    private static final Productrepository PRODUCTREPOSITORY;
    private static final Productservice PRODUCTSERVICE;

    static {
        CONNECTION = Jdbcconnection.getConnection();
        USER_REPOSORITY = new UserReposority(CONNECTION);
        USERSERVICE = new Userservice(USER_REPOSORITY);
        SHAREHOLDER_REPOSITORY = new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE = new ShareholderService(SHAREHOLDER_REPOSITORY, SHAREHOLDER_BRAND_REPOSITORY);
        BRANDREPOSITORY = new Brandrepository(CONNECTION);
        BRANDSERVICE = new Brandservice(BRANDREPOSITORY, SHAREHOLDER_BRAND_REPOSITORY);
        SHAREHOLDER_BRAND_REPOSITORY = new Shareholder_Brand_repository(CONNECTION);
        SHAREHOLDE_BRAND_SERVICE = new Shareholde_Brand_service(SHAREHOLDER_BRAND_REPOSITORY, SHAREHOLDER_REPOSITORY, BRANDREPOSITORY);
        CATEGORY_REPOSORITY = new CategoryReposority(CONNECTION);
        CATEGORY_SERVICE = new CategoryService(CATEGORY_REPOSORITY);
        PRODUCTREPOSITORY = new Productrepository(CONNECTION);
        PRODUCTSERVICE = new Productservice(PRODUCTREPOSITORY,CATEGORY_REPOSORITY,BRANDREPOSITORY);
    }

    public static Userservice getUserService() {
        return USERSERVICE;
    }

    public static ShareholderService getShareholderService() {
        return SHAREHOLDER_SERVICE;
    }

    public static Brandservice getBrandservice() {
        return BRANDSERVICE;
    }

    public static Shareholde_Brand_service getShareholdeBrandService() {
        return SHAREHOLDE_BRAND_SERVICE;
    }

    public static CategoryService getCategoryService() {
        return CATEGORY_SERVICE;
    }

    public static Productservice getProductservice() {
        return PRODUCTSERVICE;
    }
}
