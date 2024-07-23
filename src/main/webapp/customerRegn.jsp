<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhotoShop</title>
<link rel="stylesheet" href="style.css">
<style>
#addMemberBtn, .button {
	width: 15%;
}
</style>
<script type="text/javascript" src="handleMaritalStatus.js"></script>
<script type="text/javascript" src="handleAddFamily.js"></script>
</head>
<body>
	<div class="container">
		<div class="text">Customer Registration</div>
		<form action="customerForm" method="post">
		
			<div class="form-row">
				<div class="input-data">
					<input type='text' name='firstName' required />
					<div class="underline"></div>
					<label for="">First Name</label>
				</div>
				<div class="input-data">
					<input type='text' name='middleName' required />
					<div class="underline"></div>
					<label for="">Middle Name</label>
				</div>
			</div>
			
			<div class="form-row">
				<div class="input-data">
					<input type='text' name='lastName' required />
					<div class="underline"></div>
					<label for="">Last Name</label>
				</div>
				<div class="input-data">
					<input type='email' name='email' required />
					<div class="underline"></div>
					<label for="">Email</label>
				</div>
			</div>
			
			<div class="form-row">
				<div class="input-data">
					<input type="number" name='mobileNum' min='7000000000'
						max='9999999999' required />
					<div class="underline"></div>
					<label for="">Mobile no</label>
				</div>
				<div class="input-data">
					<input type="number" name='alternateNum' min='7000000000'
						max='9999999999' required />
					<div class="underline"></div>
					<label for="">Alternate Mobile no</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data textarea">
					<textarea rows="4" cols="80" name='address' required></textarea>
					<label for="">Address</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<label for="">Gender</label>
				</div>
				<label class="containerRadio" for="male">Male <input
					type="radio" name='gender' id='male' value='male' required>
					<span class="checkmark"></span>
				</label> 
				
				<label class="containerRadio" for="female">Female <input
					type="radio" name='gender' id='female' value='female' required>
					<span class="checkmark"></span>
				</label>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="">Marital Status</label>
				</div>

				<label class="containerRadio" for="single"
					onclick="handleMaritalStatus('single')">
					Single <input	type="radio" name='maritalStatus' id='single' value='single'
					required> 
					<span class="checkmark"></span>
				</label> 
					
				<label
					class="containerRadio" for="married"
					onclick="handleMaritalStatus('married')">
					Married <input type="radio" name='maritalStatus' id='married' value='married'
					required> 
					<span class="checkmark"></span>
				</label>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="">FAMILY DETAILS</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="dob">Your Date of birth</label>
				</div>
				<div class="input-data">
					<input type='date' name='dob' id='dob' required />
					<div class="underline"></div>
				</div>
			</div>

			<div id='divType'></div>

			<div class="form-row">
				<div class="input-data">
					<input type='text' name='fatherName' required />
					<div class="underline"></div>
					<label for="">Father Name</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="">Father Date of birth</label>
				</div>
				<div class="input-data">
					<input type='date' name='fatherDob' id='fatherDob' required />
					<div class="underline"></div>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<input type='text' name='motherName' required />
					<div class="underline"></div>
					<label for="">Mother Name</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="">Mother Date of birth</label>
				</div>
				<div class="input-data">
					<input type='date' name='motherDob' id='motherDob' required />
					<div class="underline"></div>
				</div>
			</div>

			<div id="addMember"></div>

			<div class="form-row">
				<div class="input-data">
					<!-- Hidden input to store member count -->
					<input type="hidden" name="memberCount" id="memberCount" value="0" />
					<label for="">Add Family Member</label>
				</div>
				<div class="input-data">
					<input type="button" class="button" id="addMemberBtn"
						onClick="handleAddFamily()" value="+" />
				</div>
			</div>

			<div class="form-row">
				<div class="input-data">
					<label for="reference">Reference</label>
				</div>
				<div class="input-data">
					<input type='text' name='reference' required />
					<div class="underline"></div>
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

</body>
</html>