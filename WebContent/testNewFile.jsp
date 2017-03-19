<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<Form Action="sendMsg" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">sender：</TD>
             <TD align="LEFT"><input	type="text" name="sender" ></TD>
         </TR>
         <TR>
             <TD align="RIGHT">alias：</TD>
             <TD align="LEFT"><input	type="text" name="alias"></TD>
         </TR>
         <TR>
             <TD align="receiver">receiver：</TD>
             <TD align="LEFT"><input	type="text" name="receiver" ></TD>
         </TR>
          <TR>
             <TD align="receiver">title：</TD>
             <TD align="LEFT"><input	type="text" name="title" ></TD>
         </TR>
          <TR>
             <TD align="receiver">msg：</TD>
             <TD align="LEFT"><input	type="text" name="msg" ></TD>
         </TR>
         <TR>
         <input type="submit" value="提交">
         </TR>
</Table>
</Form>

</body>
</html>