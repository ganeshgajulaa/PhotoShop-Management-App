<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhotoShop</title>
<link rel="stylesheet" href="style.css">
<!--<link rel="stylesheet" href="radioStyle.css">  -->
<style>
#addMemberBtn, .button {
	width: 15%;
}

#fetchBtn, .button {
	width: 50%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text">Booking Form</div>
		<form action="bookingForm" method="post">
			<div class="form-row">
				<div class="input-data">
					<input type="number" id="mobileNum" name='mobileNum'
						min='7000000000' max='9999999999' required />
					<div class="underline"></div>
					<label for="">Enter Mobile no</label>
				</div>
				<div class="input-data">
					<input type="button" class="button" id="fetchBtn"
						onClick="handleFetch()" value="Fetch Data" />
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<input type='hidden' name='name' id='name'  />
					<div class="underline"></div>
					<label for="" id="nameLabel">Name</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<input type='hidden' name='customerId' id="customerId"  />
					<div class="underline"></div>
					<label for="" id="customerIdLabel">Customer Id</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<input type='text' name='themeName' required />
					<div class="underline"></div>
					<label for="">Theme Name</label>
				</div>

			</div>

			<div class="form-row">
				<div class="input-data">
					<input type='text' name='themePrice' disabled />
					<div class="underline"></div>
					<label for="">Theme Price - ₹999</label>
				</div>

			</div>

			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="submit">
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript" src="handleFetch.js"></script>
</body>
</html>