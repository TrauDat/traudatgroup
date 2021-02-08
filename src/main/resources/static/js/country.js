$('document').ready(() => {
	$('table #editButton').on('click', function (event) {
		event.preventDefault();
		
		
		// /countries/findById/?id=
		var href = $(this).attr('href');
		console.log('asdasd',href);
		
		$.get(href, (country, status) => {
			console.log('test country',country);
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});
		
		$('#editModal').modal();
	})
	
	$('table #detailButton').on('click', function (event) {
		event.preventDefault();
		
		
		// /countries/findById/?id=
		var href = $(this).attr('href');
		
		$.get(href, (country, status) => {
			console.log('test country',country);
			$('#idDetail').val(country.id);
			$('#descriptionDetail').val(country.description);
			$('#capitalDetail').val(country.capital);
			$('#codeDetail').val(country.code);
			$('#continentDetail').val(country.continent);
			$('#nationalityDetail').val(country.nationality);
		});
		
		$('#detailModal').modal();
	})
	
	
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		console.log('href of delete', href);
		$('#buttonConfirmDelete').attr('href',href);
		
		$('#deleteModal').modal();
	})
})