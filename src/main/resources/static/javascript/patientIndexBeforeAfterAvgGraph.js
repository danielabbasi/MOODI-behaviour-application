/**
 * Created by c1443907 on 05/12/2017.
 */


$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/statistics/average",
        type : "GET",
        success : function(data){
            console.log(data);

            var before = [];
            var after = [];


            for(var i in data) {
                before.push(data[i][0]);
                after.push(data[i][1]);
            }

            var chartdata = {
                labels: ['Before', 'After'],
                fontColor: 'white',
                datasets: [
                    {
                        label: "Before",
                        fill: false,
                        lineTension: 0,
                        backgroundColor: "#4dc3ff",
                        data: before
                    }, {
                        label: "After",
                        fill: true,
                        lineTension: 0,
                        backgroundColor: " #ff8080",
                        data: after
                    }

                ]
            };

            var ctx = $("#indexGraphAverage");

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