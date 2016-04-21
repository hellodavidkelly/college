package lab3.part4.src.factoryClasses;

import lab3.part4.src.gamePieces.DamageItem;
import lab3.part4.src.gamePieces.Vehicle;

public abstract class BattleGameAbstractFactory {
	
	public abstract DamageItem getDamageItem();

	public abstract Vehicle getBattleVehicle();
}
