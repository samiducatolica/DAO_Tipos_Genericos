package DaoFactory;
import Daos.ActorDao;
import Daos.IDao;


public class DaoFactory {
    public enum DaoType{
        ACTOR
    }

      public static IDao getDao(DaoType daoType){
        IDao dao = null;
        switch (daoType){
            case ACTOR :
                dao = new ActorDao();
                break;
        }
        return dao;
    }
}
