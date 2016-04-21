package lab3.part4.src.factoryClasses;

import javax.swing.ImageIcon;

import lab3.part4.src.gamePieces.Boat;
import lab3.part4.src.gamePieces.Car;
import lab3.part4.src.gamePieces.DamageItem;
import lab3.part4.src.gamePieces.RoadBlock;
import lab3.part4.src.gamePieces.SeaMine;
import lab3.part4.src.gamePieces.Submarine;
import lab3.part4.src.gamePieces.Tank;
import lab3.part4.src.gamePieces.Vehicle;

public class SeaGameConcreteFactory extends BattleGameAbstractFactory{

	public DamageItem getDamageItem() {
		SeaMine sm = new SeaMine();
		return sm;
	}

	public Vehicle getBattleVehicle() {
		int x = (int) Math.floor(Math.random()*2)+1;

		if(x==1){
			Vehicle bvBoat = new Boat();
			return bvBoat;
		}
		if(x==2){
			Vehicle bvSub = new Submarine();
			return bvSub;
		}
		return null;
	}
}
