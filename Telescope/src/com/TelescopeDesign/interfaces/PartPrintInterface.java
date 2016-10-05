package com.TelescopeDesign.interfaces;

import java.awt.Point;
import com.TelescopeDesign.types.Reference;

abstract public interface PartPrintInterface {

	public abstract Point getPosition(Enum<?> rP);
	public abstract void setReference(Reference r);
	public abstract void setOrigin(Point p);
}
	