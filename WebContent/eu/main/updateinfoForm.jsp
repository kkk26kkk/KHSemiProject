<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>��� ���� ����</title>
<script src="js/entinfo.js" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="../euheader.jsp"/><br><br>
<h1>���(ȸ��)���� ����������</h1>
<form method="post" enctype="multipart/form-data" action="./updateinfoProcess.eumain">
<!--<c:set var="eu" value="${einfo}"/>-->
  <span>${eu.ENAME}</span><br><!-- ����� -->
  <span>${eu.ENUM }</span><br><!-- ����ڹ�ȣ -->
  <c:set var="einfo" value="${einfo}"/>
  <input type="hidden" name="EID" value="${einfo.EID }" required><br><!-- ����� �ѱ� -->
  �⺻���� <br>
  ��ǥ�ڸ�<input type="text" name="OWNERNAME" value="${einfo.OWNERNAME }" required><br><!-- ��ǥ�ڸ� -->
  ������<input type="text" name="DOE"  required ><br>
  ������� <select name="ETYPE">
    <option value="1">����</option>
    <option value="2">�߰߱��</option>
    <option value="3">�߼ұ��</option>
    <option value="4">���ұ��</option>
    <option value="5">�ܱ�����</option>
    <option value="6">��ó���</option>
    <option value="7">��������������</option>
  </select><br>
  ���� <select name="DUTY">
    <option value="1">�濵���繫</option>
    <option value="2">�����á�����ȫ��</option>
    <option value="3">IT�����ͳ�</option>
    <option value="4">������</option>
    <option value="5">����������</option>
    <option value="6">�����������</option>
    <option value="7">����</option>
    <option value="8">�������ߡ�����</option>
    <option value="9">���ꡤ����</option>
    <option value="10">����</option>
    <option value="11">�Ǽ�</option>
    <option value="12">�Ƿ�</option>
    <option value="13">�̵��</option>
    <option value="14">������Ư����</option>       
  </select><br>
  ��� <select name="INDUSTRY">
    <option value="1">���񽺾�</option>
    <option value="2">�����������</option>
    <option value="3">IT��������ž�</option>
    <option value="4">�Ǹš������</option>
    <option value="5">���������ꡤȭ�о�</option>
    <option value="6">������</option>
    <option value="7">�Ǽ���</option>
    <option value="8">�Ƿᡤ�����</option>
    <option value="9">�̵������</option>
    <option value="10">��ȭ�������������ξ�</option>
    <option value="11">�������ȸ</option>
  </select><br>
  ����� <input type="text" name="ENUM" value="${einfo.ENUM}" required><br>
  ȸ���ּ� <input type="text" name="EADDR" value="${einfo.EADDR}" required><br>
  Ȩ������ <input type="text" name="PAGEADDR"  required><br>
  ����� <input type="text" name="REVENUE" ><br>
 ȸ��ΰ� <input type="file" name="LOGO" ><br>
 
  ep.setEID(rs.getString("EID"));

 
 <input type="submit" value="����">
 
 <input type="reset" value="�ٽ��ۼ�">
 </form>
</body>
</html>