package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
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
	/*
	 * @Test public void testeBuscar() { DaoGeneric<UsuarioPessoa> daoGeneric = new
	 * DaoGeneric<UsuarioPessoa>(); UsuarioPessoa pessoa = new UsuarioPessoa();
	 * pessoa.setId(2L);
	 * 
	 * pessoa = daoGeneric.pesquisar(pessoa); System.out.println(pessoa);
	 * 
	 * }
	 */

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
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa order by id")
				.setMaxResults(teste).getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {

			System.out.println(usuarioPessoa);

		}

	}

	@Test
	public void TesteQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager()
				.createQuery(" from UsuarioPessoa where nome = :nome or sobrenome = :sobrenome")
				.setParameter("nome", "Vinycius").setParameter("sobrenome", "Cesar").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from UsuarioPessoa u")
				.getSingleResult();

		System.out.println("Soma de todas as idades é = " + somaIdade);
	}

	@Test
	public void testeNameQuery1() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.FindAll")
				.getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}

	}

	@Test
	public void testeNameQuery2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.buscaPorNome").setParameter("nome", "Vinycius")
				.getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}

	}
	
	@Test
	public void testeGravaTelefone() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(4L, UsuarioPessoa.class);
		
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("casa");
		telefoneUser.setNumero("12344124");
		telefoneUser.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefoneUser);
	}
	
	@Test
	public void testeConsultaTelefone() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(4L, UsuarioPessoa.class);
		
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuarioPessoa().getNome());
			System.out.println("-----------------------------");
			
		}
	}
}
