package com.pocStore.demoStore.DataService;

import com.pocStore.demoStore.Entity.User;
import com.pocStore.demoStore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDataService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers (){
        return userRepository.findAll();
    }
    public Optional<User> findbyID(Long id){
        return userRepository.findById(id);
    }
    public void saveUser(User user){ userRepository.save(user);}
}
