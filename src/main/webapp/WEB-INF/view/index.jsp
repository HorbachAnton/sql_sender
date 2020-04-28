<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
          <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
            <html>
              <head>
                <title>Sql-sender</title>
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
                <spring:message code="index.h1.pricing" var="pricing"/>
                <spring:message code="index.p.pricing_details" var="pricing_details"/>
                <spring:message code="index.h4.free_plan" var="free_plan"/>
                <spring:message code="index.h1.free_plan_price" var="free_plan_price"/>
                <spring:message code="index.small.free_plan_monthly_fee" var="free_plan_monthly_fee"/>
                <spring:message code="index.li.free_plan_users_number" var="free_plan_users_number"/>
                <spring:message code="index.li.free_plan_storage_size" var="free_plan_storage_size"/>
                <spring:message code="index.li.free_plan_email_support" var="free_plan_email_support"/>
                <spring:message code="index.li.free_plan_help_center" var="free_plan_help_center"/>
                <spring:message code="index.h4.pro_plan" var="pro_plan"/>
                <spring:message code="index.h1.pro_plan_price" var="pro_plan_price"/>
                <spring:message code="index.small.pro_plan_monthly_fee" var="pro_plan_monthly_fee"/>
                <spring:message code="index.li.pro_plan_users_number" var="pro_plan_users_number"/>
                <spring:message code="index.li.pro_plan_storage_size" var="pro_plan_storage_size"/>
                <spring:message code="index.li.pro_plan_email_support" var="pro_plan_email_support"/>
                <spring:message code="index.li.pro_plan_help_center" var="pro_plan_help_center"/>
                <spring:message code="index.h4.enterprise_plan" var="enterprise_plan"/>
                <spring:message code="index.h1.enterprise_plan_price" var="enterprise_plan_price"/>
                <spring:message code="index.small.enterprise_plan_monthly_fee" var="enterprise_plan_monthly_fee"/>
                <spring:message code="index.li.enterprise_plan_users_number" var="enterprise_plan_users_number"/>
                <spring:message code="index.li.enterprise_plan_storage_size" var="enterprise_plan_storage_size"/>
                <spring:message code="index.li.enterprise_plan_email_support" var="enterprise_plan_email_support"/>
                <spring:message code="index.li.enterprise_plan_help_center" var="enterprise_plan_help_center"/>
                <spring:message code="index.small.log_in" var="log_in"/>
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
                            <form:form method="GET" action="authorization/">
                              <input class="btn" type="submit" value="${authorization}"/>
                            </form:form>
                          </sec:authorize>
                        </li>
                        <li class="nav-item">
                          <sec:authorize access="!isAuthenticated()">
                            <form:form method="GET" action="registration/">
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

                <div class="container price-container" id="price-container">
                  <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 class="display-4">${pricing}</h1>
                    <p class="lead">${pricing_details}</p>
                  </div>
                  <div class="card-deck mb-3 text-center">
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">${free_plan}</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">${free_plan_price}
                          <small class="text-muted">${free_plan_monthly_fee}</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>${free_plan_users_number}</li>
                          <li>${free_plan_storage_size}</li>
                          <li>${free_plan_email_support}</li>
                          <li>${free_plan_help_center}</li>
                        </ul>
                        <form action="authorization/">
                          <button type="submit" class="btn btn-lg btn-block btn-primary">${log_in}</button>
                        </form>
                      </div>
                    </div>
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">${pro_plan}</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">${pro_plan_price}
                          <small class="text-muted">${pro_plan_monthly_fee}</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>${pro_plan_users_number}</li>
                          <li>${pro_plan_storage_size}</li>
                          <li>${pro_plan_email_support}</li>
                          <li>${pro_plan_help_center}</li>
                        </ul>
                        <form action="authorization/">
                          <button type="submit" class="btn btn-lg btn-block btn-primary">${log_in}</button>
                        </form>
                      </div>
                    </div>
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">${enterprise_plan}</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">${enterprise_plan_price}
                          <small class="text-muted">${enterprise_plan_monthly_fee}</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>${enterprise_plan_users_number}</li>
                          <li>${enterprise_plan_storage_size}</li>
                          <li>${enterprise_plan_email_support}</li>
                          <li>${enterprise_plan_help_center}</li>
                        </ul>
                        <form action="authorization/">
                          <button type="submit" class="btn btn-lg btn-block btn-primary">${log_in}</button>
                        </form>
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
