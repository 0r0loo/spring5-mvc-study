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



# 1.링 MVC의 다양한 기능들

# 2.스프링 MVC에서의 Bean 관리

# 3.스프링 MVC의 유효성 검사

# 4.스프링 MVC 인터셉터와 MyBatis















