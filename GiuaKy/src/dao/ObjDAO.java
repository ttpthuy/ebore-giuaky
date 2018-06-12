package dao;

import java.util.*;

public abstract class ObjDAO {
	public abstract void	 add(Object obj ) ;
	public abstract void	 edit(Object obj, String id ) ;
	public abstract void	 delete(Object obj ) ;
	public abstract  List<Object> show() ;
}
