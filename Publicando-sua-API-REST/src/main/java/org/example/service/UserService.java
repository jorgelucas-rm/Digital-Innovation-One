package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> findById(UUID id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> createUser(UserTO user) {
        User newUser = null;
        newUser.setNome(user.getNome());
        userRepository.save(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(UUID id, UserTO user) {
        User updateUser = userRepository.findById(id).orElse(null);

        if (updateUser == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        updateUser.setId(id);
        updateUser.setNome(user.getNome());

        userRepository.save(updateUser);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    public ResponseEntity deleteUser(UUID id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }

}
