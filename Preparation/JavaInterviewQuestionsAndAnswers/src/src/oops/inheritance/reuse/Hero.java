package src.oops.inheritance.reuse;

import src.basics.Actor;

//IS-A relationship. Hero is-a Actor
public class Hero extends Actor {
	public void fight() {
		System.out.println("fight");
	};
}
