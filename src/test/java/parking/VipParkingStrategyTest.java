package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class VipParkingStrategyTest {

	@Test
    public void testPark_givenAVipCarAndAFullParkingLot_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 4, Write a test case on VipParkingStrategy.park()
	    * With using Mockito spy, verify and doReturn */
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        parkingLot.getParkedCars().add(new Car("normalCar"));
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);
        Car vipCar = new Car("vipCar");
        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(true).when(spyVipParkingStrategy).isAllowOverPark(vipCar);
        Receipt receipt = spyVipParkingStrategy.park(parkingLots, vipCar);

        Assert.assertEquals("vipCar", receipt.getCarName());
        Assert.assertEquals("lot1", receipt.getParkingLotName());
    }

    @Test
    public void testPark_givenCarIsNotVipAndAFullParkingLot_thenGiveNoSpaceReceipt() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        parkingLot.getParkedCars().add(new Car("normalCar"));
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);
        Car car = new Car("car");
        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(false).when(spyVipParkingStrategy).isAllowOverPark(car);
        Receipt receipt = spyVipParkingStrategy.park(parkingLots, car);

        Assert.assertEquals("car", receipt.getCarName());
        Assert.assertEquals("No Parking Lot", receipt.getParkingLotName());
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
        Car car = new Car("carA");
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);

        CarDaoImpl carDao = mock(CarDaoImpl.class);
        when(carDao.isVip("carA")).thenReturn(true);

        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(carDao).when(spyVipParkingStrategy).getCarDao();

        boolean allowOverPark = spyVipParkingStrategy.isAllowOverPark(car);

        assertTrue(allowOverPark);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
        Car car = new Car("car");
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);

        CarDaoImpl carDao = mock(CarDaoImpl.class);
        when(carDao.isVip("car")).thenReturn(true);

        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(carDao).when(spyVipParkingStrategy).getCarDao();

        boolean allowOverPark = spyVipParkingStrategy.isAllowOverPark(car);

        assertFalse(allowOverPark);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse(){
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
        Car car = new Car("carA");
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);

        CarDaoImpl carDao = mock(CarDaoImpl.class);
        when(carDao.isVip("carA")).thenReturn(false);

        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(carDao).when(spyVipParkingStrategy).getCarDao();

        boolean allowOverPark = spyVipParkingStrategy.isAllowOverPark(car);

        assertFalse(allowOverPark);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
        Car car = new Car("car");
        ParkingLot parkingLot = new ParkingLot("lot1", 1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);

        CarDaoImpl carDao = mock(CarDaoImpl.class);
        when(carDao.isVip("car")).thenReturn(false);

        VipParkingStrategy spyVipParkingStrategy = spy(new VipParkingStrategy());
        doReturn(carDao).when(spyVipParkingStrategy).getCarDao();

        boolean allowOverPark = spyVipParkingStrategy.isAllowOverPark(car);

        assertFalse(allowOverPark);
    }

    private Car createMockCar(String carName) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(carName);
        return car;
    }
}
