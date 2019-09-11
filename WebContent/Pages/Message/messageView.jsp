<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Message</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<h1>
		Conversation with <span style="color: blue;"><s:property
				value="otherUserName" /></span>
	</h1>
	<div>
		<s:iterator value="messages">
			<div
				style="border: 1px dotted red; border-radius: 5px; margin-bottom: 0.5rem;
			<s:if test="senderUser">
			background-color: lightblue;
			</s:if><s:if test="!senderUser">
			background-color: lightgray;
			</s:if>">
				<!--<div> -->
				<%--Sent By: <b><s:property value="senderName" /></b> --%>
				<!--</div> -->
				<!--<div> -->
				<%--Subject: <b><s:property value="subject" /></b> --%>
				<!--</div> -->
				<div>
					Message: <b><s:property value="message" /></b>
				</div>
				<div>
					Sent On: <b><s:property value="timestamp" /></b>
				</div>
			</div>
		</s:iterator>
	</div>
	<form action="message" method="post">
		<!--<div> -->
		<!--<b>Subject</b> -->
		<!--</div> -->
		<!--<div> -->
		<!--<input type="text" name="newSubject" -->
		<%--value="<s:property value="newSubject" />" /> --%>
		<!--</div> -->
		<div>
			<b>Message</b>
		</div>
		<div>
			<input type="text" name="newMessage"
				value="<s:property value="newMessage" />" />
		</div>
		<input type="hidden" name="otherUserId"
			value="<s:property value="otherUserId" />" /> <input type="hidden"
			name="otherUserName" value="<s:property value="otherUserName" />" />
		<button name="submit" value="New">Send</button>
	</form>
	<div style="<s:property value="pageMessageStyle" />">
		<s:property value="pageMessage" />
	</div>
	<form action="message" method="post">
		<button name="submit" value="List">Back to Messages</button>
	</form>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>