package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

 public abstract class DataObject{
 public abstract Hashtable<String,Double> getData();
 public abstract ArrayList<String> getHeader();
}
