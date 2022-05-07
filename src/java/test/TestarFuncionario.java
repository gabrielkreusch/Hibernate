package test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Funcionario;
import utils.JpaUtil;

public class TestarFuncionario {

	public static void main(String args[]) {
		// conexão
		EntityManager manager = JpaUtil.getEntityManager();
		
		// inclusão de dados
		System.out.println("INCLUINDO");
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Funcionario f = new Funcionario();
                f.setNome("Gabriel");
                f.setSalario(BigDecimal.valueOf(2000));
                f.setCargo("Desenvolvedor");
		manager.persist(f);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}