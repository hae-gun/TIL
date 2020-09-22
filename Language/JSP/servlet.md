# dispatch

* request 를 연결해 줄수 있다.

  ```java
  @WebServlet("/first")
  public class FirstServlet extends HttpServlet {
  	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
  		request.setCharacterEncoding("utf-8");
  		response.setContentType("text/html;charset=utf-8");
  		request.setAttribute("address", "명동");
  		RequestDispatcher dispatch = request.getRequestDispatcher("second");
  		dispatch.forward(request, response);
  	}
  }
  ```





# context

* 설정시 어노테이션 설정이 xml 보다 우선적으로 적용된다.
* 객체를 컨테이너에 형성할 때 법치 : **클래스 명의 첫글자**를 소문자로 만들어서 지정하기.
* xml 에서의 값을 가져올 때는 `context.getInitParameter(parameter keyword)` 매서드로 사용이 가능하다.



* 서블릿 개념
  * 클라이언트 요청
  * web server에서 받아서 html 을 돌려주거나 db를 탐색하여 필요 정보를 추출
  * 예제에서는 out.print()로 직접 출력하였지만 실제는 jsp로 출력을 진행함.
  * 



