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
public class UsuarioDAOHibernate {

	private SessionFactory factory;
	
	@Autowired
	public UsuarioDAOHibernate(SessionFactory factory){
		this.factory = factory;
	}
	
	@Transactional
	public void adicionar(Usuario usuario){
		factory.openSession().save(usuario);
	}
	
	@Transactional
	public void remover(Usuario usuario){
		Query query = factory.openSession().createQuery("delete usuario where id = :id");
		query.setParameter("id", usuario.getId());
		query.executeUpdate();
	}
	
	public Usuario buscar(Usuario usuario){
		Criteria cri = factory.openSession().createCriteria(Usuario.class);
		cri.add(Restrictions.ilike("login", usuario.getLogin()));
		return (Usuario) cri.uniqueResult();
	}
	
}
