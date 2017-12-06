package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;

public class UserConverter implements Converter<String, User>{

	@Autowired
	UserRepository userRepository;
	
	public User convert(String source) {
		User user = userRepository.findOne(Long.parseLong(source));
		return user;
	}
	
}
