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
import enums.NivelAmbiente;
import enums.NivelBaba;
import model.Ambiente;
import model.Bebe;
import model.Recomendacion;
import utils.KnowledgeSessionHelper;

public class DiagnosticosPreliminaresTest {
	String K_SESSION_NAME = "kbackward-mibebe-session";
	
	KieSession sessionStatefull;
	static KieContainer kieContainer;
	
	public DiagnosticosPreliminaresTest() {}
	
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
	
	/*************** TEST BEBE CON HAMBRE ***************/
	@Test
	public void alimentarBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.AlimentarAlBebe;
		
		print("Caso de prueba: Alimentar al bebe.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setAlimentoIngerido(20);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE LASTIMADO ***************/
	@Test
	public void consolarBebeLastimadoTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.ConsolarAlBebe;
		
		print("Caso de prueba: Consolar al bebe por una lastimadura.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setZonaColorada(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE LASTIMADO ***************/
	@Test
	public void consolarBebeRasguniadoTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.ConsolarAlBebe;
		
		print("Caso de prueba: Consolar al bebe por un rasgunio.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setMarcaRoja(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE ABURRIDO ***************/
	@Test
	public void entretenerBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.DarAtencionAlBebe;
		
		print("Caso de prueba: Dar atencion al bebe aburrido.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setDesvelado(true);
		bebe.setNivelBaba(NivelBaba.Bajo);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE SUCIO ***************/
	@Test
	public void limpiarPisBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.CambiarPañalDelBebe;
		
		print("Caso de prueba: Cambiar el pañal a causa de pis.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setPañalHumedad(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE SUCIO ***************/
	@Test
	public void limpiarHecesBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.CambiarPañalDelBebe;
		
		print("Caso de prueba: Cambiar el pañal a causa de heces.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setPañalHeces(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE CON GASES ***************/
	@Test
	public void gasesBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.EjercitarPiernasDelBebe;
		
		print("Caso de prueba: Ejercitar las piernas del bebe a causa de gases.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setMovimientoIntensoPiernas(true);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE CON SUENIO ***************/
	@Test
	public void suenioBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.HacerDormirAlBebe;
		
		print("Caso de prueba: Hacer dormir al bebe.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setUltimaSiesta(170);
		
		Ambiente ambiente = new Ambiente();
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE CON CALOR ***************/
	@Test
	public void calorBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.SacarAbrigoDelBebe;
		
		print("Caso de prueba: Sacar abrigo del bebe.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setEstaCaliente(true);
		
		Ambiente ambiente = new Ambiente();
		ambiente.setNivel(NivelAmbiente.Caliente);
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
	/*************** TEST BEBE CON FRIO ***************/
	@Test
	public void frioBebeTest() {
		AccionRecomendada recomendacionEsperada = AccionRecomendada.PonerAbrigoAlBebe;
		
		print("Caso de prueba: Poner abrigo del bebe.");
		print();
		
		Bebe bebe = new Bebe();
		bebe.setEstaCaliente(false);
		
		Ambiente ambiente = new Ambiente();
		ambiente.setNivel(NivelAmbiente.Frio);
		
		print(bebe, ambiente);
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		Recomendacion recomendacion = bebe.getRecomendacion();
		assertResults(recomendacion, recomendacionEsperada);
	}
}
