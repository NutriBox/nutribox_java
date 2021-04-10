/**
 * 
 */
package br.com.nutribox.nbx.services;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.entity.Endereco;
import br.com.nutribox.nbx.entity.Especialidade;
import br.com.nutribox.nbx.entity.Menu;
import br.com.nutribox.nbx.entity.Nutricionista;
import br.com.nutribox.nbx.entity.Pessoa;
import br.com.nutribox.nbx.entity.Role;
import br.com.nutribox.nbx.entity.SubMenu;
import br.com.nutribox.nbx.entity.Telefone;
import br.com.nutribox.nbx.entity.TipoPessoa;
import br.com.nutribox.nbx.entity.User;
import br.com.nutribox.nbx.entity.enums.ERole;
import br.com.nutribox.nbx.repositories.EnderecoRepository;
import br.com.nutribox.nbx.repositories.EspecialidadeRespository;
import br.com.nutribox.nbx.repositories.MenuRepository;
import br.com.nutribox.nbx.repositories.NutricionistaRepository;
import br.com.nutribox.nbx.repositories.PessoaRepository;
import br.com.nutribox.nbx.repositories.RoleRepository;
import br.com.nutribox.nbx.repositories.SubMenuRepositories;
import br.com.nutribox.nbx.repositories.TelefoneRepository;
import br.com.nutribox.nbx.repositories.TipoPessoaRepository;
import br.com.nutribox.nbx.repositories.UserRepository;

/**
 * @author edy
 *
 */

@Service
public class DBService implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private RoleRepository roleRepository ;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private EspecialidadeRespository especialidadeRespository; 
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private SubMenuRepositories subMenuRepositories;
	
	public void instantiateTestDatabase() {
		
		/* Inicia os usuários */
		
				Role r1 = new Role(1, ERole.ROLE_USER);
				Role r2 = new Role(2, ERole.ROLE_MODERATOR);
		        Role r3 = new Role(3, ERole.ROLE_ADMIN);
				roleRepository.saveAll(Arrays.asList(r1,r2,r3));
				
			 	User u1 = new User("edymlima", "edymlima@gmail.com", encoder.encode("sempre12"));
			 	User u2 = new User("edsonlima", "edsonlima@gmail.com.br", encoder.encode("sempre12"));
			 	User u3 = new User("chicolima", "chicolima@gmail.com.br", encoder.encode("sempre12"));
			 	User u4 = new User("arianelima", "arianelima@gmail.com.br", encoder.encode("sempre12"));
			 	
			 	userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));	
			 	
			 	u1.getRoles().add(r3);
			 	u2.getRoles().add(r2);	
			 	u3.getRoles().add(r3);	
			 	u4.getRoles().add(r3);	
			 	
			 	userRepository.saveAll(Arrays.asList(u1,u2, u3, u4));
	 	
	 	/* Fim dos usuários */
		
		 	

		/* menu */
			 	Menu menuConf = new Menu(null, "Configuracao", "", "fa fa-wrench",true);
			 	Menu menuAdm = new Menu(null, "Administrativo", "", "fa fa-tachometer", true);
			 	Menu menuPaciente= new Menu(null, "Paciente", "", "fa fa-user", true);
			 	Menu menuAgenda = new Menu(null, "Agenda", "", "fa fa-calendar", true);	
	 			menuRepository.saveAll(Arrays.asList(menuConf, menuAdm, menuPaciente, menuAgenda));
	    /* Fim menu */

		/* SubMenu */
			 	SubMenu subMenuEspecialidade = new SubMenu(null, "Especialidade", "/home/especialidade", "fa fa-angellist", true, menuConf);
			 	SubMenu subMenuDashboard = new SubMenu(null, "Dashboard", "/home/dashboard", "fa fa-angellist", true, menuConf);
			 	subMenuRepositories.saveAll(Arrays.asList(subMenuDashboard,subMenuEspecialidade));
		/* fim SubMenu*/
			 	
		TipoPessoa tp1 = new TipoPessoa(null, "Pessoa Física");
		TipoPessoa tp2 = new TipoPessoa(null, "Pessoa Jurídica");
	 	
		Pessoa p1 = new Pessoa(null,"Edilberto", "72346914134", Instant.parse("2019-08-03T10:50:17.717Z"),tp1,u1);		
		Pessoa p2 = new Pessoa(null,"Edson",     "72346914134", Instant.parse("2019-08-03T10:50:17.717Z"),tp1,u2);
		Pessoa p3 = new Pessoa(null,"Francisco", "72346914134", Instant.parse("2019-08-03T10:50:17.717Z"),tp2,u3);
		Pessoa p4 = new Pessoa(null,"Ariante",   "72346914134", Instant.parse("2019-08-03T10:50:17.717Z"),tp2,u4);

		
	    Especialidade es1 = new Especialidade(null,"Nutrição clínica");
		Especialidade es2 = new Especialidade(null,"Indústria de alimentos.");
		Especialidade es3 = new Especialidade(null,"Nutrição esportiva.");
		Especialidade es4 = new Especialidade(null,"Saúde coletiva.");
		Especialidade es5 = new Especialidade(null,"Carreira acadêmica.");
		Especialidade es6 = new Especialidade(null,"Gastronomia.");
		Especialidade es7 = new Especialidade(null,"Marketing em alimentação.");
		Especialidade es8 = new Especialidade(null,"Consultoria nutricional.");
		
		Nutricionista n1 = new Nutricionista(null,123, p1);
		Nutricionista n2 = new Nutricionista(null,123, p2);
		Nutricionista n3 = new Nutricionista(null,123, p3);
		Nutricionista n4 = new Nutricionista(null,123 ,p4);
		
		n1.getEspecialidade().addAll(Arrays.asList(es1,es2,es3,es4,es5,es6,es7,es8));
		n2.getEspecialidade().addAll(Arrays.asList(es2));
		n3.getEspecialidade().addAll(Arrays.asList(es2));
		n4.getEspecialidade().addAll(Arrays.asList(es2));
		
		
		Telefone fone1 = new Telefone(null, "061", "995899884",p1);
		Telefone fone2 = new Telefone(null, "061", "992641492",p2);
			
		
		Endereco end1 = new 
				Endereco(		
						null, 
						"Rua 14 Lote 4", 
						"Polo de modas", 
						"Teste", 
						"Brasilia", 
						"df",
						123, 
						123, 
						(short) 061, 
						123,
						p1
						) ;
		
		tipoPessoaRepository.saveAll(Arrays.asList(tp1,tp2));		
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3 ,p4));
		
		especialidadeRespository.saveAll(Arrays.asList(es1,es2,es3,es4,es5,es6,es7,es8));

		nutricionistaRepository.saveAll(Arrays.asList(n1,n2, n3, n4));
		
		telefoneRepository.saveAll(Arrays.asList(fone1, fone2));
		
		enderecoRepository.saveAll(Arrays.asList(end1));
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
}