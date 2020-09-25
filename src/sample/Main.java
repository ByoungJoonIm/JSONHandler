package sample;
import java.util.ArrayList;

import org.json.JSONObject;

import handler.JSONHandler;

public class Main {
	public static void main(String args[]){
		JSONHandler jsonHandler = new JSONHandler();
		
		ArrayList<InnerClass> innerClassList = new ArrayList<InnerClass>();
		
		innerClassList.add(new InnerClass(1, "일"));
		innerClassList.add(new InnerClass(2, "이"));
		innerClassList.add(new InnerClass(3, "삼"));
		innerClassList.add(new InnerClass(4, "사"));
		
		OuterClass outerClass = new OuterClass();
		outerClass.setArrayField(innerClassList);
		outerClass.setBooleanField(true);
		outerClass.setCharField('a');
		outerClass.setDoubleField(3.14);
		outerClass.setIntField(10);
		outerClass.setStringField("hello world!");
		
		System.out.println("[변형 전의 인스턴스 상태]");
		System.out.println(outerClass);
		
		JSONObject jsonObject = jsonHandler.getJsonFromInstance(outerClass);
		System.out.println("[json 형태로 변환 후]");
		System.out.println(jsonObject);
		
		OuterClass changedClass = (OuterClass) jsonHandler.getInstanceFromJson(jsonObject, OuterClass.class);
		System.out.println("[다시 인스턴스 상태로 변경]");
		System.out.println(changedClass);
		
		System.out.println("[기존 인스턴스와 변형된 인스턴스(instance -> json -> instance)의 결과물이 같은지 비교]");
		System.out.println(outerClass.equals(changedClass));
	}
}
