/**
 * Created by c1443907 on 03/12/2017.
 */

$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/statistics/activities-by-days",
        type : "GET",
        dataType: "json",
        success : function(data){
            console.log(data);



            var count = [];
            var days = [];
            var colorz = [];

            // adapted from https://stackoverflow.com/questions/45771849/chartjs-random-colors-for-each-part-of-pie-chart-with-data-dynamically-from-data
            var dynamicColors = function() {
                var r = Math.floor(Math.random() * 255);
                var g = Math.floor(Math.random() * 255);
                var b = Math.floor(Math.random() * 255);
                return "rgb(" + r + "," + g + "," + b + ")";
            };

    // PUSH INTO DAYS MY ARRAY OF NUMBERS
            for(var i in data) {
                days.push(data[i][1]);
                count.push(data[i][0]);
                colorz.push(dynamicColors());
            }

            var chartdata = {
                labels: days,
                datasets: [
                    {
                        label: "By day",
                        // fill: false,
                        // lineTension: 0,
                        // // fontColor: 'white',
                        // backgroundColor: "#4dc3ff",
                        // pointHoverBackgroundColor: "#00b3b3",
                        // pointHoverBorderColor: "pink",
                        // backgroundColor: ["rgba(228, 87, 46, .)","rgba(242, 129, 35, 1)","rgba(31, 178, 83, 1)","rgba(162, 207, 39, 1)","rgba(234, 234, 49, 1)" ],

                        backgroundColor: ["rgba(255, 71, 26, 0.9)", "rgba(255, 255, 26, 0.7)", "rgba(255, 51, 255, 0.8)", "rgba(255, 163, 26, 0.5)", "rgba(255, 0, 0, 0.8)", "rgba(46, 184, 46, 0.8)", "rgba(0, 115, 153, 0.5)"],
                        // borderColor: "#f3f",
                        borderWidth: 2,
                        hoverBackgroundColor: "#009",
                        hoverBorderColor: "#099",
                        hoverBorderWidth: 5,
                         data: count
                    }

                ]
            };

            var ctx = $("#indexGraphDays");



            var BarGraph = new Chart(ctx, {
                type: 'pie',
                data: chartdata,
                options: {
                    legend:{
                        labels: {
                            fontColor: "#000"
                        }

                    }

                }

            });
        },
        error : function(data) {

        }
    });
});
