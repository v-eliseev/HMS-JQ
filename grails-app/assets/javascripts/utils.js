// get date from daterange control

function getDaterangeValues(controlId) {
	Element dp = document.getElementById(controlId);
	Date start = dp.startTime();
	Date end = dp.endTime();
	return { 'startTime': start, 'endTime': end };
};
