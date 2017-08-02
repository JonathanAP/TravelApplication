package fi.hh.finalproject.domain;

import org.springframework.data.repository.CrudRepository;

import fi.hh.finalproject.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
