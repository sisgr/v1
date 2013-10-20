package br.com.sisgr.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisgr.model.Reuniao;

@Repository
public class ReuniaoDAO {

	private SessionFactory factory;
	
	@Autowired
	public ReuniaoDAO (SessionFactory sessionFactory){
		this.factory = sessionFactory;
	}
	
	@Transactional
	public void adicionar(Reuniao reuniao){
		factory.openSession().save(reuniao);
	}
	
	@Transactional
	public void remover(Reuniao reuniao){
		Query query = factory.openSession().createQuery("delete reuniao where id = :id");
		query.setParameter("id", reuniao.getId());
		query.executeUpdate();
	}
	
	@Transactional(readOnly = true)
	public Reuniao buscarPorId(Reuniao reuniao){
		Criteria cri = factory.openSession().createCriteria(Reuniao.class);
		cri.add(Restrictions.ilike("id", reuniao.getId()));
		return (Reuniao) cri.uniqueResult();
	}
	
	@Transactional(readOnly = true)
	public Reuniao buscarPorNome(Reuniao reuniao){
		Criteria cri = factory.openSession().createCriteria(Reuniao.class);
		cri.add(Restrictions.ilike("login", reuniao.getNome()));
		return (Reuniao) cri.uniqueResult();
	}
	
}
