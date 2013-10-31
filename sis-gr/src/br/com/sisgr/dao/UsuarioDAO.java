package br.com.sisgr.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisgr.model.Usuario;

@Service("usuarioService")
public class UsuarioDAO {

	private SessionFactory factory;

	@Autowired
	public UsuarioDAO(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Transactional
	public boolean adicionar(Usuario usuario){
		factory.openSession().save(usuario);
		factory.close();
		
		if (existeUsuario(usuario) != false){
			return true;
		}else{
			return false;
		}	
	}
	
	@Transactional
	public void remover(Usuario usuario){
		Query query = factory.openSession().createQuery("delete usuario where id = :id");
		query.setParameter("id", usuario.getId());
		query.executeUpdate();
		factory.close();
	}
	
	@Transactional(readOnly=true)
	public boolean existeUsuario(Usuario usuario){
		Criteria cri = factory.openSession().createCriteria(Usuario.class);
		cri.add(Restrictions.ilike("email", usuario.getEmail()));
		cri.add(Restrictions.ilike("senha",usuario.getSenha()));
		Usuario us = (Usuario) cri.uniqueResult();
		factory.close();
		if (us != null){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional(readOnly=true)
	public Usuario buscarById(Integer id){
		Query query = factory.openSession().createQuery(
				"From Usuario where id = " + id);
		Usuario usuario = (Usuario) query.uniqueResult();
		factory.close();
		return usuario;
	}
	
	@Transactional(readOnly=true)
	public Usuario buscarByEmail(Usuario usuario){
		Criteria cri = factory.openSession().createCriteria(Usuario.class);
		cri.add(Restrictions.ilike("email", usuario.getEmail()));
		Usuario usuario2 = (Usuario) cri.uniqueResult();
		factory.close();
		return usuario2;
	}
	
	@Transactional
	public void editar(Usuario usuario) {
		Query q = factory.openSession().createQuery("UPDATE Usuario u SET u.nome = :nomeAlterado, "
				+ "u.sobrenome = :sobrenomeAlterado, "
				+ "u.email = :emailAlterado "
				+ "WHERE u.id = :idVelho");  
	    q.setString("nomeAlterado", usuario.getNome());
	    q.setString("sobrenomeAlterado", usuario.getSobrenome());
	    q.setString("emailAlterado", usuario.getEmail());
	    q.setInteger("idVelho", usuario.getId());  
	    q.executeUpdate();
	    factory.close();
	}
}
