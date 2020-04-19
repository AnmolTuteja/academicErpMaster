import org.iiitb.bean.*;
import org.iiitb.dao.DepartmentDao;
import org.iiitb.dao.EmployeeDao;
import org.iiitb.dao.OrganisationDao;
import org.iiitb.service.OrganisationService;
import org.iiitb.service.impl.OrganisationServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Test {
    public static void main( String[] argv){
        Employee employee = new Employee();
        employee.setUserName("anmol");
        employee.setPassword("123");

        Department department = new Department();
        department.setName("OutReach");
        department.getEmployees().add(employee);

        DepartmentDao departmentDao = new DepartmentDao();
        departmentDao.save(department);
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.save(employee);

        Organisation organisation = new Organisation();
        organisation.setName("ACMS");

        Offer offer = new Offer();
//        offer.setMinGrade(3.0);
        offer.setMaxIntake(10);

        Domain domain = new Domain();
        domain.setDiscipline("M.Tech");
        domain.setCode("MT");
        domain.setBranch("CSE");
        domain.setStudents(null);

        offer.getDomains().add(domain);

        organisation.setOffer(offer);

        OrganisationDao organisationDao = new OrganisationDao();
        organisationDao.save(organisation);


//        OrganisationService organisationService = new OrganisationServiceImpl();
//        List<Organisation> organisationList = organisationService.findAll();
//        System.out.println(organisationList.size());
//        System.out.println(organisationList.get(0).getName());
//        Iterator<Offer> offerIterator = organisationList.get(0).getOffers().iterator();
//        System.out.println(((Offer)offerIterator.next()).getMaxIntake());
    }
}
