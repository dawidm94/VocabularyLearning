package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entities.WordGroup;
import pl.coderslab.repositories.WordGroupRepository;

public class WordGroupConverter implements Converter<String, WordGroup>{

	@Autowired
	WordGroupRepository wordGroupRepository;
	
	public WordGroup convert(String source) {
		WordGroup wordGroup = wordGroupRepository.findOne(Long.parseLong(source));
		return wordGroup;
	}
	
}
