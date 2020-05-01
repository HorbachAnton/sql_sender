<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
          <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
            <html>
              <head>
                <title>Query history</title>
                <head-tag:addCSS_JS/>
              </head>
              <body>
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <spring:message code="header.strong.sql_sender" var="sql_sender"/>
                <spring:message code="header.a.home" var="home"/>
                <spring:message code="header.a.executor" var="executor"/>
                <spring:message code="header.a.query_history" var="query_history"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.authorization" var="authorization"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="query_history.h1.requests_history" var="requests_history"/>
                <spring:message code="query_history.p.history_describe" var="history_describe"/>
                <spring:message code="footer.p.copyright" var="copyright"/>

                <header>
                  <nav class="navbar navbar-expand-lg navbar-dark default-color">
                    <a class="navbar-brand" href="${contextPath}/">
                      <strong>${sql_sender}</strong>
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                          <a class="nav-link" href="${contextPath}/welcome/">${home}
                            <span class="sr-only">(current)</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="${contextPath}/request-executor/">${executor}</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="${contextPath}/query_history/">${query_history}</a>
                        </li>
                      </ul>
                      <ul class="navbar-nav nav-flex-icons">
                        <li class="nav-item">
                          <a href="?lang=en_EN">
                            <button class="btn" type="submit">${english_locale}</button>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a href="?lang=ru_RU">
                            <button class="btn" type="submit">${russian_locale}</button>
                          </a>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="!isAuthenticated()">
                            <form:form method="GET" action="${contextPath}/authorization/">
                              <input class="btn" type="submit" value="${authorization}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="!isAuthenticated()">
                            <form:form method="GET" action="${contextPath}/registration/">
                              <input class="btn" type="submit" value="${registration}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="isAuthenticated()">
                            <form:form method="POST" action="${contextPath}/logout">
                              <input class="btn" type="submit" value="${logout}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                      </ul>
                    </div>
                  </nav>
                </header>

                <div class="container queries_history_container" id="queries_history_container">
                  <div class="container header_queries_history_container">
                    <h1 class="text-center">${requests_history}</h1>
                  </div>
                  <c:if test="${not empty user_requests}">
                    <div class="container your_queries_history_container">
                      <div class="container header_your_queries_history_container">
                        <div class="row">
                          <div class="col-md-12">
                            <p class="text-center">
                              ${history_describe}
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <c:forEach var="request" items="${user_requests}">
                      <div class="row">
                        <div class="col-md-3  border border-dark">
                          <p class="text-center">${request.id}</p>
                        </div>
                        <div class="col-md-3  border border-dark">
                          <p class="text-center">${request.text}</p>
                        </div>
                        <div class="col-md-3  border border-dark align-middle">
                          <p class="text-center">
                            ${request.user.getUsername()}</p>
                        </div>
                        <div class="col-md-3  border border-dark">
                          <p class="text-center">
                            ${request.result.getMessage()}</p>
                        </div>
                      </div>
                    </c:forEach>
                  </div>
                </c:if>
              </div>

              <footer class="page-footer font-small blue">
                <div class="footer-copyright text-center py-3">
                  <p>${copyright}</p>
                </div>
              </footer>
            </body>
          </html>
