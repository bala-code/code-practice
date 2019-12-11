/**
 * 
 */
package fr.epita.quiz.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;


import java.net.URI;
import java.net.URISyntaxException;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;



import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Option;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.services.optionsDAO;


/**
 * @author BALA
 *
 */
@Path("/questions/")
public class QuestionResource {
	
	@Inject
	QuestionDAO qdao;
	@Inject
	optionsDAO odao;
	
	private static final Logger LOGGER =LogManager.getLogger(QuestionResource.class);
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		
		LOGGER.debug("entering => createQuestion() with parameters: {} ",question);
		qdao.create(question); // will show the question
		LOGGER.info("received creation order for question: {}", question);
		return Response.created(new URI("questions/"+String.valueOf(question.getId()))).build();	
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionAndOptions(@RequestBody Question question) throws URISyntaxException { 
		
		LOGGER.debug("entering => createQuestion() with parameters: {} ",question);
		Question q = qdao.createReturn(question);
		//question.getOptions().stream().forEach(q-> q.getOption());
		System.out.println(q.toString());
		for (Option op : question.getOptions()) {
			op.setQuestion(qdao.getById(q.getId(), Question.class));
			odao.update(op);
		}
		qdao.create(question); // will show the question
		LOGGER.info("received creation order for question: {}", question);
		return Response.created(new URI("questions/"+String.valueOf(question.getId()))).build();	
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		
		Question question = qdao.getById(id, Question.class);
		return Response.ok(question).build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent")  String questionContent) {
		
		List<Question> searchList = qdao.search(new Question(questionContent));
		return Response.ok(searchList).build();
	
	}
	
	@DELETE
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@QueryParam("id") Integer id) throws URISyntaxException {
		System.out.println("Testing Delete");
		Question question = new Question();
		question.setId(id);
		qdao.delete(question.getId(),Question.class); 
		return Response.ok().build();
		
	}
	
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestion(@RequestBody Question question) throws URISyntaxException {
		
		//System.out.println(question.toString()); // got error,so to find the error used system...
		LOGGER.debug("entering => updateQuestion() with parameters: {} ",question);
		qdao.update(question); // will show the question
		LOGGER.info("the question is updated: {}", question);
		return Response.created(new URI("questions/"+String.valueOf(question.getId()))).build();
		
	}
	
	@POST
	@Path("/mcq")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createoptions(@RequestBody Option opt) throws URISyntaxException {
		
		Option option = new Option();
		
		optionsDAO optiondao = new optionsDAO();
		optiondao.create(option); // will show the question
		
		LOGGER.info("received creation order for question: {}", opt);
		
		return Response.created(new URI("questions/"+String.valueOf(opt.getId()))).build();
		
	}
	
}
