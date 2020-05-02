<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
          <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

            <html>
              <head>
                <title>Request Executor</title>
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
                <spring:message code="request_executor.h1.write_query" var="write_query"/>
                <spring:message code="request_executor.p.describe_admin_executor" var="describe_admin_executor"/>
                <spring:message code="request_executor.p.describe_user_executor" var="describe_user_executor"/>
                <spring:message code="request_executor.p.available_tables" var="available_tables"/>
                <spring:message code="request-executor.button.execute" var="execute"/>
                <spring:message code="request_executor.h1.result_header" var="result_header"/>
                <spring:message code="request_executor.p.request_id" var="request_id"/>
                <spring:message code="request_executor.p.request_result_mesage" var="request_result_mesage"/>
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

                <div class="container request-container">
                  <div class="container request-header-container">
                    <h1 class="text-center">${write_query}</h1>
                  </div>
                  <div class="container request-input-container border border-dark rounded">
                    <div class="container describe-executor-container">
                      <sec:authorize access="hasAuthority('ADMIN')">
                        <p class="text-center">${describe_admin_executor}</p>
                      </sec:authorize>
                      <sec:authorize access="hasAuthority('USER')">
                        <p class="text-center">${describe_user_executor}</p>
                      </sec:authorize>
                      <c:if test="${not empty availableTables}">
                        <p class="text-center">${available_tables}
                          <c:forEach var="availableTable" items="${availableTables}" varStatus="i">
                            <c:choose>
                              <c:when test="${i.count != availableTables.size()}">
                                ${availableTable};
                              </c:when>
                              <c:otherwise>
                                ${availableTable}.
                              </c:otherwise>
                            </c:choose>
                          </c:forEach>
                        </p>
                      </c:if>
                    </div>
                    <form:form method="POST" action="${contextPath}/execute-request" class="form-group" modelAttribute="requestDTO">
                      <form:textarea path="text" class="form-control" rows="10" id="comment"/>
                      <div class="text-center">
                        <form:errors path="text" CssClass="error"/>
                      </div>
                      <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-dark text-center request-form-button">${execute}</button>
                      </div>
                    </form:form>
                  </div>
                </div>

                <c:if test="${not empty requestResultDTO}">
                  <div class="container request-result-container">
                    <div class="container request-header-container">
                      <h1 class="text-center">${result_header}</h1>
                    </div>
                    <div class="container request-input-container border border-dark rounded">
                      <div class="container d-flex flex-row input-head-container">
                        <div class="container border border-dark border-right  text-center">
                          <p class="align-middle">${request_id} ${requestResultDTO.id}</p>
                        </div>
                        <div class="container border border-dark text-center">
                          <p class="align-middle">${request_result_mesage} ${requestResultDTO.message}</p>
                        </div>
                      </div>
                      <c:if test="${not empty requestResultDTO.getRequestedData()}">
                        <div class="container requested-data-container">
                          <div class="container">
                            <h2 class="text-center container-fluid">Requested data</h2>
                          </div>
                          <c:forEach var="requestResultData" items="${requestResultDTO.getRequestedData()}">
                            <div class="container d-flex flex-row">
                              <c:forEach var="element" items="${requestResultData}">
                                <div class="container text-center  border border-dark rounded">
                                  <p class="d-inline-block text-truncate result-column">
                                    ${element}
                                  </p>
                                </div>
                              </c:forEach>
                            </div>
                          </c:forEach>
                        </div>
                      </c:if>
                    </div>
                  </div>
                </c:if>

                <footer class="page-footer font-small blue">
                  <div class="footer-copyright text-center py-3">
                    <p>${copyright}</p>
                  </div>
                </footer>
              </body>
            </html>
