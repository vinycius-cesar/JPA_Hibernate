package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	@Test
     public void testeHibernateUtil() {
    	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	UsuarioPessoa pessoa = new UsuarioPessoa();
    	
    	pessoa.setIdade(5);
    	pessoa.setLogin("teste2");
    	pessoa.setNome("Vinycius");
    	pessoa.setSenha("123");
    	pessoa.setSobrenome("Cesar");
    	pessoa.setEmail("vinycius-cesar@hotmail.com");
    	
    	daoGeneric.salvar(pessoa);
     }
	/*@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	UsuarioPessoa pessoa = new UsuarioPessoa();
    	pessoa.setId(2L);
    	
    	pessoa = daoGeneric.pesquisar(pessoa);
    	System.out.println(pessoa);
		
	}*/
	
	@Test
	public void testeBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	
    	
    	UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
    	System.out.println(pessoa);
		
	}
	
	
	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	
    	
    	UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
    	pessoa.setIdade(99);
    	pessoa.setNome("teste7");
    	
    	pessoa = daoGeneric.UpdateMerge(pessoa);
    	System.out.println(pessoa);
		
	}
	
	@Test
	public void testeDelete() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	
    	
    	UsuarioPessoa pessoa = daoGeneric.pesquisar(7L, UsuarioPessoa.class);
    	
   daoGeneric.deletarPorId(pessoa);
    	System.out.println(pessoa);
    	
		
	}
	
	
	@Test
	public void testeConsultar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
    	List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
    	for (UsuarioPessoa usuarioPessoa : list) {
    		System.out.println(usuarioPessoa);
    		System.out.println("--");
    	}
		
	}
	
	@Test
	public void testeQueryList() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
			
		}
		
	}
	
	@Test
	public void testeQueryListMaxResult() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		int teste = 1;
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().
				createQuery(" from UsuarioPessoa order by id")
				.setMaxResults(teste)
				.getResultList();
		
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
			
		}
		
	}
}
