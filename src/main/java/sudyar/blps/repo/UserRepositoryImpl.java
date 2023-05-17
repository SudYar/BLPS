package sudyar.blps.repo;


import org.springframework.stereotype.Repository;
import sudyar.blps.entity.User;
import sudyar.blps.etc.Users;
import sudyar.blps.service.XMLUtil;

import java.nio.file.Path;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final XMLUtil xmlUtil;
    private final String xmlPath = "users.xml";
    Path path = Path.of(xmlPath).toAbsolutePath();

    public UserRepositoryImpl(XMLUtil xmlUtil) {
        this.xmlUtil = xmlUtil;
    }

    @Override
    public User findByLogin(String login) {
        Users users = (Users)xmlUtil.getEntity(Users.class, "userList", path.toUri());
        if (users==null || users.getUser()==null) return null;
        List<User> userEntities = users.getUser();
        for (User cur: userEntities) {
            if (cur.getLogin().equals(login)) return cur;
        }
        return null;
    }


    @Override
    public boolean existsByLogin(String login){
        Users users = (Users)xmlUtil.getEntity(Users.class, "userList", path.toUri());
        if (users==null || users.getUser()==null) return false;
        List<User> userEntities = users.getUser();
        for (User cur: userEntities) {
            if (cur.getLogin().equals(login)) return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        Users users = (Users)xmlUtil.getEntity(Users.class, "users",path.toUri());
        if (users==null) users = new Users();
        users.getUser().add(user);
        xmlUtil.saveEntity(users.getUser(), xmlPath);
    }
}
