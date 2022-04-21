package facades;

import com.google.gson.Gson;
import dtos.CarDTO;
import utils.HttpUtils;

import java.io.IOException;


public class CarFacade {

    public CarDTO getCarByNumberPlate(String numberPlate) throws IOException {
        Gson gson = new Gson();
        String car = HttpUtils.fetchData("https://v1.motorapi.dk/vehicles/"+numberPlate);


        CarDTO carDTO = gson.fromJson(car, CarDTO.class);

        return carDTO;

    }
}
