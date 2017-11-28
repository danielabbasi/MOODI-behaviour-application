/**
 * Created by c1673218 on 26/11/2017.
 */
// Currently only using data of patient with id 4, need to change so that the patient id can be
// variable according the user specifies in controller.
$(document).ready(function(){

    var id = $.url(2);


    $.ajax({
        url : "http://localhost:8080/api/patient/" + id + "/activities/completed",
        type : "GET",
        success : function(data){
            console.log(data);

            var name = [];
            var rating = [];


            for(var i in data) {
                name.push(data[i].name);
                rating.push(data[i].rating);
            }

            var chartdata = {
                labels: name,
                datasets: [
                    {
                        label: "rating",
                        fill: false,
                        lineTension: 0.1,
                        backgroundColor: "rgba(59, 89, 152, 0.75)",
                        borderColor: "rgba(59, 89, 152, 1)",
                        pointHoverBackgroundColor: "rgba(59, 89, 152, 1)",
                        pointHoverBorderColor: "rgba(59, 89, 152, 1)",
                        data: rating
                    }

                ]
            };

            var ctx = $("#mycanvas");

            var LineGraph = new Chart(ctx, {
                type: 'line',
                data: chartdata
            });
        },
        error : function(data) {

        }
    });
});