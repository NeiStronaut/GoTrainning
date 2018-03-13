package multithreading;
import java.lang.reflect.Constructor;

public class ThreadSafeSingletonObjectEnum {
		
		// Hiding constructor
		private ThreadSafeSingletonObjectEnum() {}
		
		
		//OPTION B: Reflection safe	
		public enum Enum {

			INSTANCE;
			volatile ThreadSafeSingletonObjectEnum it;
			
			//Not lazy
			Enum() {
				synchronized(this) {
					it = new ThreadSafeSingletonObjectEnum();
				}
			}
			ThreadSafeSingletonObjectEnum getIt() {
				return it;
			}
		}
		
		
		public synchronized static ThreadSafeSingletonObjectEnum getInstanceEnum() {
			return Enum.INSTANCE.getIt();
		}
		
		
		@SuppressWarnings("unchecked")
		public static void testReflectionEnum() {

			ThreadSafeSingletonObjectEnum instanceOne = ThreadSafeSingletonObjectEnum.getInstanceEnum();
			ThreadSafeSingletonObjectEnum instanceTwo = null;
			
	        try {
	            Constructor<ThreadSafeSingletonObjectEnum>[] constructors = (Constructor<ThreadSafeSingletonObjectEnum>[]) ThreadSafeSingletonObjectEnum.class.getDeclaredConstructors();
	            for (Constructor<ThreadSafeSingletonObjectEnum> constructor : constructors) {
	                //Below code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (ThreadSafeSingletonObjectEnum) constructor.newInstance();
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
			
			testReflectionEnum();
	    }


	}
