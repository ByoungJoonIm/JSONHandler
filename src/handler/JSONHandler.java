package handler;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONObject;

public class JSONHandler {
	public <T> T getInstanceFromJson(JSONObject jsonObject, Class<T> classRepresent){
		Constructor<T> constructor = null;
		T classObject = null;
		
		try {
			constructor = classRepresent.getConstructor();
			classObject = constructor.newInstance();
			Field fields[] = classRepresent.getDeclaredFields();
			
			for(Field field : fields){
				field.setAccessible(true);
				String fieldName = field.getName();
				field.set(classObject, jsonObject.get(fieldName));
			}
		} catch(NoSuchMethodException e){
			System.out.println(e.getLocalizedMessage() + " : " + classRepresent.getName() + "의 default constructor가 없음");
			e.printStackTrace();
		} catch(InvocationTargetException e){
			e.printStackTrace();
		} catch(IllegalAccessException e){
			e.printStackTrace();
		} catch(InstantiationException e){
			e.printStackTrace();
		}
		
		return classObject;
	}
	
	public <T> JSONObject getJsonFromInstance(T object){
		JSONObject jsonObject = new JSONObject();
		
		Field fields[] = object.getClass().getDeclaredFields();
		
		try{
			for(Field field : fields){
				field.setAccessible(true);
				jsonObject.put(field.getName(), field.get(object));
			}
		} catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
