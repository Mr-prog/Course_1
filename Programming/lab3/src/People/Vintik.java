package People;

import Mechanism.AllTerrainVehicle;
import Mechanism.Condition;
import Things.BuildMaterials;

public class Vintik extends Human implements Build{
    int buildAbility = 20;
    public Vintik(String name) {
        super(name);
    }


    @Override
    public double build(BuildMaterials buildMaterials) {
        System.out.println(getName() + " положил " + buildMaterials.getName());
        return buildMaterials.getSize();
    }

    @Override
    public AllTerrainVehicle addDevice(AllTerrainVehicle allTerrainVehicle, String name, Condition condition) {
        allTerrainVehicle.addDevices(name, condition);
        return allTerrainVehicle;
    }
}
