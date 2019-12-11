package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CONTENT")
	private String questionContent;
	
	@Transient
	private List<Option> options;
	
	
	
	public Question() {
		this.options = new ArrayList<Option>();
	}
	
	
	
	
	public Question(Integer id, String questionContent) {
		this.id = id;
		this.questionContent = questionContent;
		this.options = new ArrayList<Option>();
	}




	public Question(String questionContent) {
		
		
		this.questionContent = questionContent;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


	/**
	 * @return the options
	 */
	public List<Option> getOptions() {
		return options;
	}


	/**
	 * @param options the options to set
	 */
	public void setOptions(List<Option> options) {
		this.options = options;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", questionContent=" + questionContent + ", options=" + options + "]";
	}


}
