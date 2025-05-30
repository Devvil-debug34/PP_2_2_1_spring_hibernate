package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {

        carDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listcars() {
        return carDao.listCars();
    }

    @Transactional
    @Override
    public void deleteCars() {

        carDao.deleteCar();
    }

}
