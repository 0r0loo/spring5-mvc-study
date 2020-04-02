# 0.스프링 MVC 세팅

## Spring Web MVC

- Spring Web MVC는 서블릿 API를 기반으로 만들어진 웹 프레임 워크 이다.
- Spring MVC에는 웹 애플리케이션 개발을 위한 다양한 라이브러리가 포함되어있다. 이를 통해 반복적인 작업을 상당히 줄이고 프로젝트 수행의 생산성 및 유지 보수성을 높힐 수 있다.

## 개발 방식

- Spring MVC 개발 방식은 SpringFramework와 동일 하게 XML을 이용한 방법과 자바 어노테이션을 이용하는 방법이 있다.

## MVC 개념

- MVC(Model-View-Controller)는 소프트웨어 엔지니어링에서 사용자 인터페이스와 애플리케이션 로직을 분리하는데 사용되는 패턴이다.
- MVC 패턴에는 세개의 레이어가 있다.
- Model : 애플리케이션의 비즈니스 계층을 정의한다.
- Controller : 애플리케이션의 흐름을 관리한다.
- View : 애플리케이션의 프리젠테이션 계층을 정의한다.
- Model은 Java 클래스로 구성된다.
- Controller는 서블릿으로 구성된다.
- View는 JSP 페이지로 구성된다.

## Model

- 시스템의 비즈니스 로직을 포함하고 애플리케이션의 상태를 나타내는 데이터 계층이다.
- 프리젠테이션 레이어와 무관하며 컨트롤러는 모델 레이어에서 데이터를 가져와서 뷰 레이어로 보낸다.

## Controller

- Controller 계층은 View와 Model 간의 인터페이스 역할을 한다. View 계층에서 요청을 받고 필요한 유효성 검사를 포함하여 요청을 처리한다.
- 요청은 데이터 처리를 위해 모델 계층으로 추가 전송되고, 일단 처리 되면 데이터는 컨트롤러로 다시 전송 된 다음 View에 표시된다.

## View

- 이 계층은 일반적으로 UI 형식의 응용 프로그램 출력을 나타낸다. 프리젠테이션 레이어는 컨트롤러가 가져온 모델 데이터를 표시하는데 사용된다.

## 동작방식

