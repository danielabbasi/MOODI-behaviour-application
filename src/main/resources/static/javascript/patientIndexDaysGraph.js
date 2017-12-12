$(document).ready(function () {
    var id = $.url(2);

    $.ajax({
        url: "/api/patient/" + id + "/statistics/activities-by-days",
        type: "GET",
        dataType: "json",


        success: function (data) {
            console.log(data);


            var count = [];
            var days = [];


            for (var i in data) {
                days.push(data[i][1]);
                count.push(data[i][0]);
            }

            var chartdata = {
                labels: days,
                datasets: [
                    {
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        hoverBackgroundColor: "rgba(255,99,132,0.8)",
                        hoverBorderColor: "#000",
                        pointBorderWidth: 20,
                        pointBackgroundColor: "rgba(51, 187, 255, 0.8)",
                        pointBorderColor: "rgba(51, 187, 255, 0.2)",
                        // fillColor: "rgba(220,220,220,0.2)",
                        // strokeColor: "rgba(220,220,220,1)",
                        // pointColor: "rgba(220,220,220,1)",
                        // pointStrokeColor: "#fff",
                        // // pointHighlightFill: "#fff",
                        // pointHighlightStroke: "rgba(220,220,220,1)",
                        data: count
                    }

                ]
            };

            var ctx = $("#indexGraphDays");


            var BarGraph = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    animation: {
                        duration: 2000, // general animation time
                    },
                    maintainAspectRatio: false,
                    legend: {
                        display: false,
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
        error: function (data) {

        }
    });
});