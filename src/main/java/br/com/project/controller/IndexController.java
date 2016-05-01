package br.com.project.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.include("variable", "f1_champions");
	}
       @Path("/register/")
        public void user() {
        result.include("variable", "Este Bem-vindo ao cadastro é dinâmico!!");
        result.forwardTo("/WEB-INF/jsp/user.jsp"); 
    }
}