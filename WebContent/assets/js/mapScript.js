function loadDataToMap(map) {
    $.ajax({
        url: "fetchdataservlet",
        type: 'GET',
        dataType: 'json',
 
        success: function (dataJson) {
        	$.each(dataJson.datas, function (key, data) {

                var latLng = new google.maps.LatLng(data.latitude, data.longitude);
		var imgLocation = 'assets/img/';
		var imgType = '.png'
                var marker = new google.maps.Marker({
                    position: latLng,
                    map: map,
                    icon: imgLocation.concat(data.operator,imgType),
                    title: data.operator
                });
                var details = 'Πάροχος: '+ data.operator + '\n' + 'Δεδομένα: ' + data.networkType + '\n' + 'Ώρα: ' + data.timestamp + '\n' + 'CINR: ' + data.cinr ;
                var infowindow = new google.maps.InfoWindow({ content: details });
                bindInfoWindow(marker, map, infowindow, details);
            });
        },
    });
}

function contact(){
	window.alert("data.id");
}

function initMap() {
	var mapDiv = document.getElementById('map');
	var mapProp = {
		center : new google.maps.LatLng(37.984101, 23.728018),
		zoom : 8
	};
	var map = new google.maps.Map(mapDiv, mapProp);
	var dataJson = loadDataToMap(map);
}

function bindInfoWindow(marker, map, infowindow, strDescription) {
    google.maps.event.addListener(marker, 'click', function () {
        infowindow.setContent(strDescription);
        infowindow.open(map, marker);
    });
}
