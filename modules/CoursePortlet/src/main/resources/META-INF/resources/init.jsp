<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.test.constants.ConstantsCommands" %>
<%@page import="com.test.model.Course" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
 String currentURL = PortalUtil.getCurrentURL(renderRequest);
 String backURL = ParamUtil.getString(renderRequest, "backURL");
%>
