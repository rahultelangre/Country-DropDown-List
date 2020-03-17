$(document).ready(function() {
	$.ajax({
		url : 'CountryServlet',
		cache : false,
		dataType : 'json',
		success : function(result) {
			$.each(result, function(key, value) {
				$('<option>').val(key).text(value).appendTo("#country");
			});
		}
	});
});

$(document).on("change", "#country", function() {
	$("#state").find('option').remove();
	$('<option>').val("").text("-Select State-").appendTo("#state");
	var selctedCntryId = $("#country").val();
	$.ajax({
		url : "StateServlet",
		data : {
			countryId : selctedCntryId
		},
		dataType : 'json',
		success : function(result) {
			$.each(result, function(key, value) {
				$('<option>').val(key).text(value).appendTo("#state");
			});
		}
	});
});

$(document).on("change", "#state", function() {
	$("#city").find('option').remove();
	$('<option>').val("").text("-Select City-").appendTo("#city");
	var selctedStateId = $("#state").val();
	$.ajax({
		url : "CityServlet",
		data : {
			stateId : selctedStateId
		},
		dataType : 'json',
		success : function(result) {
			$.each(result, function(key, value) {
				$('<option>').val(key).text(value).appendTo("#city");
			});
		}
	});
});