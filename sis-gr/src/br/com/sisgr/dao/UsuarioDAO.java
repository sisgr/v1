package br.com.sisgr.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisgr.model.Usuario;

@Repository
public class UsuarioDAO {

	private SessionFactory factory;
	
	@Autowired
	public UsuarioDAO(SessionFactory factory){
		this.factory = factory;
	}
	
	@Transactional
	public boolean adicionar(Usuario usuario){
		factory.openSession().save(usuario);
		
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
	}
	
	@Transactional(readOnly=true)
	public boolean existeUsuario(Usuario usuario){
		Criteria cri = factory.openSession().createCriteria(Usuario.class);
		cri.add(Restrictions.ilike("email", usuario.getEmail()));
		Usuario us = (Usuario) cri.uniqueResult();
		
		if (us != null){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional(readOnly=true)
	public Usuario buscar(Usuario usuario){
		Criteria cri = factory.openSession().createCriteria(Usuario.class);
		cri.add(Restrictions.ilike("email", usuario.getEmail()));
		return (Usuario) cri.uniqueResult();
	}
	
}
