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
                fontColor: 'white',
                datasets: [
                    {
                        label: "Activity score",
                        fill: false,
                        lineTension: 0,
                        // fontColor: 'white',
                        backgroundColor: "#FFFFFF",
                        borderColor: "red",
                        pointHoverBackgroundColor: "#00b3b3",
                        pointHoverBorderColor: "pink",
                        data: rating
                    }

                ]
            };

            var ctx = $("#mycanvas");

            var LineGraph = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    legend:  {
                        labels: {
                            fontColor: 'white'
                        }
                    }
                }
            });
        },
        error : function(data) {

        }
    });
});