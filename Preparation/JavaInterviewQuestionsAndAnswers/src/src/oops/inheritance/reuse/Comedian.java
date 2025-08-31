package src.oops.inheritance.reuse;

import src.basics.Actor;

//IS-A relationship. Comedian is-a Actor
public class Comedian extends Actor {
	public void performComedy() {
		System.out.println("Comedy");
	};

	public void act() {
	}
}
