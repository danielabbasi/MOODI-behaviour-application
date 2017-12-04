/**
 * Created by c1443907 on 03/12/2017.
 */

$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/activities/days",
        type : "GET",
        dataType: "json",
        success : function(data){
            console.log(data);



            var days = [];

    // PUSH INTO DAYS MY ARRAY OF NUMBERS
            for(var i in data) {
                days.push(data[i].data);
            }

            var chartdata = {
                labels: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
                datasets: [
                    {
                        label: "Peak",
                        fill: false,
                        lineTension: 0,
                        // fontColor: 'white',
                        backgroundColor: "#4dc3ff",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: days
                    }

                ]
            };

            var ctx = $("#indexGraphDays");

            var BarGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata,
                options: {
                    legend:{
                        labels: {
                            fontColor: "#000"
                        }
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true,
                                fontColor: "#000",

                            }


                        }],
                        xAxes: [{
                            ticks: {
                                fontColor: "#000",

                            }
                        }]
                    }
                }

            });
        },
        error : function(data) {

        }
    });
});
