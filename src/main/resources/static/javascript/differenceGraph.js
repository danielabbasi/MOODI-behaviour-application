/**
 * Created by c1673218 on 11/12/2017.
 */
$(document).ready(function(){
    var id = $.url(2);

    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/statistics/difference",
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
                        fill: false,
                        lineTension: 0.1,
                        backgroundColor: "rgba(59, 89, 152, 0.75)",
                        borderColor: "rgba(59, 89, 152, 1)",
                        pointHoverBackgroundColor: "rgba(59, 89, 152, 1)",
                        pointHoverBorderColor: "rgba(59, 89, 152, 1)",
                        data: difference
                    }
                ]
            };

            var ctx = $("#differenceGraph");

            var LineGraph = new Chart(ctx, {
                type: 'line',
                data: chartdata
            });
        },
        error : function(data) {

        }
    });
});




