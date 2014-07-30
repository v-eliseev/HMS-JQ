// get date from daterange control

function getDaterangeValues(controlId) {
	var dp = document.getElementById(controlId);
	var startTime = dp.startTime();
	var endTime = dp.endTime();
	return { 'startTime': startTime, 'endTime': endTime };
};
