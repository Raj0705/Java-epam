package com.epam.rd.autotasks.house;


import com.epam.rd.autotasks.residents.cats.Cat;
import com.epam.rd.autotasks.residents.cats.Kitten;
import com.epam.rd.autotasks.residents.dogs.Dog;
import com.epam.rd.autotasks.residents.dogs.Puppy;
//Please, use generics to change House class in order to dogs cannot enter cats' house and cats cannot enter dogs' house.
//
//You need to alter residents field and enter methods of the House class.
//
//Note that if you have done everything right, then two particular lines in the Main class may prevent successful compilation,
//so you may need to remove them. See details in the Main class.

public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("Rax");
        Puppy randy = new Puppy("Randy");
        Cat barbos = new Cat("Barbos");
        Kitten murzik = new Kitten("Murzik");

        House<Dog> dogHouse = new House();
        dogHouse.enter(rex);
        dogHouse.enter(randy);
        // dogHouse.enter(murzik); //This must fail on compilation stage if you parameterize the dogHouse. Delete the line when solution is ready
        System.out.println(dogHouse);

        House<Cat> catHouse = new House();
        catHouse.enter(barbos);
        catHouse.enter(murzik);
        //    catHouse.enter(rex); //This must fail on compilation stage if you parameterize the catHouse. Delete the line when solution is ready
        System.out.println(catHouse);
    }
}