package pl.coderslab.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class WordGroupConverter implements Converter<String, WordGroup>{

	@Autowired
	private WordGroupDao wordGroupDao;
	
	public WordGroup convert(String source) {
		WordGroup wordGroup = wordGroupDao.findById(Long.parseLong(source));
		return wordGroup;
	}
	
}
