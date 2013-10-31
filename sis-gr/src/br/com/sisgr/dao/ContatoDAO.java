package br.com.sisgr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisgr.model.Contato;

@Service("contatoDAO")
public class ContatoDAO {

	private SessionFactory factory;

	@Autowired
	public ContatoDAO(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Autowired
	private Contato contato;

	@Transactional
	public void adicionar(Contato contato) {
		factory.close();
		factory.openSession().saveOrUpdate(contato);
		factory.close();
	}

	@Transactional
	public void remover(Integer id) {
		Query query = factory.openSession().createQuery(
				"Delete From Contato Where id = " + id);
		query.executeUpdate();
		factory.close();
	}

	@Transactional(readOnly = true)
	public Contato buscarPorId(Integer id) {
		Query query = factory.openSession().createQuery(
				"From Contato where id = " + id);
		Contato contato = (Contato) query.uniqueResult();
		factory.close();
		return contato;
	}

	@Transactional(readOnly = true)
	public Contato buscarPorNome(Contato contato) {
		Criteria cri = factory.openSession().createCriteria(Contato.class);
		cri.add(Restrictions.ilike("nome", contato.getNome()));
		Contato contato2 = (Contato) cri.uniqueResult();
		factory.close();
		return contato2;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Contato> listarContatos(Integer id) {
		Query query = factory.openSession().createQuery(
				"From Contato where usuarioId = " + id);
		List<Contato> contatos = query.list();
		
		factory.close();
		
		return contatos;
	}

	@Transactional
	public void editar(Contato contato) {
		Query q = factory.openSession().createQuery("UPDATE Contato c SET c.nome = :nomeAlterado, "
				+ "c.sobrenome = :sobrenomeAlterado, "
				+ "c.email = :emailAlterado "
				+ "WHERE c.id = :idVelho");  
	    q.setString("nomeAlterado", contato.getNome());
	    q.setString("sobrenomeAlterado", contato.getSobrenome());
	    q.setString("emailAlterado", contato.getEmail());
	    q.setInteger("idVelho", contato.getId());  
	    q.executeUpdate();
	    factory.close();
	}
}
