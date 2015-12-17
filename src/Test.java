
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
public class Test {

	@org.junit.Test
	public void test() {
		Configuration cfg=new Configuration().configure("classpath:spring-hibernate.xml");
		SchemaExport sExport=new SchemaExport(cfg);
		sExport.create(true,true);
		
	}

}
