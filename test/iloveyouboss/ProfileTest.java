package iloveyouboss;

import static org.junit.Assert.*;

import org.junit.*;

public class ProfileTest {
	
	public ProfileTest() {
		System.out.println("constructed : profileTest");
	}
	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@beforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("@afterClass");
	}
	
	@Before
	public void create() {
		System.out.println("@before");
		profile = new Profile("Bull Hockey, Inc.");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();
	}
	
	@After
	public void after() {
		System.out.println("@after");
	}

   @Test
   public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
      profile.add(new Answer(question, Bool.FALSE));
      criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
      
      boolean matches = profile.matches(criteria);
      
      assertFalse(matches);
   }
   
   @Test
   public void matchAnswersTrueForAnyDontCareCriteria() {
	  profile.add(new Answer(question, Bool.FALSE));
	  criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
	  
	  boolean matches = profile.matches(criteria);
	  
	  assertTrue(matches);
   }
}
