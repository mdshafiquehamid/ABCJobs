<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Thread</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<div>
		<div>
			Subject: <b><s:property value="threadSubject" /></b>
		</div>
		<div>
			Message: <b><s:property value="threadMessage" /></b>
		</div>
		<div>
			Created By: <b><s:property value="threadCreatorName" /></b>
		</div>
		<div>
			Created On: <b><s:property value="threadCreatedOn" /></b>
		</div>
	</div>
	<hr />
	<div>
		<s:iterator value="threadReplies">
			<div
				style="border: 1px dotted red; border-radius: 5px; margin-bottom: 0.5rem;
			<s:if test="replyCreator">
			background-color: lightblue;
			</s:if><s:if test="!replyCreator">
			background-color: lightgray;
			</s:if>">
				<div>
					Reply: <b><s:property value="replyContent" /></b>
				</div>
				<div>
					Replied By: <b><s:property value="userName" /></b>
				</div>
				<div>
					Replied On: <b><s:property value="timestamp" /></b>
				</div>
			</div>
		</s:iterator>
	</div>
	<form action="thread" method="post">
		<div>
			<b>Reply</b>
		</div>
		<div>
			<input type="text" name="threadReplyMessage"
				value="<s:property value="threadReplyMessage" />" />
		</div>
		<input type="hidden" name="threadId"
			value="<s:property value="threadId" />" /> <input type="hidden"
			name="threadSubject" value="<s:property value="threadSubject" />" />
		<input type="hidden" name="threadMessage"
			value="<s:property value="threadMessage" />" /> <input type="hidden"
			name="threadCreatorName"
			value="<s:property value="threadCreatorName" />" /> <input
			type="hidden" name="threadCreatedOn"
			value="<s:property value="threadCreatedOn" />" />
		<button name="submit" value="Reply">Reply</button>
	</form>
	<div style="<s:property value="pageMessageStyle" />">
		<s:property value="pageMessage" />
	</div>
	<form action="thread" method="post">
		<button name="submit" value="List">Back to Threads</button>
	</form>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>