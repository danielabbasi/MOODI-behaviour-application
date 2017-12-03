/**
 * Created by c1673218 on 26/11/2017.
 */
$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/activities/completed",
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
                        backgroundColor: "#FFFFFF",
                        borderColor: "red",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: ratingBefore
                    }, {
                        label: "After",
                        fill: false,
                        lineTension: 0,
                        // fontColor: 'white',
                        backgroundColor: "#00b3b3",
                        borderColor: "white",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: ratingAfter
                    }

                ]
            };

            var ctx = $("#mycanvas");

            var BarGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata,
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
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