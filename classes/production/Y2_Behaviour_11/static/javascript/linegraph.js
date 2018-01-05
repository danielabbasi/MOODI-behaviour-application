/**
 * Created by c1673218 on 26/11/2017.
 */
$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "/api/gp/1/patients/" + id + "/activities/statistics/completed",
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
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        borderWidth: 2,
                        hoverBackgroundColor: "rgba(255,99,132,0.8)",
                        hoverBorderColor: "#000",
                        data: ratingBefore
                    }, {
                        label: "After",
                        backgroundColor: "rgba(51, 187, 255, 0.2)",
                        borderColor: "#00b3b3",
                        borderWidth: 2,
                        hoverBackgroundColor: "rgba(51, 187, 255, 0.8)",
                        hoverBorderColor: "#000",
                        data: ratingAfter
                    }

                ]
            };

            var ctx = $("#mycanvas");

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
                                display:true,
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
                                    display: true,
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