




$('.thermometer-toggle').on('change',function() {

    var fillPercentage = $('.thermometer-toggle').val() / $('.thermometer-toggle').prop('max');

    var fillHeight = fillPercentage * ( $('#thermometer-top').height());

    $('#thermometer-fill').css('height', 12 + fillHeight);
    $('#thermometer-bottom span').text(Math.round(fillPercentage * 100));

});

// Run!
moods = ["Very Happy", "Happy", "Neutral", "Sad", "Upset", "Very Sad"];
//moods = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
rangeSlider('range-slider-1', function(value) {
    document.getElementById('test-result').innerHTML = determineState(value, moods);

    //Following line added in by Jamie Highfield
    document.getElementById('result-emoji').src = "/images/emojis/" + (determineState(value, moods).replace(/\s/g, '')).toLowerCase() + ".png";
});

function determineState(percentage, statesArray) {
    valueOfOne = 100 / (statesArray.length -1);
    return statesArray[Math.round(percentage / valueOfOne)];
}