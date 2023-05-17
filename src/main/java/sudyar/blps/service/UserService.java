package sudyar.blps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudyar.blps.entity.User;
import sudyar.blps.repo.UserRepositoryImpl;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean exitsUserLogin(String login){
        return userRepository.existsByLogin(login);
    }
}
