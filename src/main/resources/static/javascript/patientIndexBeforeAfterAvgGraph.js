/**
 * Created by c1443907 on 05/12/2017.
 */


$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "/api/patient/" + id + "/statistics/average",
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
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        borderWidth: 2,
                        hoverBackgroundColor: "rgba(255,99,132,0.8)",
                        hoverBorderColor: "#000",
                        data: before
                    }, {
                        label: "After",
                        backgroundColor: "rgba(51, 187, 255, 0.2)",
                        borderColor: "#00b3b3",
                        borderWidth: 2,
                        hoverBackgroundColor: "rgba(51, 187, 255, 0.8)",
                        hoverBorderColor: "#000",
                        data: after
                    }

                ]
            };

            var ctx = $("#indexGraphAverage");

            var BarGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata,
                options:
                    {
                        maintainAspectRatio: false,

                        legend: {
                            labels: {
                                fontColor: "#000"
                            }
                        },
                        scales: {
                            yAxes: [{
                                display:false,
                                gridLines: {
                                    display: true,
                                    color: "rgba(255,99,132,0.2)"
                                },
                                ticks: {
                                    beginAtZero: true,
                                    fontColor: "#000",

                                }


                            }],
                            xAxes: [{
                                gridLines: {
                                    display: false,
                                    color: "rgba(255,99,132,0.2)"
                                },

                                ticks: {
                                    display:true,
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