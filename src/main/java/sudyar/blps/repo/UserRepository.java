package sudyar.blps.repo;

import sudyar.blps.entity.User;

public interface UserRepository {
    User findByLogin(String login);
    boolean existsByLogin(String login);
    void save(User user);
}