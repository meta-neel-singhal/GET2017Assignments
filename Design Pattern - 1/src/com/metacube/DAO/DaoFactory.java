package com.metacube.DAO;

/**
 *
 * @author Neel Singhal
 */
public class DaoFactory {
    private static BaseDao dao;
    private DaoFactory(){
        
    }
    public static <T extends BaseDao> T getDaoInstance(String name){
        if(dao==null){
            synchronized(DaoFactory.class){
                if(dao==null){
                    switch(name){
                        case "MY_SQL":
                            dao = new MySqlDao();
                            break;
                        case "In_Memory":
                            dao = new InMemoryDao();
                            break;
                        case "File":
                            dao = new FileDao();
                            break;
                    }
                }
            }
        }
        return (T)dao;
    }
}
