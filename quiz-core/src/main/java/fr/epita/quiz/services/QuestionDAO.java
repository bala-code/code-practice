package fr.epita.quiz.services;
	

import java.util.ArrayList;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Option;
import fr.epita.quiz.datamodel.Question;

@Repository
public class QuestionDAO extends DAO<Question>{

	@Override
	protected String getQueryString() {
		return "from Question q where q.questionContent like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String,Object> map, Question question) {
		map.put("pContent", "%" + question.getQuestionContent() + "%");
		
	}
	
	@Transactional
	@Override
	public Question createReturn(Question q) {
		q.setOptions(new ArrayList<Option>());
		Question question = em.merge(q);
		return question;
	}

}
