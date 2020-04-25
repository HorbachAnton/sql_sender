<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
          <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

            <html>
              <head>
                <title>Authorization</title>
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
                <spring:message code="authorization.input.username" var="username"/>
                <spring:message code="authorization.input.password" var="password"/>
                <spring:message code="authorization.label.remember_me" var="remember_me"/>
                <spring:message code="authorization.button.login" var="login"/>
                <spring:message code="authorization.div.not_have_account" var="not_have_account"/>
                <spring:message code="authorization.a.sign_up" var="sign_up"/>
                <spring:message code="footer.p.copyright" var="copyright"/>

                <header>
                  <nav class="navbar navbar-expand-lg navbar-dark default-color">
                    <a class="navbar-brand" href="#">
                      <strong>${sql_sender}</strong>
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                          <a class="nav-link" href="#">${home}
                            <span class="sr-only">(current)</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">${executor}</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">${query_history}</a>
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
                            <form:form method="GET" action="authorization">
                              <input class="btn" type="submit" value="${authorization}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="!isAuthenticated()">
                            <form:form method="GET" action="registration">
                              <input class="btn" type="submit" value="${registration}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="isAuthenticated()">
                            <form:form method="POST" action="logout">
                              <input class="btn" type="submit" value="${logout}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                      </ul>
                    </div>
                  </nav>
                </header>

                <div class="container h-100">
                  <div class="d-flex justify-content-center h-100">
                    <div class="user_card">
                      <div class="d-flex justify-content-center">
                        <div class="brand_logo_container">
                          <img src="<c:url value="/resources/img/authorization-logo.png" />" class="brand_logo" alt="Logo"></div>
                        </div>
                        <div class="d-flex justify-content-center form_container">
                          <form:form method="POST" action="${contextPath}/login">
                            <div class="input-group mb-3">
                              <div class="input-group-append">
                                <span class="input-group-text">
                                  <i class="fas fa-user"></i>
                                </span>
                              </div>
                              <input type="text" name="username" class="form-control input_user" placeholder="${username}"/></div>
                            <div class="input-group mb-2">
                              <div class="input-group-append">
                                <span class="input-group-text">
                                  <i class="fas fa-key"></i>
                                </span>
                              </div>
                              <input type="password" name="password" class="form-control input_pass" placeholder="${password}"/></div>
                            <div class="form-group">
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlInline">
                                  <label class="custom-control-label" for="customControlInline">${remember_me}</label>
                                </div>
                              </div>
                              <div class="d-flex justify-content-center mt-3 login_container">
                                <button type="submit" value="submit" class="btn login_btn">${login}</button>
                              </div>
                            </form:form>
                          </div>
                          <div class="mt-4">
                            <div class="d-flex justify-content-center links">
                              ${not_have_account}
                              <a href="#" class="ml-2">${sign_up}</a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>

                    <footer class="page-footer font-small blue">
                      <div class="footer-copyright text-center py-3">
                        <p>${copyright}</p>
                      </div>
                    </footer>

                  </body>
                </html>
