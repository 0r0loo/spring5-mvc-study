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

### <form:form&gt; 태그

- <from&gt; 태그를 생성한다.
- modelAttribute : form 태그 내의 입력 요소들에 적용될 value 값을 가진 객체 이름 이 속성의 값이 id 속성으로 설정된다. 생략 시 command라는 문자열이 id로 설정된다.
- action : 요청할 주소를 설정한다. 생략 시 현재 페이지가 설정된다.
- method : 요청 방식을 설정한다. 생략 시 post로 설정된다.

### <form:button&gt; 태그

- Submit 버튼을 생성한다.
- disabled : true를 세팅해주면 버튼을 누룰 수 없도록 비활성화 된다.

### <form:hidden&gt; 태그

- Hidden 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### <form:input&gt; 태그

- text 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### <form:password&gt; 태그

- password 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
- showPassword : 세팅될 값의 이름을 지정하더라도 값이 세팅 되지 않는데 이 속성에 true를 넣어주면 값이 세팅된다.

### <form:textarea&gt; 태그

- textarea 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

### select, checkbox, radio

- Spring에서 제공하는 form custom tag를 이용하면 select, checkbox, radio 등을 유동적으로 생성하여 사용할 수 있다.

### <form:select &gt;

- select 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 값과 동일한 value 속성의 option 태그를 선택한다.

### <form:option&gt;, <form:options&gt;

- <form:option : select 태그의 option 태그 하나를 생성한다.
- <from:options : select 태그의 option들을 생성한다.
- items : option 태그들을 생성할 때 필요한 데이터가 담긴 list나 배열

### <form:checkbox&gt;, <formcheckboxs&gt;

- <form:checkbox&gt; : checkbox 하나를 생성한다.
- <form:checkboxs&gt; : checkbox 들을 생성한다.
- items : checkbox들을 생성하기 위해 필요한 정보가 담겨 있는 list나 배열

### <form:radiobutton&gt;, <form:radiobuttons&gt;

- <form:radiobutton&gt; : radiobutton 하나를 생성한다.
- <form:radiobuttons&gt; : radiobutton 들을 생성한다.
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

## RequestScope

### Request

- 브라우저에 의해 새로운 요청이 발생하면 브라우저는 서버에 요청에 관련된 정보를 전송하게 된다.
- 이를 받은 서버는 브라우저가 보낸 요청 정보들을 보관하기 위해 HttpServletRequest 객체를 생성해 요청 정보들을 담아 두게 된다.
- 요청 정보가 담겨 있는 HttpSerlvetRequest 객체는 응답 결과가 브라우저로 전송 될 때까지 유지 되며 사용이 가능하다.

### RequestScope

- 새로운 요청이 발생해 응답결과가 브라우저로 전달 될 때 까지 요청 정보가 담겨 있는 Request 객체를 사용할 수 있다.
- 이러한 사용 범위를 RequestScope라고 부른다.
- HttpSerlverRequest 객체에는 서버 개발자가 필요에 의해 데이터나 객체를 저장 할 수 있고 RequestScope 내에서 사용이 가능하다.

## RequestScope 빈 주입

### 빈 주입

- @Autowired를 활용하여 Bean을 자동으로 주입 받을 수 있다.
- 스프링 코어에는 빈 주입시 prototype과 singleton이 있다.
- Spring MVC에서는 추가로 request, session, application을 제공하고 있다.

### Request Scope

- Bean을 정의할 때 request scope로 정의하면 요청이 발생할 때 마다 Bean 객체가 생성되어 자동으로 주입된다.
- 주입된 Bean은 요청 발생시 주입만 이루어지는 것이므로 request 영역에 저장되지는 않는다.
- Xml로 bean을 설정하고 byName으로 주입 받았을 경우에만 request 영억에 자동으로 저장된다.

### Request Scope

- Java 방식은 @RequestScope를 사용한다.
- XML 방식은 bean을 정의할 때 scope = "request"로 설정한다.

------

## SessionScope

### Session

- 브라우저가 최초로 서버에 요청을 하게 되면 브라우저당 하나씩 메모리 공간을 서버에서 할당하게 된다.
- 이 메모리 영역은 브라우저당 하나씩 지정되며 요청이 새롭게 발생하더라도 같은 메모리 공간을 사용하게 된다.
- 이러한 공간을 session 이라고 부른다.
- 이 영역은 브라우저를 종료할 때 까지 서버에서 사용할 수 있다.

### SessionScope

