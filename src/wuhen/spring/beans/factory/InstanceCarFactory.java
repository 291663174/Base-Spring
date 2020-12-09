package wuhen.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 *  实例工厂方法：实例工厂的方法，即现需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 */
public class InstanceCarFactory {

    private Map<String,Car> carMap = null;
    public InstanceCarFactory(){
        carMap = new HashMap<String, Car>();
        carMap.put("audi", new Car("audi",300000));
        carMap.put("ford", new Car("ford",400000));
    }

    public Car getCar(String brand){
        return carMap.get(brand);
    }

}
