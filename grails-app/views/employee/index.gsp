
<%@ page import="grails.demo.search.Employee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<h1>Employee Filters</h1>
   		<g:form action="index" method="post">
            <div class="dialog">
                <table>
                    <tbody>
			<tr class="prop">
				<td valign="top" class="name">
					<label for="department">Department:</label>
				</td>
				<td valign="top" class="value">
					<g:select name="department" from='${departmentList }' optionKey="id"
					  value="${flash.department }" noSelection="['':'-Choose department-']"/>
				</td>
			</tr>
					<tr class="prop">
				<td valign="top" class="name">
					<label for="firstName">First Name:</label>
				</td>
				<td valign="top" class="value">
					<input type="text" id="firstName" name="firstName" value="${flash.firstName}">
                        	
				</td>
			</tr>
			<tr class="prop">
				<td valign="top" class="name">
					<label for="firstName">Last Name:</label>
				</td>
				<td valign="top" class="value">
					<input type="text" id="lastName" name="lastName" value="${flash.lastName}">
           					</td>
			</tr>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <span class="button"><input class="save" type="submit" value="Search"></span>
            </div>
        </g:form>
		<div id="list-employee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="employee.department.label" default="Department" /></th>
					
						<g:sortableColumn property="firstName" title="${message(code: 'employee.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'employee.lastName.label', default: 'Last Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<%-- <g:each in="${employeeInstanceList}" status="i" var="employeeInstance"> --%>
				<g:each in="${employeeList}" status="i" var="employeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeInstance.id}">${fieldValue(bean: employeeInstance, field: "department")}</g:link></td>
					
						<td>${fieldValue(bean: employeeInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "lastName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<%--<g:paginate total="${employeeInstanceCount ?: 0}" />--%>
				<g:paginate total = "${employeeList.getTotalCount()}" params="${flash}" />
			</div>
		</div>
	</body>
</html>
