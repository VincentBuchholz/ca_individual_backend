package facades;

import dtos.CarDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CarFacadeTest {
    private CarFacade carFacade = new CarFacade();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCarByNumberPlate() throws IOException {
        CarDTO carDTO;
        carDTO = carFacade.getCarByNumberPlate("al47267");
        assertEquals("FORD",carDTO.getMake());
        assertEquals("KA",carDTO.getModel());
        assertEquals("WF0UXXLTRUDG37985",carDTO.getVin());

    }
}