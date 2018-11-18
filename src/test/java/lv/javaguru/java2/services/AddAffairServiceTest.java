package lv.javaguru.java2.services;

import lv.javaguru.java2.services.add.AddAffairService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// @RunWith(MockitoJUnitRunner.class)
public class AddAffairServiceTest {

    //@Mock
    private AffairRepositoryMock repositoryMock = new AffairRepositoryMock();

    //@InjectMocks
    private AddAffairService service;

    @Before
    public void init() {
        repositoryMock = new AffairRepositoryMock();
//        service = new AddAffairService(repositoryMock);
    }

    @Test
    public void test() {
        assertFalse(repositoryMock.isAffairSaved());
//        service.addAffair("title", "description");
        assertTrue(repositoryMock.isAffairSaved());
    }
}
