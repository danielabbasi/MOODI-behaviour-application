function initialiseCalendar(container){
	const template = '<select id="month_choose">				<option value="1">January</option>				<option value="2">February</option>				<option value="3">March</option>				<option value="4">April</option>				<option value="5">May</option>				<option value="6">June</option>				<option value="7">July</option>				<option value="8">August</option>				<option value="9">September</option>				<option value="10">October</option>				<option value="11">November</option>				<option value="12">December</option>			</select>			<select id="year_choose">				<option value="2010">2010</option>				<option value="2011">2011</option>				<option value="2012">2012</option>				<option value="2013">2013</option>				<option value="2014">2014</option>				<option value="2015">2015</option>				<option value="2016">2016</option>				<option value="2017">2017</option>				<option value="2018">2018</option>				<option value="2019">2019</option>				<option value="2020">2020</option>			</select>			<div class="calendar-container">				<div class="calendar-row">					<div class="calendar-header">Monday</div>					<div class="calendar-header">Tuesday</div>					<div class="calendar-header">Wednesday</div>					<div class="calendar-header">Thursday</div>					<div class="calendar-header">Friday</div>					<div class="calendar-header">Saturday</div>					<div class="calendar-header">Sunday</div>				</div>				<div class="calendar-row">					<div id="M1" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M2" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M3" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M4" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M5" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M6" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M7" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>				</div>				<div class="calendar-row">					<div id="M8" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M9" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M10" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M11" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M12" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M13" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M14" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>				</div>				<div class="calendar-row">					<div id="M15" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M16" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M17" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M18" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M19" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M20" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M21" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>				</div>				<div class="calendar-row">					<div id="M22" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M23" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M24" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M25" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M26" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M27" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M28" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>				</div>				<div class="calendar-row">					<div id="M29" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M30" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M31" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M32" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M33" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M34" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M35" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>				</div>				<div class="calendar-row">					<div id="M36" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M37" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M38" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M39" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M40" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M41" class="calendar-data">						<div class="date">													</div>						<div class="contents">						</div>					</div>					<div id="M42" class="calendar-data">						<div class="date">													</div>						<div class="contents">					</div>				</div>			</div>';
	
	$('#calendar-wrapper').html(template);
    selectedYear = getCurrentYear();
    selectedMonth = getCurrentMonth();
    setDates();

    document.getElementById('month_choose').onchange = function() {
        selectedMonth = this.value;
        setDates();
    }

    document.getElementById('year_choose').onchange = function() {
        selectedYear = this.value;
        setDates();
    }
}

function getCurrentMonth() {
	var currentDate = new Date();
	return currentDate.getMonth() + 1;
}

function getCurrentYear() {
	var currentDate = new Date();
	return currentDate.getFullYear();
}

function getDay(year, month) {
	var day = new Date(year + "-" + month + "-01").getDay();
	return day;
}

function getDayString(day) {
	if(day == 1) {
		return "MON";
	} else if(day == 2) {
		return "TUE";
	} else if(day == 3) {
		return "WED";
	} else if(day == 4) {
		return "THU";
	} else if(day == 5) {
		return "FRI";
	} else if(day == 6) {
		return "SAT";
	} else {
		return "SUN";
	}
}

function daysInMonth(year, month) {
    return new Date(year, month, 0).getDate();
}

var day = null;
var selectedYear = null;
var selectedMonth = null;

function setDates() {
	day = getDay(selectedYear, selectedMonth);
	
	if(day == 0) {
		day = 7;
	}
	
	var dayString = getDayString(day);
	
	var totalDays = daysInMonth(selectedYear, selectedMonth);
	
	for(i = 1; i <= 42; i++) {
		if(i >= day && i <= totalDays + day - 1) {
			document.getElementById('M' + i).classList.remove('disabled');
			document.getElementById('M' + i).children[0].innerHTML = i - day + 1;			
		} else {
			document.getElementById('M' + i).classList.add('disabled');
			document.getElementById('M' + i).children[0].innerHTML = "";
		}
		document.getElementById('M' + i).children[1].innerHTML = "";
	}
	
	document.getElementById('month_choose').value = selectedMonth;
	document.getElementById('year_choose').value = selectedYear;
	
	calendarLoaded();
}

function addSchedule(scheduleDay, scheduleTime, text) {
	document.getElementById('M' + (day + scheduleDay - 1)).children[1].innerHTML += '<div class="schedule"><span class="time">' + scheduleTime + '</span> ' + text + '</div>';
}

function calendarLoaded() { } // this should be overridden