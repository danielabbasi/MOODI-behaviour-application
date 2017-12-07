/**
 * Created by c1443907 on 02/12/2017.
 */
$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/statistics/last-activities",
        type : "GET",
        success : function(data){
            console.log(data);

            var name = [];
            var ratingBefore = [];
            var ratingAfter = [];


            for(var i in data) {
                name.push(data[i].name);
                ratingBefore.push(data[i].ratingBefore);
                ratingAfter.push(data[i].ratingAfter);
            }

            var chartdata = {
                labels: name,
                fontColor: 'white',
                datasets: [
                    {
                        label: "Before",
                        fill: false,
                        lineTension: 0,
                        // fontColor: 'white',
                        backgroundColor: "#4dc3ff",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: ratingBefore
                    }, {
                        label: "After",
                        fill: false,
                        lineTension: 0,
                        // fontColor: 'white',
                        backgroundColor: " #ff8080",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: ratingAfter
                    }

                ]
            };

            var ctx = $("#indexGraph");

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