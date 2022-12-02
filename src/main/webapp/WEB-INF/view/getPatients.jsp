<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Get All Patients</title>
</head>
<body>
<table style="text-align: center">
    <tr>
        <th>Patient Last Name |</th>
        <th>Medicine Name |</th>
        <th>Blood concentration (0 min), mcg/mL |</th>
        <th>Blood concentration (15 min), mcg/mL |</th>
        <th>Blood concentration (30 min), mcg/mL</th>
    </tr>
    <br>
    <c:forEach var="patient" items="${all_patients}">
        <tr>
            <td>${patient.lastName}</td>
            <td>${patient.medicine}</td>
            <td>${patient.bloodConcentration0}</td>
            <td>${patient.bloodConcentration15}</td>
            <td>${patient.bloodConcentration30}</td>
            <c:url value="/updatePatient" var="updateLink">
                <c:param name="id" value="${patient.id}"/>
            </c:url>
            <td><a href="${updateLink}">Update the patient data</a></td>
            <c:url value="/deletePatient" var="deleteLink">
                <c:param name="id" value="${patient.id}"/>
            </c:url>
            <td></td>
            <td><a href="${deleteLink}">Delete the patient data</a> </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add a new patient" onclick="window.location.href='addPatient'">
</body>
</html>
