<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 등록</title>

</head>
<body>

	<header> 
		<h1>숙소 등록 </h1>
	</header>

	<main>
		<form action="/journey/accom/insert" method="post" enctype="multipart/form-data">
			<div>
				<label for="name">숙소 이름:</label> 
				<input type="text" id="name" name="name" required>
			</div>
			<div>
				<label for="address">주소:</label> 
				<input type="text" id="address" name="address" required>
			</div>
			<div>
				<label for="swimYn">수영장 여부:</label> 
				<select id="swimYn" name="swimYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="spaYn">스파 여부:</label> 
				<select id="spaYn" name="spaYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="disabledYn">장애인 시설 여부:</label> 
				<select id="disabledYn" name="disabledYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="parkingYn">주차장 여부:</label> 
				<select id="parkingYn" name="parkingYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="elevatorYn">엘리베이터 여부:</label> 
				<select id="elevatorYn" name="elevatorYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="breakfastYn">조식 제공 여부:</label> 
				<select id="breakfastYn" name="breakfastYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="smokeYn">흡연 가능 여부:</label>
				<select id="smokeYn" name="smokeYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="imgUrl">이미지 업로드:</label> 
				<input type="file" id="imgUrl" name="imgUrl" required>
			</div>
			<button type="submit">등록</button>
		</form>
		
	</main>
	
</body>
</html>