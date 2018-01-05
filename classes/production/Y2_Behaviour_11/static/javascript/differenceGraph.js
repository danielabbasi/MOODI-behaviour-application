/**
 * Created by c1673218 on 11/12/2017.
 */
$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "/api/patient/" + id + "/statistics/difference",
        type : "GET",
        dataType: "json",
        success : function(data){
            console.log(data);

            var difference = [];
            var name = [];

            for(var i in data) {
                difference.push(data[i][0]);
                name.push(data[i][1]);
            }

            var chartdata = {
                labels: name,
                datasets: [
                    {
                        label: "relative mood change",
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        hoverBorderColor: "#000",
                        fill: false,
                        data: difference
                    }
                ]
            };

            var ctx = $("#differenceGraph");

            var LineGraph = new Chart(ctx, {
                type: 'line',
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