![스프링mvc주요구성요소및처리흐름](https://user-images.githubusercontent.com/49504411/78194901-4befcd00-74b9-11ea-9dd3-76d0febc7ad0.png)
<<<<<<< HEAD
=======

>>>>>>> cf31b3487455d6407a4a3367ad640d2faa29196c

## DispatcherServlet

- Servlet/JSP에서 사용자 요청이 발생하면 이 요청 정보를 해석하고 개발자가 만든 코드를 동작시키는 첫 번째 서블릿이다.
- Spring MVC는 DispatcherServlet을 확대하여 Spring Framework가 가지고 있는 기능을 사용할 수 있도록 이 클래스를 재정의하고 있다.
- Spring MVC 프로젝트 설정에서 가장 먼저 해야하는 DispatcherServlet 클래스를 Spring MVC에서 재정의한 클래스로 설정하는 일이다.

## 설정 방식

- Spring MVC 프로젝트를 설정하는 방식은 XML을 이용하는 방법과 Java 코드를 활용하는 방법이 있다.

## pom.xml

- 라이브러리 설정
- servlet-api
- jsp-api
- jstl
- springWebMVC

## XML로세팅

### web.xml 설정

- DispatcherServlet 클래스를 Spring에서 제공하는 클래스로 설정한다.

### ApplicationContext 설정

- Spring MVC로 만든 웹 애플리케이션에 대한 설정을 하는 파일이다.

### RootContext 파일 설정

- Spring MVC 프로젝트 수행 시 사용할 Bean들을 정의하는 파일이다.

### 파라미터 필터 설정

- 파라미터에 한글이 있을 경우 위해 인코딩을 설정한다.

### Controller 설정

- app-context.xml 파일에 Controller를 찾을 수 있도록 설정해준다.
- Controller를 구현한다.

### JSP 설정

- Controller 작성이 수행되고 랜더링 될 jsp를 설정한다.

### 정적 파일 경로 설정

- HTML에서 사용할 정적 파일들(이미지, 사운드, js, css 등)이 배치될 경로를 지정한다.

## Java로 세팅

### web.xml 설정 ->

- AbstractAnnotationConfigDispatcherServletInitializer 상속 또는
- 혹은 WebApplicationInitializer 인터페이스 구현

### servlet-context.xml ->

- WebMvcConfigurer 인터페이스 구현

### root-context.xml ->

- 상속 없음





------



# 1.스프링 MVC의 다양한 기능들

## URL Mapping

### Servlet / JSP URL 주소

- 사용자가 서버에 접속해서 서비스를 받기 위해 입력하는 주소를 URL이라고 부른다.
- URL 주소는 여러 의미를 가지고 있는 값들로 구성된다.
- 프로토콜://도메인주소(IP):포트번호/경로1/경로2/....

### URL 주소

- 프로토콜 : 서버와 클라이언트간의 통신을 위한 약속이다.(생략 시 http)
- 도메인 주소(IP 주소) : IP 주소는 같은 네트워크 망에서 컴퓨터를 구분하기 위해 제공되는 숫자로 구성된 고유 주소이다. 인터넷 망에 연결된 컴퓨터는 전 세계에서 유일한 주소를 할당 받고 공유기 등에 연결된 컴퓨터는 공유기안에서 유일한 주소를 할당 받는다. 그러나 숫자는 사람이 외우기 어려워 도메인 주소라는 걸 만들어 제공한다. 도메인 주소는 IP주소로 변환되어 컴퓨터를 찾을 수 있도록 한다.
- 포트번호 : 1부터 65535번까지로 구성된 숫자이다. 컴퓨터 내에서 프로그램을 구분하기 위해 사용한다. (생략시 80)
- 경로1/경로2/경로3... : 여기서 부터는 서버 혹은 개발 방식이나 분야에 따라 다르게 해석된다 Servlet/JSP에서는 첫번째 경로는 Context Path라고 부른다. 하나의 서버에서 각 웹 애플리케이션을 구분하기 위해 지정되는 이름이며 폴더의 이름이 Context Path가 된다. 그 이후 경로는 하위 경로가 된다.

### Spring MVC 에서의 주소

- Spring MVC에서는 Context Path 다음에 나오는 주소는 실제 물리적인 경로와 다르게 지정할 수 있다.

### 하위 경로

### 하위 경로 통합



------

## 요청 방식

### 요청 방식 지정하기

- Spring MVC는 요청 주소별로 메서드를 정의 할 수도 있지만 같은 요청 주소에서 요청 방식에 따라 메서드를 정의할 수도 있다.
- GET, POST, PUT, DELETE, PATCH에 대해 처리할 수 있다.

### @RequestMapping

- RequestMapping 어노테이션은 요청 주소 세팅 뿐만 아니라 요청 방식도 설정할 수 있다.

### 요청 어노테이션

- RequestMapping 대신 요청 별로 제공되는 어노테이션을 사용할 수도 있다.
- @GetMapping
- @PostMapping

### 동시에 설정하기

- RequestMapping은 요청 방식을 동시에 설정 할 수 있다.

------

## 파라미터 추출하기

### 파라미터 추출하기

- 클라이언트 요청 발생 시 전달하는 파라미터 데이터를 손쉽게 주입 받을 수 있도록 다양한 방식을 제공하고 있다.
- Spring MVC는 Servlet / JSP 처럼 요청 방식에 따라 파라미터 추출하는 방식이 달라지지 않는다.

### HttpServletRequest 사용하기

- Spring MVC는 필요한 객체나 데이터는 주입을 받아 사용하게 된다.
- Servlet / JSP에서 파라미터 데이터를 추출할 때 HttpSerlvetRequest 객체를 통하게 되는데 Spring MVC에서 이 객체를 주입 받아 사용할 수 있다.
- 파라미터 추출 뿐만 아니라 HttpServletRequest 객체가 필요할 경우 사용하면 된다.

### WebRequest 사용하기

- WebRequest는 HttpServletRequest 클래스를 확장한 클래스이다.

### @PathVariable

- 데이터가 요청 주소에 있을 경우 값을 주입 받을 수 있는 어노테이션이다.
- Restful API 서버 프로그래밍시 많이 사용하는 방식이다
- 요청주소/값1/값2/값3
- servlet jsp 에선 ㄴㄴ ㅋㅣ=벨류%키=벨류%...

### @RequestParam

- 파라미터 데이터를 직접 주입 받을 수 있다.
- 지정된 변수의 이름과 파라미터의 이름이 같을 경우 값을 주입 받는다.
- 가능한 경우 형 변환도 처리해준다.
- value : 파라미터의 이름과 변수의 이름이 다를 경우 파라미터 이름을 지정한다.
- required : false를 설정하면 지정된 이름의 파라미터가 없을 경우 null이 주입된다
- defaultValue : 디폴트 값을 지정할수 있다.

------

## 객체로 파라미터 추출하기

### Map으로 주입 받기

- 클라이언트가 전달하는 모든 파라미터 데이터를 한번에 Map으로 받을 수 있다.
- 단 동일한 명으로 전달되는 2개 이상의 파라미터는 하나만 담기게 된다.
- 동일한 명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 한다.

### @ModelAttribute

- ModelAttribute 어노테이션을 사용하면 파라미터를 객체로 주입받을 수 있다.
- 전달되는 파라미터의 이름과 동일한 프로퍼티에 자동으로 주입된다.
- 이 어노테이션은 생략이 가능하다.
- 이러한 객체를 커맨드 객체(Command Object)라고 부른다.

------

## ViewResolver

### ViewResolver

- 컨트롤러에서 전달받은 View의 이름을 토대로 jsp를 찾아 선택하고 jsp 데이터를 분석해 응답결과를 만들어 전달하는 요소이다.

### HttpServletRequest

- Spring MVC는 jsp를 처리할 때 HttpServletRequest 객체를 jsp 쪽으로 전달한다.
- ViewResolver는 이를 이용해 JSP 작업시 데이터를 사용할 수 있다.

### Model

- Model 객체를 주입 받아 세팅하면 HttpServletRequest 객체에 담겨 이를 JSP로 전달할 수 있다.

### ModelAndView

- ModelAndView는 Model에 값을 세팅하는 기능과 View의 이름을 지정하는 기능을 모두 가지고 있다.

------

## 커맨드 객체 이용하기

### 커맨드 객체

- 클라이언트가 전달해 주는 파라미터 데이터를 주입 받기 위해 사용하는 객체

### Request를 통해 전달

- 커맨드 객체는 HttpServletRequest 객체에 자동으로 담기고 jsp로 전달된다.
- 이 때, HttpServletRequest 객체에 저장되는 이름은 클래스의 이름으로 결정된다(맨앞 대문자는 소문자로 바뀜!ㅎㅎ)

### 저장되는 이름 설정

- HttpServletRequest에 저장되는 이름을 지정하고 싶다면 ModelAttribute 어노테이션에 지정하면 된다.

------

## Form 커스탬 태그

### Form 태그

- Spring에서는 <form:태그명 형태로 되어있는 커스텀 태그를 제공하고 있다.
- Form 커스텀 태그를 활용하면 Model 객체에 들어있는 값을 form 요소에 주입 시킬 수 있다.
- 회원 정보 수정 등 정보 수정페이지를 구성할 때 요긴하게 사용할 수 있다.

------

## Form 요소

### Form 요소

- Form 커스텀 태그를 사용하면 사용자 입력폼을 만들 수 있다.
- 주로 정보 수정 페이지를 구성할 때 사용한다.
- 구글검색하면 스프링 공식문서나옴ㅋ

### <form:form 태그

- <from 태그를 생성한다.
- modelAttribute : form 태그 내의 입력 요소들에 적용될 value 값을 가진 객체 이름 이 속성의 값이 id 속성으로 설정된다. 생략 시 command라는 문자열이 id로 설정된다.
- action : 요청할 주소를 설정한다. 생략 시 현재 페이지가 설정된다.
- method : 요청 방식을 설정한다. 생략 시 post로 설정된다.

### <form:button 태그

- Submit 버튼을 생성한다.
- disabled : true를 세팅해주면 버튼을 누룰 수 없도록 비활성화 된다.

### <form:hidden 태그

- Hidden 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### <form:input 태그

- text 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### <form:password 태그

- password 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
- showPassword : 세팅될 값의 이름을 지정하더라도 값이 세팅 되지 않는데 이 속성에 true를 넣어주면 값이 세팅된다.

### <form:textarea 태그

- textarea 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### select, checkbox, radio

- Spring에서 제공하는 form custom tag를 이용하면 select, checkbox, radio 등을 유동적으로 생성하여 사용할 수 있다.

### <form:select 

- select 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 값과 동일한 value 속성의 option 태그를 선택한다.

### <form:option, <form:options

- <form:option : select 태그의 option 태그 하나를 생성한다.
- <from:options : select 태그의 option들을 생성한다.
- items : option 태그들을 생성할 때 필요한 데이터가 담긴 list나 배열

### <form:checkbox, <formcheckboxs

- <form:checkbox : checkbox 하나를 생성한다.
- <form:checkboxs : checkbox 들을 생성한다.
- items : checkbox들을 생성하기 위해 필요한 정보가 담겨 있는 list나 배열

### <form:radiobutton, <form:radiobuttons

- <form:radiobutton : radiobutton 하나를 생성한다.
- <form:radiobuttons : radiobutton 들을 생성한다.
- items : radiobutton들을 생성하기 위해 필요한 정보가 담겨있는 list나 배열

------

## Redirect와 Forward

### 코드의 흐름

- 웹 애플리케이션은 브라우저가 서버에 요청을 하면 요청 정보를 분석하고 응답 결과를 생성하여 브라우저로 전달하는 과정을 거친다.
- 여기에서 서버의 동작은 어떤 분야를 가지고 개발을 하느냐에 따라 달라지게 된다.
- Spring MVC는 요청이 발생되면 요청 주소를 분석하여 그와 매핑되어 있는 메서드를 호출하고 메서드가 반환하는 정보를 토대로 응답결과를 생성하여 클라이언트에게 전달한다.

### 메서드의 리턴

- Controller를 통해 요청 주소와 매핑되어 있는 메서드는 반드시 무언가를 반환해야 한다.
- 우리는 지금까지 문자열, Model, ModelAndView를 반환해 보았다.
- 이들은 모두 브라우저에게 전달할 응답결과를 생성하기 위한 JSP를 지정하는 부분이다.
- 이 밖에도 다양한 정보를 반환할 수 있으며, 이를 토대로 동작을 제어할 수 있다.

### Redirect

- Redirect는 서버가 클라이언트에게 요청할 주소를 응답결과로 전달하는 것을 의미한다.
- 클라이언트는 응답결과로 받은 요청주소를 직접 요청하게 된다.
- 브라우저가 요청하는 것이므로 주소창의 주소는 변경된다.
- Redirect는 새로운 요청이 발생하는 것이므로 HttpServletRequest 객체는 소멸후 새롭게 생성되며 HttpSession 객체는 그대로 유지된다.

### forward

- 코드의 흐름을 서버상에서만 이동하는 것을 의미한다.
- 브라우저는 다른 곳으로 흐름이 이동되었다는 것을 알 수 없기 때문에 주소창의 주소는 변경되지 않는다.
- HttpServletRequest, HttpSession 모두 유지된다.

------



# 2.스프링 MVC에서의 Bean 관리

# 3.스프링 MVC의 유효성 검사

# 4.스프링 MVC 인터셉터와 MyBatis































