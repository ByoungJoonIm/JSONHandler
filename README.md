# JSONHandler
- java로 작성된 json parser + 역변환
  - json object -> class
  - class -> jsonObject
  - class의 구조와 상관없이 변환 가능
    - default constructor 필수
    - class의 field 이름과 json의 key이름이 동일해야함
    - class에서 배열 필드를 가지는 경우 ArrayList를 사용해야함

## 사용법
- maven dependency 추가
- JSONHandler 생성
  ```java
  JSONHandler jsonHandler = new JSONHandler();
  ```
- json object -> class로 변환
  ```java
  OuterClass changedClass = (OuterClass) jsonHandler.getInstanceFromJson(jsonObject, OuterClass.class);
  ```
- class -> json object로 변환
  ```java
  JSONObject jsonObject = jsonHandler.getJsonFromInstance(outerClassInstance);
  ```
  
## 예제
- 소스
  ```java
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
  ```
- 출력
  ```
  [변형 전의 인스턴스 상태]
  TempClass [intField=10, booleanField=true, doubleField=3.14, charField=a, stringField=hello world!, arrayField=[InnerClass [val1=1, val2=일], InnerClass [val1=2, val2=이], InnerClass [val1=3, val2=삼], InnerClass [val1=4, val2=사]]]
  [json 형태로 변환 후]
  {"doubleField":3.14,"arrayField":[{"val2":"일","val1":1},{"val2":"이","val1":2},{"val2":"삼","val1":3},{"val2":"사","val1":4}],"charField":"a","booleanField":true,"intField":10,"stringField":"hello world!"}
  [다시 인스턴스 상태로 변경]
  TempClass [intField=10, booleanField=true, doubleField=3.14, charField=a, stringField=hello world!, arrayField=[InnerClass [val1=1, val2=일], InnerClass [val1=2, val2=이], InnerClass [val1=3, val2=삼], InnerClass [val1=4, val2=사]]]
  [기존 인스턴스와 변형된 인스턴스(instance -> json -> instance)의 결과물이 같은지 비교]
  true
  ```
