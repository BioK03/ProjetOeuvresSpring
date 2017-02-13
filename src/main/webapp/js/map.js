var map = L.map('map', {
    center: [45.779312, 4.868314],
    zoom: 15
});
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png?{foo}', {foo: 'bar'}).addTo(map);

var popup = L.popup()
	.setLatLng([45.779312, 4.868314])
	.setContent("Médiathèque de Polytech' Lyon")
	.openOn(map);