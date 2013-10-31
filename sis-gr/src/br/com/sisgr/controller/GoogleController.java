package br.com.sisgr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sisgr.dao.UsuarioDAO;
import br.com.sisgr.model.GoogleOauthHelper;
import br.com.sisgr.model.Usuario;

@Controller
public class GoogleController 
{

    private GoogleOauthHelper helper = new GoogleOauthHelper(); 
	
    private UsuarioDAO dao;
    private Usuario usuario;
    
    
    @Autowired
    public GoogleController(UsuarioDAO usuarioDao)
    {
    	this.usuario = new Usuario();
    	this.dao = usuarioDao;
    }
    
    
    /**
     * Método responsável por capturar o login do usuário através do protocolo OAUTH e persistir 
     * o usuário no banco de dados da aplicação.
     * @param code
     * @param state
     * @return String
     * @throws IOException
     */
    @RequestMapping("/google")
    public String home(HttpSession session,
                                    HttpServletRequest request,
                                             HttpServletResponse response) throws IOException
    {       
    	
         if((request.getParameter("code") == null) ||
                   (request.getParameter("state") == null))
         {
             response.sendRedirect(helper.buildLoginUrl());
             
             session.setAttribute("state", helper.getStateToken());   
         } 
         
         
         else if((request.getParameter("code") != null) ||
                    (request.getParameter("state") != null) && 
                        (request.getParameter("state").equals(session.getAttribute("state"))))
         {
             session.removeAttribute("state");
             
             JSONObject jObj = new JSONObject(helper.
            		 getUsuarioInfoJson(request.getParameter("code")));
         
            /**
             * Fazendo o set do objeto Usuario, com os dados da conta do google 
             */
            usuario.setNome(jObj.getString("given_name"));
            usuario.setSobrenome(jObj.getString("family_name"));
            usuario.setEmail(jObj.getString("email"));
            usuario.setSenha("senha"); 
            
            System.out.println("nome" + usuario.getNome() + " email: " + usuario.getEmail());
            
            /**
             * Verificando se o usuário existe no banco, caso exista faz o login. 
             * Caso não exista cadastra o usuário no banco e libera o acesso.
             */
            if (dao.existeUsuario(usuario) != false)
            {
            	usuario = dao.buscarByEmail(usuario);
            	session.setAttribute("usuarioLogado", usuario);
            }else 
            {
            	dao.adicionar(usuario);
            	session.setAttribute("usuarioLogado", usuario);
            }
        }
        
         return "agenda/agenda";
    }
}