- 브라우저가 최초의 요청을 발생 시키고 브라우저를 닫을 때 까지를 SessionScope라고 부른다.
- SessionScope에서는 session 영역에 저장되어 있는 데이터나 객체를 자유롭게 사용할 수 있다.

### @SessionAttribute

- Session 영역에 저장되어 있는 객체를 사용하고자 할 때 메서드의 매개변수로 @SessionAttribute를 설정하면 Session 영역에 저장되어 있는 Bean을 주입 받을 수 있다.

### @SessionAttributes

- @ModelAttribute를 통해 주입 받는 Bean은 자동으로 Request 영역에 저장되고 Request 영역으로 부터 주입을 받게 된다.
- 이 때, @ModelAttribute를 통해 주입 받는 Bean을 @SessionAttributes로 지정해 놓으면 request 영역이 아닌 session 영역에 저장되고 session 영역으로 부터 주입 받을 수 있다.

## SessionScope

### Session Scope

- Bean을 정의할 때 session Scope로 정의하면 브라우저가 서버에 최초의 요청을 보낼 때 Bean 객체가 주입된다.
- 주입된 Bean은 주입만 이루어지는 것이므로 session 영역에 저장되지는 않는다.

### Session Scope

- Java 방식은 @SessionScope를 사용한다.
- XML 방식은 bean을 정의할 때 scope="session"으로 설정한다.

------

### ApplicationScope

### Application Scope

- 서버가 가동될 때부터 서버가 종료되는 시점까지의 범위를 Application Scope라고 부른다.
- Application Scope 동안 사용할 수 있는 메모리 영역이 만들어 지며 ServletContext라는 클래스 타입의 객체로 관리한다.
- ServletContext에 저장된 데이터나 객체는 서버가 종료되기 전까지 서버는 웹브라우저에 관계없이 동일한 메모리 공간을 사용하게 된다.

### ServletContext

- HttpServletRequest 객체로 부터 추출이 가능하다.
- Controller에서 주입 받을 수 있다.

## Application Scope

- Bean을 정의할 때 application scope로 정의하면 서버가 가동될 때 자동으로 주입된다.
- 주입된 Bean은 주입만 이루어지는 것이므로 application 영역에 저장되지는 않는다.
- 서버가 가동될 때 자동으로 주입 되는 것이므로 @Lazy를 설정하지 않아도 된다.

### Application Scope

- Java 방식은 @ApplicationScope를 사용한다.
- XML 방식은 bean을 정의할 때 scope="application"으로 설정한다.

------

## Cookie

### Cookie

- 사용자 웹 브라우저에 저장되는 데이터이다.
- 요청일 발생했을 때 웹 브라우저는 쿠키에 저장된 정보를 서버에 전달하게 된다.
- 만약 응답 결과로 쿠키 정보가 전달되면 웹 브라우저가 쿠키에 저장하게 된다.
- 쿠키는 사용자 브라우저에 저장되는 것이므로 브라우저가 전달 해 줄 때만 쿠키 정보를 사용할 수 있다.

### Cookie 저장

- 서버측 코드로 쿠키에 데이터를 저장할 수 있는 방법은 없다.
- 브라우저로 보낼 응답 결과에 저장할 쿠키 정보를 담아 보내면 브라우저에 의해 쿠키가 저장된다.
- Spring MVC에 쿠키 저장은 Servlet/JSP에서 사용하는 방법으로 처리한다.

### Cookie 읽어오기

- Cookie 정보는 브라우저가 요청을 발생 시켰을 때 요청 정보에 같이 담아서 서버로 전달해 준다.
- Servlet/JSP에서는 쿠키 정보를 배열로 받아 사용할 수 있다.
- Spring MVC에서는 쿠키 정보를 주입 받아 사욜할 수 있다.



------



# 3.스프링 MVC의 유효성 검사

## Properties

### Properties

- 애플리케이션을 개발할 때 프로그램 실행 중 절대 변하지 않는 값을이 있을 수 있다.
- Spring MVC에서는 이러한 값들을 properties 파일에 작성하고 이를 가져다 사용 할 수 있도록 제공하고 있다.

### @PropertySource, @PropertySources

- 사용할 properties 파일을 지정한다.
- 하나 혹은 다수의 파일을 지정할 수있다.

### @Value

- properties 파일에 작성한 값을 주입 받을 수 있다.

### Property Editor

- properties 파일에 한글을 작성하면 유니코드 형식의 문자열로 변경된다.
- 이거 설치하셈

