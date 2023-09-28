<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
<style>
	.square {
		border: 1px solid black;
		box-sizing: border-box;
	}
	#squareMain {
		background: white;
		border: none;
		width: 600px;
		height: 600px;
		margin: 0 auto;
		position: relative;
	}
	#squareM1 {
		background: #ef6fde;
		width: 300px;
		height: 300px;
		position: absolute;
		left: 0;
	}
	#squareM2 {
		background: black;
		width: 300px;
		height: 300px;
		position: absolute;
		right: 0;
	}
	#squareM3 {
		background: black;
		width: 300px;
		height: 300px;
		position: absolute;
		left: 0;
		bottom: 0;
	}
	#squareM4 {
		background: yellow;
		width: 300px;
		height: 300px;
		position: absolute;
		right: 0;
		bottom: 0;
	}
	#squareCenter {
		background: green;
		width: 300px;
		height: 300px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate( -50%, -50% );
	}
	#squareM1_1 {
		background: lightgray;
		width: 150px;
		height: 150px;
		position: absolute;
		left: 0;
		border-top: none;
		border-left: none;
	}
	#squareM2_1 {
		background: skyblue;
		width: 150px;
		height: 150px;
		position: absolute;
		right: 0;
		bottom: 0;
		border-bottom: none;
		border-right: none;
	}
	#squareM2_2 {
		background: blue;
		width: 150px;
		height: 150px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate( -50%, -50% );
		z-index: 2;
	}
	#squareM3_1 {
		background: lightgray;
		width: 150px;
		height: 150px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate( -50%, -50% );
		z-index: 2;
	}
	#squareCenter_1 {
		background: red;
		width: 150px;
		height: 150px;
		position: absolute;
		top: 50%;
		transform: translate( 0%, -50% );
	}
	#squareCenter_2 {
		background: lightgray;
		width: 150px;
		height: 150px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate( -50%, 0% );
	}
</style>
</head>
<body>
<%@ include file="./navi.jsp" %>
	<div id="questionBox" class="wrapper">
		<h2>과제 2</h2>
		<div id="squareMain" class="square">
			<div id="squareM1" class="square">
				<div id="squareM1_1" class="square">
				</div>
			</div>
			<div id="squareM2" class="square">
				<div id="squareM2_1" class="square">
				</div>
				<div id="squareM2_2" class="square">
				</div>
			</div>
			<div id="squareM3" class="square">
				<div id="squareM3_1" class="square">
				</div>
			</div>
			<div id="squareM4" class="square">
			</div>
			<div id="squareCenter" class="square">
				<div id="squareCenter_1" class="square">
				</div>
				<div id="squareCenter_2" class="square">
				</div>
			</div>
		</div>
	</div>
</body>
</html>