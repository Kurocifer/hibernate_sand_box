import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class SimInterceptor extends EmptyInterceptor {
	private int updates;
	private int creates;
	private int loads;

	// Called before an object is deleted
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNapubmes, Type[] types) {
		// blah blah
	}

	// Called when hibernate detects that an object is dirty (i.e has been changed) during a flush i.e update operation
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		if (entity instanceof Employee) {
			System.out.println("Update Operation");
			return true;
		}

		return false;
	}

	// Called before an object is initialized
	public boolean onLoad(Object entity, Serializable id,
      		Object[] state, String[] propertyNames, Type[] types) {
		// blah blah
		return true;
   }
   
   // Called before an object is saved
   public boolean onSave(Object entity, Serializable id,
      Object[] state, String[] propertyNames, Type[] types) {
         if ( entity instanceof Employee ) {
            System.out.println("Create Operation");
            return true; 
         }
         return false;
   }
   
   //called before commit into database
   public void preFlush(Iterator iterator) {
      System.out.println("preFlush");
   }
   
   //called after committed into database
   public void postFlush(Iterator iterator) {
      System.out.println("postFlush");
   }
}

