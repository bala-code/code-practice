package fr.epita.quiz.services;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Option;

@Repository
public class optionsDAO extends DAO<Option> {

	@Override
	protected String getQueryString() {
		// TODO Auto-generated method stub
		return  "from Option a where a.optionContent like :pCont";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Option t) {
		// TODO Auto-generated method stub
		map.put("pCont", "%" + t.getOptionContent() + "%");
		
	}
	
		
}