***

## Message

### Properties

- properties를 활용 하면 다양한 값들을 미리 정의 해놓고 이를 가져다 사용할 수 있다.
- properties에 작성한 값을 JSP에서 사용하고자 한다면 몇 가지 설정이 필요하다.

### Message

- Properties 파일을 Message로 등록하면 이 데이터는 JSP에서도 사용할 수 있다.
- Properties 파일을 Message로 등록하면 다국어 처리가 가능해진다.

### MessageSource

- MessageSource 객체를 이용해 properties 파일을 등록해주면 Message로 등록할 수 있다
- 여기에서는 일정 시간마다 한번씩 갱신되는 ReloadbleResourceBundleMessageSource를 사용한다.

### Java에서 사용하기

- Message로 등록된 데이터를 Java 코드에서 사용하고자 한다면 MessageSource를 주입 받아 사용하면 된다.
- 이 때, Locale을 지정하면 다국어 처리가 가능하다.

### JSP에서 사용하기

- Message로 등록된 데이터를 jSP에서 사용하고자 한다면 message 커스텀 태그를 사용한다.

***



## 유효성 검사

### 유효성 검사

- 웹 애플리케이션에서 사용자 입력에 대해 유효성을 검사해야 하는 경우가 있다.
- JavaScript로 처리할 수 도 있지만 Spring MVC를 이용하여 처리할 수도 있다. 난자스가 나은듯...

### JSR-303

- Spring MVC는 JSR-303 규격의 유효성 검사 라이브러리를 사용할 수 있다.
- Bean에 데이터가 입력될 때 어떤 검사를 할 것인지 어노테이션으로 지정하고 지정된 어노테이션의 조건에 맞지 않으면 개발자에게 입력 값에 오류가 있다는 정보를 전달 한다.
- 개발자는 이를 통해 유효성 검사를 진행할 수 있다.

### pom.xml

- JSR-303을 사용하려면 라이브러리를 추가해야 한다. JSR-303은 실제 유효성 검사를 할 클래스가 존재해야 하는데 여기서는 hibernate라는 라이브러리를 사용

### Bean에 어노테이션 설정

- 먼저 Bean에 어노테이션을 설정한다. JSR-303과 Hibernate에서는 다양한 어노테이션을 제공한다.

### @Valid

- Controller의 메서드에서 주입 받는 Bean에 @Valid를 설정하면 유효성 검사를 실시한다.
- 유효성 검사 결과를 사용하고자 한다면 BindingResult 객체를 주입 받아야 한다.
- 이 객체에는 유효성 검사를 실행한 결과 정보가 담겨있다.
- 이를 통해 Controller에서 사용자가 입력한 값에 문제가 있는지 파악할 수 있다.

### JSP에서 사용하기

- 만약 JSP에서 잘못 입력한 항목에 대해 메시지를 보여주고 싶다면 errors를 사용하면 된다.
- Controller에서 주입 받았던 BindingResult 객체는 errors라는 이름으로 request영역에 저장된다. 이를 이용해 메시지를 출력할 수 있다.

***

## 에러 메시지 커스터 마이징

### 에러 메시지

- 유효성 검사에서 오류가 있다고 판단되는 항목에 대해서 JSP에서 메시지를 출력하였다.
- 우리가 출력하는 메시지는 JSR-303에서 정의한 메시지가 그대로 나오는 것이며 우리가 설정한 문자열은 아니다.
- JSR-303과 Hibernate에서 제공하는 어노테이션중 일부는 새로운 메시지를 셋팅할 수 있고 일부는 셋팅하지 모한다.

### Properties를 이용한 메시지 설정

- 유효성 검사를 통과하지 못하면 JSP에 오류 관련된 정보가 전달된다.
- 이 때 codes[0]으로 값을 가져오면 다음 양식으로 문자열을 가져올 수 있다.
- 에러종류.빈이름.프로퍼티이름
- 우리가 Properties 파일에 위와 같은 양식의 이름으로 메시지를 등록해주면 properties 파일에 작성한 문자열을 가져와 출력할 수 있고 다국어 처리까지 가능해진다.

### Form 데이터 유지하기

- 유효성 검증에 통과하지 못해 다시 입력화면으로 돌아왔을 때 기존에 입력했던 내용을 유지해야 할 경우가 있다.
- 이 때 입력 화면으로 전달된 Bean 객체에서 input 태그에 값을 주입하면 된다.
- 전에 살펴 보았던 Spring MVC의 Form 커스텀 태그를 활용하면 된다.
- 이 때, 검증 실패 문자열도 손쉽게 셋팅하는 것이 가능하다.

