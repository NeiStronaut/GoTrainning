package multithreading;

import java.lang.reflect.Constructor;

public class ThreadSafeSingletonObject {
	
	// Hiding constructor
	private ThreadSafeSingletonObject() {}
	
	
	//OPTION A: Non reflection safe
	private volatile static ThreadSafeSingletonObject it = null;
	
	public synchronized static ThreadSafeSingletonObject getInstance() {
		if(it == null) {
			it = new ThreadSafeSingletonObject();
		}
		return it;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void testReflection() {

		ThreadSafeSingletonObject instanceOne = ThreadSafeSingletonObject.getInstance();
		ThreadSafeSingletonObject instanceTwo = null;
		
        try {
            Constructor<ThreadSafeSingletonObject>[] constructors = (Constructor<ThreadSafeSingletonObject>[]) ThreadSafeSingletonObject.class.getDeclaredConstructors();
            for (Constructor<ThreadSafeSingletonObject> constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (ThreadSafeSingletonObject) constructor.newInstance();
                break;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
	}
	
	
	public static void main(String[] args) {
		testReflection();
    }


}
