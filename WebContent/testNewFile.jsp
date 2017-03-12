<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<Form Action="goMemberPage.do" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">辦法：</TD>
             <TD align="LEFT"><input	type="text" name="servType" ></TD>
         </TR>
         <TR>
             <TD align="RIGHT">用戶：</TD>
             <TD align="LEFT"><input	type="text" name="userId"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">起點：</TD>
             <TD align="LEFT"><input	type="text" name="rngStart" ></TD>
         </TR>
         <TR>
         <input type="submit" value="提交">
         </TR>
</Table>
</Form>

</body>
</html>