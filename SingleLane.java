package assignment3.bridge;

import assignment3.car.Car;

public interface SingleLane {

    void enterBridgeFromOutside(Car car);
    void enterCity(Car car);
    void enterBridgeFromCity(Car car);
    void exitToOutside(Car car);
    void crossBridge(Car car);

}
