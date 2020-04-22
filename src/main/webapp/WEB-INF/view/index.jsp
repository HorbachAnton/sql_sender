<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
          <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
            <html>
              <head>
                <head-tag:addCSS_JS/>
              </head>
              <body>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.p.app_name" var="app_name"/>
                <spring:message code="header.input.authorization" var="authorization"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>

                <header>
                  <div class="container-fluid">
                    <div class="row align-items-center">
                      <div class="col-xl-4 d-flex justify-content-around">
                        <div class="container">
                          <a href="?lang=en_EN">
                            <button class="btn btn-primary" type="submit">${english_locale}</button>
                          </a>
                          <a href="?lang=ru_RU">
                            <button class="btn btn-primary" type="submit">${russian_locale}</button>
                          </a>
                        </div>
                      </div>
                      <div class="col-xl-4 d-flex justify-content-center">
                        <h1>${app_name}</h1>
                      </div>
                      <div class="col-xl-4 d-flex justify-content-end">
                        <sec:authorize access="!isAuthenticated()">
                          <form:form method="GET" action="authorization">
                            <input class="btn btn-primary" type="submit" value="${authorization}"/>
                          </form:form>
                          <form:form method="GET" action="registration">
                            <input class="btn btn-primary" type="submit" value="${registration}"/>
                          </form:form>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                          <form:form method="POST" action="logout">
                            <input class="btn btn-primary" type="submit" value="${logout}"/>
                          </form:form>
                        </sec:authorize>
                      </div>
                    </div>
                  </div>
                </header>
              </body>
            </html>
