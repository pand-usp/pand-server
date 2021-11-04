package br.usp.each.pand.repository;

import br.usp.each.pand.model.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.List;
import java.util.Optional;

public class UserRepository implements PanacheMongoRepository<User> {
    public void insertUser(User user) {
        this.persist(user);
    }

    public Optional<User> findUser(String username) {
        return Optional.ofNullable(this.find("username", username).firstResult());
    }


}
