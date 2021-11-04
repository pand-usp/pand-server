package br.usp.each.pand.service;

import br.usp.each.pand.model.User;
import br.usp.each.pand.repository.UserRepository;

import javax.inject.Inject;
import java.util.Optional;

public class UserService {
    UserRepository users;

    @Inject
    public UserService(UserRepository users) {
        this.users = users;
    }

    public void register(User user) {
        users.insertUser(user);
    }

    public Optional<User> login(String username, String password){
        Optional<User> maybeUser = users.findUser(username);

        if (maybeUser.isPresent() && (maybeUser.get().password).equals(password)){
            return maybeUser;
        }
        return Optional.empty();
    }
}
