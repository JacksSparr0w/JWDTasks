<%@ page import="com.katsubo.task3.bean.Device" %><%--
  Created by IntelliJ IDEA.
  User: jacksparroy
  Date: 25.06.19
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.katsubo.task3.bean.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Device list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>XML Parsers</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Devices</h2>
        </div>
        <%
            List<Device> devices = (List<Device>) request.getAttribute("devices");

            if (devices != null && !devices.isEmpty()) {
                out.println("<table class=\"w3-table-all w3-card-4 w3-hoverable\">\n");
                out.println("<tr>\n" +
                        "      <th>ID</th>\n" +
                        "      <th>Name</th>\n" +
                        "      <th>Origin</th>\n" +
                        "      <th>Price</th>\n" +
                        "      <th>Critical</th>\n" +
                        "      <th>Peripheral</th>\n" +
                        "      <th>Cooler</th>\n" +
                        "      <th>Device Type</th>\n" +
                        "      <th>Ports</th>\n" +
                        "      <th>Energy</th>\n" +
                        "      <th>Group</th>\n" +

                        "    </tr>");
                for (Device device : devices) {

                    Type type = device.getType();

                    out.println("<tr>\n" +
                            "      <th>" + device.getId() + "</th>\n" +
                            "      <th>" + device.getName() + "</th>\n" +
                            "      <th>" + device.getOrigin() + "</th>\n" +
                            "      <th>" + device.getPrice() + "</th>\n" +
                            "      <th>" + device.isCritical() + "</th>\n" +
                            "      <th>" + type.isPeripheral() + "</th>\n" +
                            "      <th>" + type.isCooler() + "</th>\n" +
                            "      <th>" + type.getName() + "</th>\n" +
                            "      <th>" + type.getPorts() + "</th>\n" +
                            "      <th>" + type.getEnergyUse() + "</th>\n" +
                            "      <th>" + type.getGroup() + "</th>\n" +

                            "    </tr>");
                }
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>There are no devices yet!</h5>\n" +
                    "</div>");
        %>
        <div type="button" class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='..'">Back to main</button>
        </div>
    </div>

</div>

</body>
</html>
