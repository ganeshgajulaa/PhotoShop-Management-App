function handleMaritalStatus(status) {
	const divType = document.getElementById('divType');
	if (status === 'married') {
		divType.innerHTML = `
			<div class="form-row">
				<div class="input-data">
					<label for="anniversaryDate">Anniversary Date</label>
				</div>
				<div class="input-data">
					<input type="date" name="anniversaryDate" id="anniversaryDate" required>
					<div class="underline"></div>
				</div>
			</div>
			
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="spouseName" required>
					<div class="underline"></div>
					<label for="spouseName">Spouse Name</label>
				</div>
			</div>		
			
			<div class="form-row">
				<div class="input-data">
					<label for="spouseDob">Spouse Date of Birth</label>
				</div>
				<div class="input-data">
					<input type="date" name="spouseDob" id="spouseDob" required>
					<div class="underline"></div>
				</div>
			</div>
		`;
	} else {
		divType.innerHTML = '';
	}
}
