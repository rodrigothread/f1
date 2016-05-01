package br.com.project.controller;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.project.dao.TbPilotoDAO;
import br.com.project.model.TbPiloto;
import br.com.project.dao.TbConstrutoresDAO;
import br.com.project.model.TbConstrutores;



@Controller
public class PilotoController {

    private final Result result;
    private final TbPilotoDAO tbPilotoDAO;
    private final TbConstrutoresDAO tbConstrutoresDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected PilotoController() {
        this(null,null,null);  
    }

    @Inject
    public PilotoController(Result result,TbPilotoDAO tbPilotoDAO,TbConstrutoresDAO tbConstrutoresDAO) {
        this.result = result;
        this.tbPilotoDAO= tbPilotoDAO;
        this.tbConstrutoresDAO=tbConstrutoresDAO;
    }
    
    @Path("/register/piloto/list/")
    public void pilotolist(){
        result.include("lista", tbPilotoDAO.listAll());
        result.forwardTo("/WEB-INF/jsp/register/piloto/pilotolist.jsp"); 
    }

    @Path("/register/piloto/create/")
    public void pilotocreate() {
         result.include("lista", tbConstrutoresDAO.listAll());
        result.forwardTo("/WEB-INF/jsp/register/piloto/pilotocreate.jsp"); 
    }
    
    @Post("/register/piloto/persist/")
    public void pilotopersist(TbPiloto tbPiloto) {
        try {
            tbPilotoDAO.insert(tbPiloto);
            result.include("success", "Registro incluído com sucesso.");
        } catch (Exception ex) {
            result.include("error", "Ocorreu um erro e os dados não foram salvos.");
        }
        result.redirectTo(this).pilotocreate();
    }  
    
    @Post("/register/piloto/update/")
    public void pilotoupdate(int idPiloto) {
        result.include("tbPiloto", tbPilotoDAO.getByID(idPiloto));
        result.forwardTo("/WEB-INF/jsp/register/piloto/pilotoupdate.jsp"); 
    }
    
    @Put("/register/piloto/marge/{tbPiloto.idPiloto}")
    public void pilotomarge(TbPiloto tbPiloto) {
        try {
            tbPilotoDAO.edit(tbPiloto);
            result.include("success", "Registro editado com sucesso.");
        } catch (Exception ex) {
            result.include("error", "Ocorreu um erro e os dados não foram salvos.");
        }
        result.redirectTo(this).pilotolist();
    }
    
    @Delete("/register/piloto/remove/")
    public void pilotoremove(int idPiloto) {
        try {
            tbPilotoDAO.delete(idPiloto);
            result.include("success", "Registro excluído com sucesso.");
        } catch (Exception ex) {
            result.include("error", "Ocorreu um erro ao remover os dados.");
        }
        result.redirectTo(this).pilotolist(); 
    }
       
}