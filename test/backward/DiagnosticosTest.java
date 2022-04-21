package backward;

import static utils.TestCaseUtils.assertResults;
import static utils.TestCaseUtils.print;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

import enums.AccionRecomendada;
import enums.NivelBaba;
import model.Ambiente;
import model.Bebe;
import model.Recomendacion;
import utils.KnowledgeSessionHelper;

public class DiagnosticosTest {
	String K_SESSION_NAME = "kbackward-mibebe-session";
	
	KieSession sessionStatefull;
	static KieContainer kieContainer;
	
	public DiagnosticosTest() {}
	
	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
        
		Agenda agenda = sessionStatefull.getAgenda();

		agenda.getAgendaGroup("Recomendacion al llanto del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de afecciones").setFocus();
		agenda.getAgendaGroup("Diagnostico de colicos").setFocus();
		agenda.getAgendaGroup("Diagnostico de dientes creciendo").setFocus();
		agenda.getAgendaGroup("Diagnostico de frio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de calor del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de suenio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de suenio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de gases").setFocus();
		agenda.getAgendaGroup("Diagnostico de suciedad en el panial").setFocus();
		agenda.getAgendaGroup("Diagnostico nivel de aburrimiento del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de lesiones en el cuerpo").setFocus();
		agenda.getAgendaGroup("Diagnostico de Hambre").setFocus();
	}
	
	@Before
	public void setUp() {
		print("---------- Start ----------");
		print();
		this.prepareKnowledgeSession();
	}

	@After
	public void tearDown() {
		print();
		print("---------- End ----------");
		print();
	}
	
	/*************** TEST BEBE CON COLICOS ***************/
	@Test
	public void colicosBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.ConsultarPediatra;
		
		print("Caso de prueba: Consultat con un pediatra a causa de colicos.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setMalaReaccionTacto(true);
		bebe.setConErupciones(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE CON AFECCION ***************/
	@Test
	public void afeccionBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.ConsultarPediatra;
		
		print("Caso de prueba: Consultat con un pediatra a causa de una afeccion.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setEstaCaliente(true);
		bebe.setTempCorporal(39);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST SALIENDO DIENTES DEL BEBE ***************/
	@Test
	public void saliendoDientesBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.FrotarYenfriarEncias;
		
		print("Caso de prueba: Frotar y enfriar encias del bebe.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setDesvelado(true);
		bebe.setNivelBaba(NivelBaba.Alto);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
}
