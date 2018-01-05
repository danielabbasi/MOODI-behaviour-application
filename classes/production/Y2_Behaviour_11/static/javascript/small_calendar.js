function initialiseCalendar(container){
    const template = '<div class="calendar-container"><div class="calendar-row"><select id="month_choose" class="calendar-select"><option value="1">January</option><option value="2">February</option><option value="3">March</option><option value="4">April</option><option value="5">May</option><option value="6">June</option><option value="7">July</option><option value="8">August</option><option value="9">September</option><option value="10">October</option><option value="11">November</option><option value="12">December</option></select><select id="year_choose" class="calendar-select"><option value="2010">2010</option><option value="2011">2011</option><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015">2015</option><option value="2016">2016</option><option value="2017">2017</option><option value="2018">2018</option><option value="2019">2019</option><option value="2020">2020</option></select></div><div class="calendar-row"><div class="calendar-header">M</div><div class="calendar-header">T</div><div class="calendar-header">W</div><div class="calendar-header">T</div><div class="calendar-header">F</div><div class="calendar-header">S</div><div class="calendar-header">S</div></div><div class="calendar-row"><div id="M1" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M2" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M3" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M4" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M5" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M6" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M7" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div><div class="calendar-row"><div id="M8" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M9" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M10" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M11" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M12" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M13" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M14" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div><div class="calendar-row"><div id="M15" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M16" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M17" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M18" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M19" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M20" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M21" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div><div class="calendar-row"><div id="M22" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M23" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M24" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M25" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M26" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M27" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M28" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div><div class="calendar-row"><div id="M29" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M30" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M31" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M32" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M33" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M34" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M35" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div><div class="calendar-row"><div id="M36" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M37" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M38" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M39" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M40" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M41" class="calendar-data"><div class="date"></div><div class="contents"></div></div><div id="M42" class="calendar-data"><div class="date"></div><div class="contents"></div></div></div>';

    $('#calendar-wrapper').html(template);

    $(document).ready(function() {

        selectedYear = getCurrentYear();
        selectedMonth = getCurrentMonth();
        setDates(null);

        document.getElementById('month_choose').onchange = function() {
            selectedMonth = this.value;
            setDates(null);
        }

        document.getElementById('year_choose').onchange = function() {
            selectedYear = this.value;
            setDates(null);
        }

        $('.calendar-data').click(function() {
            if(this.classList.contains("disabled")) {
                if(parseInt(this.children[0].innerHTML) > 12) {
                    setPreviousMonth(this.children[0].innerHTML);
                } else {
                    setNextMonth(this.children[0].innerHTML);
                }
            } else {
                this.classList.add('selected');
                selectedDay = this.children[0].innerHTML;
                for(i = 1; i <= 42; i++) {
                    if(document.getElementById('M' + i) != this) {
                        document.getElementById('M' + i).classList.remove('selected');
                    }
                }
            }

            updateTextBox();
            //this.classList.contains('selected') ? this.classList.remove('selected') : this.classList.add('selected');
            //alert(this.children[0].innerHTML + " " + monthNames[currentDay.getMonth()] + " " + selectedYear);
        });

        $('.date-calendar').attr('readonly', 'readonly');
        $('.date-calendar').css('cursor', 'pointer');

        $('.date-calendar').click(function() {
            if($('#calendar-wrapper').is(":visible") == true) {
                hideCalendar();
            } else {
                showCalendarAtLocation($(this).offset().left, $(this).offset().top + $(this).height(), $(this).width());
            }
        });

        hideCalendar();

    });
}

function showCalendar() {
    $('#calendar-wrapper').show();
}

function showCalendarAtLocation(x, y, width) {
    $('#calendar-wrapper').css('position', 'absolute');
    $('#calendar-wrapper').css('top', y);
    $('#calendar-wrapper').css('left', x);
    $('#calendar-wrapper').css('width', width);
    showCalendar();
}

function hideCalendar() {
    $('#calendar-wrapper').hide();
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

var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var day = null;
var selectedYear = null;
var selectedMonth = null;
var selectedDay = 1;
var currentDay = null;

function getPreviousMonthDays() {
    var newMonth = selectedMonth;
    var newYear = selectedYear;

    if(newMonth == 1) {
        newMonth = 12;
        newYear = newYear - 1;
    } else {
        newMonth = newMonth - 1;
    }

    return daysInMonth(newYear, newMonth);
}

function setDates(selectDay) {
    day = getDay(selectedYear, selectedMonth);

    if(day == 0) {
        day = 7;
    }

    var dayString = getDayString(day);

    var totalDays = daysInMonth(selectedYear, selectedMonth);

    var previousMonthDays = getPreviousMonthDays();

    for(i = 1; i <= 42; i++) {
        document.getElementById('M' + i).classList.remove('selected');

        if(i >= day && i <= totalDays + day - 1) {
            document.getElementById('M' + i).classList.remove('disabled');
            document.getElementById('M' + i).children[0].innerHTML = i - day + 1;

            if(selectDay != null) {
                if(selectDay == (i - day + 1)) {
                    document.getElementById('M' + i).classList.add('selected');
                }
            } else if(i == day) {
                document.getElementById('M' + i).classList.add('selected');
            }
        } else if(i < day) {
            document.getElementById('M' + i).classList.add('disabled');
            document.getElementById('M' + i).children[0].innerHTML = previousMonthDays - day + (i + 1);
        } else {
            document.getElementById('M' + i).classList.add('disabled');
            document.getElementById('M' + i).children[0].innerHTML = i - totalDays - day + 1;
        }
        document.getElementById('M' + i).children[1].innerHTML = "";
    }

    document.getElementById('month_choose').value = selectedMonth;
    document.getElementById('year_choose').value = selectedYear;

    updateTextBox();
}

function addSchedule(scheduleDay, scheduleTime, text, history, upcoming, past) {
    document.getElementById('M' + (day + scheduleDay - 1)).children[1].innerHTML += '<div class="schedule' + ((history == true) ? " history" : (upcoming == true ? " upcoming" : (past == true ? " past" : ""))) + '"><span class="time">' + scheduleTime + '</span> ' + text + '</div>';
}

function setPreviousMonth(selectDay) {
    var newMonth = selectedMonth;
    var newYear = selectedYear;

    if(newMonth == 1) {
        newMonth = 12;
        newYear = newYear - 1;
    } else {
        newMonth = newMonth - 1;
    }

    document.getElementById('month_choose').value = newMonth;
    document.getElementById('year_choose').value = newYear;

    selectedMonth = newMonth;
    selectedYear = newYear;

    setDates(selectDay);
}

function setNextMonth(selectDay) {
    var newMonth = selectedMonth;
    var newYear = selectedYear;

    if(newMonth == 12) {
        newMonth = 1;
        newYear = newYear + 1;
    } else {
        newMonth = newMonth + 1;
    }

    document.getElementById('month_choose').value = newMonth;
    document.getElementById('year_choose').value = newYear;

    selectedMonth = newMonth;
    selectedYear = newYear;

    setDates(selectDay);
}

function updateTextBox() {
    $('.date-calendar').val((String(selectedDay).length == 1 ? "0" + selectedDay : selectedDay) + "/" + (String(selectedMonth).length == 1 ? "0" + selectedMonth : selectedMonth) + "/" + selectedYear);
}