***



## JSR-303

### JSR-303

- JSR-303 어노테이션은 빈 객체에 주입되는 값의 유효성 검사를 하기 위해 제공되는 어노테이션 이다.
- ▪https://beanvalidation.org/1.0/spec/
- @AssertTrue : true가 아닌 값이 들어오면 오류
- @AsserFalse : false가 아닌 값이 들어오면 오류
- @Max(값) : 값보다 큰 값이 들어오면 오류
- @Min(값) : 값보다 작은 값이 들어오면 오류
- @DecimalMax(value= 값, inclusive = true/false) : 값보다 작거나 같은 값이 들어와야 한다. inclusive가 false면 값은 포함하지 않기 때문에 작은 값이 들어와야 한다. 생략하면 true
- @DecimalMin(value = 값, inclusive = true/false) : 값보다 크거나 같은 값이 들어와야 한다. Inclusive가 false면 값은 포함하지 않기 때문에 큰 값이 들어와야 한다. 생략하면 false
- @Nulll : 값이 들어오면 오류가 발생
- @NotNull : 값이 들어오지 않으면 오류가 발생
- @Digits(integer = 자릿수, fraction = 자릿수) : 지정된 자릿수의 숫자가 아닐 경우 오류가 발생. Integer-정수 자릿수, fraction - 실수 자릿수
- @Size(min = 글자수, max = 글자수) : 지정된 글자수 보다 짧거나 길면 오류가 발생
- @Pattern(regexp=정규식) : 주어진 정규식에 위배되면 오류 발생

***



## JSR-380

### JSR-380

- JSR-303와 더불어 추가로 JSR-380 규격도 지원한다.
- 원리는 똑같고 유효성 검사의 편의성을 더하기 위해 추가로 제공되는 부분이다.
- ▪https://beanvalidation.org/2.0/spec/
- @NotEmpty : 주입된 값의 길이가 0이면 오류 발생. 공백도 글자로 인식한다.
- @NotBlank : 주입된 값이 공백을 제거하고 길이가 0이면 오류가 발생.
- @Positive : 양수가 아니라면 오류 발생.
- @PositiveOrZero : 0 또는 양수가 아니라면 오류 발생
- @Negative : 음수가 아니라면 오류 발생
- @NegativeOrZero : 0 또는 음수가 아니라면 오류 발생.
- @Email : 이메일 형식이 아니라면 오류 발생. 중간에 @가 있는지 정도만 확인한다.



***

## Validator

### Validator

- Validator를 직접 만들어 보기
- JSR-303, JSR-380 스펙으로 유효성 검사를 한 후 추가적으로 다른 유호성 검사를 하고자 할 때 사용한다.

### Validator 인터페이스 구현

- 먼저 Validator 인터페이스를 구현한다.
- supports : 유효성 검사할 데이터를 가지고  있는 객체가 유효성 검사가 가능한지 확인한다.
- validate : 유효성 검사를 하는 메서드

### Validator를 컨트롤러에서 등록

- Validator를 컨트롤러에 등록 해준다.
- 사용할 Validator가 하나면 setValidator, 한개 이상이면 addValidators 메서드를 사용한다.

### ValidateUtils

- 지정된 값에 대해 유효성 검사를 하는 메서드
- rejectIfEmpty(error 객체, "프로퍼티이름", "코드 이름") : 값이 비어 있는지 확인 한다. 공백은 글자로 취급한다.
- rejectIfEmptyOrWhitespace(error객체, "프로퍼티이름", "코드이름") : 값이 비어 있거나 공백으로만 구성되어 있는지 확인 한다.
- 입력값에 문제가 있다면 error 객체에 오류 정보를 저장한다. 사용할 오류 메시지는 "코드이름.bean객체이름.프로퍼티이름" 으로 구성된다.

### rejectValue

- 유효성 조건을 직접 만들어 검사할 때 사용한다.
- If문으로 유효성 검사를 해주고 위배시 rejectValue를 통해 오류 정보를 지정한다.
- rejectValue("프로퍼티이름","코드이름")
- 입력값에 문제가 있다면 error 객체에 오류 정보를 저장한다. 사용할 오류 메시지는 "코드이름.bean객체이름.프로퍼티이름"으로 구성된다.
- 















------



# 4.스프링 MVC 인터셉터와 MyBatis































