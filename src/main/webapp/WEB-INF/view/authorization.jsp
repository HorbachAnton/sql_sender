<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

          <html>
            <head>
              <title>Authorization</title>
              <head-tag:addCSS_JS/>
            </head>

            <body>
              <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
              <spring:message code="authorization.input.username" var="username"/>
              <spring:message code="authorization.input.password" var="password"/>
              <spring:message code="authorization.label.remember_me" var="remember_me"/>
              <spring:message code="authorization.button.login" var="login"/>
              <spring:message code="authorization.div.not_have_account" var="not_have_account"/>
              <spring:message code="authorization.a.sign_up" var="sign_up"/>

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
                </body>
              </html>
