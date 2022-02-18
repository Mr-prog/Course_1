package People;

import Mechanism.AllTerrainVehicle;
import Mechanism.Condition;
import Things.BuildMaterials;

public interface Build {
    public double build(BuildMaterials buildMaterials);

    public AllTerrainVehicle addDevice(AllTerrainVehicle allTerrainVehicle, String name, Condition condition);
}
