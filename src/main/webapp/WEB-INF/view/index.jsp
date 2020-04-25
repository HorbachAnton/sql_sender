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
                <spring:message code="header.strong.sql_sender" var="sql_sender"/>
                <spring:message code="header.a.home" var="home"/>
                <spring:message code="header.a.executor" var="executor"/>
                <spring:message code="header.a.query_history" var="query_history"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.authorization" var="authorization"/>
                <spring:message code="header.input.registration" var="registration"/>
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

                <div class="container price-container">
                  <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 class="display-4">Pricing</h1>
                    <p class="lead">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It's built with default Bootstrap components and utilities with little customization.</p>
                  </div>
                  <div class="card-deck mb-3 text-center">
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Free</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">$0
                          <small class="text-muted">/ mo</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>10 users included</li>
                          <li>2 GB of storage</li>
                          <li>Email support</li>
                          <li>Help center access</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign up for free</button>
                      </div>
                    </div>
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Pro</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">$15
                          <small class="text-muted">/ mo</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>20 users included</li>
                          <li>10 GB of storage</li>
                          <li>Priority email support</li>
                          <li>Help center access</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-primary">Get started</button>
                      </div>
                    </div>
                    <div class="card mb-4 box-shadow">
                      <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Enterprise</h4>
                      </div>
                      <div class="card-body">
                        <h1 class="card-title pricing-card-title">$29
                          <small class="text-muted">/ mo</small>
                        </h1>
                        <ul class="list-unstyled mt-3 mb-4">
                          <li>30 users included</li>
                          <li>15 GB of storage</li>
                          <li>Phone and email support</li>
                          <li>Help center access</li>
                        </ul>
                        <button type="button" class="btn btn-lg btn-block btn-primary">Contact us</button>
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
