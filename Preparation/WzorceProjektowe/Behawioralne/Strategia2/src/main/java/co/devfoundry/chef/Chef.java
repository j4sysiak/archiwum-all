package co.devfoundry.chef;

import co.devfoundry.chef.egg_cooker.EggCooker;

public class Chef {

    private EggCooker eggCooker;  // to możemy zapodać przez konstruktor lub w set jakiejś właściwości
    // lub jak tu w metodzie setEggCooker(...)

//    public Chef(EggCooker eggCooker) {
//        this.eggCooker = eggCooker;
//    }

    public void cook() {
        this.eggCooker.cookEgg();
    }

     public void setEggCooker(EggCooker eggCooker) {
         this.eggCooker = eggCooker;
     }

}
