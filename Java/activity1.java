package Activities;
import Activities.cars;
public class activity1 {

        public static void main(String[] args) {
            cars toyota = new cars();
            toyota.make = 2014;
            toyota.color = "Black";
            toyota.transmission = "Manual";

            //Using Car class method
            toyota.displayCharacterstics();
            toyota.accelerate();
            toyota.brake();
        }


}
