public class EncapsulationExample {
    public static void main(String[] args) {
        try {
            Car car = getCar();
            System.out.printf("차 이름: %s\n", car.getCarName());
            System.out.printf("연비: %.2fL/h\n", car.getRealFuelEfficiency());
            System.out.println("정답입니다.");
        } catch (Exception e) {
            System.out.println("연비 조작이 확인되었습니다.");
            System.out.println("오답입니다.");
        }
    }

    private static abstract class Car {
        private final String carName = "Car Prototype";

        private double realFuelEfficiency = 7.5;

        public String getCarName() {
            return carName;
        }

        public double getRealFuelEfficiency() {
            return realFuelEfficiency;
        }

        public final void setRealFuelEfficiency(double realFuelEfficiency) throws Exception {

            if (realFuelEfficiency > this.realFuelEfficiency) {
                throw new Exception("연비 조작 불가.");
            }
            this.realFuelEfficiency = realFuelEfficiency;
        }
    }

    private static class PerformanceManipulation extends Car {
        {
            try {
                setRealFuelEfficiency(15.0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public String getCarName() {
            return "New Car";
        }
    }

    public static Car getCar() {
        return new PerformanceManipulation();
    }
}
