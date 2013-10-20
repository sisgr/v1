package br.com.sisgr.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{
		
		String uri = request.getRequestURI();
		if(uri.endsWith("cadastro") || uri.endsWith("logar") || uri.endsWith("adicionaUsuario") || uri.endsWith("inicio")
				|| uri.endsWith("sucesso") || uri.endsWith("formLogin") || uri.contains("resources")) {
			return true;
		}
		if(request.getSession().getAttribute("usuarioLogado")!=null) {
			return true;
		} else {
			response.sendRedirect("formLogin");
			return false;
		}
		
	}
}
