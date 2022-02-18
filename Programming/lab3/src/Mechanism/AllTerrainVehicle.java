package Mechanism;

import Mechanism.*;

public class AllTerrainVehicle extends Mechanisms implements Drive {
    String PlaceState = "Rocket special container";
    public Wheels wheels = new Wheels();
    private Mechanisms[] container = new Mechanisms[0];
    Drawing drawing = new Drawing("Чертеж родота: pxx2");
    public AllTerrainVehicle(String name, Condition condition) {
        super(name, condition);
    }

    public void addDevices(String name, Condition condition) {
        class Devise extends Mechanisms {
            Devise(String name, Condition condition) {
                super(name, condition);
            }
        }
        Devise device = new Devise(name, condition);
        Mechanisms[] arr = new Mechanisms[container.length + 1];
        System.arraycopy(container, 0, arr, 0, container.length);
        arr[arr.length - 1] = device;
        setContainer(arr);
        getInfo.getInfo();
    }


    public static class Drawing {
        private final String drawing;

        Drawing(String drawing) {
            this.drawing = drawing;
        }

        public void printDrawing() {
            System.out.println(drawing);
        }
    }

    public class Wheels {
        WheelsSate wheels;

        public void changeWheels(WheelsSate wheels) {
            this.wheels = wheels;
            System.out.println("Теперь колеса " + getName() + wheels.name());
        }
    }

    GetInfo getInfo = new GetInfo() {
        @Override
        public void getInfo() {
            System.out.println(getName() + ": предметы загруженные в машину: " + printContainer(container));
        }
    };

    public void setContainer(Mechanisms[] container) {
        this.container = container;
    }

    public String printContainer(Mechanisms[] container) {
        StringBuilder inf = new StringBuilder();
        for (Mechanisms mechanisms : container) {
            inf.append(mechanisms.getName()).append(" ");
        }
        return inf.toString();
    }

    public void setPlaceState(String placeState) {
        PlaceState = placeState;
    }
}