<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add new patient</title>
</head>
<body>
<form:form action="savePatient" method="post" modelAttribute="new_patient">
    <form:hidden path="id"/>
    <table>
      <tr>
          <td><label>Patient last name:</label></td>
          <td><form:input path="lastName"/></td>
      </tr>
      <tr>
          <td><label>Medicine name:</label></td>
          <td><form:input path="medicine"/></td>
      </tr>
      <tr>
          <td><label>Blood concentration, mcg/mL:</label></td>
      </tr>
      <tr>
          <td><label>- before taking medicine (0 min)</label></td>
          <td><form:input path="bloodConcentration0"/></td>
      </tr>
      <tr>
          <td><label>- after taking medicine (15 min)</label></td>
          <td><form:input path="bloodConcentration15"/></td>
      </tr>
      <tr>
          <td><label>- after taking medicine (30 min)</label></td>
          <td><form:input path="bloodConcentration30"/></td>
      </tr>
      <tr>
          <td><input type="submit" value="Save patient data"></td>
      </tr>
  </table>

</form:form>
</body>
</html>
