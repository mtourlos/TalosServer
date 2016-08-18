function sendAjax() {
    $.ajax({
        url: "addservlet",
        type: 'GET',
 
        success: function (responseText) {
            window.alert(responseText)
        },
    });
}

function initMap() {
	var mapDiv = document.getElementById('map');
	var map = new google.maps.Map(mapDiv, {
		center : {
			lat : 44.540,
			lng : -78.546
		},
		zoom : 8
	});
}