$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(state, status) {
			console.log('test country', state);
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#codeEdit').val(state.code);
			$('#nameEdit').val(state.name);
			$('#capitalEdit').val(state.capital);
			$('#detailsEdit').val(state.detail);
		});

		$('#editModal').modal();
	});

	$('table #detailButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(state, status) {
			console.log('test country', state);
			$('#idDetail').val(state.id);
			$('#ddlCountryDetail').val(state.countryid);
			$('#codeDetail').val(state.code);
			$('#nameDetail').val(state.name);
			$('#capitalDetail').val(state.capital);
			$('#detailsDetail').val(state.detail);
		});

		$('#detailModal').modal();
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#buttonConfirmDelete').attr('href', href);

		$('#deleteModal').modal();

	});
})